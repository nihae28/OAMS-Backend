package com.dbms.onlineairportmanagement.controller;

import com.dbms.onlineairportmanagement.model.TrafficController;
import com.dbms.onlineairportmanagement.repository.TrafficControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/trafficController")
public class TrafficControllerController {
    @Autowired
    private TrafficControllerRepository trafficControllerRepository;

    @PostMapping("/add/{name}")
    public ResponseEntity<?> saveUser(@PathVariable String name, @RequestParam String last_exam_date) throws ParseException {
        System.out.println("saving for" + name);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(last_exam_date+" 00:00", formatter);

        TrafficController trafficController = new TrafficController(name, dateTime);
        TrafficController savedTrafficController = trafficControllerRepository.save(trafficController);
        return ResponseEntity.ok(savedTrafficController);
    }

    @GetMapping("/lastExamDate/{name}")
    public ResponseEntity<?> getLastExamDate(@PathVariable String name) {
        System.out.println("getting data for" + name);
        TrafficController trafficController = trafficControllerRepository.getTrafficControllerBySsn(name);
        return  ResponseEntity.ok(trafficController);
    }
}
