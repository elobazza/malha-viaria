package model;

import controller.ControllerSimulacao;
import java.util.Iterator;
import java.util.List;
import malha.MalhaViaria;

import java.util.Objects;
import java.util.Random;
import javax.swing.ImageIcon;

public class Veiculo extends Thread {

    private final int velocidade;
    private final MalhaViaria malhaViaria;

    private ItemPista pistaAtual;
    private ItemPista pistaAnterior;
    private ImageIcon icone;

    private Iterator<ItemPista> percurso;
    private PercursoPista percursoPista;

    public Veiculo(MalhaViaria malhaViaria) {
        this.percursoPista = new PercursoPistaBase();
        this.sorteiaIcone();
        this.malhaViaria = malhaViaria;
        this.velocidade = velocidadeAleatoria();
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public void setPistaAtual(ItemPista pistaAtual) {
        this.pistaAtual = pistaAtual;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public PercursoPista getPercursoPista() {
        return percursoPista;
    }

    public void setPercursoPista(PercursoPista percursoPista) {
        this.percursoPista = percursoPista;
    }

    @Override
    public synchronized void start() {
        while (ControllerSimulacao.getInstance().isRunning()) {
            try {
                if (this.pistaAtual.isSaida()) {
                    this.pistaAtual.setOcupada(false);
                    this.pistaAtual.setVeiculo(null);
                    
                    removeVeiculo();
                    
                    return;
                }

                if (this.percurso == null || !this.percurso.hasNext()) {
                    this.percurso = this.getPercurso().iterator();
                }

                ItemPista proximaPista = this.percurso.next();

                this.pistaAnterior = this.pistaAtual;
                this.pistaAnterior.setVeiculo(null);
                this.pistaAnterior.setOcupada(false);

                this.pistaAtual = proximaPista;
                
                malhaViaria.adicionarVeiculo(pistaAtual.getPosicaoPista(), this);

                ControllerSimulacao.getInstance().notifyTableModelChanged();

                Thread.sleep(this.getVelocidade());
            } catch (InterruptedException e) {
                System.out.println("Erro");
            }
        }
    }

    private void sorteiaIcone() {
        Random random = new Random();
        int opcao = random.nextInt(8);
        
        switch(opcao) {
            case 1:  
                this.icone = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/veiculo-1.png")));
                break;
            case 2:  
                this.icone = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/veiculo-2.png")));
                break;
            case 3:  
                this.icone = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/veiculo-3.png")));
                break;
            case 4:  
                this.icone = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/veiculo-4.png")));
                break;
            case 5:  
                this.icone = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/veiculo-5.png")));
                break;
            case 6:  
                this.icone = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/veiculo-6.png")));
                break;
            case 7:  
                this.icone = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/veiculo-7.png")));
                break;
            default:
                this.icone = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/veiculo-8.png"))); 
        }
    }
    
    
    private synchronized List<ItemPista> getPercurso() {
        return this.percursoPista.getPercurso(this.pistaAtual, this.pistaAnterior);
    }

    private int velocidadeAleatoria() {
        Random random = new Random();
        int acrescimo = random.nextInt(250);
        return 250 + acrescimo;
    }

    private void removeVeiculo() {
        malhaViaria.removerVeiculo(pistaAtual.getPosicaoPista(), this);
    }
}
