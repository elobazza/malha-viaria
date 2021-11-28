/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import models.Pista;

/**
 *
 * @author elois
 */
public class DefaultTableCellRendererMalha extends DefaultTableCellRenderer {
    
    public Component getTableCellRendererComponent(JTable table, Object pista, boolean isSelected, boolean hasFocus, int row, int column) {
        if(pista != null) {
            Pista pistaAtual = (Pista) pista;
            
            if(pistaAtual.getVeiculo()!= null) {
//                super.setIcon(pistaAtual.getCarro().getIcone());    
            }
            else {
//                super.setBackground(pistaAtual.getCor());
                super.setIcon(pistaAtual.getIcone());
            }
        }
//        else {
//            throw new Error("ERRINHO");
//        }
        
        super.setHorizontalAlignment(CENTER);
        super.setVerticalAlignment(CENTER);
        super.repaint();
        
        return this;
    }
}
