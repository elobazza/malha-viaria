package controller;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import models.Veiculo;
import models.Pista;
import view.InterfaceViewObserver;
import view.TableModelMalha;

/**
 * Controller Game
 * 
 * @author Eloisa Bazzanella e Maria Eduarda Buzana
 */
public class ControllerSimulacao implements InterfaceControllerObserved {
     
    private Pista[][] malha;
    
    private ArrayList<Pista> pistasEntrada;

    private ArrayList<Veiculo> carros;
    
    private ArrayList<InterfaceViewObserver> observers;
    
    private static ControllerSimulacao instance = null;

    public ControllerSimulacao() {
        this.observers     = new ArrayList<InterfaceViewObserver>();
        this.carros        = new ArrayList<Veiculo>();
        this.pistasEntrada = new ArrayList<Pista>();
    }

    public static ControllerSimulacao getInstance() {
        if (instance == null) {
            instance = new ControllerSimulacao();
        }
        return instance;
    }
    
    public void addObserver(InterfaceViewObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(InterfaceViewObserver observer) {
        this.observers.remove(observer);
    }
    
    public void carregaSimulacao(File arquivo) throws IOException {
        BufferedReader in      = new BufferedReader(new FileReader(arquivo));
        int            linhas  = Integer.parseInt(in.readLine());
        int            colunas = Integer.parseInt(in.readLine());

        malha = new Pista[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            String row[] = in.readLine().split("\t");
            for (int j = 0; j < colunas; j++) {
                if(Integer.parseInt(row[j]) == 0) {
                    malha[i][j] = new Pista();
                    malha[i][j].setCor(new Color(40, 114, 51));
                    malha[i][j].setIcone(new ImageIcon(this.getClass().getResource("/img/grama.png")));
                } else {
                    malha[i][j] = new Pista();
                    malha[i][j].setCor(new Color(128, 128, 128));
                    malha[i][j].setIcone(new ImageIcon(this.getClass().getResource("/img/asfalto.jpg")));
                    
                }
            }
        }
         this.notifyTableModel(new TableModelMalha(this));
        
    }   
    
    private void notifyTableModel(TableModelMalha tableModelMalha) {
        for (InterfaceViewObserver observer : this.observers) {
            observer.atualizaTableModel(tableModelMalha);
        }
    }
    
    @Override
    public Pista[][] getMalhaRodoviaria() {
        return this.malha;
    }
}