package controller;

import model.Pista;
import model.Veiculo;

/**
 * Controller do Veículo
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since  novembro, 2021
 */
public class ControllerVeiculo extends Thread {
    
    private ControllerSimulacao controllerSimulacao = ControllerSimulacao.getInstance();
    
    private Veiculo veiculo;
    private int     quantidadeCarros;
    private int     velocidade;
    
    public ControllerVeiculo(Veiculo veiculo, int velocidade) {
        this.veiculo = veiculo;
        this.velocidade = velocidade;
    }
    
    // Insere carros na malha viaria
    @Override
    public void start() {
         
    }
     
    // Define aleatoriamente a proxima pista para onde o carro se desloca 
    private synchronized Pista getProximaPistaRandom() {
         Pista pista = null;
         
         
         
         return pista;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getQuantidadeCarros() {
        return quantidadeCarros;
    }

    public void setQuantidadeCarros(int quantidadeCarros) {
        this.quantidadeCarros = quantidadeCarros;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }    
}
