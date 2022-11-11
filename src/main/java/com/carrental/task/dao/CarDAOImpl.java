package com.carrental.task.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carrental.task.entity.Car;

@Repository
public class CarDAOImpl implements CarDAO {

	private EntityManager entityManager;
	
	@Autowired
	public CarDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Car save(Car car) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(car);
		
		return car;
	}

	@Override
	public List<Car> getAllCars() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Car> query = session.createQuery("from Car", Car.class);
	
		List<Car> cars = query.getResultList();
		
		return cars;
	}

	@Override
	public Car rentCar(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		if(checkIfAvailible(id) == true) {
			Car car = session.get(Car.class, id);	
			car.setAvailible(false);
			return car;
		}
		
		return null;
	}

	@Override
	public boolean checkIfAvailible(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("select c.available from Car c where c.id=:carId");
		
		query.setParameter("carId", id);
		
		boolean res = (boolean) query.getSingleResult();
		
		return res;
	}

	@Override
	public Car getCar(int id) {

		Session session = entityManager.unwrap(Session.class);
		
		Car car = session.get(Car.class, id);
		
		return car;
	}

}
