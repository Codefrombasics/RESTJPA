package com.example.RESTJPA.controller;


import com.example.RESTJPA.dao.EmployeeDAO;
import com.example.RESTJPA.entity.Employee;
import com.example.RESTJPA.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employee")
    public List<Employee> findAll(){
        //logic available in EmployeeDAO class
        return employeeService.findAll();
    }


    @GetMapping("/employee/{id}")
    public Employee findById(@PathVariable("id") int id){
        //logic available in EmployeeDAO class
        return employeeService.findById(id);
    }

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee employee){
      return  employeeService.save(employee);
    }
    @PutMapping("/employee")
    public Employee update(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteById(@PathVariable("id") int id){
        employeeService.deleteById(id);
    }


}
