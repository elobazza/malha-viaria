package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.PosicaoPista;
import model.Veiculo;
import model.ItemPista;
import service.MalhaViariaService;
import view.InterfaceViewObserver;
import view.tablemodel.TableModelMalha;


/**
 * Classe de Controller da Simulação
 *
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since novembro, 2021
 */
public class ControllerSimulacao implements InterfaceControllerObserved {

    private boolean start = true;
    private boolean pause = false;

    private MalhaViariaService malhaViaria;

    private ArrayList<Veiculo> veiculos;
    private ArrayList<InterfaceViewObserver> observers;

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

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
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
        BufferedReader in = new BufferedReader(new FileReader(arquivo));
        int linhas = Integer.parseInt(in.readLine());
        int colunas = Integer.parseInt(in.readLine());

        malhaViaria = new MalhaViariaService(linhas, colunas);

        for (int linhaAtual = 0; linhaAtual < linhas; linhaAtual++) {
            String[] listaTipos = in.readLine().split("\t");
            for (int colunaAtual = 0; colunaAtual < colunas; colunaAtual++) {
                int tipoPista = Integer.parseInt(listaTipos[colunaAtual]);
                PosicaoPista posicaoPista = new PosicaoPista(linhaAtual, colunaAtual);
                malhaViaria.adicionarItemPista(posicaoPista, new ItemPista(tipoPista));
            }
        }
        malhaViaria.inicializarMalha();
        notifyTableModel(new TableModelMalha(this));
    }

    public void iniciarSimulacao(int quantidadeVeiculo, boolean usaSemaforo, boolean usaMonitor) {
        notifyButtonChanged(true);
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
        Veiculo veiculo = new Veiculo();
        this.addVeiculo(veiculo);
        veiculo.setPistaAtual(itemPistaAtual);
        new Thread(veiculo::start).start();
    }

    public void sleepThread() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControllerSimulacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void finalizaSimulacao() {
        notifyButtonChanged(false);
    }
    
    public void finalizaSimulacaoCompletamente() {
        this.veiculos =  null;
        notifyTableModelChanged();
    }

    public void notifyRemovedVehicle() {

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
