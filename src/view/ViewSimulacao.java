package view;


import view.tablemodel.TableModelMalha;
import view.tablemodel.DefaultTableCellRendererMalha;
import controller.ControllerSimulacao;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ViewSimulacao extends javax.swing.JFrame implements InterfaceViewObserver {

    private ControllerSimulacao controllerSimulacao;
    private TableModelMalha tableModel;

    private int quantidadeCarros;

    public ViewSimulacao(ControllerSimulacao controller) {
        initComponents();

        this.btFinalizar.setEnabled(false);
        this.btFinalizarDef.setEnabled(false);

        this.atualizaTableModel(new TableModelMalha(controller));
        this.controllerSimulacao = controller;
        this.controllerSimulacao.addObserver(this);
//        ImageIcon imagem = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/imagem.png")));
                
        this.pnImagem.setBackground(new Color(68, 110, 58));
//        this.tableMalha.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tfQtdVeiculos = new javax.swing.JTextField();
        btFinalizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMalha = new javax.swing.JTable();
        btIniciar = new javax.swing.JButton();
        rbSemaforo = new javax.swing.JRadioButton();
        rbMonitor = new javax.swing.JRadioButton();
        pnImagem = new javax.swing.JPanel();
        btFinalizarDef = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("QUANTIDADE DE VEÍCULOS:");

        btFinalizar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btFinalizar.setText("Finalizar");
        btFinalizar.setMaximumSize(new java.awt.Dimension(63, 24));
        btFinalizar.setMinimumSize(new java.awt.Dimension(63, 24));
        btFinalizar.setPreferredSize(new java.awt.Dimension(63, 24));
        btFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel2.setText("Malha Viária");

        tableMalha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableMalha.setRowHeight(26);
        tableMalha.setAutoscrolls(false);
        tableMalha.setEnabled(false);
        tableMalha.setTableHeader(null);
        tableMalha.setAutoResizeMode(5);
        tableMalha.setShowGrid(false);
        tableMalha.setDefaultRenderer(Object.class, new DefaultTableCellRendererMalha());
        tableMalha.setGridColor(Color.BLACK);
        jScrollPane1.setViewportView(tableMalha);

        btIniciar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btIniciar.setText("Iniciar");
        btIniciar.setMaximumSize(new java.awt.Dimension(63, 24));
        btIniciar.setMinimumSize(new java.awt.Dimension(63, 24));
        btIniciar.setPreferredSize(new java.awt.Dimension(63, 24));
        btIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarActionPerformed(evt);
            }
        });

        rbSemaforo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        rbSemaforo.setText("Executar utilizando Semáforo");
        rbSemaforo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSemaforoActionPerformed(evt);
            }
        });

        rbMonitor.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        rbMonitor.setText("Executar utilizando Monitor");
        rbMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMonitorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnImagemLayout = new javax.swing.GroupLayout(pnImagem);
        pnImagem.setLayout(pnImagemLayout);
        pnImagemLayout.setHorizontalGroup(
            pnImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        pnImagemLayout.setVerticalGroup(
            pnImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        btFinalizarDef.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btFinalizarDef.setText("Finalizar Definitivo");
        btFinalizarDef.setMaximumSize(new java.awt.Dimension(63, 24));
        btFinalizarDef.setMinimumSize(new java.awt.Dimension(63, 24));
        btFinalizarDef.setPreferredSize(new java.awt.Dimension(63, 24));
        btFinalizarDef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarDefActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfQtdVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbSemaforo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbMonitor)
                    .addComponent(pnImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btFinalizarDef, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btFinalizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(btIniciar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(pnImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfQtdVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbSemaforo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbMonitor)
                .addGap(20, 20, 20)
                .addComponent(btIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btFinalizarDef, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
        this.controllerSimulacao.setStart(false);
        this.atualizaButton(false);
    }//GEN-LAST:event_btFinalizarActionPerformed

    private void btIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarActionPerformed

        if(tfQtdVeiculos.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Por favor, informe a quantidade de carros! :D");
        }
        else {
            this.quantidadeCarros = Integer.parseInt(tfQtdVeiculos.getText());

            if(rbMonitor.isSelected()) {
                try {
                    this.controllerSimulacao.iniciarSimulacao(quantidadeCarros, false, true);
                } catch (IOException ex) {
                    Logger.getLogger(ViewSimulacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
            else if (rbSemaforo.isSelected()) {
                try {
                    this.controllerSimulacao.iniciarSimulacao(quantidadeCarros, true, false);
                } catch (IOException ex) {
                    Logger.getLogger(ViewSimulacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
            else {
                JOptionPane.showMessageDialog(null,"Por favor, informe qual método deseja utilizar! :D");
            }

            this.controllerSimulacao.setRunning(true);
            this.controllerSimulacao.setStart(true);
        }
    }//GEN-LAST:event_btIniciarActionPerformed

    private void rbSemaforoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSemaforoActionPerformed
        if(rbMonitor.isSelected()){
            rbMonitor.setSelected(false);
        }
    }//GEN-LAST:event_rbSemaforoActionPerformed

    private void btFinalizarDefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarDefActionPerformed
        this.controllerSimulacao.setStart(false);
        this.controllerSimulacao.setRunning(false);
        this.controllerSimulacao.removeTodosVeiculos();
        this.controllerSimulacao.inicializarMalha();
        this.controllerSimulacao.notifyTableModelChanged();
        this.atualizaButton(false);
        
        // Só para garantir que vai realmente apagar todos, antes acontecia 
        // (raramente) de ficar um veiculo ou dois
        this.controllerSimulacao.removeTodosVeiculos();
        this.controllerSimulacao.inicializarMalha();
        this.controllerSimulacao.notifyTableModelChanged();
    }//GEN-LAST:event_btFinalizarDefActionPerformed

    private void rbMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMonitorActionPerformed
        if(rbSemaforo.isSelected()){
            rbSemaforo.setSelected(false);
        }
    }//GEN-LAST:event_rbMonitorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFinalizar;
    private javax.swing.JButton btFinalizarDef;
    private javax.swing.JButton btIniciar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnImagem;
    private javax.swing.JRadioButton rbMonitor;
    private javax.swing.JRadioButton rbSemaforo;
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
        if (iniciar) {
            this.btIniciar.setEnabled(false);
            this.btFinalizar.setEnabled(true);
            this.btFinalizarDef.setEnabled(true);
        } else {
            this.btIniciar.setEnabled(true);
            this.btFinalizar.setEnabled(false);
            this.btFinalizarDef.setEnabled(false);
        }
    }
}
