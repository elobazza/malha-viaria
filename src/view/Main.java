package view;

import controller.ControllerSimulacao;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Classe Main
 * @author Eloísa Bazzanella e Maria Eduarda Buzana
 * @since  novembro, 2021
 */
public class Main extends javax.swing.JFrame {

    private FileNameExtensionFilter Filter;
    private JFileChooser            FileChooser;
    private ControllerSimulacao     controllerSimulacao;
    
    public Main() {
//        try {
//            UIManager.setLookAndFeel( new FlatLightLaf());
//        } catch( Exception ex ) {
//            System.err.println("Failed to initialize LaF");
//        }
        initComponents();
        this.setFileChooserOptions();
        this.controllerSimulacao = ControllerSimulacao.getInstance();
    }
    
    /** 
     * Define as propriedades da Janela de Selecao de Arquivos
     * 
     * - Realizada filtragem somente de .txt
     */    
    private void setFileChooserOptions(){
        this.FileChooser = new JFileChooser();
        this.Filter      = new FileNameExtensionFilter("TEXT FILES", "txt", "text");

        FileChooser.setFileFilter(Filter);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        zero_zero1 = new javax.swing.JLabel();
        zero_zero2 = new javax.swing.JLabel();
        zero_zero16 = new javax.swing.JLabel();
        zero_zero18 = new javax.swing.JLabel();
        zero_zero19 = new javax.swing.JLabel();
        zero_zero22 = new javax.swing.JLabel();
        zero_zero24 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        zero_zero1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zero_zero1.setText("0 X 0");

        zero_zero2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zero_zero2.setText("0 X 0");

        zero_zero16.setBackground(new java.awt.Color(255, 51, 0));
        zero_zero16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zero_zero16.setText("0x0");
        zero_zero16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        zero_zero16.setMaximumSize(new java.awt.Dimension(105, 105));
        zero_zero16.setMinimumSize(new java.awt.Dimension(105, 105));
        zero_zero16.setPreferredSize(new java.awt.Dimension(105, 105));

        zero_zero18.setBackground(new java.awt.Color(255, 51, 0));
        zero_zero18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zero_zero18.setText("0x0");
        zero_zero18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        zero_zero18.setMaximumSize(new java.awt.Dimension(105, 105));
        zero_zero18.setMinimumSize(new java.awt.Dimension(105, 105));
        zero_zero18.setPreferredSize(new java.awt.Dimension(105, 105));

        zero_zero19.setBackground(new java.awt.Color(255, 51, 0));
        zero_zero19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zero_zero19.setText("0x0");
        zero_zero19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        zero_zero19.setMaximumSize(new java.awt.Dimension(105, 105));
        zero_zero19.setMinimumSize(new java.awt.Dimension(105, 105));
        zero_zero19.setPreferredSize(new java.awt.Dimension(105, 105));

        zero_zero22.setBackground(new java.awt.Color(255, 51, 0));
        zero_zero22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zero_zero22.setText("0x0");
        zero_zero22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        zero_zero22.setMaximumSize(new java.awt.Dimension(105, 105));
        zero_zero22.setMinimumSize(new java.awt.Dimension(105, 105));
        zero_zero22.setPreferredSize(new java.awt.Dimension(105, 105));

        zero_zero24.setBackground(new java.awt.Color(255, 51, 0));
        zero_zero24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zero_zero24.setText("0x0");
        zero_zero24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        zero_zero24.setMaximumSize(new java.awt.Dimension(105, 105));
        zero_zero24.setMinimumSize(new java.awt.Dimension(105, 105));
        zero_zero24.setPreferredSize(new java.awt.Dimension(105, 105));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton1.setText("Sobre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClickSobre(evt);
            }
        });

        jButton3.setText("Carregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClickCarregar(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Malha Viária");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onClickCarregar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickCarregar
        int fileChooseResponsee = FileChooser.showSaveDialog(null);

        if (fileChooseResponsee == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = new File(FileChooser.getSelectedFile().getAbsolutePath());
            
            try {
                controllerSimulacao.carregaSimulacao(arquivoSelecionado);
                ViewSimulacao telaSimulacao = new ViewSimulacao(controllerSimulacao);
                telaSimulacao.setVisible(true);
                
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_onClickCarregar

    private void onClickSobre(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickSobre
        new Sobre().setVisible(true);
    }//GEN-LAST:event_onClickSobre

   
   
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel zero_zero1;
    private javax.swing.JLabel zero_zero16;
    private javax.swing.JLabel zero_zero18;
    private javax.swing.JLabel zero_zero19;
    private javax.swing.JLabel zero_zero2;
    private javax.swing.JLabel zero_zero22;
    private javax.swing.JLabel zero_zero24;
    // End of variables declaration//GEN-END:variables
}
