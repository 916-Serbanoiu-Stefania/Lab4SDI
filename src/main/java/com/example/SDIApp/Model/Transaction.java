package com.example.SDIApp.Model;

/*
sa ruleze pe port 80
relatia 1 to many, cand se adauga un autor se asociaza bookurile    /author/id/books
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "Transactions_Table1")
public class Transaction {
    @Id
    @GeneratedValue
    private Integer transactionID;

    private int quantity;

    private boolean applied_discount_code;

    private String date;

    @ManyToOne
    Client client;

    @ManyToOne
    Product product;


    //constructor
    public Transaction(){}

    public Transaction(
                       @JsonProperty("quantity") int quantity,
                       @JsonProperty("applied_discount_code") boolean applied_discount_code,
                       @JsonProperty("date") String date,
                       Client id,
                       Product product) {
        this.transactionID = null;
        this.quantity = quantity;
        this.applied_discount_code = applied_discount_code;
        this.date = date;
        this.client = id;
        this.product = product;
    }



    public boolean isApplied_discount_code() {
        return applied_discount_code;
    }

   public Client getClient() { return client; }

    public Integer getTransactionID() {
        return transactionID;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public String getDate() {
        return date;
    }


    public void setApplied_discount_code(boolean applied_discount_code) {
        this.applied_discount_code = applied_discount_code;
    }

  public void setClient(Client client) { this.client = client; }

    public void setDate(String date) {
        this.date = date;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
