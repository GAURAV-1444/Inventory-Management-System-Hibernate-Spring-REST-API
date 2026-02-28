package com.product.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String category;
	private double price;
	private String manufacturingDate; // YYYY-MM-DD
	private String expiryDate; // YYYY-MM-DD
	private int warranty; // Months
	private int quantity;

//	public Products() {
//		super();
//	}
//
//	public Products(int id, String name, String category, double price, String manufacturingDate, String expiryDate,
//			int warranty, int quantity) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.category = category;
//		this.price = price;
//		this.manufacturingDate = manufacturingDate;
//		this.expiryDate = expiryDate;
//		this.warranty = warranty;
//		this.quantity = quantity;
//	}
//
//	public Products(String name, String category, double price, String manufacturingDate, String expiryDate,
//			int warranty, int quantity) {
//		super();
//		this.name = name;
//		this.category = category;
//		this.price = price;
//		this.manufacturingDate = manufacturingDate;
//		this.expiryDate = expiryDate;
//		this.warranty = warranty;
//		this.quantity = quantity;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//
//	public String getManufacturingDate() {
//		return manufacturingDate;
//	}
//
//	public void setManufacturingDate(String manufacturingDate) {
//		this.manufacturingDate = manufacturingDate;
//	}
//
//	public String getExpiryDate() {
//		return expiryDate;
//	}
//
//	public void setExpiryDate(String expiryDate) {
//		this.expiryDate = expiryDate;
//	}
//
//	public int getWarranty() {
//		return warranty;
//	}
//
//	public void setWarranty(int warranty) {
//		this.warranty = warranty;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	@Override
//	public String toString() {
//		return "Products [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price
//				+ ", manufacturingDate=" + manufacturingDate + ", expiryDate=" + expiryDate + ", warranty=" + warranty
//				+ ", quantity=" + quantity + "]";
//	}

}
