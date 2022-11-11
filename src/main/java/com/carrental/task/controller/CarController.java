package com.carrental.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrental.task.entity.Car;
import com.carrental.task.service.CarService;

@RestController
@RequestMapping("/api")
public class CarController {

	private CarService carService;
	
	@Autowired
	public CarController(CarService carService) {
		this.carService=carService;
	}
	
	@PostMapping("/cars")
	public Car createListing(@RequestBody Car car) {
		car.setId(0);
		carService.save(car);
		return car;
	}
	
	@PutMapping("/cars")
	public Car updateCar(@RequestBody Car car) {
		carService.save(car);
		return car;
	}
	
	@GetMapping("/cars")
	public List<Car> getAllCars(){
		return carService.getAllCars();
	}
	
	@GetMapping("/car/{id}")
	public Car getCar(@PathVariable int id) {
		Car car = carService.getCar(id);
		
		if(car == null) {
			throw new CarNotFoundException("Car id not found: " + id);
		}
		
		return car;
	}
	
	@GetMapping("/cars/{id}")
	public boolean checkIfAvailable(@PathVariable int id) {
		
		Car car = carService.getCar(id);
		
		if(car == null) {
			throw new CarNotFoundException("Car id not found: " + id);
		}
		
		return carService.checkIfAvailible(id);
	}
	
	@PutMapping("/cars/{id}")
	public Car rentCar(@PathVariable int id) {
		
		Car car = carService.getCar(id);
		
		if(car == null) {
			throw new CarNotFoundException("Car id not found: " + id);
		}
		
		return carService.rentCar(id);
	} 
	
}
