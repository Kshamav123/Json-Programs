package com.json;

import java.util.Scanner;

public class CompanyShares {
	public void computingShares() {

		LinkedList list = new LinkedList();
		Boolean choice = true;
		while (choice) {
			System.out.println("\n1. Add shares\n2. Delete shares\n3. Print shares\n4. Exit");
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.println("Enter company shares");
				int data = scanner.nextInt();
				list.add(data);
				break;
			case 2:
				int deleted = (int) list.deleteAtEnd();
				System.out.println("Deleted company share is " + deleted);
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
