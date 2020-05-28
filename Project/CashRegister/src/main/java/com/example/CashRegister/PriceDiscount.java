package com.example.CashRegister;

public class PriceDiscount {
	private int quantity;
	private double cost;
	
	public PriceDiscount(int quantity, double cost) {
		
		this.quantity = quantity;
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
