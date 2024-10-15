package org.example;

import java.util.Scanner;

public class Main {
    static Draw draw;
    static Scanner read = new Scanner(System.in);

    private static void App() {
        draw = new Draw();
        Player player = new Player();
        player.login("Fabio", "12345");
        Room newRoom = new Room();
        newRoom.addPLayer();
        newRoom.addPLayer();
        newRoom.addPLayer();

        newRoom.drawFlop();
        newRoom.giveCards();
        newRoom.giveCards();
        newRoom.playersShowCards();

        newRoom.playersDiscardCard();
        newRoom.playersShowCards();
        RoomBlackJack blackjack = new RoomBlackJack();
        /*boolean exit = true;
        System.out.println("Indique o numero de Cartas que deseja pedir");
        int numCartas = read.nextInt();
        for (Card i : draw.mao(numCartas)) {
            System.out.print(draw.card(i));
        }*/
    }

    public static void main(String[] args) {
        App();
    }
}