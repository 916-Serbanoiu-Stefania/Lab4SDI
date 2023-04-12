package com.example.SDIApp.Repositoriy;

import com.example.SDIApp.Model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface WorkerRepository extends JpaRepository<Worker, Integer> {
}
