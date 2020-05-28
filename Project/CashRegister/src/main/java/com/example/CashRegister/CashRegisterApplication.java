package com.example.CashRegister;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CashRegisterApplication {
	private static final Logger log = LoggerFactory.getLogger(CashRegisterApplication.class);
	private static final OFFER_TYPE DISCOUNT_AMOUNT = null;
	public static void main(String[] args) {
		SpringApplication.run(CashRegisterApplication.class, args);	
	}
	
	@Bean
	  public CommandLineRunner demo(Register repository) {
	    return (args) -> {
	    	
	    Bill b = new Bill();
	    // ......... addItem() adding single item....
	    log.info("ADD ITEM() METHOD............");
		repository.addItem("apple", 100);
		repository.addItem("orange", 200);
		repository.addItem("yellow", 300);
		repository.addItem("mango", 400);
		for (Entry<String, Double> entry : repository.items.entrySet()) {
		    log.info(entry.getKey() + ":" + entry.getValue().toString());
		} 
		log.info(" ");
		log.info(" ");
		//addItems(multiple items adding through map......
		log.info("ADD ITEMS METHOD............");
		repository.multiple_items.put("potato",200.0);
		repository.multiple_items.put("capsicum",300.0);
		repository.addItems(repository.multiple_items);
		for (Entry<String, Double> entry : repository.items.entrySet()) {
		    log.info(entry.getKey() + ":" + entry.getValue().toString());
		} 
		
		log.info(" ");
		log.info(" ");
		
		//add offer....
		log.info("ADD OFFER METHOD......");
		repository.addOffer("apple", DISCOUNT_AMOUNT, 2, 200);
		for (Entry<String, Map<OFFER_TYPE, Price>> entry : repository.offer.entrySet()) {
		    log.info(entry.getKey());
		    
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
//		b.getItemsPurchased();
//		b.getTotalPrice();
		log.info(" ");
		log.info(" ");
		
		//Cancel Checkout....
		log.info("CANCEL CHECKOUT......");
		repository.cancelCheckout();
		log.info(" ");
		log.info(" ");
		
		//SCAN ITEM
		log.info("SCAN ITEM......");
		double val = repository.scanItem("apple");
		String s=String.valueOf(val);  
		log.info(s);
		log.info(" ");
		log.info(" ");
		
		
		//GET INSTANCE
//		log.info("GET INSTANCE......");
//		repository.getInstance();
//		log.info(" ");
//		log.info(" ");
		
		
		// BILL CLASS 
		
		//getItems
		log.info("get items and their corresponding discount amount");
		b.getItems();
		log.info(" ");
		log.info(" ");
		
		//getTotalCost method
		log.info("GET TOTALCOST METHOD......");
		b.getTotalPrice();
		log.info(" ");
		log.info(" ");
		
	    };
	  }
}
