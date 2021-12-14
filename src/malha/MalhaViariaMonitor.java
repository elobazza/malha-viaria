package malha;

import model.PosicaoPista;
import model.Veiculo;

public class MalhaViariaMonitor extends MalhaViaria {

    public MalhaViariaMonitor(int linhas, int colunas) {
        super(linhas, colunas);
    }

    @Override
    public synchronized void adicionarVeiculo(PosicaoPista posicaoPista, Veiculo veiculo) {
        int linha = posicaoPista.getLinha();
        int coluna = posicaoPista.getColuna();
        malha[linha][coluna].setVeiculo(veiculo);
    }

    @Override
    public synchronized void removerVeiculo(PosicaoPista posicaoPista, Veiculo veiculo) {
        int linha = posicaoPista.getLinha();
        int coluna = posicaoPista.getColuna();
        malha[linha][coluna].setVeiculo(null);
        notificarController(veiculo);
    }
}
