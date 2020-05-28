package com.example.CashRegister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.springframework.stereotype.Component;

import com.example.exceptions.CheckoutInProgressException;
import com.example.exceptions.InvalidItemScan;
import com.example.exceptions.NoCheckoutInProgressException;

@Component
public class Register {
	@Inject
	private RegisterFields reg;
	public void  startCheckout() throws CheckoutInProgressException{
		reg.setCheckoutInProgress(true);
		System.out.println(reg.isCheckoutInProgress());
		
	}
	public Bill finishCheckout() throws NoCheckoutInProgressException{
		Bill b = new Bill();
		ArrayList<Items>  itemsPurchased = b.itemsPurchased;
		double price = b.getTotalPrice();
		Bill bill = new Bill(itemsPurchased, price);
		return bill;
	}
	public void cancelCheckout() throws NoCheckoutInProgressException{
		reg.setCheckoutInProgress(false);
		System.out.println(reg.isCheckoutInProgress());
		
	}
	public double scanItem(String item) throws InvalidItemScan, NoCheckoutInProgressException{
//		if(!reg.isCheckoutInProgress()) {
//			throw new NoCheckoutInProgressException();
//		}
//		if (reg.getItems().get(item)==null) {
//			throw new InvalidItemScan();
//		} 
		return reg.getItems().get(item);
	}
	
	public Register getInstance() {
        return reg.getSingleInstance(); 	
	}
	// add items to a map
	public void addItem(String item, double price) throws CheckoutInProgressException {
		reg.items.put(item,price);
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
		if(reg.getOffer().get(item)!=null) {
			Map<OFFER_TYPE,Price> m = reg.getOffer().get(item);
//			System.out.println(m.size()+"adding");
			m.put(offerType, new Price(N,d));
			Map<String, Map<OFFER_TYPE, Price>> cur=reg.getOffer();
			cur.put(item, m);
			reg.setOffer(cur);
//			System.out.println(m.size()+"fsfs");
		} else {
			Map<OFFER_TYPE, Price> currentItem = new HashMap<OFFER_TYPE, Price>();
//			System.out.println(offerType+" #####"+N);
			currentItem.put(offerType, new Price(N,d));
			Map<String, Map<OFFER_TYPE, Price>> cur=reg.getOffer();
			cur.put(item, currentItem);	
		}
	}
}
