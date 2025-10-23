package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        homeScreen();
        System.out.println("How many players are at the table today?\nType Here: ");
        int playerNum = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Player> table = new ArrayList<>();
        ArrayList<Player> endGame = new ArrayList<>();

        for (int i = 1;i<=playerNum;i++){
            Hand hand = new Hand();

            System.out.printf("\nPlease enter player %d's name: ",i);
            String playerName = scanner.nextLine();
            Player player = new Player(playerName,i,hand);
            table.add(player);
            hand.deal(deck.deal());
            hand.deal(deck.deal());
        }
        //the house plays too..
        Hand houseHand = new Hand();
        Player house = new Player("house",0,houseHand);
        houseHand.deal(deck.deal());
        System.out.printf("The dealer reveals it's first card...\n%d!",houseHand.getValue());
        // compare 'em captain
        //hold the scores here
        Player highestScorer = null;
        int highScore = 0;

        for (Player p : table){
            System.out.printf("\n%s's hand is has %d total points.",p.getPlayerName(),p.getHand().getValue());
            System.out.printf("%s, would you like to hit or stay?\n[HIT] [STAY]\nType Here: ",p.getPlayerName());
            String hitStay = scanner.nextLine().trim().toUpperCase();
            switch (hitStay){
                case "H","HIT":
                    p.getHand().deal(deck.deal());
                    break;
                case "S","STAY":
                    System.out.printf("%s is choosing to STAY!",p.getPlayerName());

                    break;
                default:
            }

        }

        //for final scores
        for (Player p : endGame){
            System.out.printf("\n%s's hand is has %d total points.",p.getPlayerName(),p.getHand().getValue());
            if (p.getHand().getValue()>highScore){
                highestScorer = p;
                highScore = p.getHand().getValue();
            }

        }



       /** if (hand1.getValue()>hand2.getValue()){
            System.out.printf("%s is the winner!",player1Name);

        }else if (hand2.getValue()>hand1.getValue()){
            System.out.printf("%s is the winner!",player2Name);

        }else{
            System.out.println("Tie!");
        }*/


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