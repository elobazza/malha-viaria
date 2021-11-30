package model;

import java.util.concurrent.Semaphore;
import javax.swing.ImageIcon;

/**
 * Modelo do Veículo
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since  novembro, 2021
 */
public class Veiculo {
    
    private ImageIcon icone;

    private Pista pista;    
    private Pista pistaAnterior;

//    private Semaphore mutex = new Semaphore(1);
    
    public Veiculo() {
        this.icone = new ImageIcon(getClass().getResource("/img/veiculo.png"));
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
    
    
}
