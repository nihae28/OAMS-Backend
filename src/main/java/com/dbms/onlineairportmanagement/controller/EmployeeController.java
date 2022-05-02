package com.dbms.onlineairportmanagement.controller;


import com.dbms.onlineairportmanagement.model.Employee;
import com.dbms.onlineairportmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee-controller")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/getEmployees")
    @ResponseBody
    public List<Employee> getEmployees() {

        return StreamSupport.stream(employeeRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @PostMapping("/insertemployee")
    @ResponseBody
    public ResponseEntity insertModel(@RequestBody Employee employee) {
        try {
            employeeRepository.save(employee);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
            return ResponseEntity.ok().body("Failed");
        }
        return ResponseEntity.ok().body("Insert successful");
    }


    @GetMapping("/deleteModel/{ssn}")
    @ResponseBody
    public ResponseEntity deleteModel(@PathVariable String ssn) {
        try {
            employeeRepository.deleteById(ssn);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
            return ResponseEntity.ok().body("Failed");
        }
        return ResponseEntity.ok().body("Delete successful");
    }


}
