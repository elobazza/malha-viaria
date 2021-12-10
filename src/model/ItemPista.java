package model;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * Modelo da Pista
 *
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since novembro, 2021
 */
public class ItemPista {

    private ItemPista pistaCima;
    private ItemPista pistaBaixo;
    private ItemPista pistaDireita;
    private ItemPista pistaEsquerda;

    private boolean isEntrada;
    private boolean isSaida;
    private int tipo;
    private Color cor;
    private ImageIcon icone;

    private Veiculo veiculo;

    public ItemPista(int tipo) {
        this.tipo = tipo;
        this.isEntrada = false;
        this.isSaida = false;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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
