package org.example;

import java.util.Scanner;

public class Main {
    static Draw draw;
    static Scanner read = new Scanner(System.in);

    private static void App() {
        draw = new Draw();
        boolean exit = true;
            System.out.println("Indique o numero de Cartas que deseja pedir");
            int numCartas = read.nextInt();
            for (Carta i : draw.mao(numCartas)) {
                System.out.print(draw.card(i));
            }
    }

    public static void main(String[] args) {
        App();
    }


}