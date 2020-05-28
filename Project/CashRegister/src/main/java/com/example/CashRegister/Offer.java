package com.example.CashRegister;
import javax.persistence.*;

@Entity
@Table(name = "offers")
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private OFFER_TYPE name;
	
	@Column 
	private String item;
	
	@Column
	private int quantity;
	
	@Column
	private double amount;
	
	public Offer() {

	}

	protected Offer(String item, OFFER_TYPE name, int quantity, double amount) {
		super();
		this.item = item;
		this.name = name;
		this.quantity = quantity;
		this.amount = amount;
	}


	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OFFER_TYPE getName() {
		return name;
	}

	public void setName(OFFER_TYPE name) {
		this.name = name;
	}
}