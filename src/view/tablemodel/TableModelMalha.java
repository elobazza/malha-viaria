package view.tablemodel;

import controller.InterfaceControllerObserved;
import javax.swing.table.AbstractTableModel;

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
