package model;

import java.awt.Color;
import javax.swing.ImageIcon;

public class ItemPista {

    private ItemPista pistaCima;
    private ItemPista pistaBaixo;
    private ItemPista pistaDireita;
    private ItemPista pistaEsquerda;
    
    private ItemPista pistaDiagonalCimaDireita;
    private ItemPista pistaDiagonalCimaEsquerda;
    private ItemPista pistaDiagonalBaixoDireita;
    private ItemPista pistaDiagonalBaixoEsquerda;

    private PosicaoPista posicaoPista;

    private boolean ocupada = false;
    private boolean isEntrada;
    private boolean isSaida;
    private int tipo;
    private Color cor;
    private ImageIcon icone;

    private Veiculo veiculo;

    public ItemPista(int tipo, PosicaoPista posicaoPista) {
        this.tipo = tipo;
        this.isEntrada = false;
        this.isSaida = false;
        this.posicaoPista = posicaoPista;
    }

    public int getTipo() {
        return tipo;
    }

    public boolean isTransitavel() {
        return this.getVeiculo() == null;
    }

    public ItemPista getPistaCima() {
        return pistaCima;
    }

    public void setPistaCima(ItemPista pistaCima) {
        this.pistaCima = pistaCima;
    }

    public ItemPista getPistaBaixo() {
        return pistaBaixo;
    }

    public void setPistaBaixo(ItemPista pistaBaixo) {
        this.pistaBaixo = pistaBaixo;
    }

    public ItemPista getPistaDireita() {
        return pistaDireita;
    }

    public void setPistaDireita(ItemPista pistaDireita) {
        this.pistaDireita = pistaDireita;
    }

    public ItemPista getPistaEsquerda() {
        return pistaEsquerda;
    }

    public void setPistaEsquerda(ItemPista pistaEsquerda) {
        this.pistaEsquerda = pistaEsquerda;
    }

    public ItemPista getPistaDiagonalCimaDireita() {
        return pistaDiagonalCimaDireita;
    }

    public void setPistaDiagonalCimaDireita(ItemPista pistaDiagonalCimaDireita) {
        this.pistaDiagonalCimaDireita = pistaDiagonalCimaDireita;
    }

    public ItemPista getPistaDiagonalCimaEsquerda() {
        return pistaDiagonalCimaEsquerda;
    }

    public void setPistaDiagonalCimaEsquerda(ItemPista pistaDiagonalCimaEsquerda) {
        this.pistaDiagonalCimaEsquerda = pistaDiagonalCimaEsquerda;
    }

    public ItemPista getPistaDiagonalBaixoDireita() {
        return pistaDiagonalBaixoDireita;
    }

    public void setPistaDiagonalBaixoDireita(ItemPista pistaDiagonalBaixoDireita) {
        this.pistaDiagonalBaixoDireita = pistaDiagonalBaixoDireita;
    }

    public ItemPista getPistaDiagonalBaixoEsquerda() {
        return pistaDiagonalBaixoEsquerda;
    }

    public void setPistaDiagonalBaixoEsquerda(ItemPista pistaDiagonalBaixoEsquerda) {
        this.pistaDiagonalBaixoEsquerda = pistaDiagonalBaixoEsquerda;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public void setIcone(ImageIcon icone) {
        this.icone = icone;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public boolean isEntrada() {
        return isEntrada;
    }

    public void setIsEntrada(boolean isEntrada) {
        this.isEntrada = isEntrada;
    }

    public boolean isSaida() {
        return isSaida;
    }

    public void setIsSaida(boolean isSaida) {
        this.isSaida = isSaida;
    }

    public PosicaoPista getPosicaoPista() {
        return posicaoPista;
    }

    public boolean isCruzamento() {
        return this.getTipo() > 4; //Cruzamentos possuem o Tipo entre 5 e 12 (Limite)
    }

}
