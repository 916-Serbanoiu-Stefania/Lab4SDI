package com.example.SDIApp;

import com.example.SDIApp.Model.Worker;
import com.example.SDIApp.Repositoriy.WorkerRepository;
import com.example.SDIApp.Service.WorkerService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestFilterBySalary {
    @Mock
    private WorkerRepository workerRepository;

    @InjectMocks
    private WorkerService workerService;



    @Test
    public void testFilterSalary()
    {
        // Initialize the @Mock annotated fields in the test class
        MockitoAnnotations.openMocks(this);

        // Create a mock implementation of WorkerRepository as a class
        workerRepository = mock(WorkerRepository.class);

        // Populate the repository with data
        // We will have 10 'Worker' objects
        Worker worker1 = new Worker("John", "Doe", 25, "john.doe@example.com", "male", 50000);
        Worker worker2 = new Worker("Jane", "Doe", 30, "jane.doe@example.com", "female", 60000);
        Worker worker3 = new Worker("Bob", "Smith", 40, "bob.smith@example.com", "male", 70000);
        Worker worker4 = new Worker("Mary", "Johnson", 45, "mary.johnson@example.com", "female", 80000);
        Worker worker5 = new Worker("Tom", "Williams", 35, "tom.williams@example.com", "male", 90000);
        Worker worker6 = new Worker("Sarah", "Brown", 28, "sarah.brown@example.com", "female", 55000);
        Worker worker7 = new Worker("David", "Lee", 32, "david.lee@example.com", "male", 65000);
        Worker worker8 = new Worker("Emily", "Wang", 38, "emily.wang@example.com", "female", 75000);
        Worker worker9 = new Worker("Kevin", "Chen", 42, "kevin.chen@example.com", "male", 85000);
        Worker worker10 = new Worker("Amy", "Lin", 29, "amy.lin@example.com", "female", 60000);

        // Mock the behaviour of workerRepository
        when(workerRepository.findAll()).thenReturn(Arrays.asList(worker1, worker2, worker3, worker4, worker5, worker6, worker7, worker8, worker9, worker10));

        // Create an instance of workerService using the mock implementation of the repository
        workerService = new WorkerService(workerRepository);
        this.workerService.addService(worker1);
        this.workerService.addService(worker2);
        this.workerService.addService(worker3);
        this.workerService.addService(worker4);
        this.workerService.addService(worker5);
        this.workerService.addService(worker6);
        this.workerService.addService(worker7);
        this.workerService.addService(worker8);
        this.workerService.addService(worker9);
        this.workerService.addService(worker10);

        // Test if the service and repo saved the items correctly
        Assertions.assertEquals(10, workerService.getWorkersService().size());
        Assertions.assertEquals(10, workerRepository.findAll().size());

        // Test the method's output against the expected result
        List<Worker> workers = workerService.filterService(70000);
        Assertions.assertEquals(4, workers.size());
        Assertions.assertEquals("mary.johnson@example.com", workers.get(0).getEmail());
        Assertions.assertEquals("tom.williams@example.com", workers.get(1).getEmail());
        Assertions.assertEquals("emily.wang@example.com", workers.get(2).getEmail());
        Assertions.assertEquals("kevin.chen@example.com", workers.get(3).getEmail());

    }

}

