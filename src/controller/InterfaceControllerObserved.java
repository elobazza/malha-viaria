package controller;

import model.Pista;
import view.InterfaceViewObserver;

/**
 * Interface para o Controller
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since  novembro, 2021
 */
public interface InterfaceControllerObserved {
    
    public Pista[][] getMalhaRodoviaria();
    
    public void addObserver(InterfaceViewObserver observer);
    
    public void removeObserver(InterfaceViewObserver observer);
    
}
