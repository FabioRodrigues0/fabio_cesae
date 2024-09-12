package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Baralho {
    ArrayList<Carta> cartas;
    static int SIZE_NAIPE = 0;
    static int SIZE_RANK = 0;
    private static final Random RANDOM = new Random();

    public Baralho() {

    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas() {
        Naipe[] temp_naipes = Naipe.getNaipes().clone();
        SIZE_NAIPE = temp_naipes.length;
        Rank[] temp_ranks = Rank.getRanks().clone();
        SIZE_RANK = temp_ranks.length;
        cartas = new ArrayList<>();
        for (int i = 0; i < SIZE_NAIPE; i++) {
            for (int j = 0; j < SIZE_RANK; j++) {
                cartas.add(new Carta(temp_naipes[i].getType(), temp_ranks[j].getType()));
            }
        }
    }

    public Carta getRandomCard(ArrayList<Carta> newValues) {
        return newValues.get(RANDOM.nextInt(newValues.size()));
    }
}