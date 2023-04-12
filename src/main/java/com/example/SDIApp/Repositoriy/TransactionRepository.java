package com.example.SDIApp.Repositoriy;

import com.example.SDIApp.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    // we'll do a statistical report about the maximum price each client gave for a product
    @Query("SELECT t.client.clientID, t.client.clientName, MAX(t.product.price) as MaximumPrice FROM Transaction t GROUP BY t.client.clientID, t.client.clientName")
    List<Object[]> findAllClientsByMostExpensivePurchasedProduct(); // the returned data will be stored into a list of arrays of Objects
}
