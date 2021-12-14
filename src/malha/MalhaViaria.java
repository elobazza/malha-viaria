package malha;

import controller.ControllerSimulacao;
import model.ItemPista;
import model.PosicaoPista;
import model.Veiculo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static controller.Constantes.*;

public abstract class MalhaViaria {

    protected final ItemPista[][] malha;

    private final int linhas;
    private final int colunas;
    private final List<ItemPista> entradas;

    public MalhaViaria(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.entradas = new ArrayList<>();
        this.malha = new ItemPista[linhas][colunas];
    }

    public void inicializarMalha() {
        limparPistas();
        definirEntradasSaidas();
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

    public abstract void adicionarVeiculo(PosicaoPista posicaoPista, Veiculo veiculo);

    public abstract void removerVeiculo(PosicaoPista posicaoPista, Veiculo veiculo);

    public ItemPista[][] getMalha() {
        return malha;
    }

    protected void notificarController(Veiculo veiculo) {
        ControllerSimulacao.getInstance().removeVeiculo(veiculo);
        ControllerSimulacao.getInstance().notifyTableModelChanged();
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
        Random random = new Random();
        int opcao = random.nextInt(16);
        
        switch(opcao) {
            case 5: case 6: {
                malha[linha][coluna].setIcone(getResourceFileByPath(CAMINHO_ARQUIVO_FLOR));
                break;
            }
            case 8: {
                malha[linha][coluna].setIcone(getResourceFileByPath(CAMINHO_ARQUIVO_FLORZINHA));
                break;
            }
            case 9: {
                malha[linha][coluna].setIcone(getResourceFileByPath(CAMINHO_ARQUIVO_MATINHO));
                break;
            }
            default: {
                malha[linha][coluna].setIcone(getResourceFileByPath(CAMINHO_ARQUIVO_GRAMA));
                break;
            }
            
        }
    }

    private void itemPistaAsfalto(PosicaoPista posicaoPista) {
        int linha = posicaoPista.getLinha();
        int coluna = posicaoPista.getColuna();
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

                adicionarPistasAdjacentes(itemPistaAtual, new PosicaoPista(linhaAtual, colunaAtual));

                if (primeiraLinha(linhaAtual)) {
                    definirEntradaSe(itemPistaAtual, ESTRADA_BAIXO);
                    definirSaidaSe(itemPistaAtual, ESTRADA_CIMA);
                }

                if (ultimaLinha(linhaAtual)) {
                    definirEntradaSe(itemPistaAtual, ESTRADA_CIMA);
                    definirSaidaSe(itemPistaAtual, ESTRADA_BAIXO);
                }

                if (primeiraColuna(colunaAtual)) {
                    definirEntradaSe(itemPistaAtual, ESTRADA_DIREITA);
                    definirSaidaSe(itemPistaAtual, ESTRADA_ESQUERDA);
                }

                if (ultimaColuna(colunaAtual)) {
                    definirEntradaSe(itemPistaAtual, ESTRADA_ESQUERDA);
                    definirSaidaSe(itemPistaAtual, ESTRADA_DIREITA);
                }
            }
        }
    }
     
    public void limparPistas() {
        for (int linhaAtual = 0; linhaAtual < linhas; linhaAtual++) {
            for (int colunaAtual = 0; colunaAtual < colunas; colunaAtual++) {
                ItemPista itemPistaAtual = malha[linhaAtual][colunaAtual];
                
                itemPistaAtual.setVeiculo(null);
                itemPistaAtual.setOcupada(false);
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

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public List<ItemPista> getEntradas() {
        return entradas;
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

    private void adicionarPistasAdjacentes(ItemPista itemPista, PosicaoPista posicaoPista) {
        int linha = posicaoPista.getLinha();
        int coluna = posicaoPista.getColuna();

        if (verificaIndiceExisteArray(linha, coluna - 1)) {
            itemPista.setPistaEsquerda(malha[linha][coluna - 1]);
        }

        if (verificaIndiceExisteArray(linha, coluna + 1)) {
            itemPista.setPistaDireita(malha[linha][coluna + 1]);
        }

        if (verificaIndiceExisteArray(linha + 1, coluna)) {
            itemPista.setPistaBaixo(malha[linha + 1][coluna]);
        }

        if (verificaIndiceExisteArray(linha - 1, coluna)) {
            itemPista.setPistaCima(malha[linha - 1][coluna]);
        }
        
        if (verificaIndiceExisteArray(linha - 1, coluna + 1)) {
            itemPista.setPistaDiagonalCimaDireita(malha[linha - 1][coluna + 1]);
        }
        
        if (verificaIndiceExisteArray(linha - 1, coluna - 1)) {
            itemPista.setPistaDiagonalCimaEsquerda(malha[linha - 1][coluna - 1]);
        }
        
        if (verificaIndiceExisteArray(linha + 1, coluna + 1)) {
            itemPista.setPistaDiagonalBaixoDireita(malha[linha + 1][coluna + 1]);
        }
        
        if (verificaIndiceExisteArray(linha + 1, coluna - 1)) {
            itemPista.setPistaDiagonalBaixoEsquerda(malha[linha + 1][coluna - 1]);
        }
    }


    private boolean verificaIndiceExisteArray(int x, int y) {
        return (x >= 0 && x < this.malha.length) && (y >= 0 && y < this.malha[0].length);
    }

}
