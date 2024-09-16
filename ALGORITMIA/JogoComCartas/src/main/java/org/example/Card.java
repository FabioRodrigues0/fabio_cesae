package org.example;

public class Card {
    String naipe;
    String rank;

    public Card() {

    }

    public Card(String new_naipe, String new_rank) {
        naipe = new_naipe;
        rank = new_rank;
    }

    public Card(Naipe valueNaipe, Rank valueRank) {
        naipe = valueNaipe.toString();
        rank = valueRank.toString();
    }
}
