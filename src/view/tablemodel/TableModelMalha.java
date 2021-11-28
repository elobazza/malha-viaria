package view.tablemodel;

import controller.InterfaceControllerObserved;
import javax.swing.table.AbstractTableModel;

/**
 * Classe para Criação da Table Model
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since  novembro, 2021
 */
public class TableModelMalha extends AbstractTableModel {
    
    private InterfaceControllerObserved controller;

    public TableModelMalha(InterfaceControllerObserved controller) {
        this.controller = controller;
    }
    
    @Override
    public int getRowCount() {
        return this.controller.getMalhaRodoviaria().length;
    }

    @Override
    public int getColumnCount() {
        return this.controller.getMalhaRodoviaria()[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.controller.getMalhaRodoviaria()[rowIndex][columnIndex];
    }
    
}
