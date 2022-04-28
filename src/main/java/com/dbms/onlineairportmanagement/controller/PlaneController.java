package com.dbms.onlineairportmanagement.controller;


import com.dbms.onlineairportmanagement.model.AirplaneModel;
import com.dbms.onlineairportmanagement.model.Plane;
import com.dbms.onlineairportmanagement.model.response.AirplaneWithModelDetails;
import com.dbms.onlineairportmanagement.repository.AirplaneModelRepository;
import com.dbms.onlineairportmanagement.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/plane-controller")
public class PlaneController {

    @Autowired
    PlaneRepository planeRepository;
    @Autowired
    AirplaneModelRepository airplaneModelRepository;


    @GetMapping("/getplanes")
    @ResponseBody
    public List<Plane> getAirplaneModels() {
        return StreamSupport.stream(planeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @PostMapping("/insertplane")
    @ResponseBody
    public ResponseEntity insertModel(@RequestBody Plane plane) {
        try {
            planeRepository.save(plane);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
            return ResponseEntity.ok().body("Failed");
        }
        return ResponseEntity.ok().body("Insert successful");
    }

    @GetMapping("/deleteplane/{reg}")
    @ResponseBody
    public ResponseEntity deleteModel(@PathVariable int reg) {
        try {
            planeRepository.deleteById(reg);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
            return ResponseEntity.ok().body("Failed");
        }
        return ResponseEntity.ok().body("Delete successful");
    }

    @GetMapping("/getPlane/{reg}")
    @ResponseBody
    public ResponseEntity getPlaneDetails(@PathVariable int reg) {
        try {
            List<Plane> planes =planeRepository.findByRegNo(reg);
            List<AirplaneWithModelDetails> airplaneWithModelDetailsList = planes.stream().map(plane -> {
                AirplaneModel airplaneModel = this.airplaneModelRepository.findById(plane.getModelNo()).get();
                AirplaneWithModelDetails airplaneWithModelDetails = new AirplaneWithModelDetails(plane.getRegNo(), airplaneModel != null ? airplaneModel.getModelNo() : plane.getModelNo(), airplaneModel != null ?  airplaneModel.getCapacity() : 1, airplaneModel != null ?  airplaneModel.getWeight() : 1);
                return airplaneWithModelDetails;}).collect(Collectors.toList());
            return ResponseEntity.ok().body(airplaneWithModelDetailsList);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
            return ResponseEntity.ok().body("Failed");
        }
    }
}
