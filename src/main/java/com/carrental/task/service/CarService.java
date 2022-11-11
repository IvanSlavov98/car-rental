package com.carrental.task.service;

import com.carrental.task.entity.Car;

import java.util.List;

public interface CarService {

	public Car save(Car car);
	public List<Car> getAllCars();
	public Car rentCar(int id);
	public Car getCar(int id);
	public boolean checkIfAvailible(int id);
	
}
