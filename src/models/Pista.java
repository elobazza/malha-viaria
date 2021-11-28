/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author elois
 */
public class Pista {
    
    private boolean transitaCima;
    private boolean transitaBaixo;
    private boolean transitaDireita;
    private boolean transitaEsquerda;
    
    private Color cor;
    private ImageIcon icone;
    
    private Veiculo veiculo;

    public Pista() {}
    
    public Pista(boolean transitaCima, boolean transitaBaixo, boolean transitaDireita, boolean transitaEsquerda) {
        this.transitaCima = transitaCima;
        this.transitaBaixo = transitaBaixo;
        this.transitaDireita = transitaDireita;
        this.transitaEsquerda = transitaEsquerda;
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
       
    
}
