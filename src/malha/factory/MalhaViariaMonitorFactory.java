package malha.factory;

import malha.MalhaViaria;
import malha.MalhaViariaMonitor;

public class MalhaViariaMonitorFactory extends AbstractMalhaFactory {

    @Override
    public MalhaViaria criarMalha(int linhas, int colunas) {
        return new MalhaViariaMonitor(linhas, colunas);
    }

}
