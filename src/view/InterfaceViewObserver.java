package view;

import view.tablemodel.TableModelMalha;

public interface InterfaceViewObserver {

    void atualizaTable();

    void atualizaTableModel(TableModelMalha tableModelMalha);

    void atualizaButton(Boolean iniciar);

}
