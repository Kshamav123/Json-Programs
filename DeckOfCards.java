package com.json;

public class DeckOfCards {
	
	public static void main(String[] args) {

		int i, j, k = 0;
		String suits[] = { "club", "spade", "diamond", "heart" };
		String rank[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		String deck[] = new String[52];
		String player[][] = new String[4][9];

		

		for (i = 0; i < rank.length; i++) {
			for (j = 0; j < suits.length; j++) {
				deck[suits.length * i + j] = rank[i] + " of " + suits[j];
			}
		}

	
		for (i = 0; i < deck.length; i++) {
			int index = i + (int) (Math.random() * (52 - i));
			String temp = deck[index];
			deck[index] = deck[i];
			deck[i] = temp;
		}

	
		for (i = 0; i < suits.length; i++) {
			System.out.print("Player " + (i+1)  + " ");
			for (j = 0; j < 9; j++) {
				player[i][j] = deck[k++];
				System.out.print(player[i][j] + " , ");
			}
			System.out.println();
		}
	}
}