package com.dbms.onlineairportmanagement.controller;

import com.dbms.onlineairportmanagement.model.Technician;
import com.dbms.onlineairportmanagement.model.Test_info;
import com.dbms.onlineairportmanagement.repository.TechnicianRepository;
import com.dbms.onlineairportmanagement.repository.TestInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/technician-controller")
public class TechnicianController {

    @Autowired
    TestInfoRepository testInfoRepository;

    @Autowired
    TechnicianRepository technicianRepository;

    @GetMapping("/gettechnicians")
    @ResponseBody
    public List<Technician> getAirplaneModels() {
        return StreamSupport.stream(technicianRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @PostMapping("/inserttechnician")
    @ResponseBody
    public ResponseEntity insertModel(@RequestBody Technician technician) {
        try {
            technicianRepository.save(technician);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
            return ResponseEntity.ok().body("Failed");
        }
        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deletetechnician/{ssn}")
    @ResponseBody
    public ResponseEntity deleteModel(@PathVariable String ssn) {
        try {
            technicianRepository.deleteById(ssn);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
            return ResponseEntity.ok().body("Failed");
        }
        return ResponseEntity.ok().body("Delete successful");
    }

    @GetMapping("/getAssignedTests/{ssn}")
    @ResponseBody
    public List<Test_info> getTestsAssigned(@PathVariable String ssn) {

        return StreamSupport.stream(testInfoRepository.findAll().spliterator(), false)
                .filter(testInfo -> testInfo.getSsn().equals(ssn))
                .collect(Collectors.toList());
    }
}
