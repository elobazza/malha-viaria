package model;

import controller.ControllerSimulacao;
import java.util.concurrent.Semaphore;
import javax.swing.ImageIcon;

/**
 * Modelo do Veículo
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since  novembro, 2021
 */
public class Veiculo extends Thread {
    
    private ImageIcon icone;

    private Pista pista;    
    private Pista pistaAnterior;
    
    private int velocidade;

    private Semaphore mutex = new Semaphore(1);
    
    public Veiculo() {
        this.icone = new ImageIcon(this.getClass().getResource("/img/veiculo.png"));
        this.velocidade = 1000;
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public void setIcone(ImageIcon icone) {
        this.icone = icone;
    }

    public Pista getPista() {
        return pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }

    public Pista getPistaAnterior() {
        return pistaAnterior;
    }

    public void setPistaAnterior(Pista pistaAnterior) {
        this.pistaAnterior = pistaAnterior;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    
    @Override
    public void start() {
        while(true) {
            try {
                this.mutex.acquire();
                
                if(this.pista.isSaida()) {
                    this.pista.setVeiculo(null);
                    ControllerSimulacao.getInstance().notifyTableModelChanged();
                    
                    this.finalize();
                }
                
                Pista proximaPista = this.getProximaPista();
                
                this.pistaAnterior = this.pista;
                this.pistaAnterior.setVeiculo(null);
                
                this.pista = proximaPista;
                this.pista.setVeiculo(this);
                
                ControllerSimulacao.getInstance().notifyTableModelChanged();
                
                Thread.sleep(this.getVelocidade());
                
                this.mutex.release();
            } 
            catch (InterruptedException ex) {} 
            catch (Throwable ex) {}
            finally {
                this.mutex.release();
            }
        }
    }
        
    public synchronized Pista getProximaPista() {
        Pista pista = null;
        
        switch(this.pista.getTipo()) {
            case 1: {
                pista = this.pista.getPistaCima();
            }
            case 2: {
                pista = this.pista.getPistaDireita();
                
            }
            case 3: {
                pista = this.pista.getPistaBaixo();
                
            }
            case 4: {
                pista = this.pista.getPistaEsquerda();
                
            }
        }
        
//        if(!pista.isTransitavel()) {
//            pista = this.getProximaPista();
//        } else{
//            
//        }
        
//        if(this.pistaAnterior != null && pista.equals(this.pistaAnterior)) {
            pista = this.getProximaPista();
//        }
        
        return pista;
    }  
}
