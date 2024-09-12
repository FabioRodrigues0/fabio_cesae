package org.example;

public class Carta {
    String naipe;
    String rank;

    public Carta() {

    }

    public Carta(String new_naipe, String new_rank) {
        naipe = new_naipe;
        rank = new_rank;
    }

    public Carta(Naipe valueNaipe, Rank valueRank) {
        naipe = valueNaipe.toString();
        rank = valueRank.toString();
    }
}
