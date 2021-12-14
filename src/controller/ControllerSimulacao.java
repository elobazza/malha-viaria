package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import malha.factory.AbstractMalhaFactory;
import malha.factory.MalhaViariaMonitorFactory;
import model.PosicaoPista;
import model.Veiculo;
import model.ItemPista;
import malha.MalhaViaria;
import malha.factory.MalhaViariaSemaforoFactory;
import view.InterfaceViewObserver;
import view.tablemodel.TableModelMalha;

public class ControllerSimulacao implements InterfaceControllerObserved {

    private boolean start = true;
    private boolean running = true;
    
    private File arquivo;
    private int linhas;
    private int colunas;
    
    private MalhaViaria malhaViaria;

    private ArrayList<Veiculo> veiculos;
    private final ArrayList<InterfaceViewObserver> observers;

    private static ControllerSimulacao instance = null;

    private ControllerSimulacao() {
        this.observers = new ArrayList<>();
        this.veiculos = new ArrayList<>();
    }

    public static ControllerSimulacao getInstance() {
        if (instance == null) {
            instance = new ControllerSimulacao();
        }
        return instance;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isStart() {
        return this.start;
    }

    public void addVeiculo(Veiculo carro) {
        this.veiculos.add(carro);
    }

    public void removeTodosVeiculos() {
        this.veiculos = new ArrayList<Veiculo>();
    }
    
    public void removeVeiculo(Veiculo carro) {
        this.veiculos.remove(carro);
    }

    public void addObserver(InterfaceViewObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(InterfaceViewObserver observer) {
        this.observers.remove(observer);
    }

    public void carregaSimulacao(File arquivo) throws IOException {
        this.arquivo = arquivo;
       
        this.criaMalha(false);
        this.inicializarMalha();
        notifyTableModel(new TableModelMalha(this));
    }
    
    
    public void factoryMalha(boolean usaMonitor) {
        if(usaMonitor) {
            AbstractMalhaFactory factory = new MalhaViariaMonitorFactory();
            malhaViaria = factory.criarMalha(linhas, colunas);
        } else {
            AbstractMalhaFactory factory = new MalhaViariaSemaforoFactory();
            malhaViaria = factory.criarMalha(linhas, colunas);
        }
    }
    
    public void criaMalha(boolean usaMonitor) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader(arquivo));
        this.linhas = Integer.parseInt(in.readLine());
        this.colunas = Integer.parseInt(in.readLine());
        
        this.factoryMalha(false);
        
        for (int linhaAtual = 0; linhaAtual < linhas; linhaAtual++) {
            String[] listaTipos = in.readLine().split("\t");
            for (int colunaAtual = 0; colunaAtual < colunas; colunaAtual++) {
                int tipoPista = Integer.parseInt(listaTipos[colunaAtual]);
                PosicaoPista posicaoPista = new PosicaoPista(linhaAtual, colunaAtual);
                malhaViaria.adicionarItemPista(posicaoPista, new ItemPista(tipoPista, posicaoPista));
            }
        }
    }
    
    public void inicializarMalha() {
        malhaViaria.inicializarMalha();
    }

    public void iniciarSimulacao(int quantidadeVeiculo, boolean usaSemaforo, boolean usaMonitor) throws FileNotFoundException, IOException {
        notifyButtonChanged(true);
         
        if(usaMonitor) {
            this.malhaViaria = null;
            this.criaMalha(true);
        
            this.inicializarMalha();
            notifyTableModel(new TableModelMalha(this));
        }
        
        new Thread(() -> {
            while (start) {
                if (this.veiculos.size() < quantidadeVeiculo) {
                    iniciarNovoVeiculo(malhaViaria.entradaAleatoria());
                    notifyTableModelChanged();
                }
                sleepThread();
            }
        }).start();
    }

    public void iniciarNovoVeiculo(ItemPista itemPistaAtual) {
        Veiculo veiculo = new Veiculo(malhaViaria);
        this.addVeiculo(veiculo);
        veiculo.setPistaAtual(itemPistaAtual);
        new Thread(veiculo::start).start();
    }

    public void sleepThread() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControllerSimulacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void finalizaSimulacao() {
        notifyButtonChanged(false);
    }
    

    public void notifyTableModel(TableModelMalha tableModelMalha) {
        for (InterfaceViewObserver observer : this.observers) {
            observer.atualizaTableModel(tableModelMalha);
        }
    }

    public synchronized void notifyTableModelChanged() {
        for (InterfaceViewObserver observer : this.observers) {
            observer.atualizaTable();
        }
    }

    public void notifyButtonChanged(boolean iniciar) {
        for (InterfaceViewObserver observer : this.observers) {
            observer.atualizaButton(iniciar);
        }
    }
   
    @Override
    public ItemPista[][] getMalhaRodoviaria() {
        return this.malhaViaria.getMalha();
    }

}
