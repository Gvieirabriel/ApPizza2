/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizza.telas;

import br.com.pizza.modelo.tabela.ModeloTabelaPedidos;
import br.com.appizza.cliente.Cliente;
import br.com.appizza.pedido.Pedido;
import br.com.pizza.dao.ClienteDAO;
import br.com.pizza.dao.PedidoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Leticia
 */
public class ManterPedido extends javax.swing.JFrame {

    private ModeloTabelaPedidos ModeloTabelaPedidos;
    private int linhaClicada=-1;
    
    /**
     * Creates new form ManterPedido
     */
    public ManterPedido() {
        ModeloTabelaPedidos = new ModeloTabelaPedidos();
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

        pesquisar = new javax.swing.JLabel();
        telefone = new javax.swing.JTextField();
        pesqCli = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPedidos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pesquisar.setText("Pesquisar Cliente (cel/tel):");

        telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneActionPerformed(evt);
            }
        });

        pesqCli.setText("Ok");
        pesqCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqCliActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        tabelaPedidos.setModel(ModeloTabelaPedidos);
        tabelaPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPedidos);

        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesqCli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(46, 46, 46)
                .addComponent(cancelar)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisar)
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesqCli)
                    .addComponent(cancelar)
                    .addComponent(jButton1))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_telefoneActionPerformed

    private void pesqCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqCliActionPerformed
        // TODO add your handling code here:
        ClienteDAO daoc = new ClienteDAO();
        PedidoDAO dao = new PedidoDAO();
        List<Cliente> lista = new ArrayList();
        List<Pedido> listaP = new ArrayList();
        lista = daoc.pesquisaTel(telefone.getText());
        if(!lista.isEmpty()){
            try {
                listaP = dao.listarPedidoCliente(lista.get(0).getIdCliente());
                if(listaP.isEmpty()){
                    IncluirPedido p = new IncluirPedido();
                    p.recebeCliente(lista.get(0).getIdCliente());
                    p.setVisible(true);
                    this.setVisible(false);
                    /*ManterItemPedido mip = new ManterItemPedido();
                    mip.recebePedido(0,lista.get(0).getIdCliente());
                    mip.setVisible(true);
                    this.setVisible(false);*/
                }
            } catch (Exception ex) {
                Logger.getLogger(ManterPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
            ModeloTabelaPedidos.setLista(listaP);
        }else{
            JOptionPane.showMessageDialog(null,"Não encontrado.");
        }
    }//GEN-LAST:event_pesqCliActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        new TelaInicial().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(linhaClicada != -1){
            ClienteDAO daoc = new ClienteDAO();
            List<Cliente> lista = new ArrayList();
            lista = daoc.pesquisaTel(telefone.getText());
            Pedido p = ModeloTabelaPedidos.getPedido(linhaClicada);
           /* AlterarPedido a = new AlterarPedido();
            a.recebePedido(p.getNumeroPedido());
            a.setVisible(true);
            this.setVisible(false);*/
           ManterItemPedido mip = new ManterItemPedido();
           System.out.println(p.getNumeroPedido());
           mip.recebePedido(p.getNumeroPedido(),lista.get(0).getIdCliente());
           mip.listarPedidos();
           mip.setVisible(true);
           this.setVisible(false);
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelaPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPedidosMouseClicked
        // TODO add your handling code here:
        linhaClicada = tabelaPedidos.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_tabelaPedidosMouseClicked

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
            java.util.logging.Logger.getLogger(ManterPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManterPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManterPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManterPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManterPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pesqCli;
    private javax.swing.JLabel pesquisar;
    private javax.swing.JTable tabelaPedidos;
    private javax.swing.JTextField telefone;
    // End of variables declaration//GEN-END:variables
}
