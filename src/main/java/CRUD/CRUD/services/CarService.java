package CRUD.CRUD.services;

import CRUD.CRUD.entities.Car;
import CRUD.CRUD.repositories.services.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;


    public ResponseEntity createCar(Car car) {
        carRepository.save(car);
        return ResponseEntity.status(HttpStatus.OK).body("A new car has been created");
    }

    public ResponseEntity getCars() {
        List<Car> carList = new ArrayList<>(carRepository.findAll());
        return  ResponseEntity.status(HttpStatus.OK).body(carList);
    }

    public ResponseEntity getCar(long id) {
        if(carRepository.existsById(id))
            return ResponseEntity.status(HttpStatus.OK).body(carRepository.findById(id));
        else{
            Car car1 = new Car();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(car1);
        }
    }

    public ResponseEntity editCarType(long id, Car car) {
        if(carRepository.existsById(id)) {
            car.setId(id);
            carRepository.save(car);
            return ResponseEntity.status(HttpStatus.OK).body("The car's type has been edited");
        }
        else{
            Car car1 = new Car();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(car1);
        }
    }

    public ResponseEntity deleteCar(long id) {
        if(carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("The car has been deleted");
        }
        else{
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity deleteCars() {
        carRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Every car has been deleted");
    }
}