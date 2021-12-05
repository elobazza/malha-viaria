package model;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * Modelo da Pista
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since  novembro, 2021
 */
public class Pista {
    
    private Pista pistaCima;
    private Pista pistaBaixo;
    private Pista pistaDireita;
    private Pista pistaEsquerda;
    
    private boolean transitavel;
    
    private boolean   isEntrada;
    private boolean   isSaida;
    private int       tipo;
    private Color     cor;
    private ImageIcon icone;
    
    private Veiculo veiculo;

    public Pista() {}
    
    public Pista(int tipo) {
        this.tipo = tipo;
        if(this.tipo == 0) {
            setTransitavel(false);
        } else {
            setTransitavel(true);
        }
        
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean isTransitavel() {
        return transitavel;
    }

    public void setTransitavel(boolean transitavel) {
        this.transitavel = transitavel;
    }

    public Pista getPistaCima() {
        return pistaCima;
    }

    public void setPistaCima(Pista pistaCima) {
        this.pistaCima = pistaCima;
    }

    public Pista getPistaBaixo() {
        return pistaBaixo;
    }

    public void setPistaBaixo(Pista pistaBaixo) {
        this.pistaBaixo = pistaBaixo;
    }

    public Pista getPistaDireita() {
        return pistaDireita;
    }

    public void setPistaDireita(Pista pistaDireita) {
        this.pistaDireita = pistaDireita;
    }

    public Pista getPistaEsquerda() {
        return pistaEsquerda;
    }

    public void setPistaEsquerda(Pista pistaEsquerda) {
        this.pistaEsquerda = pistaEsquerda;
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
    
    public boolean isCruzamento() {
        return this.getTipo() > 4; //Cruzamentos possuem o Tipo entre 5 e 12 (Limite)
    }
    
}
