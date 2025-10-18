package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    protected String nome;
    protected List<Carta> cartas;
    protected int pontos;
    protected boolean parou;

    public Jogador(String nome) {
        this.nome = nome;
        this.cartas = new ArrayList<>();
        this.pontos = 0;
        this.parou = false;
    }

    public void receberCarta(Carta carta) {
        if (carta == null || parou) return;
        cartas.add(carta);
        pontos += carta.getValor();
        if (pontos > 21) parou = true;
    }

    public void parar() {
        this.parou = true;
    }

    public boolean isParou() {
        return parou;
    }

    public int getPontos() {
        return pontos;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public String getNome() {
        return nome;
    }
}
