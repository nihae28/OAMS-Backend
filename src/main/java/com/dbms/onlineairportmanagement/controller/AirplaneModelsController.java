package com.dbms.onlineairportmanagement.controller;

import com.dbms.onlineairportmanagement.model.AirplaneModel;
import com.dbms.onlineairportmanagement.repository.AirplaneModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/airplane_models")
public class AirplaneModelsController {

    @Autowired
    AirplaneModelRepository airplaneModel;

    @GetMapping("/getmodels")
    @ResponseBody
    public List<AirplaneModel> getAirplaneModels() {
        return StreamSupport.stream(airplaneModel.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @PostMapping("/insertmodel")
    @ResponseBody
    public ResponseEntity insertModel(@RequestBody AirplaneModel model) {
        try {
            airplaneModel.save(model);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
            return ResponseEntity.ok().body("Failed");
        }
        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deleteModel/{modelno}")
    @ResponseBody
    public ResponseEntity deleteModel(@PathVariable int modelno) {
        try {
            airplaneModel.deleteById(modelno);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
            return ResponseEntity.ok().body("Failed");
        }
        return ResponseEntity.ok().body("Delete successful");
    }
}
