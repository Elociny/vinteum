package com.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monte {
    private List<Carta> cartas;

    public Monte() {
        cartas = new ArrayList<>();
        for (Naipe naipe : Naipe.values()) {
            for (int i = 1; i <= 13; i++) {
                int valor = i > 10 ? 10 : i;
                cartas.add(new Carta(valor, naipe));
            }
        }
        embaralhar();
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta virar() {
        if (cartas.isEmpty()) return null;
        return cartas.remove(0);
    }
}
