import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		int accountNum = 0;
		String name = " ";
		double accountBalance = 0;		
		ArrayList<Account> bankAccounts = new ArrayList<Account>();
		Scanner s = new Scanner(System.in);

    try {
      File myObj = new File("bank.txt");
      Scanner reader = new Scanner(myObj);
      while (reader.hasNextLine()) {
        String line = reader.nextLine();
        String [] items = line.split(",");

        try {
          accountNum = Integer.parseInt(items[0]);
        } catch (NumberFormatException e) {
          	System.out.println("Invalid data in file. Skipping a record");
					  reader.nextLine();
        }

         try {
          name = items[1];
        } catch (Exception e) {
          	System.out.println("Invalid data in file. Skipping a record");
					  reader.nextLine();
        }

         try {
          accountBalance = Double.parseDouble(items[2]);
        } catch (NumberFormatException e) {
          	System.out.println("Invalid data in file. Skipping a record");
					  reader.nextLine();
        }

        bankAccounts.add(new Account(accountNum, name, accountBalance));
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  
		char option;
    while(true) {
      Account account = new Account();
      System.out.print("Enter (p)rint, (d)eposit, (w)ithdrawal, (l)ookup, or (q)uit: ");
			option = (s.nextLine()).charAt(0);
			switch (option) {
				case 'p':	
					System.out.print("Enter account number: ");
					accountNum = Integer.parseInt(s.nextLine());
					Account accountEntered = account.findAccount(bankAccounts, accountNum, " ");
					System.out.println(accountEntered);
					break;

				case 'd':	
					System.out.print("Enter account number: ");
					accountNum = Integer.parseInt(s.nextLine());
					accountEntered = account.findAccount(bankAccounts, accountNum, " ");
					double deposit = 0;
					try{
            System.out.print("Enter deposit amount: ");
            deposit = Double.parseDouble(s.nextLine());
					}catch(NumberFormatException e){
						System.out.println("Enter numbers only. No characters allowed.");
					}
					accountEntered.deposit(deposit);	
					break;

				case 'w':
					System.out.print("Enter account number: ");
					accountNum = Integer.parseInt(s.nextLine());
					accountEntered = account.findAccount(bankAccounts, accountNum, " ");
					double withdraw = 0;
					try{
            System.out.print("Enter withdrawal amount: ");
            withdraw = Double.parseDouble(s.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("Enter numbers only. No characters allowed.");
					}
					accountEntered.withdrawal(withdraw);
					break;

				case 'l':	
					System.out.print("Enter name: ");
					name = s.nextLine();
					accountEntered = account.findAccount(bankAccounts, 0, name);
          System.out.print(accountEntered.toString());
					break;
			}
    }
	} 
}