package org.example;

import java.util.ArrayList;

public class Room {
    Player playerPoker;
    ArrayList<Player> listPlayers;
    Pack roomPack;
    Draw draw;

    public Room() {
        listPlayers = new ArrayList<>();
        roomPack = new Pack();
        draw = new Draw();
        roomPack.setCartas();
    }

    void addPLayer() {
        playerPoker = new Player();
        if(listPlayers.isEmpty()){
            playerPoker.id = 1;
        }else {
            playerPoker.id = listPlayers.getLast().id + 1;
        }
        playerPoker.nickname = "Player_" + (playerPoker.id);
        listPlayers.add(playerPoker);
    }

    void countPlayers() {
        System.out.println("Have " + listPlayers.size() + " players in room");
    }

    void printPlayers() {
        for(Player player : listPlayers){
            System.out.println("-> " + player.nickname);
        }
    }

    void leavePlayer(int index) {
        listPlayers.remove(index -1 );
    }

    void drawFlop(){
        ArrayList<Card> flop = draw.drawCards(3, roomPack.carts);
        for(Card card : flop){
            System.out.println(draw.card(card));
        }
    }
}
