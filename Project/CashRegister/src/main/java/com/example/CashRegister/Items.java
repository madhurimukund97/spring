package com.example.CashRegister;

import java.util.Map;

public class Items {
	private String name;
	private int quantity;
	public Items(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
//	log.info("ADD OFFER METHOD......");
//	repository.addOffer("apple", DISCOUNT_AMOUNT, 2, 200);
//	for ( String entry : repository.offer.keySet()) {
//		Map<OFFER_TYPE, Price> a=repository.offer.get(entry);
//		for(OFFER_TYPE of:a.keySet())
//			log.info(of+" "+a.get(of));
//	} 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
