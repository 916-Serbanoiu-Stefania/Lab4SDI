package com.example.SDIApp.API;

import com.example.SDIApp.Model.Worker;
import com.example.SDIApp.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("api/worker")
@RestController
public class WorkerController {
    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }


    // this is a request
    @PostMapping("/add")
    public Worker addNewWorker(@RequestBody Worker worker)
    {
        return workerService.addService(worker);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/all")
    public List<Worker> getAllWorkers()
    {
        return workerService.getWorkersService();
    }

    @GetMapping("/get/{id}")
    public Optional<Worker> getWorker(@PathVariable("id") Integer id)
    {
        return workerService.getService(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteWorker(@PathVariable("id") Integer id)
    {
        workerService.deleteService(id);
    }

    @PutMapping("/update/{id}")
    public Worker updateWorkerInfo(@PathVariable("id") Integer id, @RequestBody Worker worker)
    {
        return workerService.updateService(id, worker);
    }


    // this function returns all workers with a salary higher than 'givenSalary'
    @GetMapping(path = "/salary/{salary}")
    public List<Worker> filterBySalary(@PathVariable("salary") int salary)
    {
        return workerService.filterService(salary);
    }
}
