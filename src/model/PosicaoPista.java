package model;

public class PosicaoPista {
    private final int linha;
    private final int coluna;

    public PosicaoPista(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

}
