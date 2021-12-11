package view;

//import com.formdev.flatlaf.FlatLightLaf;
import view.tablemodel.TableModelMalha;
import view.tablemodel.DefaultTableCellRendererMalha;
import controller.ControllerSimulacao;
import java.awt.Color;

/**
 * Classe View da Simulação
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since  novembro, 2021
 */
public class ViewSimulacao extends javax.swing.JFrame implements InterfaceViewObserver {
    
    private ControllerSimulacao controllerSimulacao;
    private TableModelMalha     tableModel;
    
    private int quantidadeCarros;
    
    public ViewSimulacao(ControllerSimulacao controller) {
        initComponents();
        
        this.btFinalizar.setEnabled(false);
        this.btPause.setEnabled(false);
        
        this.atualizaTableModel(new TableModelMalha(controller));
        this.controllerSimulacao = controller;
        this.controllerSimulacao.addObserver(this);       
    }
    
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfQtdVeiculos = new javax.swing.JTextField();
        btPause = new javax.swing.JButton();
        btFinalizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMalha = new javax.swing.JTable();
        btIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Quantidade de Veículos");

        btPause.setText("Parar Carros");
        btPause.setMaximumSize(new java.awt.Dimension(63, 24));
        btPause.setMinimumSize(new java.awt.Dimension(63, 24));
        btPause.setPreferredSize(new java.awt.Dimension(63, 24));
        btPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPauseActionPerformed(evt);
            }
        });

        btFinalizar.setText("Finalizar");
        btFinalizar.setMaximumSize(new java.awt.Dimension(63, 24));
        btFinalizar.setMinimumSize(new java.awt.Dimension(63, 24));
        btFinalizar.setPreferredSize(new java.awt.Dimension(63, 24));
        btFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarActionPerformed(evt);
            }
        });

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

        btIniciar.setText("Iniciar");
        btIniciar.setMaximumSize(new java.awt.Dimension(63, 24));
        btIniciar.setMinimumSize(new java.awt.Dimension(63, 24));
        btIniciar.setPreferredSize(new java.awt.Dimension(63, 24));
        btIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfQtdVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addComponent(btIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btPause, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfQtdVeiculos))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btPause, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPauseActionPerformed
        this.controllerSimulacao.setPause(true);
        this.atualizaButton(true);
        this.btPause.setEnabled(false);
    }//GEN-LAST:event_btPauseActionPerformed

    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
        this.controllerSimulacao.setStart(false);
        this.atualizaButton(false);
    }//GEN-LAST:event_btFinalizarActionPerformed

    private void btIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarActionPerformed
        this.quantidadeCarros = Integer.parseInt(tfQtdVeiculos.getText());
        this.controllerSimulacao.iniciarSimulacao(quantidadeCarros, false, false);
        this.controllerSimulacao.setStart(true);
        this.controllerSimulacao.setPause(false);
    }//GEN-LAST:event_btIniciarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFinalizar;
    private javax.swing.JButton btIniciar;
    private javax.swing.JButton btPause;
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

    @Override
    public void atualizaButton(Boolean iniciar) {
        if(iniciar) {
            this.btIniciar.setEnabled(false);
            this.btPause.setEnabled(true);
            this.btFinalizar.setEnabled(true);
        } else {
            this.btIniciar.setEnabled(true);
            this.btPause.setEnabled(false);
            this.btFinalizar.setEnabled(false);
        }
    }
}
