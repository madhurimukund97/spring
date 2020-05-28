package com.example.CashRegister;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public class RegisterFields {
	private static final Register single_instance = new Register();
	private boolean isCheckoutInProgress;
	public Map<String, Double> items = new HashMap<>();
	public Map<String, Double> multiple_items = new HashMap<>();
	public Map<String, Map<OFFER_TYPE, Price>> offer = new HashMap<>();
	public boolean isCheckoutInProgress() {
		return isCheckoutInProgress;
	}
	public void setCheckoutInProgress(boolean isCheckoutInProgress) {
		this.isCheckoutInProgress = isCheckoutInProgress;
	}
	public Map<String, Double> getItems() {
		return items;
	}
	public void setItems(Map<String, Double> items) {
		this.items = items;
	}
	public Map<String, Double> getMultiple_items() {
		return multiple_items;
	}
	public void setMultiple_items(Map<String, Double> multiple_items) {
		this.multiple_items = multiple_items;
	}
	public Map<String, Map<OFFER_TYPE, Price>> getOffer() {
		return offer;
	}
	public void setOffer(Map<String, Map<OFFER_TYPE, Price>> offer) {
		this.offer = offer;
	}
	public static Register getSingleInstance() {
		return single_instance;
	}
	
	
}
