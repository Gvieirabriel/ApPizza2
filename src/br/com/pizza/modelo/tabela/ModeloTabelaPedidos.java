/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizza.modelo.tabela;

import br.com.appizza.pedido.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pichau
 */
public class ModeloTabelaPedidos extends AbstractTableModel{
    private String[] colunas = new String[]{"Pedido","Status","Valor"};
    private List<Pedido> lista = new ArrayList();
    
    public ModeloTabelaPedidos() {
        
    }
    
    public void AdicionaPedido(Pedido cliente){
        this.lista.add(cliente);
        //this.fireTableRowsInserted(lista.size()-1,lista.size()-1);
    }
    
    public void limpaTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }
    
    public boolean removePedido(Pedido cliente) {
        int linha = this.lista.indexOf(cliente);
        boolean result = this.lista.remove(cliente);
        this.fireTableRowsDeleted(linha,linha);
        return result;
    }
    
    public List<Pedido> getLista(int[] indices) {
        List<Pedido> lista = new ArrayList();
        for(int i = 0; i < indices.length; i++){
            lista.add(this.lista.get(indices[i]));
        }
        return lista;
    }

    public void setLista(List<Pedido> lista) {
        this.lista = lista;
        this.fireTableRowsInserted(0,lista.size()-1);
    }
    
    public Pedido getPedido(int linha){
        return lista.get(linha);
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }
    
    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido pedido = lista.get(rowIndex);
        switch (columnIndex){
            case 0: return pedido.getNumeroPedido();
            case 1: return pedido.getStatus();
            case 2: return pedido.getValorTotal();
            default : return null;
        }
    }
    
}
