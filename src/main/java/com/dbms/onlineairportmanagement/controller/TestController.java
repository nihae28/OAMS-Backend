package com.dbms.onlineairportmanagement.controller;

import com.dbms.onlineairportmanagement.model.FAATest;
import com.dbms.onlineairportmanagement.repository.FAATestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/tests-controller")
public class TestController {

    @Autowired
    FAATestRepository faaTestRepository;

    @GetMapping("/gettests")
    @ResponseBody
    public List<FAATest> getAirplaneModels() {
        return StreamSupport.stream(faaTestRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @PostMapping("/inserttest")
    @ResponseBody
    public ResponseEntity insertModel(@RequestBody FAATest test) {
        try {
            faaTestRepository.save(test);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
            return ResponseEntity.ok().body("Failed");
        }
        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deletetest/{faano}")
    @ResponseBody
    public ResponseEntity deleteModel(@PathVariable String faano) {
        try {
            faaTestRepository.deleteById(faano);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
            return ResponseEntity.ok().body("Failed");
        }
        return ResponseEntity.ok().body("Delete successful");
    }

}
