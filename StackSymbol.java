package com.json;

import java.util.Scanner;

public class StackSymbol {
	
	public void computingSymbol() {
		LinkedList list = new LinkedList();
		Boolean choice = true;
		while (choice) {
			System.out.println("\n1. Add symbol\n2. Delete symbol\n3. Print symbol\n4. Exit");
			Scanner scanner = new Scanner(System.in);
			Scanner scanner2 = new Scanner(System.in);
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.println("Enter company symbol");
				String data = scanner2.nextLine();
				list.add(data);
				break;
			case 2:
				String deleted = (String) list.deleteAtEnd();
				System.out.println("Deleted company symbol is " + deleted);
				break;
			case 3:
				list.print();
				break;

			case 4:
				choice = false;
				break;
			default:
				System.out.println("Invalid choice");

			}
		}
	}
}
