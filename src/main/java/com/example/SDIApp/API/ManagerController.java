package com.example.SDIApp.API;

import com.example.SDIApp.DTO.ManagerDTOStatisticAvgWorkerSalary;
import com.example.SDIApp.DTO.ManagerDTO2;
import com.example.SDIApp.Model.Manager;
import com.example.SDIApp.Model.Worker;
import com.example.SDIApp.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("api/manager")
@RestController
public class ManagerController {
    private final ManagerService service;

    @Autowired
    public ManagerController(ManagerService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Manager addNewManager(@RequestBody Manager manager) { return service.addService(manager); }

    @GetMapping("/all")
    public List<Manager> getAllManagers() { return service.getManagersService(); }

    @GetMapping("/all2")
    public List<ManagerDTO2> getAllManagers2() { return service.getManagersService2(); }

    @GetMapping("/get/{id}")
    public Optional<Manager> getManager(@PathVariable Integer id) { return service.getService(id); }

    @GetMapping("/workers/{id}")
    public List<Worker> getWorkers(@PathVariable Integer id)
    {
        return service.getWorkersService(id);
    }

    @GetMapping("/info")
    public String getManagersInfo() { return service.getManagersInfo(); }

    @DeleteMapping("/delete/{id}")
    public void deleteManager(@PathVariable("id") Integer id) { service.deleteService(id); }

    @PutMapping ("update/{id}")
    public Manager updateManager(@PathVariable("id") Integer id, @RequestBody Manager manager)
    {
        return service.updateService(id, manager);
    }

    @GetMapping ("/statistic")
    public List<ManagerDTOStatisticAvgWorkerSalary> getAllAvgWorkersSalary()
    {
        return service.getAllManagersOrderByAvgWorkerSalaryDesc();
    }
}
