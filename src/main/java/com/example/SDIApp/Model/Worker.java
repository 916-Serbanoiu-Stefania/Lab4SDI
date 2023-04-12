package com.example.SDIApp.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

/*
{
    "firstName" : "Corina",
    "lastName" : "Andreescu",
    "age": 50,
    "email" : "no",
    "gender" : "female"
    "salary" : 4000
}
 */
@Table(name = "WORKERS_TABLE") // WORKER_TABLE name bound to manager in 1ton
@Entity // This tells Hibernate to make a table out of this class
        // Hibernate automatically translates the entity into a table.

public class Worker {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer wid;

    private String firstName;

    private String lastName;

    private int age;

    private String email;

    private String gender;

    private int salary;



    // constructor

    public Worker()
    {}

    public Worker(
                  @JsonProperty("firstName") String firstName,
                  @JsonProperty("lastName") String lastName,
                  @JsonProperty("age") int age,
                  @JsonProperty("email") String email,
                  @JsonProperty("gender") String gender,
                  @JsonProperty("salary") int salary)
    {
        this.wid = null;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
    }


    //    getters

    public Integer getWid() {
        return wid;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getSalary() { return salary; }

    //    setters

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(int salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "Worker\n" + " -id = " + wid + ", first name = '" + firstName + ", last name = '" + lastName +
                ", age = " + age +  ", email = '" + email + ", gender = " + gender + ", salary = " + salary + "\n\n";
    }

    enum Gender {
        MALE, FEMALE
    }
}
