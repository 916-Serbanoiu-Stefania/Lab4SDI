package com.example.SDIApp.API;

import com.example.SDIApp.DTO.ClientDTOStatisticMaxPrice;
import com.example.SDIApp.Model.Client;
import com.example.SDIApp.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/api/client")
@RestController
public class ClientController {
    @Autowired
    private ClientService service;

    @PostMapping("/add")
    public Client addNewClient(@RequestBody Client client) {
        return service.addService(client);
    }

    @GetMapping("/all")
    public List<Client> getAllClients() {
        return service.getClientsService();
    }

    @GetMapping("/get/{id}")
    public Optional<Client> getClient(@PathVariable java.lang.Integer id) {
        return service.getService(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable("id") java.lang.Integer id) {
        service.deleteService(id);
    }

    @PutMapping("update/{id}")
    public Client updateClient(@PathVariable("id") Integer id, @RequestBody Client client) {
        return service.updateService(id, client);
    }
}
