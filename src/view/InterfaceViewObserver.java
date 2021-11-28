package view;

import view.tablemodel.TableModelMalha;

/**
 * Interface para a View
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since  novembro, 2021
 */
public interface InterfaceViewObserver {
    
    public void atualizaTable();
    
    public void atualizaTableModel(TableModelMalha tableModelMalha);
   
}
