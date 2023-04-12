
package com.example.SDIApp.Model;


/*
{
    "clientName" : "Ion",
    "phone" : "0712345678",
    "gender" : "male",
    "email" : "ion47363@mail.com",
    "age" : 25
}
 */


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;



@Entity
@Data
@Table(name = "clients")// This tells Hibernate to make a table out of this class
// Hibernate automatically translates the entity into a table.
@JsonIgnoreProperties({"transactions"})
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer clientID;

    private String clientName;

    private String phone;

    private String gender;

    private String email;

    private int age;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    /*
    2
    @ManyToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinTable(name = "cp_fk",
    joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "clientID"),
    inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "productID"))
    private List<Product> products;
     */
    /*
    1
    @JoinTable(name = "client_product",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="cp_fk",referencedColumnName = "clientID")
    private List<Product> products;
    */


    //constructors

    public Client()
    {}

    /*
    public Client(
            @JsonProperty("clientName") String clientName,
            @JsonProperty("phone") String phone,
            @JsonProperty("gender") String gender,
            @JsonProperty("email") String email,
            @JsonProperty("age") int age)
            //JsonProperty("products") List<Product> product)
     {
        this.clientID = null;
        this.clientName = clientName;
        this.phone= phone;
        this.gender = gender;
        this.email = email;
        this.age = age;
        //this.products = product;
    }
     */

    public Client(
            @JsonProperty("clientName") String clientName,
            @JsonProperty("phone") String phone,
            @JsonProperty("gender") String gender,
            @JsonProperty("email") String email,
            @JsonProperty("age") int age,
            @JsonProperty("transactions") List<Transaction> transactionList
    )
    {
        this.clientID = null;
        this.clientName = clientName;
        this.phone= phone;
        this.gender = gender;
        this.email = email;
        this.age = age;
        this.transactions = transactionList;
    }



    //     setters

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTransactions(List<Transaction> transactions) { this.transactions = transactions; }




    //       getters

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getClientName() {
        return clientName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public Integer getClientID() {
        return clientID;
    }

    public List<Transaction> getTransactions() { return transactions; }
}
