package com.example;

import com.example.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PrimaryController {

    @FXML private HBox mesaDoJogador;
    @FXML private HBox mesaDoComputador;
    @FXML private ImageView monte;

    @FXML private Label pontosMesa;
    @FXML private Label pontosJogador;
    @FXML private Label resultado;

    private Jogo jogo;

    @FXML
    public void initialize() {
        novoJogo();
    }

    // Lógica para o turno do jogador
    public void turno() {
        if (jogo.acabou()) return;

        if (!jogo.jogador.isParou()) {
            jogo.distribuirCarta(jogo.jogador);
        }

        // Computador só joga se ainda não parou
        if (!jogo.computador.isParou()) {
            jogo.distribuirCarta(jogo.computador);
        }

        atualizar();

        // Mostra resultado se o jogo terminou
        if (jogo.acabou()) {
            resultado.setText(jogo.resultado());
        }
    }

    // Atualiza as cartas e os pontos na tela
    public void atualizar() {
        pontosJogador.setText("Jogador: " + jogo.jogador.getPontos());
        pontosMesa.setText("Mesa: " + jogo.computador.getPontos());

        mesaDoJogador.getChildren().clear();
        mesaDoComputador.getChildren().clear();

        jogo.jogador.getCartas()
                .forEach(carta -> mesaDoJogador.getChildren().add(imagemCarta(carta)));

        jogo.computador.getCartas()
                .forEach(carta -> mesaDoComputador.getChildren().add(imagemCarta(carta)));
    }

    // Inicia um novo jogo
    public void novoJogo() {
        jogo = new Jogo();

        mesaDoJogador.getChildren().clear();
        mesaDoComputador.getChildren().clear();

        pontosJogador.setText("Jogador: 0");
        pontosMesa.setText("Mesa: 0");
        resultado.setText("");
    }

    // Jogador pede carta
    public void pedirCarta() {
        if (!jogo.jogador.isParou()) {
            turno();
        }
    }

    // Jogador decide parar
    public void parar() {
        jogo.jogador.parar();

        // Computador joga automaticamente até parar
        while (!jogo.computador.isParou()) {
            jogo.distribuirCarta(jogo.computador);
        }

        atualizar();

        // Exibe resultado final
        resultado.setText(jogo.resultado());
    }

    // Cria ImageView para a carta
    private ImageView imagemCarta(Carta carta) {
        ImageView imagem = new ImageView(App.class.getResource(carta.imagePath()).toString());
        imagem.setFitHeight(120);
        imagem.setPreserveRatio(true);
        return imagem;
    }
}
