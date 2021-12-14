package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PercursoPistaBase implements PercursoPista {

    @Override
    public List<ItemPista> getPercurso(ItemPista pistaAtual, ItemPista pistaAnterior) {
        List<ItemPista> percurso = new ArrayList<>();
        ItemPista proximaPista = null;
        
        do {
            proximaPista = this.getProximaPista(pistaAtual, pistaAnterior);  
        } while (proximaPista.isOcupada() || !proximaPista.isTransitavel());
        
        proximaPista.setOcupada(true);

        percurso.add(proximaPista);
        
        if(proximaPista.isCruzamento()) {
            percurso.addAll(this.getPercurso(proximaPista, pistaAtual));
        }
       
        return percurso;
    }
    
    
    @Override
    public ItemPista getProximaPista(ItemPista pistaAtual, ItemPista pistaAnterior) {
        ItemPista pista = null;

        switch (pistaAtual.getTipo()) {
            case 1: {
                if(pistaAtual.getPistaDireita().getTipo() == pistaAtual.getTipo()){
                    Random random = new Random();
                    int opcao = random.nextInt(5);

                    if (opcao == 1) {
                        pista = pistaAtual.getPistaDiagonalCimaDireita();
                    } else {
                        pista = pistaAtual.getPistaCima();
                    }
                } 
                else if(pistaAtual.getPistaEsquerda().getTipo() == pistaAtual.getTipo()) {
                    Random random = new Random();
                    int opcao = random.nextInt(5);

                    if (opcao == 1) {
                        pista = pistaAtual.getPistaDiagonalCimaEsquerda();
                    } else {
                        pista = pistaAtual.getPistaCima();
                    }
                }
                else {
                    pista = pistaAtual.getPistaCima();
                }
                break;
            }
            case 2: {
                if(pistaAtual.getPistaCima().getTipo() == pistaAtual.getTipo()){
                    Random random = new Random();
                    int opcao = random.nextInt(5);

                    if (opcao == 1) {
                        pista = pistaAtual.getPistaDiagonalCimaDireita();
                    } else {
                        pista = pistaAtual.getPistaDireita();
                    }
                } 
                else if(pistaAtual.getPistaBaixo().getTipo() == pistaAtual.getTipo()) {
                    Random random = new Random();
                    int opcao = random.nextInt(5);

                    if (opcao == 1) {
                        pista = pistaAtual.getPistaDiagonalBaixoDireita();
                    } else {
                        pista = pistaAtual.getPistaDireita();
                    }
                }
                else {
                    pista = pistaAtual.getPistaDireita();
                }
                
                break;
                
            }
            case 3: {
                if(pistaAtual.getPistaEsquerda().getTipo() == pistaAtual.getTipo()){
                    Random random = new Random();
                    int opcao = random.nextInt(5);

                    if (opcao == 1) {
                        pista = pistaAtual.getPistaDiagonalBaixoEsquerda();
                    } else {
                        pista = pistaAtual.getPistaBaixo();
                    }
                } 
                else if(pistaAtual.getPistaDireita().getTipo() == pistaAtual.getTipo()) {
                    Random random = new Random();
                    int opcao = random.nextInt(5);

                    if (opcao == 1) {
                        pista = pistaAtual.getPistaDiagonalBaixoDireita();
                    } else {
                        pista = pistaAtual.getPistaBaixo();
                    }
                }
                else {
                    pista = pistaAtual.getPistaBaixo();
                }
                break;
            
            }
            case 4: {
                if(pistaAtual.getPistaCima().getTipo() == pistaAtual.getTipo()){
                    Random random = new Random();
                    int opcao = random.nextInt(5);

                    if (opcao == 1) {
                        pista = pistaAtual.getPistaDiagonalCimaEsquerda();
                    } else {
                        pista = pistaAtual.getPistaEsquerda();
                    }
                } 
                else if(pistaAtual.getPistaBaixo().getTipo() == pistaAtual.getTipo()) {
                    Random random = new Random();
                    int opcao = random.nextInt(5);

                    if (opcao == 1) {
                        pista = pistaAtual.getPistaDiagonalBaixoEsquerda();
                    } else {
                        pista = pistaAtual.getPistaEsquerda();
                    }
                }
                else {
                    pista = pistaAtual.getPistaEsquerda();
                }
                break;
            }
            case 5: {
                pista = pistaAtual.getPistaCima();
                break;
            }
            case 6: {
                pista = pistaAtual.getPistaDireita();
                break;
            }
            case 7: {
                pista = pistaAtual.getPistaBaixo();
                break;
            }
            case 8: {
                pista = pistaAtual.getPistaEsquerda();
                break;
            }
            case 9: {
                if (pistaAnterior.getTipo() == 11 || pistaAnterior.getTipo() == 9) {
                    pista = pistaAtual.getPistaDireita();
                }
                else {
                    Random random = new Random();
                    int opcao = random.nextInt(2);

                    if (opcao == 1) {
                        pista = pistaAtual.getPistaCima();
                    } else {
                        pista = pistaAtual.getPistaDireita();
                    }
                }
                break;
            }
            case 10: {
                if (pistaAnterior.getTipo() == 9 || pistaAnterior.getTipo() == 10) {
                    pista = pistaAtual.getPistaCima();
                } else {
                    Random random = new Random();
                    int opcao = random.nextInt(2);

                    if (opcao == 1) {
                        pista = pistaAtual.getPistaCima();
                    } else {
                        pista = pistaAtual.getPistaEsquerda();
                    }
                }
                break;
            }
            case 11: {
                if (pistaAnterior.getTipo() == 12 || pistaAnterior.getTipo() == 11) {
                    pista = pistaAtual.getPistaBaixo();
                } else {
                    Random random = new Random();
                    int opcao = random.nextInt(2);

                    if (opcao == 1) {
                        pista = pistaAtual.getPistaBaixo();
                    } else {
                        pista = pistaAtual.getPistaDireita();
                    }
                }
                break;
            }
            case 12: {
                if (pistaAnterior.getTipo() == 10 || pistaAnterior.getTipo() == 12) {
                    pista = pistaAtual.getPistaEsquerda();
                } else {
                    Random random = new Random();
                    int opcao = random.nextInt(2);

                    if (opcao == 1) {
                        pista = pistaAtual.getPistaBaixo();
                    } else {
                        pista = pistaAtual.getPistaEsquerda();
                    }
                }
                break;
            }
        }
        
//        if (pistaAnterior != null && pista.equals(pistaAnterior)) {
//            pista = this.getProximaPista(pistaAtual, pistaAnterior);
//        }
        
        return pista;
    }

}