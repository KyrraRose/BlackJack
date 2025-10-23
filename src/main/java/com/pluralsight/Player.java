package com.pluralsight;

public class Player {
    private String playerName;
    private int playerNum;
    private Hand hand;
    private boolean stay;

    public Player(String playerName, int playerNum,Hand hand) {
        this.playerName = playerName;
        this.playerNum = playerNum;
        this.hand = hand;
        this.stay = false;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public boolean isStaying() {
        return stay;
    }

    public void setStay(boolean stay) {
        this.stay = stay;
    }
}
