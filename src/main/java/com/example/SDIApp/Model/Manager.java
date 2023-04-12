package com.example.SDIApp.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

/*
{
    "firstName" : "Lia",
    "lastName" : "Wen",
    "gender" : "unknown",
    "email" : "zero@yahoo.com",
    "age" : 40,
    "salary" : 19500,
    "workers" : [
        {
    "firstName" : "Ion",
    "lastName" : "Popescu",
    "age": 38,
    "email" : "asd@yahoo.com",
    "gender" : "?",
    "salary" : 2583
},
{
    "firstName" : "Alan",
    "lastName" : "Watts",
    "age": 25,
    "email" : "watts3443@gmail.com",
    "gender" : "male",
    "salary" : 5800
}
    ]
}
 */

@Table(name = "MANAGERS")
@Entity // This tells Hibernate to make a table out of this class
        // Hibernate automatically translates the entity into a table.
public class Manager {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer managerID;

    @Column(nullable = false) //  this column / field can't take null values
    public String managerFirstName;

    @Column(nullable = false) //  this column / field can't take null values
    public String managerLastName;

    public String gender;

    public String email;

    public int age;

    public int salary;

    @OneToMany(targetEntity = Worker.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="mw_fk",referencedColumnName = "managerID")
    public List<Worker> workers;

    //     constructor


    public List<Worker> getWorkers() {
        return workers;
    }

    public Manager()
    {}

    public Manager(
                   @JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String managerLastName,
                   @JsonProperty("gender") String gender,
                   @JsonProperty("email") String email,
                   @JsonProperty("age") int age,
                   @JsonProperty("salary") int salary,
                   @JsonProperty("workers") List<Worker> workerList) {
        this.managerID = null;
        this.managerFirstName = firstName;
        this.managerLastName = managerLastName;
        this.gender = gender;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.workers = workerList;
    }

    //     setters

    public void setManagerID(Integer managerID) {
        this.managerID = managerID;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    public void setManagerFirstName(String managerFirstName) {
        this.managerFirstName = managerFirstName;
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

    public void setSalary(int salary) {
        this.salary = salary;
    }

    //       getters

    public String getGender() {
        return gender;
    }

    public String getManagerLastName() {
        return managerLastName;
    }

    public String getManagerFirstName() {
        return managerFirstName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public Integer getManagerID() {
        return managerID;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString()
    {
        return "id = " + managerID + "\nfirst name = '" + managerFirstName + "\nlast name = '" + managerLastName +
                "\nage = " + age +  "\nemail = '" + email + "\ngender = " + gender + "\nsalary = " + salary + "\n\n\n";
    }
}
