package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Pack {
    ArrayList<Card> carts;
    static int SIZE_NAIPE = 0;
    static int SIZE_RANK = 0;
    private static final Random RANDOM = new Random();

    public Pack() {

    }

    public ArrayList<Card> getCarts() {
        return carts;
    }

    public void setCarts() {
        Naipe[] temp_naipes = Naipe.getNaipes().clone();
        SIZE_NAIPE = temp_naipes.length;
        Rank[] temp_ranks = Rank.getRanks().clone();
        SIZE_RANK = temp_ranks.length;
        carts = new ArrayList<>();
        for (int i = 0; i < SIZE_NAIPE; i++) {
            for (int j = 0; j < SIZE_RANK; j++) {
                carts.add(new Card(temp_naipes[i].getType(), temp_ranks[j].getType()));
            }
        }
    }

    public void setCarts(int size) {
        Naipe[] temp_naipes = Naipe.getNaipes().clone();
        SIZE_NAIPE = temp_naipes.length;
        Rank[] temp_ranks = Rank.getRanks().clone();
        SIZE_RANK = temp_ranks.length;
        carts = new ArrayList<>();
        for (int b = 0; b < size; b++) {
            for (int i = 0; i < SIZE_NAIPE; i++) {
                for (int j = 0; j < SIZE_RANK; j++) {
                    carts.add(new Card(temp_naipes[i].getType(), temp_ranks[j].getType()));
                }
            }
        }
    }

    public Card getRandomCard(ArrayList<Card> newValues) {
        return newValues.get(RANDOM.nextInt(newValues.size()));
    }
}