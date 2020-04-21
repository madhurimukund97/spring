package BankingExample;

public class Account {
	private static final double RATE = 1;
	int id;
	double balance;

	public Account() {

	}

	// customer id setter method
	public void setID(int i) {
		id = i;
	}

	// customer id getter method
	public int getID() {
		return id;
	}
	
	//set balance account
	public void setBalance(double amt) {
		balance = balance + amt;
	}
	
	//get account balance
	public double getBalance() {
		return balance;
	}
	
	// withdraw amount from the bank
	public void withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
		} else {
			System.out.println("Insufficient funds");
		}
	}

	//adds deposit amount to balance.
	public void deposit(double amount) {
		balance += amount;
	}
	
	// Adds interest to the account and returns the new balance.
	public double addInterest() {
		balance += (balance * RATE);
		return balance;
	}
}
