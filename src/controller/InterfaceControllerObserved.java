package controller;

import model.ItemPista;
import view.InterfaceViewObserver;

public interface InterfaceControllerObserved {
    
    public ItemPista[][] getMalhaRodoviaria();
    
    public void addObserver(InterfaceViewObserver observer);
    
    public void removeObserver(InterfaceViewObserver observer);
    
}
