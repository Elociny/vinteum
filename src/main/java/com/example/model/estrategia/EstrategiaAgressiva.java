package com.example.model.estrategia;

import com.example.model.Jogador;

public class EstrategiaAgressiva implements EstrategiaDeParada {
    @Override
    public boolean deveParar(Jogador computador) {
        return computador.getPontos() >= 19;
    }
}
