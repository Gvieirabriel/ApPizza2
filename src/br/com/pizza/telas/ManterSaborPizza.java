/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizza.telas;

import br.com.appizza.sabor.Sabor;
import br.com.pizza.dao.SaborDAO;
import br.com.pizza.modelo.tabela.ModeloTabelaSabor;
import javax.swing.JOptionPane;

/**
 *
 * @author Leticia
 */
public class ManterSaborPizza extends javax.swing.JFrame {

    private ModeloTabelaSabor ModeloTabelaSabor;
    private int linhaClicada=-1;
    
    public ManterSaborPizza() {
        ModeloTabelaSabor = new ModeloTabelaSabor();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sabor = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        salvar = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        listar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaSabor = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        sabor1 = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cadastrar Sabor Pizza");

        sabor.setText("Sabor:");

        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        atualizar.setText("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        listar.setText("Listar");
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        tabelaSabor.setModel(ModeloTabelaSabor);
        tabelaSabor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaSaborMouseClicked(evt);
            }
        });
        tabelaSabor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tabelaSaborKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaSabor);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simples", "Especial", "Premium" }));

        sabor1.setText("Tipo:");

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(listar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(excluir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(limpar))
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(sabor)
                                            .addComponent(sabor1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(salvar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(atualizar))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 75, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sabor)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salvar)
                    .addComponent(atualizar))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sabor1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listar)
                    .addComponent(excluir)
                    .addComponent(limpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(cancelar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        // TODO add your handling code here:
        Sabor sabor = null;
        SaborDAO dao = new SaborDAO();
        try {
            String nomeS = nome.getText();
            sabor = new Sabor(nomeS,jComboBox1.getSelectedIndex());
            dao.inserirSabor(sabor);
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar no banco de dados. E="+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        ModeloTabelaSabor.AdicionaSabor(sabor); 
    }//GEN-LAST:event_salvarActionPerformed

    private void tabelaSaborMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaSaborMouseClicked
        // TODO add your handling code here:
        linhaClicada = tabelaSabor.rowAtPoint(evt.getPoint());
        Sabor sabor = ModeloTabelaSabor.getSabor(linhaClicada);
        nome.setText(sabor.getNome());
    }//GEN-LAST:event_tabelaSaborMouseClicked

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        // TODO add your handling code here:
        if(linhaClicada != -1){
            SaborDAO dao = new SaborDAO();
            Sabor sabor = ModeloTabelaSabor.getSabor(linhaClicada);
            try{
                sabor.setNome(nome.getText());
                sabor.setCodTipo(jComboBox1.getSelectedIndex());
                dao.atualizarSabor(sabor);
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Erro ao atualizar no banco de dados. E="+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
            try {
            ModeloTabelaSabor.setLista(dao.listarSabor());
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar com o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            } 
        } 
    }//GEN-LAST:event_atualizarActionPerformed

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        // TODO add your handling code here:
        try {
            SaborDAO dao = new SaborDAO();
            ModeloTabelaSabor.setLista(dao.listarSabor());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar com o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_listarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        // TODO add your handling code here:
        if(linhaClicada != -1){
            SaborDAO dao = new SaborDAO();
            Sabor sabor = ModeloTabelaSabor.getSabor(linhaClicada);
            try{
                dao.excluirSabor(sabor);
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Erro ao atualizar no banco de dados. E="+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
            ModeloTabelaSabor.removeSabor(sabor);
            }
    }//GEN-LAST:event_excluirActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        // TODO add your handling code here:
        ModeloTabelaSabor.limpaTabela();
    }//GEN-LAST:event_limparActionPerformed

    private void tabelaSaborKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaSaborKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaSaborKeyTyped

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        new TelaInicial().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManterSaborPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManterSaborPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManterSaborPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManterSaborPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManterSaborPizza().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton excluir;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpar;
    private javax.swing.JButton listar;
    private javax.swing.JTextField nome;
    private javax.swing.JLabel sabor;
    private javax.swing.JLabel sabor1;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabelaSabor;
    // End of variables declaration//GEN-END:variables
}
