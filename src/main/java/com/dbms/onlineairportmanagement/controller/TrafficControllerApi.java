package com.dbms.onlineairportmanagement.controller;

import com.dbms.onlineairportmanagement.model.TrafficController;
import com.dbms.onlineairportmanagement.repository.TrafficControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequestMapping("/traffic-controller")
@RestController
public class TrafficControllerApi {

    @Autowired
    TrafficControllerRepository controllerRepository;


    @GetMapping("/getcontroller")
    @ResponseBody
    public List<TrafficController> getAirplaneModels() {
        return StreamSupport.stream(controllerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @PostMapping("/insertcontroller")
    @ResponseBody
    public ResponseEntity insertModel(@RequestBody TrafficController trafficController) {
        try {
            controllerRepository.save(trafficController);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
            return ResponseEntity.ok().body("Failed");
        }
        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deletecontroller/{ssn}")
    @ResponseBody
    public ResponseEntity deleteModel(@PathVariable String ssn) {
        try {
            controllerRepository.deleteById(ssn);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
            return ResponseEntity.ok().body("Failed");
        }
        return ResponseEntity.ok().body("Delete successful");
    }
}
