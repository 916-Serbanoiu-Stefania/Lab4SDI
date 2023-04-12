package com.example.SDIApp.Service;

import com.example.SDIApp.DTO.ManagerDTOStatisticAvgWorkerSalary;
import com.example.SDIApp.DTO.ManagerDTO2;
import com.example.SDIApp.Repositoriy.ManagerRepository;
import com.example.SDIApp.Model.Manager;
import com.example.SDIApp.Model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ManagerDTOMapper mapper;

    public List<ManagerDTO2> getManagersService2(){
        return managerRepository.findAll().stream().map(mapper).collect(Collectors.toList());
    }

    public Manager addService(Manager new_manager)
    {
        return managerRepository.save(new_manager);
    }

    public List<Manager> addManagersListService(List<Manager> managers)
    {
        return managerRepository.saveAll(managers);
    }

    public List<Manager> getManagersService()
    {
        return managerRepository.findAll();
    }

    public Optional<Manager> getService(Integer id) { return managerRepository.findById(id); }

    public void deleteService(Integer id) { managerRepository.deleteById(id); }
    public Manager updateService(Integer id, Manager new_manager)
    {
        Manager manager = managerRepository.findById(id).orElse(null);

        manager.setAge(new_manager.getAge());
        manager.setEmail(new_manager.getEmail());
        manager.setGender(new_manager.getGender());
        manager.setManagerLastName(new_manager.getManagerLastName());
        manager.setManagerFirstName(new_manager.getManagerFirstName());
        manager.setSalary(new_manager.getSalary());

        return managerRepository.save(manager);
    }

    public String getManagersInfo()
    {
        List<Manager> managerList= managerRepository.findAll();
        int length = managerList.size();
        StringBuilder managers = new StringBuilder();
        for(int i = 0; i < length; i++)
        {
            managers.append(managerList.get(i));
        }
        return managers.toString();
    }

   public List<Worker>  getWorkersService(Integer id)
   {
       return this.getService(id).get().getWorkers();
   }


    // statistical report about average salary of workers for each manager
    public List<ManagerDTOStatisticAvgWorkerSalary> getAllManagersOrderByAvgWorkerSalaryDesc() {
        List<Object[]> statistic = managerRepository.findAllManagersByAvgWorkerSalary();
        List<ManagerDTOStatisticAvgWorkerSalary> managersDTO = new ArrayList<>();
        for (Object[] row : statistic)
        {
            Integer managerID = (Integer) row[0];
            String name = (String) row [1];
            Double avg = (Double) row[2];
            managersDTO.add(new ManagerDTOStatisticAvgWorkerSalary(managerID, name, avg));
        }
        return managersDTO;
    }
}
