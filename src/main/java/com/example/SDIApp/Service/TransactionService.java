package com.example.SDIApp.Service;

import com.example.SDIApp.DTO.ClientDTOStatisticMaxPrice;
import com.example.SDIApp.Model.Product;
import com.example.SDIApp.Repositoriy.TransactionRepository;
import com.example.SDIApp.Model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.repository = transactionRepository;
    }

    public Transaction addService(Transaction new_transaction) { return repository.save(new_transaction); }

    public List<Transaction> addTransactionsListService(Set<Transaction> transactionSet)
    {
        return repository.saveAll(transactionSet); // the set becomes a List<Transaction>
    }

    public List<Transaction> getTransactionsService() { return repository.findAll(); }

    public Optional<Transaction> getService(Integer id) { return repository.findById(id); }

    public void deleteService(Integer id) { repository.deleteById(id); }

    public Transaction updateService(Integer id, Transaction newTransaction)
    {
        Transaction t = repository.findById(id).orElse(null);

        t.setDate(newTransaction.getDate());
        t.setQuantity(newTransaction.getQuantity());
        t.setApplied_discount_code(newTransaction.isApplied_discount_code());

        return repository.save(t);
    }

    public List<ClientDTOStatisticMaxPrice> findAllClientsByMostExpensivePurchasedProduct() {
        List<Object[]> statistic = repository.findAllClientsByMostExpensivePurchasedProduct();
        List<ClientDTOStatisticMaxPrice> clientsDTO = new ArrayList<>();
        for(Object[] row: statistic)
        {
            Integer clientID = (Integer) row[0];
            String name = (String) row[1];
            int maxPrice = (int) row[2];
            clientsDTO.add(new ClientDTOStatisticMaxPrice(clientID, name, maxPrice));
        }
        return clientsDTO;
    }
}
