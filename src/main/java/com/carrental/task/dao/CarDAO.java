package com.carrental.task.dao;

import java.util.List;

import com.carrental.task.entity.Car;

public interface CarDAO {

	public Car save(Car car);
	public List<Car> getAllCars();
	public Car rentCar(int id);
	public boolean checkIfAvailible(int id);
	public Car getCar(int id);
	
}
