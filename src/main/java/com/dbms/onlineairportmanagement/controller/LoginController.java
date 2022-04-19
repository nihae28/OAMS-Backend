package com.dbms.onlineairportmanagement.controller;

import com.dbms.onlineairportmanagement.exception.EmployeeNotFoundException;
import com.dbms.onlineairportmanagement.model.Employee;
import com.dbms.onlineairportmanagement.model.LoginDetails;
import com.dbms.onlineairportmanagement.repository.EmployeeRepository;
import com.dbms.onlineairportmanagement.repository.LoginDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginDetailsRepository loginDetailsRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("login")
    public Employee login(@RequestBody LoginDetails loginDetails) {
        LoginDetails fetchedDetails = loginDetailsRepository.getById(loginDetails.getEmail());
        if(fetchedDetails!=null && loginDetails.getPassword().equals(fetchedDetails.getPassword())) {
            return employeeRepository.getByEmailId(loginDetails.getEmail());
        }

        throw new EmployeeNotFoundException("No employee found with passed username/password");
    }

    @PostMapping("adminlogin")
    public Employee adminlogin(@RequestBody LoginDetails loginDetails) {
        LoginDetails fetchedDetails = loginDetailsRepository.getById(loginDetails.getEmail());
        if(fetchedDetails!=null && loginDetails.getPassword().equals(fetchedDetails.getPassword())) {
            Employee employee =  employeeRepository.getByEmailId(loginDetails.getEmail());
            if(!employee.getRole().equals("Admin")) {
                throw new EmployeeNotFoundException("No admin found with passed username/password");
            }

            return employee;
        }

        throw new EmployeeNotFoundException("No employee found with passed username/password");
    }
}