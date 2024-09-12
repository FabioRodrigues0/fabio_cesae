package org.example;

import java.util.ArrayList;

public class Draw {
    private ArrayList<Carta> cartasMao;
    Baralho baralho;
    public Draw() {
        baralho = new Baralho();
        baralho.setCartas();
    }
    public ArrayList<Carta> mao(int numCartas) {
        cartasMao = new ArrayList<>();
        boolean exit = true;
        for (int i = 0; i < numCartas + 1; i++) {
            if (baralho.cartas.size() == 1){
                cartasMao.add(baralho.cartas.get(i));
                break;
            }
            var temp_carta = baralho.getRandomCard(baralho.cartas);
            cartasMao.add(temp_carta);
            baralho.cartas.remove(temp_carta);
        }
        return cartasMao;
    }

    public String card(Carta carta) {
        return String.format("""
                 _ _ _
                |     |
                | %s %s |
                |_ _ _|
                """, carta.rank, carta.naipe);
    }
}
