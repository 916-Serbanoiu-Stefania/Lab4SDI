package com.example.SDIApp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@Table(name = "Product1")
@JsonIgnoreProperties({"transactions"})
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private java.lang.Integer productID;

    private String name;

    private int price;

    private int weight;

    private String materials;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    /*
    2
    @ManyToMany(mappedBy = "products")
    private List<Client> clients;
     */
    /*
    1
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne
    @JoinColumn(name = "clientID") // marks this column as join column in order to associate entities
    private Client client;
     */



    //constructors

    public Product() {}
    /*
    public Product (
            @JsonProperty("name")  String name,
            @JsonProperty("price") int price,
            @JsonProperty ("weight") int weight,
            @JsonProperty("materials") String materials
    )
    {
        this.price= price;
        this.materials = materials;
        this.weight = weight;
        this.name = name;
    }
     */
    /*
    public Product (
            @JsonProperty("name")  String name,
            @JsonProperty("price") int price,
            @JsonProperty ("weight") int weight,
            @JsonProperty("materials") String materials,
            @JsonProperty("clients") List<Client> c
    )
    {
        this.price= price;
        this.materials = materials;
        this.weight = weight;
        this.name = name;
        this.clients = c;
    }
     */

    public Product (
            @JsonProperty("name")  String name,
            @JsonProperty("price") int price,
            @JsonProperty ("weight") int weight,
            @JsonProperty("materials") String materials,
            @JsonProperty("transactions") List<Transaction> transactionList
    )
    {
        this.price= price;
        this.materials = materials;
        this.weight = weight;
        this.name = name;
        this.transactions = transactionList;
    }



    // setters and getters
    public String getName() {
        return name;
    }

    public java.lang.Integer getProductID() {
        return productID;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public void setProductID(java.lang.Integer productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

//    public void setClients(List<Client> c) { this.clients = c; }
//
//    public List<Client> getClients() { return clients; }

    public void setTransactions(List<Transaction> transactions) { this.transactions = transactions; }

    public List<Transaction> getTransactions() { return transactions; }
}
