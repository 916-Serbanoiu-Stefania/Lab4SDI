package com.example.SDIApp;

import com.example.SDIApp.DTO.ClientDTOStatisticMaxPrice;
import com.example.SDIApp.Model.Client;
import com.example.SDIApp.Model.Product;
import com.example.SDIApp.Model.Transaction;
import com.example.SDIApp.Repositoriy.TransactionRepository;
import com.example.SDIApp.Service.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


public class testFindMaxProductPriceByClient {
    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;


    @Test
    public void testFindMaxProductPriceByClient()
    {
        // Initialize the @Mock annotated fields in the test class
        MockitoAnnotations.openMocks(this);

        // Create a mock implementation of TransactionRepository
        transactionRepository = mock(TransactionRepository.class);

        // Populate the repository with data
        Client client1 = new Client("John", "0712345678", "male", "fdsfsddsf", 25, null);
        Client client2 = new Client("Jane", "0712345678", "male", "fdsfsddsf", 25, null);
        Product product1 = new Product( "Product A", 10, 5, "m1", null);
        Product product2 = new Product( "Product B", 20, 4, "m1", null);
        Product product3 = new Product( "Product C", 2, 4, "m2", null);
        Transaction transaction1 = new Transaction(10, false, "2022-04-05", client1, product1);
        Transaction transaction2 = new Transaction(20, false, "2022-04-06", client1, product2);
        Transaction transaction3 = new Transaction(30, false, "2022-04-07", client2, product1);
        Transaction transaction4 = new Transaction(4, false, "2022-04-08", client2, product3);


        /*
        It's important to make sure that the mocked data you use in your tests is representative of the real data y
        our application will work with.
        If the mocked data is significantly different from the real data, it may lead to false positives or false negatives
        in your test results.

    In this case, since you're using Mockito to mock the database interactions, you're not actually interacting with a real database.
     Instead, you're creating a fake implementation of the TransactionRepository interface that returns the data
     you specify when its methods are called.

    As long as the data you return from your mocked findAllClientsByMostExpensivePurchasedProduct() method
    is representative of the data you expect to see in your real database, your tests should be valid.
    However, if the data you return is significantly different from what you expect to see in the real database,
    your tests may not be accurate.
         */


        // Mock the behaviour of transactionRepository
        when(transactionRepository.findAll()).thenReturn(Arrays.asList(transaction1, transaction2, transaction3, transaction4));

        // Create an instance of TransactionService using the mock implementation of the repository
        transactionService = new TransactionService(transactionRepository);
        this.transactionService.addService(transaction1);
        this.transactionService.addService(transaction2);
        this.transactionService.addService(transaction3);
        this.transactionService.addService(transaction4);

        // Test if the service and repo saved the items correctly
        Assertions.assertEquals(4, transactionService.getTransactionsService().size());
        Assertions.assertEquals(4, transactionRepository.findAll().size());

        // Expected result
        List<Object[]> result = new ArrayList<>();
        result.add(new Object[] {1, "John", 20});
        result.add(new Object[] {2, "Jane", 10});

        // Create a mock of the function
        when(transactionRepository.findAllClientsByMostExpensivePurchasedProduct()).thenReturn(result);

        // Test the method's output against the expected result
        List<ClientDTOStatisticMaxPrice> maxPrices = transactionService.findAllClientsByMostExpensivePurchasedProduct();
        Assertions.assertEquals(2, maxPrices.size());
        Assertions.assertEquals("John", maxPrices.get(0).getName());
        Assertions.assertEquals(20, maxPrices.get(0).getMaxPrice());
        Assertions.assertEquals("Jane", maxPrices.get(1).getName());
        Assertions.assertEquals(10, maxPrices.get(1).getMaxPrice());
    }
}
