package model;

import controller.ControllerSimulacao;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * Modelo do Veículo
 *
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since novembro, 2021
 */
public class Veiculo extends Thread {

    private ImageIcon icone;

    private Pista pista;
    private Pista pistaAnterior;

    private int velocidade;

    private Semaphore mutex = new Semaphore(1);

    public Veiculo() {
        this.icone = new ImageIcon(this.getClass().getResource("/img/veiculo.png"));
        this.velocidade = 500;
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
    public synchronized void start() {
        while (true) {
            try {
                this.mutex.acquire();

                if (pista.isSaida()) {
                    this.removeVeiculo();
                    this.mutex.release();
                    
                    return;
                }

                Pista proximaPista = this.getProximaPista();

                this.pistaAnterior = this.pista;
                this.pistaAnterior.setVeiculo(null);

                this.pista = proximaPista;
                this.pista.setVeiculo(this);

                this.mutex.release();

                ControllerSimulacao.getInstance().notifyTableModelChanged();

                Thread.sleep(this.getVelocidade());
            } catch (InterruptedException e) {
                System.out.println("Erro");
            }
        }
    }

    public void removeVeiculo() {
        this.pista.setVeiculo(null);
        ControllerSimulacao.getInstance().removeVeiculo(this);
        ControllerSimulacao.getInstance().notifyTableModelChanged();
    }

    public synchronized Pista getProximaPista() {
        Pista pista = null;

        switch (this.pista.getTipo()) {
            case 1:
            case 5: {
                pista = this.pista.getPistaCima();
                break;
            }
            case 2:
            case 6: {
                pista = this.pista.getPistaDireita();
                break;
            }
            case 3:
            case 7: {
                pista = this.pista.getPistaBaixo();
                break;
            }
            case 4:
            case 8: {
                pista = this.pista.getPistaEsquerda();
                break;
            }
            case 9: {
                if (this.pistaAnterior.getTipo() == 11) {
                    pista = this.pista.getPistaDireita();
                } else {
                    Random random = new Random();
                    int opcao = random.nextInt(2);

                    if (opcao == 1) {
                        pista = this.pista.getPistaCima();
                    } else {
                        pista = this.pista.getPistaDireita();
                    }
                }
                break;
            }
            case 10: {
                if (this.pistaAnterior.getTipo() == 9) {
                    pista = this.pista.getPistaCima();
                } else {
                    Random random = new Random();
                    int opcao = random.nextInt(2);

                    if (opcao == 1) {
                        pista = this.pista.getPistaCima();
                    } else {
                        pista = this.pista.getPistaEsquerda();
                    }
                }
                break;
            }
            case 11: {
                if (this.pistaAnterior.getTipo() == 12) {
                    pista = this.pista.getPistaBaixo();
                } else {
                    Random random = new Random();
                    int opcao = random.nextInt(2);

                    if (opcao == 1) {
                        pista = this.pista.getPistaBaixo();
                    } else {
                        pista = this.pista.getPistaDireita();
                    }
                }
                break;
            }
            case 12: {
                if (this.pistaAnterior.getTipo() == 10) {
                    pista = this.pista.getPistaEsquerda();
                } else {
                    Random random = new Random();
                    int opcao = random.nextInt(2);

                    if (opcao == 1) {
                        pista = this.pista.getPistaBaixo();
                    } else {
                        pista = this.pista.getPistaEsquerda();
                    }
                }
                break;
            }

        }

        if (!pista.isTransitavel()) {
            pista = this.getProximaPista();
        }

        if (this.pistaAnterior != null && pista.equals(this.pistaAnterior)) {
            pista = this.getProximaPista();
        }

        return pista;
    }
}
