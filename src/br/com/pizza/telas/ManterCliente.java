
package br.com.pizza.telas;

import br.com.pizza.dao.ClienteDAO;
import br.com.appizza.cliente.Cliente;
import br.com.pizza.modelo.tabela.ModeloTabelaCliente;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author Leticia
 */
public class ManterCliente extends javax.swing.JFrame {

    private ModeloTabelaCliente ModeloTabelaCliente;
    private int linhaClicada=-1;
    
    public ManterCliente() {
        ModeloTabelaCliente = new ModeloTabelaCliente();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        sobrenome = new javax.swing.JTextField();
        telefone = new javax.swing.JTextField();
        cadastrarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaCliente = new javax.swing.JTable();
        listar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        limpa = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Sobrenome:");

        jLabel3.setText("Telefone:");

        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        cadastrarCliente.setText("Cadastrar");
        cadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarClienteActionPerformed(evt);
            }
        });

        TabelaCliente.setModel(ModeloTabelaCliente);
        TabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaCliente);

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

        limpa.setText("Limpar");
        limpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpaActionPerformed(evt);
            }
        });

        atualizar.setText("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(listar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(excluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(limpa))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(16, 16, 16)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(telefone, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(nome, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sobrenome, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(cadastrarCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(atualizar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastrarCliente)
                    .addComponent(atualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listar)
                    .addComponent(excluir)
                    .addComponent(limpa))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void cadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarClienteActionPerformed
        Cliente cliente = null;
        ClienteDAO dao = new ClienteDAO();
        try {
            String nomeC = nome.getText();
            String sobrenomeC = sobrenome.getText();
            int telefoneC = Integer.parseInt(telefone.getText());
            cliente = new Cliente(nomeC,sobrenomeC,telefoneC);
            dao.inserirCliente(cliente);
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar no banco de dados. E="+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        ModeloTabelaCliente.AdicionaCliente(cliente); 
    }//GEN-LAST:event_cadastrarClienteActionPerformed

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        try {
            ClienteDAO dao = new ClienteDAO();
            ModeloTabelaCliente.setLista(dao.listarCliente());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar com o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_listarActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        if(linhaClicada != -1){
            ClienteDAO dao = new ClienteDAO();
            Cliente cliente = ModeloTabelaCliente.getCliente(linhaClicada);
            try{
                cliente.setNome(nome.getText());
                cliente.setSobrenome(sobrenome.getText());
                cliente.setTelefone(Integer.parseInt(telefone.getText()));
                dao.atualizarCliente(cliente);
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Erro ao atualizar no banco de dados. E="+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
            ModeloTabelaCliente.fireTableRowsUpdated(linhaClicada, linhaClicada);
        } 
    }//GEN-LAST:event_atualizarActionPerformed

    private void tabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMouseClicked
        linhaClicada = TabelaCliente.rowAtPoint(evt.getPoint());
        Cliente cliente = ModeloTabelaCliente.getCliente(linhaClicada);
        nome.setText(cliente.getNome());
        sobrenome.setText(cliente.getSobrenome());
        telefone.setText(Integer.toString(cliente.getTelefone()));
    }//GEN-LAST:event_tabelaClienteMouseClicked

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
            if(linhaClicada != -1){
            ClienteDAO dao = new ClienteDAO();
            Cliente cliente = ModeloTabelaCliente.getCliente(linhaClicada);
            try{
                dao.excluirCliente(cliente);
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Erro ao atualizar no banco de dados. E="+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
            ModeloTabelaCliente.removeCliente(cliente);
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void limpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpaActionPerformed
        ModeloTabelaCliente.limpaTabela();
    }//GEN-LAST:event_limpaActionPerformed

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
            java.util.logging.Logger.getLogger(ManterCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManterCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManterCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManterCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManterCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaCliente;
    private javax.swing.JButton atualizar;
    private javax.swing.JButton cadastrarCliente;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton limpa;
    private javax.swing.JButton listar;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField sobrenome;
    private javax.swing.JTextField telefone;
    // End of variables declaration//GEN-END:variables
}
