package controller;

import model.Pista;

/**
 * Controller da Pista
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since  novembro, 2021
 */
public class ControllerPista {
        
    public void defineDirecaoPista(Pista pista) {
        pista.setTransitaCima(false);
        pista.setTransitaBaixo(false);
        pista.setTransitaDireita(false);
        pista.setTransitaEsquerda(false);
        
        switch(pista.getTipo()) {
            case 1: case 5: {
                pista.setTransitaCima(true);
                break;
            }
            case 2: case 6: {
                pista.setTransitaDireita(true);
                break;
            }
            case 3: case 7: {
                pista.setTransitaBaixo(true);
                break;
            }
            case 4: case 8: {
                pista.setTransitaEsquerda(true);
                break;
            }
            case 9: {
                pista.setTransitaCima(true);
                pista.setTransitaDireita(true);
                break;
            }
            case 10: {
                pista.setTransitaCima(true);
                pista.setTransitaEsquerda(true);
                break;
            }
            case 11: {
                pista.setTransitaBaixo(true);
                pista.setTransitaDireita(true);
                break;
            }
            case 12: {
                pista.setTransitaBaixo(true);
                pista.setTransitaEsquerda(true);
                break;
            }
        }
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
                    }
                }
                
                if(j == 0) {
                    if(pista.getTipo() == 2) {
                        pista.setIsEntrada(true);
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
                    }
                }
                
            }
        }
    }
    
}
