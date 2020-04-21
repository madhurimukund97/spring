package BankingExample;

public class Main {
	public static void main(String args[]) {
		Account acct = new Account();
		acct.setID(1122);
		acct.setBalance(20000);
		System.out.println("After depositing Rs. 3000 into account, Account balance:  ");

		acct.deposit(3000);
		System.out.println(acct.getBalance());

		acct.withdraw(2500);
		System.out.println("\nAfter withdrawl of Rs.2500, Account balance: ");
		System.out.println(acct.getBalance());

		acct.deposit(32000);

		System.out.println(acct.getBalance());

		acct.setBalance(20000);
		System.out.println(acct.getBalance());
	}
}
