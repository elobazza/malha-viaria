package malha;

import model.PosicaoPista;
import model.Veiculo;

import java.util.concurrent.Semaphore;

public class MalhaViariaSemaforo extends MalhaViaria {

    private final Semaphore mutex;

    public MalhaViariaSemaforo(int linhas, int colunas) {
        super(linhas, colunas);

        mutex = new Semaphore(1);
    }

    @Override
    public void adicionarVeiculo(PosicaoPista posicaoPista, Veiculo veiculo) {
        try {
            mutex.acquire();
            int linha = posicaoPista.getLinha();
            int coluna = posicaoPista.getColuna();
            malha[linha][coluna].setVeiculo(veiculo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mutex.release();
        }
    }

    @Override
    public void removerVeiculo(PosicaoPista posicaoPista, Veiculo veiculo) {
        try {
            mutex.acquire();
            int linha = posicaoPista.getLinha();
            int coluna = posicaoPista.getColuna();
            malha[linha][coluna].setVeiculo(null);
            notificarController(veiculo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mutex.release();
        }
    }
}
