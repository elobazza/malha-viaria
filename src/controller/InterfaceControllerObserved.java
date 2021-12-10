package controller;

import model.ItemPista;
import view.InterfaceViewObserver;

/**
 * Interface para o Controller
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since  novembro, 2021
 */
public interface InterfaceControllerObserved {
    
    public ItemPista[][] getMalhaRodoviaria();
    
    public void addObserver(InterfaceViewObserver observer);
    
    public void removeObserver(InterfaceViewObserver observer);
    
}
