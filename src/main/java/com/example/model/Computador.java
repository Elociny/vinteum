package com.example.model;

import com.example.model.estrategia.EstrategiaDeParada;

public class Computador extends Jogador {
    private EstrategiaDeParada estrategia;

    public Computador(String nome, EstrategiaDeParada estrategia) {
        super(nome);
        this.estrategia = estrategia;
    }

    @Override
    public boolean isParou() {
        if (!parou) {
            parou = estrategia.deveParar(this);
        }
        return parou;
    }
}
