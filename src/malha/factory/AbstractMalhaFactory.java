package malha.factory;

import malha.MalhaViaria;

public abstract class AbstractMalhaFactory {

    public abstract MalhaViaria criarMalha(int linhas, int colunas);
}
