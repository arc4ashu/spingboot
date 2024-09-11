package com.arc.json.date.ex.controller;

import com.arc.json.date.ex.bo.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1")
public class EmployeeController {

    @Autowired
    ObjectMapper objectMapper;
    @PostMapping(value="/employee",
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public Employee createHotel(@RequestBody Employee employee) throws JsonProcessingException {

        System.out.println(employee.getDateOfBirth().toString());
       // System.out.println(objectMapper.writeValueAsString(employee));

        return employee;
    }
}
