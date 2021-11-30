package model;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * Modelo da Pista
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since  novembro, 2021
 */
public class Pista {
    
    private boolean transitaCima;
    private boolean transitaBaixo;
    private boolean transitaDireita;
    private boolean transitaEsquerda;
    
    private boolean   isEntrada;
    private boolean   isSaida;
    private int       tipo;
    private Color     cor;
    private ImageIcon icone;
    
    private Veiculo veiculo;

    public Pista() {}
    
    public Pista(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public boolean isTransitaCima() {
        return transitaCima;
    }

    public void setTransitaCima(boolean transitaCima) {
        this.transitaCima = transitaCima;
    }

    public boolean isTransitaBaixo() {
        return transitaBaixo;
    }

    public void setTransitaBaixo(boolean transitaBaixo) {
        this.transitaBaixo = transitaBaixo;
    }

    public boolean isTransitaDireita() {
        return transitaDireita;
    }

    public void setTransitaDireita(boolean transitaDireita) {
        this.transitaDireita = transitaDireita;
    }

    public boolean isTransitaEsquerda() {
        return transitaEsquerda;
    }

    public void setTransitaEsquerda(boolean transitaEsquerda) {
        this.transitaEsquerda = transitaEsquerda;
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

    public Color getCor() {
        return cor;
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

}
