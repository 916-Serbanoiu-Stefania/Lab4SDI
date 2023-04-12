package com.example.SDIApp.Repositoriy;

import com.example.SDIApp.Model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean
// CRUD refers Create, Read, Update, Delete
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    // we'll do a statistical report about the average salary for the workers managed by each manager
   @Query("SELECT m.managerID, CONCAT(m.managerFirstName, ' ', m.managerLastName), AVG(w.salary) from Manager m " +
           "join m.workers w " +
           "GROUP BY m.managerID, m.managerFirstName, m.managerLastName " +
           "ORDER BY AVG(w.salary) DESC")
   List<Object[]> findAllManagersByAvgWorkerSalary(); // the returned data will be stored into a list of arrays of Objects
}
