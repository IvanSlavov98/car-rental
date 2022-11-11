package com.carrental.task.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "model")
	private String model;

	@Column(name = "available")
	private boolean available;
	
	public Car() {
		
	}

	public Car(int id, String model, boolean available) {
		this.id = id;
		this.model = model;
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailible(boolean available) {
		this.available = available;
	}
	
}
