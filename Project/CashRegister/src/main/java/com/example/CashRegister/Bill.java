package com.example.CashRegister;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
@Component
public class Bill {
	@Inject
	public RegisterFields register;
	public static double totalPrice;
	ArrayList<Items>  itemsPurchased = new ArrayList<Items>();
	Bill() {
		
	}
	public RegisterFields getRegister() {
		return register;
	}
	public void setRegister(RegisterFields register) {
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
	Bill(ArrayList l, double totalPrice) {
		this.totalPrice = totalPrice;
		itemsPurchased=l;
	}
	
	
	Map<String,Double> purchaseItemsPrice = new HashMap<String,Double>();
	
	public Map<String, Double> getItems() {
		for(int i=0;i<itemsPurchased.size();i++) {
			Items currentItem = itemsPurchased.get(i);
//			System.out.println(currentItem.getName()+" "+currentItem.getQuantity());
			Map<String, Map<OFFER_TYPE, Price>> offer = register.getOffer();
			Map<String,Double> items=register.getItems();
			Map<OFFER_TYPE, Price> discounts = offer.get(currentItem.getName());
//			System.out.println(discounts.size()+"hjjshfjsk");
			//add a method to calculate the price, returns price
			double costOfGood=getCost(currentItem,discounts,items);
			purchaseItemsPrice.put(currentItem.getName(),costOfGood);
		}
		return purchaseItemsPrice;
	}
	public double getCost(Items cur, Map<OFFER_TYPE, Price> discount,Map<String, Double> items) {
		// TODO Auto-generated method stub
		double total=0;
			if(discount==null) {
				total+=cur.getQuantity()*items.get(cur.getName());
			}else {
				ArrayList<Price> a=new ArrayList<>();
				a.sort(new Comparator<Price>() {
				public int compare(Price p1, Price p2) {
					return p2.getQuantity()-p1.getQuantity();
				}});
				for(OFFER_TYPE offerType:discount.keySet()) {
					a.add(discount.get(offerType));
				}
				total+=getCost2(items,cur,a);
			}
		return total;
	}
	public double getCost2(Map<String, Double> priceForEach2,Items cur, ArrayList<Price> a) {
		int totalGood=cur.getQuantity();
		double total=0;
		for(Price p:a) {
//			System.out.println("sfsf");
			if(totalGood==0)
				break;
			total+=p.getCost()*(totalGood/p.getQuantity());
			totalGood=totalGood%p.getQuantity();
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
