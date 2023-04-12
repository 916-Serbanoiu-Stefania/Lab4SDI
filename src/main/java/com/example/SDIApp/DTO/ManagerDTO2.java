package com.example.SDIApp.DTO;

import com.example.SDIApp.Model.Worker;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ManagerDTO2 (
        int ManagerID,
        String firstName,
        String managerLastName,
        String gender,
        String email,
        int age,
        int salary
){}