package service;

import model.ItemPista;
import model.PosicaoPista;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static controller.Constantes.*;

public class MalhaViariaService {

    private int linhas;
    private int colunas;
    private ItemPista[][] malha;
    private List<ItemPista> entradas;

    public MalhaViariaService(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.entradas = new ArrayList<>();
        this.malha = new ItemPista[linhas][colunas];
    }

    public void inicializarMalha() {
        definirEntradasSaidas();
        carregaMatrizPistas();
    }

    public void adicionarItemPista(PosicaoPista posicaoPista, ItemPista itemPista) {
        int linha = posicaoPista.getLinha();
        int coluna = posicaoPista.getColuna();
        malha[linha][coluna] = itemPista;
        ajustarTipoItemPista(posicaoPista, itemPista.getTipo());
    }

    public ItemPista entradaAleatoria() {
        Random random = new Random();
        return entradas.get(random.nextInt(entradas.size()));
    }

    public ItemPista[][] getMalha() {
        return malha;
    }

    private void ajustarTipoItemPista(PosicaoPista posicaoPista, int tipoPista) {
        if (tipoPista == GRAMA) {
            itemPistaGrama(posicaoPista);
        } else {
            itemPistaAsfalto(posicaoPista);
        }
    }

    private void itemPistaGrama(PosicaoPista posicaoPista) {
        int linha = posicaoPista.getLinha();
        int coluna = posicaoPista.getColuna();
        malha[linha][coluna].setCor(COR_VERDE);
        malha[linha][coluna].setIcone(getResourceFileByPath(CAMINHO_ARQUIVO_GRAMA));
    }

    private void itemPistaAsfalto(PosicaoPista posicaoPista) {
        int linha = posicaoPista.getLinha();
        int coluna = posicaoPista.getColuna();
        malha[linha][coluna].setCor(COR_CINZA);
        malha[linha][coluna].setIcone(getResourceFileByPath(CAMINHO_ARQUIVO_ASFALTO));
    }

    //TODO colocar isso no local apropriado
    private ImageIcon getResourceFileByPath(String filePath) {
        return new ImageIcon(Objects.requireNonNull(this.getClass().getResource(filePath)));
    }

    private void definirEntradasSaidas() {
        for (int linhaAtual = 0; linhaAtual < linhas; linhaAtual++) {
            for (int colunaAtual = 0; colunaAtual < colunas; colunaAtual++) {
                ItemPista itemPistaAtual = malha[linhaAtual][colunaAtual];

                if (primeiraLinha(linhaAtual)) {
                    definirEntradaSe(itemPistaAtual, DIRECAO_PISTA_BAIXO);
                    definirSaidaSe(itemPistaAtual, DIRECAO_PISTA_CIMA);
                }

                if (ultimaLinha(linhaAtual)) {
                    definirEntradaSe(itemPistaAtual, DIRECAO_PISTA_CIMA);
                    definirSaidaSe(itemPistaAtual, DIRECAO_PISTA_BAIXO);
                }

                if (primeiraColuna(colunaAtual)) {
                    definirEntradaSe(itemPistaAtual, DIRECAO_PISTA_DIREITA);
                    definirSaidaSe(itemPistaAtual, DIRECAO_PISTA_ESQUERDA);
                }

                if (ultimaColuna(colunaAtual)) {
                    definirEntradaSe(itemPistaAtual, DIRECAO_PISTA_ESQUERDA);
                    definirSaidaSe(itemPistaAtual, DIRECAO_PISTA_DIREITA);
                }
            }
        }
    }

    private void definirEntradaSe(ItemPista itemPistaAtual, int direcaoPistaAtual) {
        if (itemPistaAtual.getTipo() == direcaoPistaAtual) {
            itemPistaAtual.setIsEntrada(true);
            adicionarNovaEntrada(itemPistaAtual);
        }
    }

    private void definirSaidaSe(ItemPista itemPistaAtual, int direcaoPistaAtual) {
        if (itemPistaAtual.getTipo() == direcaoPistaAtual) {
            itemPistaAtual.setIsSaida(true);
        }
    }

    private Boolean primeiraLinha(int linhaAtual) {
        return linhaAtual == 0;
    }

    private Boolean ultimaLinha(int linhaAtual) {
        return linhaAtual == (linhas - 1);
    }

    private Boolean primeiraColuna(int colunaAtual) {
        return colunaAtual == 0;
    }

    private Boolean ultimaColuna(int colunaAtual) {
        return colunaAtual == (colunas - 1);
    }

    private void adicionarNovaEntrada(ItemPista itemPista) {
        this.entradas.add(itemPista);
    }

    private void carregaMatrizPistas() {
        for (int linhaAtual = 0; linhaAtual < malha.length; linhaAtual++) {
            for (int colunaAtual = 0; colunaAtual < malha[linhaAtual].length; colunaAtual++) {
                ItemPista itemPista = malha[linhaAtual][colunaAtual];

                if (verificaIndiceExisteArray(linhaAtual, colunaAtual - 1)) {
                    itemPista.setPistaEsquerda(malha[linhaAtual][colunaAtual - 1]);
                }

                if (verificaIndiceExisteArray(linhaAtual, colunaAtual + 1)) {
                    itemPista.setPistaDireita(malha[linhaAtual][colunaAtual + 1]);
                }

                if (verificaIndiceExisteArray(linhaAtual + 1, colunaAtual)) {
                    itemPista.setPistaBaixo(malha[linhaAtual + 1][colunaAtual]);
                }

                if (verificaIndiceExisteArray(linhaAtual - 1, colunaAtual)) {
                    itemPista.setPistaCima(malha[linhaAtual - 1][colunaAtual]);
                }
            }
        }
    }

    private boolean verificaIndiceExisteArray(int x, int y) {
        return (x >= 0 && x < this.malha.length) && (y >= 0 && y < this.malha[0].length);
    }

}
