package model;

import java.util.List;

public interface PercursoPista {
    
    public List<ItemPista> getPercurso(ItemPista pistaAtual, ItemPista pistaAnterior);
    
    public ItemPista getProximaPista(ItemPista pistaAtual, ItemPista pistaAnterior);
    
}
