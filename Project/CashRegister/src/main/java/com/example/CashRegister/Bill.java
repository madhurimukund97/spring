package com.example.CashRegister;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

public class Bill {
	
	@Inject
	public Register register;
	public double totalPrice;
	ArrayList<Items>  itemsPurchased = new ArrayList<Items>();
	Bill() {
		
	}
	public Register getRegister() {
		return register;
	}
	public void setRegister(Register register) {
		this.register = register;
	}
	public ArrayList<Items> getItemsPurchased() {
		return itemsPurchased;
	}
	public void setItemsPurchased(ArrayList<Items> itemsPurchased) {
		this.itemsPurchased = itemsPurchased;
	}
	public Map<String, Double> getPurchaseItemsPrice() {
		return purchaseItemsPrice;
	}
	public void setPurchaseItemsPrice(Map<String, Double> purchaseItemsPrice) {
		this.purchaseItemsPrice = purchaseItemsPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	Bill(ArrayList l) {
		
		itemsPurchased=l;
	}
	
	Map<String,Double> purchaseItemsPrice = new HashMap<String,Double>();
	
	public Map<String, Double> getItems() {
		for(int i=0;i<itemsPurchased.size();i++) {
			Items currentItem = itemsPurchased.get(i);
			Map<String, Map<OFFER_TYPE, Price>> offer = register.getOffer();
			Map<String,Double> items=register.getItems();
			Map<OFFER_TYPE, Price> discounts = offer.get(currentItem.getName());
			//add a method to calculate the price, returns price
			double costOfGood=getCost(currentItem.getQuantity(),offer,items);
			purchaseItemsPrice.put(currentItem.getName(),costOfGood);
		}
		return purchaseItemsPrice;
	}
	public double getCost(int quantity,Map<String, Map<OFFER_TYPE, Price>> offer,Map<String, Double> items) {
		// TODO Auto-generated method stub
		Map<String,Integer> purchased=new HashMap<>();
		double total=0;
		for(String curItem:purchased.keySet()) {
			Map<OFFER_TYPE,Price> discount=offer.get(curItem);
			if(discount==null) {
				total+=purchased.get(curItem)*items.get(curItem);
			}else {
				ArrayList<Price> a=new ArrayList<>();
				a.sort(new Comparator<Price>() {
				public int compare(Price p1, Price p2) {
					return p2.getQuantity()-p1.getQuantity();
				}});
				for(OFFER_TYPE offerType:discount.keySet()) {
					a.add(discount.get(offerType));
				}
				total+=getCost2(items,purchased,a,purchased.get(curItem));
			}
		}
		return total;
	}
	public int getCost2(Map<String, Double> priceForEach2, Map<String, Integer> purchased2, ArrayList<Price> a, int totalGoods) {
		int total=0;
		for(Price p:a) {
			if(totalGoods==0)
				break;
			total+=p.getCost()*(totalGoods/p.getQuantity());
			totalGoods=totalGoods%p.getQuantity();
		}
		return total;
	}
	public double getTotalPrice() {
		//add the total in purchaseItemsPrice with for loop
		for (double price : purchaseItemsPrice.values()) {
			totalPrice+=price;
		}
		return totalPrice;
	}
	
}
