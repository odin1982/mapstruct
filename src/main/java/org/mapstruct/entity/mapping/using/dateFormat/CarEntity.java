package org.mapstruct.entity.mapping.using.dateFormat;

import java.util.GregorianCalendar;

public class CarEntity {
	private int id;
	private double price;
	private GregorianCalendar manufacturingDate;
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
	public GregorianCalendar getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(GregorianCalendar manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	
}