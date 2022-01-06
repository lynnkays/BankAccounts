/**
 * <Account.java>
 * <Kaylynn Diaz-Schott>
 * 
 * <Contains a constructor and has the methods that control the deposit, withdrawl and the get Methods>
 */

import java.util.*;

public class Account {
	private int number;
	private String name;
	private double balance;

  public Account () {}
	
	public Account(int number, String name, double balance) {
		this.number = number;
		this.name = name;
		this.balance = balance;
	}
	
	public void deposit(double add) {
		balance+=add;
	}
	
	public void withdrawal(double minus) {
		balance-=minus;
	}
	
	public int getNum() {
		return number;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
  
  public Account findAccount (ArrayList<Account> accounts, int accountNumber, 
      String name) {
		for(int i = 0; i < accounts.size();i++){
      System.out.println(accounts.get(i).getName());
			if ((accounts.get(i).getNum()== accountNumber) || 
        accounts.get(i).getName().equals(name)) {
				  return accounts.get(i); 
			}
		}
		return null;
	} 
	
	public String toString() {
		return "\n" + this.number + ", " + this.name + ", $" + this.balance + "\n";
	}
}