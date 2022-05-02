package com.dbms.onlineairportmanagement.controller;


import com.dbms.onlineairportmanagement.model.Employee;
import com.dbms.onlineairportmanagement.model.LoginDetails;
import com.dbms.onlineairportmanagement.repository.EmployeeRepository;
import com.dbms.onlineairportmanagement.repository.LoginDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employee-controller")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    LoginDetailsRepository loginDetailsRepository;

    @GetMapping("/getEmployees")
    @ResponseBody
    public List<Employee> getEmployees() {

        return StreamSupport.stream(employeeRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @PostMapping("/insertemployee")
    @ResponseBody
    public ResponseEntity insertEmployee(@RequestBody Employee employee) {
        try {
            employeeRepository.save(employee);
            loginDetailsRepository.save(new LoginDetails(employee.getEmailId(), "12345"));
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
