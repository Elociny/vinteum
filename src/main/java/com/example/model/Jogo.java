package com.example.model;

import java.util.Random;
import com.example.model.estrategia.*;

public class Jogo {
    public Jogador jogador;
    public Computador computador;
    private Monte monte;

    public Jogo() {
        monte = new Monte();
        jogador = new Jogador("Você");

        EstrategiaDeParada estrategia = new Random().nextBoolean()
                ? new EstrategiaCautelosa()
                : new EstrategiaAgressiva();

        computador = new Computador("Mesa", estrategia);
    }

    public Carta distribuirCarta(Jogador j) {
        if (j.isParou()) return null;
        Carta carta = monte.virar();
        j.receberCarta(carta);
        return carta;
    }

    public boolean acabou() {
        return jogador.isParou() && computador.isParou();
    }

    public String resultado() {
        if (jogador.getPontos() > 21) return "Você perdeu!";
        if (computador.getPontos() > 21) return "Você ganhou!";
        if (acabou()) {
            if (jogador.getPontos() > computador.getPontos()) return "Você ganhou!";
            if (jogador.getPontos() < computador.getPontos()) return "Você perdeu!";
            return "Empate!";
        }
        return "";
    }
}
