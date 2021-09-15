package com.json;

import java.util.Scanner;

public class ShareMain {
	public static void main(String[] args) {
	      
		Boolean choice = true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.Company share\n2.Stock symbol\n3.date and time\n4.Exit");
		int option = scanner.nextInt();
		switch(option) {
		case 1:CompanyShares shares = new CompanyShares();
		       shares.computingShares();
		       break;
		case 2:StackSymbol symbol = new StackSymbol();
		       symbol.computingSymbol();
		       break;
		case 3:DateTime time =new DateTime();
		       time.computingTime();
		       break;
		case 4:choice = false;
		       break;
		 default:System.out.println("Invalid choice");
		}
		
	}
}
