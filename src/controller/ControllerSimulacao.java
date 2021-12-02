package controller;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import model.Veiculo;
import model.Pista;
import view.InterfaceViewObserver;
import view.tablemodel.TableModelMalha;

/**
 * Classe de Controller da Simulação
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since  novembro, 2021
 */
public class ControllerSimulacao implements InterfaceControllerObserved {
     
    private Pista[][] malha;
    
    private ArrayList<Pista> pistasEntrada;

    private ArrayList<Veiculo> carros;
    
    private ArrayList<InterfaceViewObserver> observers;
       
    private static ControllerSimulacao instance = null;

    public ControllerSimulacao() {
        this.observers       = new ArrayList<InterfaceViewObserver>();
        this.carros          = new ArrayList<Veiculo>();
        this.pistasEntrada   = new ArrayList<Pista>();
    }

    public static ControllerSimulacao getInstance() {
        if (instance == null) {
            instance = new ControllerSimulacao();
        }
        return instance;
    }
    
    public ArrayList<Pista> getPistasEntrada() {
        return pistasEntrada;
    }

    public void addPistasEntrada(Pista pista) {
        this.pistasEntrada.add(pista);
    }

    public ArrayList<Veiculo> getVeiculos() {
        return carros;
    }

    public void addVeiculo(Veiculo carro) {
        this.carros.add(carro);
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
                    malha[i][j] = new Pista(Integer.parseInt(row[j]));
                    malha[i][j].setCor(new Color(40, 114, 51));
                    malha[i][j].setIcone(new ImageIcon(this.getClass().getResource("/img/grama.png")));
                    
                } else {
                    malha[i][j] = new Pista(Integer.parseInt(row[j]));
                    malha[i][j].setCor(new Color(128, 128, 128));
                    malha[i][j].setIcone(new ImageIcon(this.getClass().getResource("/img/asfalto.jpg")));
                    if(i == 0 && j == 7){
                        malha[i][j].setVeiculo(new Veiculo());
                    }
                }
            }
        }
        
        this.definePistaEntradaSaida(malha);
        this.notifyTableModel(new TableModelMalha(this));
    }   
    
    public void definePistaEntradaSaida(Pista[][] malha) {
        int linhas = malha.length;
        int colunas = malha[0].length;
        
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                Pista pista = malha[i][j];
                
                pista.setIsEntrada(false);
                pista.setIsSaida(false);
                
                if(i == 0) {
                    if(pista.getTipo() == 3) {
                        pista.setIsEntrada(true);
                        this.addPistasEntrada(pista);
                    }
                    if(pista.getTipo() == 1) {
                        pista.setIsSaida(true);
                    }
                }
                
                if(i == linhas) {
                    if(pista.getTipo() == 3) {
                        pista.setIsSaida(true);
                    }
                    if(pista.getTipo() == 1) {
                        pista.setIsEntrada(true);
                        this.addPistasEntrada(pista);
                    }
                }
                
                if(j == 0) {
                    if(pista.getTipo() == 2) {
                        pista.setIsEntrada(true);
                        this.addPistasEntrada(pista);
                    }
                    if(pista.getTipo() == 4) {
                        pista.setIsSaida(true);
                    }
                }
                
                if(j == colunas) {
                    if(pista.getTipo() == 2) {
                        pista.setIsSaida(true);
                    }
                    if(pista.getTipo() == 4) {
                        pista.setIsEntrada(true);
                        this.addPistasEntrada(pista);
                    }
                }
            }
        }
    }
    
    public void iniciaSimulacao(int quantidadeVeiculo, boolean usaSemaforo, boolean usaMonitor) {
        new Thread(() -> {
            Random random = new Random();
            
            while(this.carros.size() < quantidadeVeiculo) {
                Pista pista = this.pistasEntrada.get(random.nextInt(this.pistasEntrada.size()));

                Veiculo veiculo = new Veiculo();
                
                this.addVeiculo(veiculo);
                
                pista.setVeiculo(veiculo);
                veiculo.setPista(pista);
                
//                this.notifyTableModel();
                
                new Thread(() -> {
                    veiculo.start();
                }).start();
                
                try {
                    Thread.sleep(veiculo.getVelocidade());
                } catch (InterruptedException ex) {
//                    Logger.getLogger(ControllerMalhaRodoviaria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
    private void notifyTableModel(TableModelMalha tableModelMalha) {
        for (InterfaceViewObserver observer : this.observers) {
            observer.atualizaTableModel(tableModelMalha);
        }
    }
    
    public synchronized void notifyTableModelChanged() {
        for (InterfaceViewObserver observer : this.observers) {
            observer.atualizaTable();
        }
    }
    
    @Override
    public Pista[][] getMalhaRodoviaria() {
        return this.malha;
    }
}