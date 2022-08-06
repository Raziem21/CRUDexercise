package co.develhope.CRUDexercise.controllers;

import co.develhope.CRUDexercise.entities.Car;
import co.develhope.CRUDexercise.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping
    public Car create(@RequestBody Car car) {
        Car carSaved = carRepository.saveAndFlush(car);
        return carSaved;
    }

    @GetMapping("/{id}")
    public Optional<Car> readCar(@PathVariable long id) {
        Optional<Car> car = carRepository.findById(id);
        return car;
    }

    @GetMapping("/viewAll")
    public List<Car> readAllCars() {
        List<Car> car = carRepository.findAll();
        return car;
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable long id, @RequestBody Car car) {
        car.setId(id);
        Car newCar = carRepository.saveAndFlush(car);
        return newCar;
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id) {
        carRepository.deleteById(id);
    }

    @DeleteMapping("")
    public void deleteAllCars(@RequestParam List<Long> ids) {
        carRepository.deleteAllById(ids);
    }
}
