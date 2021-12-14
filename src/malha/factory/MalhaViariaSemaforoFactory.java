package malha.factory;

import malha.MalhaViaria;
import malha.MalhaViariaSemaforo;

public class MalhaViariaSemaforoFactory extends AbstractMalhaFactory {

    @Override
    public MalhaViaria criarMalha(int linhas, int colunas) {
        return new MalhaViariaSemaforo(linhas, colunas);
    }

}
