package com.study.project.controllers;

import com.study.project.entities.Car;
import com.study.project.repositories.ProjectCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private ProjectCarRepository projectCarRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAll(){
        List<Car> cars = projectCarRepository.findAll();
        return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Car>create(@RequestBody Car car){
        Car car1 = projectCarRepository.save(car);
        return new ResponseEntity<Car>(car1, HttpStatus.CREATED);
    }
    @GetMapping("/read")
    public ResponseEntity<Car> read(@RequestParam long id){
        Car cars1 = projectCarRepository.findById(id).get();
        return new ResponseEntity<Car>(cars1, HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Car ca){
        if (ca.getId()== null){
            return new ResponseEntity<String>("Id not found", HttpStatus.NOT_FOUND);
        }
        Car carr = projectCarRepository.saveAndFlush(ca);
        return new ResponseEntity<Car>(carr, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam long idc){
        if (!projectCarRepository.existsById(idc)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        projectCarRepository.deleteById(idc);
        return new ResponseEntity<String>("Deleted by sucess", HttpStatus.NO_CONTENT);
    }
}