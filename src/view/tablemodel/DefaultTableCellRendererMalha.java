package view.tablemodel;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Pista;

/**
 * Classe para Renderizar a Malha (desenhar na tela)
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since  novembro, 2021
 */
public class DefaultTableCellRendererMalha extends DefaultTableCellRenderer {
    
    public Component getTableCellRendererComponent(JTable table, Object pista, boolean isSelected, boolean hasFocus, int row, int column) {
        if(pista != null) {
            Pista pistaAtual = (Pista) pista;
            
            if(pistaAtual.getVeiculo()!= null) {
//                super.setIcon(pistaAtual.getCarro().getIcone());    
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
