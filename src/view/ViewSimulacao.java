/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

//import com.formdev.flatlaf.FlatLightLaf;

import controller.ControllerSimulacao;
import java.awt.Color;

/**
 *
 * @author mduda
 */
public class ViewSimulacao extends javax.swing.JFrame implements InterfaceViewObserver {
    
    private ControllerSimulacao controller;
    private TableModelMalha     tableModel;
    
    public ViewSimulacao(ControllerSimulacao controller) {
        initComponents();
        
        this.atualizaTableModel(new TableModelMalha(controller));
        this.controller = controller;
        this.controller.addObserver(this);
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfQtdVeiculos = new javax.swing.JTextField();
        btIniciar = new javax.swing.JButton();
        btFinalizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMalha = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Quantidade de Veículos");

        btIniciar.setText("Iniciar");
        btIniciar.setMaximumSize(new java.awt.Dimension(63, 24));
        btIniciar.setMinimumSize(new java.awt.Dimension(63, 24));
        btIniciar.setPreferredSize(new java.awt.Dimension(63, 24));

        btFinalizar.setText("Finalizar");
        btFinalizar.setMaximumSize(new java.awt.Dimension(63, 24));
        btFinalizar.setMinimumSize(new java.awt.Dimension(63, 24));
        btFinalizar.setPreferredSize(new java.awt.Dimension(63, 24));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Simulação Malha Viária");

        tableMalha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableMalha.setAutoscrolls(false);
        tableMalha.setEnabled(false);
        tableMalha.setTableHeader(null);
        tableMalha.setRowHeight(35);
        tableMalha.setShowGrid(false);
        tableMalha.setDefaultRenderer(Object.class, new DefaultTableCellRendererMalha());
        tableMalha.setGridColor(Color.BLACK);
        jScrollPane1.setViewportView(tableMalha);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfQtdVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(86, 86, 86)
                            .addComponent(btIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(178, 178, 178)
                            .addComponent(jLabel2))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfQtdVeiculos)
                    .addComponent(btIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFinalizar;
    private javax.swing.JButton btIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMalha;
    private javax.swing.JTextField tfQtdVeiculos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void atualizaTable() {
        this.tableModel.fireTableDataChanged();
    }

    @Override
    public void atualizaTableModel(TableModelMalha tableModelMalha) {
        this.tableModel = tableModelMalha;
        this.tableMalha.setModel(this.tableModel);
    }
}
