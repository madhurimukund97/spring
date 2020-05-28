package com.example.CashRegister;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CashRegisterApplication {
	@Inject
    RegisterFields reg;
	@Inject
	Bill b;
	private static final Logger log = LoggerFactory.getLogger(CashRegisterApplication.class);
	private static final OFFER_TYPE DISCOUNT_AMOUNT = null;
	public static void main(String[] args) {
		SpringApplication.run(CashRegisterApplication.class, args);	
	}
	
	@Bean
	  public CommandLineRunner demo(Register repository) {
	    return (args) -> {
	    
	    
	    // ......... addItem() adding single item....
	    log.info("ADD ITEM() METHOD............");
		repository.addItem("apple", 120);
		repository.addItem("orange", 200);
		repository.addItem("yellow", 300);
		repository.addItem("mango", 400);
		for (Entry<String, Double> entry : reg.getItems().entrySet()) {
		    log.info(entry.getKey() + ":" + entry.getValue().toString());
		} 
		log.info(" ");
		log.info(" ");
		//addItems(multiple items adding through map......
		log.info("ADD ITEMS METHOD............");
		reg.multiple_items.put("potato",200.0);
		reg.multiple_items.put("capsicum",300.0);
		repository.addItems(reg.multiple_items);
		for (Entry<String, Double> entry : reg.getItems().entrySet()) {
		    log.info(entry.getKey() + ":" + entry.getValue().toString());
		} 
		
		log.info(" ");
		log.info(" ");
		
		//add offer....
		log.info("ADD OFFER METHOD......");
		repository.addOffer("apple", OFFER_TYPE.DISCOUNT_AMOUNT, 3, 300);
		repository.addOffer("apple", OFFER_TYPE.DISCOUNT_PERCENT, 2, 210);
		repository.addOffer("orange", OFFER_TYPE.DISCOUNT_AMOUNT, 3, 200);
		for (Entry<String, Map<OFFER_TYPE, Price>> entry : reg.offer.entrySet()) {
		    log.info(entry.getKey());
//		    System.out.println(entry.getValue().size());
		    for( OFFER_TYPE cur:entry.getValue().keySet()) {
		    	if(cur==null) {
		    		
		    	}
//		    		System.out.println("null");
		    	else {
//		    		System.out.println(entry.getValue().get(cur).getQuantity());
		    		log.info(cur.toString());
		    		log.info(String.valueOf(entry.getValue().get(cur).getQuantity()));
		    		}
		    }  
		} 
		log.info(" ");
		log.info(" ");
		
		//Start Checkout......
		log.info("START CHECKOUT......");
		repository.startCheckout();
		log.info(" ");
		log.info(" ");
		
		//Finish Checkout....
		log.info("FINISH CHECKOUT......");
		Bill bill = repository.finishCheckout();
		b.getItemsPurchased();
		b.getTotalPrice();
		log.info(" ");
		log.info(" ");
		
		//Cancel Checkout....
		log.info("CANCEL CHECKOUT......");
		repository.cancelCheckout();
		log.info(" ");
		log.info(" ");
		
		//SCAN ITEM
		log.info("SCAN ITEM......");
		double val = repository.scanItem("capsicum");
		String s=String.valueOf(val);  
		log.info(s);
		log.info(" ");
		log.info(" ");
		
		
		//GET INSTANCE
		log.info("GET INSTANCE......");
		repository.getInstance();
		log.info(" ");
		log.info(" ");
		
		
		// BILL CLASS 
		
		//getItems
		log.info("get items and their corresponding discount amount");
		ArrayList<Items> a = new ArrayList<>();
		a.add(new Items("apple",8));
		b.setItemsPurchased(a);
		for (Entry<String, Double> entry : b.getItems().entrySet()) {
		    log.info(entry.getKey() + ":" + entry.getValue().toString());
		} 
//		b.getItems();
		log.info(" ");
		log.info(" ");
		
		//getTotalCost method
		log.info(b.getTotalPrice()+"GET TOTALCOST METHOD......");
		b.getTotalPrice();
		log.info(" ");
		log.info(" ");
		
	    };
	 }
}
