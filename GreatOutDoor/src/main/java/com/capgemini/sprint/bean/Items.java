package com.capgemini.sprint.bean;

public class Items {
	String name;
	int id;
	double price;

	Items() {
	}
    public Items(String name, int id, double price) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
		
	}
