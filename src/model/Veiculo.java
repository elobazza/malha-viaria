package model;

import controller.ControllerSimulacao;

import java.util.Random;
import java.util.concurrent.Semaphore;
import javax.swing.ImageIcon;

/**
 * Modelo do Veículo
 *
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since novembro, 2021
 */
public class Veiculo extends Thread {

    private ImageIcon icone;

    private ItemPista pistaAtual;
    private ItemPista pistaAnterior;

    private int velocidade;

    private Semaphore mutex = new Semaphore(1);

    public Veiculo() {
        this.icone = new ImageIcon(this.getClass().getResource("/img/veiculo.png"));
        
        Random random = new Random();
        int acrescimo = random.nextInt(250);
        this.velocidade = 500 + acrescimo;
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public void setIcone(ImageIcon icone) {
        this.icone = icone;
    }

    public ItemPista getPistaAtual() {
        return pistaAtual;
    }

    public void setPistaAtual(ItemPista pistaAtual) {
        this.pistaAtual = pistaAtual;
    }

    public ItemPista getPistaAnterior() {
        return pistaAnterior;
    }

    public void setPistaAnterior(ItemPista pistaAnterior) {
        this.pistaAnterior = pistaAnterior;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public synchronized void start() {
        while (ControllerSimulacao.getInstance().isStart() && !ControllerSimulacao.getInstance().isPause()) {
            try {
                this.mutex.acquire();

                if (pistaAtual.isSaida()) {
                    this.removeVeiculo();
                    this.mutex.release();

                    return;
                }

                ItemPista proximaPista = this.getProximaPista();
                
                while(!proximaPista.isTransitavel()) {
                    proximaPista = this.getProximaPista();
                }

                this.pistaAnterior = this.pistaAtual;
                this.pistaAnterior.setVeiculo(null);
                this.pistaAtual = proximaPista;
                this.pistaAtual.setVeiculo(this);

                this.mutex.release();

                ControllerSimulacao.getInstance().notifyTableModelChanged();

                Thread.sleep(this.getVelocidade());
            } catch (InterruptedException e) {
                System.out.println("Erro");
            }
        }
    }

    public void removeVeiculo() {
        this.pistaAtual.setVeiculo(null);
        ControllerSimulacao.getInstance().removeVeiculo(this);
        ControllerSimulacao.getInstance().notifyTableModelChanged();
    }

    public synchronized ItemPista getProximaPista() {
        ItemPista pista = null;

        switch (this.pistaAtual.getTipo()) {
            case 1:
            case 5: {
                pista = this.pistaAtual.getPistaCima();
                break;
            }
            case 2:
            case 6: {
                pista = this.pistaAtual.getPistaDireita();
                break;
            }
            case 3:
            case 7: {
                pista = this.pistaAtual.getPistaBaixo();
                break;
            }
            case 4:
            case 8: {
                pista = this.pistaAtual.getPistaEsquerda();
                break;
            }
            case 9: {
                if (this.pistaAnterior.getTipo() == 11) {
                    pista = this.pistaAtual.getPistaDireita();
                } else {
                    Random random = new Random();
                    int opcao = random.nextInt(2);

                    if (opcao == 1) {
                        pista = this.pistaAtual.getPistaCima();
                    } else {
                        pista = this.pistaAtual.getPistaDireita();
                    }
                }
                break;
            }
            case 10: {
                if (this.pistaAnterior.getTipo() == 9) {
                    pista = this.pistaAtual.getPistaCima();
                } else {
                    Random random = new Random();
                    int opcao = random.nextInt(2);

                    if (opcao == 1) {
                        pista = this.pistaAtual.getPistaCima();
                    } else {
                        pista = this.pistaAtual.getPistaEsquerda();
                    }
                }
                break;
            }
            case 11: {
                if (this.pistaAnterior.getTipo() == 12) {
                    pista = this.pistaAtual.getPistaBaixo();
                } else {
                    Random random = new Random();
                    int opcao = random.nextInt(2);

                    if (opcao == 1) {
                        pista = this.pistaAtual.getPistaBaixo();
                    } else {
                        pista = this.pistaAtual.getPistaDireita();
                    }
                }
                break;
            }
            case 12: {
                if (this.pistaAnterior.getTipo() == 10) {
                    pista = this.pistaAtual.getPistaEsquerda();
                } else {
                    Random random = new Random();
                    int opcao = random.nextInt(2);

                    if (opcao == 1) {
                        pista = this.pistaAtual.getPistaBaixo();
                    } else {
                        pista = this.pistaAtual.getPistaEsquerda();
                    }
                }
                break;
            }

        }

        if (this.pistaAnterior != null && pista.equals(this.pistaAnterior)) {
            pista = this.getProximaPista();
        }

        return pista;
    }
}
