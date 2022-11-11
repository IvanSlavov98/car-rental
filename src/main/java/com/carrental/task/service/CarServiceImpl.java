package com.carrental.task.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrental.task.dao.CarDAO;
import com.carrental.task.entity.Car;

@Service
public class CarServiceImpl implements CarService {

	private CarDAO carDAO;
	
	@Autowired
	public CarServiceImpl(CarDAO carDAO) {
		this.carDAO = carDAO;
	}

	@Override
	@Transactional
	public Car save(Car car) {
		return carDAO.save(car);
	}

	@Override
	@Transactional
	public List<Car> getAllCars() {
		return carDAO.getAllCars();
	}

	@Override
	@Transactional
	public Car rentCar(int id) {
		return carDAO.rentCar(id);
	}

	@Override
	@Transactional
	public boolean checkIfAvailible(int id) {
		return carDAO.checkIfAvailible(id);
	}

	@Override
	@Transactional
	public Car getCar(int id) {
		return carDAO.getCar(id);
	}

}
