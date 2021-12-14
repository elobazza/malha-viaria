package view.tablemodel;

import java.awt.Component;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.ItemPista;

public class DefaultTableCellRendererMalha extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object pista, boolean isSelected, boolean hasFocus, int row, int column) {
        if(pista != null) {
            ItemPista pistaAtual = (ItemPista) pista;
            
            super.setIcon(pistaAtual.getIcone());
            
            switch(pistaAtual.getTipo()) {
                case 1: {
                    ImageIcon imagem = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/asfalto-cima.png")));
                    super.setIcon(imagem);
                    break;
                }
                case 2: {
                    ImageIcon imagem = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/asfalto-direita.png")));
                    super.setIcon(imagem);
                    break;
                }
                case 3: {
                    ImageIcon imagem = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/asfalto-baixo.png")));
                    super.setIcon(imagem);
                    break;
                }
                case 4: {
                    ImageIcon imagem = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/asfalto-esquerda.png")));
                    super.setIcon(imagem);
                    break;
                }
            }
            
            if(pistaAtual.getVeiculo()!= null) {
                super.setIcon(pistaAtual.getVeiculo().getIcone());    
            }
            else if(pistaAtual.isOcupada()) {
                ImageIcon imagem = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/asfalto-ocupado.png")));
                super.setIcon(imagem);
            }
            
            
        }
        
        super.setHorizontalAlignment(CENTER);
        super.setVerticalAlignment(CENTER);
        super.repaint();
        
        return this;
    }
}
