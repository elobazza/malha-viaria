package view.tablemodel;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.ItemPista;

/**
 * Classe para Renderizar a Malha (desenhar na tela)
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since  novembro, 2021
 */
public class DefaultTableCellRendererMalha extends DefaultTableCellRenderer {
    
    public Component getTableCellRendererComponent(JTable table, Object pista, boolean isSelected, boolean hasFocus, int row, int column) {
        if(pista != null) {
            ItemPista pistaAtual = (ItemPista) pista;
            
            if(pistaAtual.getVeiculo()!= null) {
                super.setIcon(pistaAtual.getVeiculo().getIcone());    
            }
            else {
                super.setIcon(pistaAtual.getIcone());
            }
        }
        
        super.setHorizontalAlignment(CENTER);
        super.setVerticalAlignment(CENTER);
        super.repaint();
        
        return this;
    }
}
