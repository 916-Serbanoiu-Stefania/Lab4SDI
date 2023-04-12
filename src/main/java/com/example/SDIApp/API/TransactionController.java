package com.example.SDIApp.API;

import com.example.SDIApp.DTO.ClientDTOStatisticMaxPrice;
import com.example.SDIApp.Model.Manager;
import com.example.SDIApp.Model.Transaction;
import com.example.SDIApp.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/transactions/")
@RestController
public class TransactionController {
    @Autowired
    private TransactionService service;

    @PostMapping("/add")
    public Transaction addNewTransaction(@RequestBody Transaction new_transaction) { return service.addService(new_transaction); }

    @GetMapping("/all")
    public List<Transaction> getAllTransactions()
    {
        return service.getTransactionsService();
    }

    @GetMapping("/get/{transactionID}")
    public Optional<Transaction> getTransaction(@PathVariable Integer transactionID)
    {
        return service.getService(transactionID);
    }

    @GetMapping("/statistic")
    public List<ClientDTOStatisticMaxPrice> getStatistic()
    {
        List<ClientDTOStatisticMaxPrice> list = service.findAllClientsByMostExpensivePurchasedProduct();
        return list;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTransaction(@PathVariable("id") Integer id) {
        service.deleteService(id);
    }

    @PutMapping ("update/{id}")
    public Transaction updateTransaction(@PathVariable("id") Integer id, @RequestBody Transaction transaction)
    {
        return service.updateService(id, transaction);
    }
}
