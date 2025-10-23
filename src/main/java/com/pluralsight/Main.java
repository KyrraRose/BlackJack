package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();

        homeScreen();
        System.out.print("Please enter player 1's name: ");
        String player1Name = scanner.nextLine(); //dot notation

        System.out.print("Please enter player 2's name: ");
        String player2Name = scanner.nextLine();

        // deal 5 cards
        deck.shuffle();

        for (int i = 0; i < 2; i++) {
            hand1.deal(deck.deal());
            hand2.deal(deck.deal());
        }
        System.out.printf("%s's hand is worth %d.",player1Name,hand1.getValue());
        System.out.println();
        System.out.printf("%s's hand is worth %d.",player2Name,hand2.getValue());
        System.out.println();

        if (hand1.getValue()>hand2.getValue()){
            System.out.printf("%s is the winner!",player1Name);

        }else if (hand2.getValue()>hand1.getValue()){
            System.out.printf("%s is the winner!",player2Name);

        }else{
            System.out.println("Tie!");
        }


        scanner.close();
    }

    public static void homeScreen() {
        System.out.println("˚　　　　✦　　　.　　. 　 ˚　.　　　　　 . ✦　　　 　˚　　　　 . ★⋆.\n" +
                "˚　　*   　　✦　　　.　　.　　　✦　˚　.˚　　　　.　　. 　 ˚　.　　　 ✦");
        System.out.println("Welcome to the Table ✦　　　.　　.　　　✦　˚　.˚   . ✦　.　　　˚　");
        System.out.println("BlackJack is what we're serving today..˚　　　　✦　　　.　　.");
        System.out.println("˚　　　　✦　　　.　　. 　 ˚　.　　　　　 . ✦　　　 　˚　　　　 . ★⋆\n" +
                "˚　　*   　　✦　　　.　　.　　　✦　˚　.˚　　　　.　　. 　 ˚　.　　　 ✦");
    }

}