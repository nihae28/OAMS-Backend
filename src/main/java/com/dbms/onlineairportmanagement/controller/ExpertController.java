package com.dbms.onlineairportmanagement.controller;


import com.dbms.onlineairportmanagement.model.Employee;
import com.dbms.onlineairportmanagement.model.Expert;
import com.dbms.onlineairportmanagement.repository.EmployeeRepository;
import com.dbms.onlineairportmanagement.repository.ExpertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/expert-controller")
public class ExpertController {

    @Autowired
    ExpertRepository expertRepository;

    @GetMapping("/getExperts")
    @ResponseBody
    public List<Expert> getExperts() {
        return StreamSupport.stream(expertRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @PostMapping("/addExpert")
    @ResponseBody
    public ResponseEntity addExpert(@RequestBody Expert expert) {
        try {
            expertRepository.save(expert);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
            return ResponseEntity.ok().body("Failed");
        }
        return ResponseEntity.ok().body("Insert successful");
    }
}
