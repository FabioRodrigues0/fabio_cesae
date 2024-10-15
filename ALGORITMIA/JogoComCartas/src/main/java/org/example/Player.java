package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Player extends User {
    int points;
    String nickname;
    Card playerCard;
    ArrayList<Card> playerHand;

    public Player() {
    }

    void drawCard(Collection<Card> tempHand){
            if (playerHand == null){
                playerHand = new ArrayList<>();
            }
            playerHand.addAll(tempHand);
    }

    void discardCard(){
        if(playerHand != null){
            if(playerHand.size() == 1){
                playerHand.removeFirst();
            }else {
                Random rand = new Random();
                playerHand.remove(rand.nextInt(playerHand.size()));
            }
        }else {
            System.out.println("Player don't have cards");
        }
    }

    void discardAll(){
        if(playerHand != null){
            playerHand.clear();
        }
    }

    void showHand(Draw draw){
        for(Card card : playerHand){
            System.out.print(draw.card(card));
        }
    }
}