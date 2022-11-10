package CRUD.CRUD.controllers;

import CRUD.CRUD.entities.Car;
import CRUD.CRUD.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity createCar(@RequestBody Car car){
        return carService.createCar(car);
    }

    @GetMapping
    public ResponseEntity getCars(){
        return carService.getCars();
    }

    @GetMapping("/{id}")
    public ResponseEntity getcar(@PathParam("id")long id){
        return carService.getCar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity editCarType(@PathParam("id")long id, @RequestBody Car car){
        return carService.editCarType(id, car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(@PathParam("id")long id){
        return carService.deleteCar(id);
    }

    @DeleteMapping
    public ResponseEntity deleteCars(){
        return carService.deleteCars();
    }
}