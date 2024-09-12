package org.example;

import java.util.ArrayList;
import java.util.Random;

public enum Naipe {
    ESPADA("♠"),
    PAUS("♣"),
    OUROS("♦"),
    COPAS("♥");

    private static final Naipe[] VALUES = values();

    public static Naipe[] getNaipes() {
        return VALUES;
    }

    private String type;

    Naipe(String type) {

        this.type = type;

    }

    public String getType() {

        return type;

    }
}
