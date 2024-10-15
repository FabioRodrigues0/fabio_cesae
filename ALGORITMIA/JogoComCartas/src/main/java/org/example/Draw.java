package org.example;

import java.util.ArrayList;
import java.util.Collection;

public class Draw {
    private Collection<Card> cartHand;
    Pack pack;
    public Draw() {
        pack = new Pack();
        pack.setCarts();
    }
    public Collection<Card> hand(int numCartas) {
        cartHand = new ArrayList<>();
        boolean exit = true;
        for (int i = 0; i < numCartas + 1; i++) {
            if (pack.carts.size() == 1){
                cartHand.add(pack.carts.get(i));
                break;
            }
            var temp_cart = pack.getRandomCard(pack.carts);
            cartHand.add(temp_cart);
            pack.carts.remove(temp_cart);
        }
        return cartHand;
    }

    public Collection<Card> drawCards(int numCartas, ArrayList<Card> newPack) {
        cartHand = new ArrayList<>();
        boolean exit = true;
        for (int i = 0; i < numCartas; i++) {
            if (newPack.size() == 1){
                cartHand.add(newPack.get(i));
                break;
            }
            var temp_cart = pack.getRandomCard(newPack);
            cartHand.add(temp_cart);
            newPack.remove(temp_cart);
        }
        return cartHand;
    }


    public String card(Card carta) {
        return String.format("""
                 _ _ _
                |     |
                | %s %s |
                |_ _ _|
                """, carta.rank, carta.naipe);
    }
}
