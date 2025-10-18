package com.example.model;

public class Carta {
    private int numero;
    private Naipe naipe;

    public Carta(int valor, Naipe naipe) {
        this.numero = valor;
        this.naipe = naipe;
    }

    public int getValor() {
        return numero;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public String imagePath() {
        return "classic-cards/" + numero + this.naipe + ".png";
    }
}
