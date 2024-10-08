package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public enum Rank {
    A("A"),
    DOIS("2"),
    TRES("3"),
    QUATRO("4"),
    CINCO("5"),
    SEIS("6"),
    SETE("7"),
    OITO("8"),
    NOVE("9"),
    DEZ("10"),
    VALETE("J"),
    DAMA("Q"),
    REI("R");

    private static final Rank[] VALUES = values();

    public static Rank[] getRanks() {
        return VALUES;
    }

    private String type;

    Rank(String type) {
        this.type = type;
    }

    public String getType() {

        return type;

    }
}
