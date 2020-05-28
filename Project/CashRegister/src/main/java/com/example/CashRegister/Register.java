package com.example.CashRegister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Singleton;

import org.springframework.stereotype.Component;

import com.example.exceptions.CheckoutInProgressException;
import com.example.exceptions.InvalidItemScan;
import com.example.exceptions.NoCheckoutInProgressException;

@Component
public class Register {
//	private static Singleton single_instance = ;
	private boolean isCheckoutInProgress;
	public Map<String, Double> items = new HashMap<>();
	public Map<String, Double> multiple_items = new HashMap<>();
	public Map<String, Map<OFFER_TYPE, Price>> offer = new HashMap<>();
	
	Register() {
		
	}
	public boolean isCheckoutInProgress() {
		return isCheckoutInProgress;
	}
	
	public Map<String, Double> getItems() {
		return items;
	}
	
	public Map<String, Map<OFFER_TYPE, Price>> getOffer() {
		return offer;
	}
	
	public void  startCheckout() throws CheckoutInProgressException{
		
		isCheckoutInProgress=true;
		System.out.println(isCheckoutInProgress);
		
	}
//	public Bill finishCheckout() throws NoCheckoutInProgressException{
//		Bill b = new Bill();
////		ArrayList<Items>  itemsPurchased = b.itemsPurchased;
////		double price = b.getTotalPrice();
////		Bill bill = new Bill(itemsPurchased, price);
//		return bill;
//	}
	public void cancelCheckout() throws NoCheckoutInProgressException{
		isCheckoutInProgress = false;
		System.out.println(isCheckoutInProgress);
		
	}
	public double scanItem(String item) throws InvalidItemScan, NoCheckoutInProgressException{
//		if(!isCheckoutInProgress) {
//			throw new NoCheckoutInProgressException();
//		}
//		if (items.get(item)==null) {
//			throw new InvalidItemScan();
//		} 
		return items.get(item);
	}
	
//	public Register getInstance() {
//		if (single_instance == null) 
//            single_instance = (Singleton) new Register(); 
//  
//        return (Register) single_instance; 
		
		
//	}
	// add items to a map
	public void addItem(String item, double price) throws CheckoutInProgressException {
		items.put(item,price);
	}
	// Add multiple items
	void addItems(Map itemPriceMap) throws CheckoutInProgressException {
		Iterator<Map.Entry<String, Double>> itr = itemPriceMap.entrySet().iterator(); 
		while(itr.hasNext()) 
        { 
             Map.Entry<String, Double> entry = itr.next(); 
             addItem(entry.getKey(), entry.getValue());
        } 
	}
	public void addOffer(String item, OFFER_TYPE offerType, int N, double d) throws CheckoutInProgressException {
		if(offer.get(item)!=null) {
			Map<OFFER_TYPE,Price> m = offer.get(item);
			m.put(offerType, new Price(N,d));
		} else {
			Map<OFFER_TYPE, Price> currentItem = new HashMap<OFFER_TYPE, Price>();
			currentItem.put(offerType, new Price(N,d));
			offer.put(item, currentItem);
		}
	}
}
