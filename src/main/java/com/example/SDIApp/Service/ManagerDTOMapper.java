package com.example.SDIApp.Service;

import com.example.SDIApp.Model.Manager;
import com.example.SDIApp.DTO.ManagerDTO2;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ManagerDTOMapper implements Function<Manager, ManagerDTO2> {
        @Override
        public ManagerDTO2 apply(Manager manager) {
            return new ManagerDTO2(
                    manager.getManagerID(),
                    manager.getManagerFirstName(),
                    manager.getManagerLastName(),
                    manager.getGender(),
                    manager.getEmail(),
                    manager.getAge(),
                    manager.getSalary()
            );
        }
}
