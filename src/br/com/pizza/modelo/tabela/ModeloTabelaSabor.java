/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizza.modelo.tabela;

import br.com.appizza.sabor.Sabor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Leticia
 */
public class ModeloTabelaSabor extends AbstractTableModel{
    private String[] colunas = new String[]{"Id","Sabor","Tipo"};
    private List<Sabor> lista = new ArrayList();
    
    public ModeloTabelaSabor(){
    }
    
    public ModeloTabelaSabor(List<Sabor> lista) {
        this.lista = lista;
    }


    public void limpaTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }

    public boolean removeSabor(Sabor sabor) {
        int linha = this.lista.indexOf(sabor);
        boolean result = this.lista.remove(sabor);
        this.fireTableRowsDeleted(linha,linha);
        return result;
    }

    public void AdicionaSabor(Sabor sabor) {
        this.lista.add(sabor);
    }
    
    public List<Sabor> getLista(int[] indices) {
        List<Sabor> lista = new ArrayList();
        for(int i = 0; i < indices.length; i++){
            lista.add(this.lista.get(indices[i]));
        }
        return lista;
    } 
    
    public void setLista(List<Sabor> lista) {
        this.lista = lista;
        this.fireTableRowsInserted(0,lista.size()-1);
    }
    
    public Sabor getSabor(int linha){
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
        Sabor customer = lista.get(rowIndex);
        switch (columnIndex){
            case 0: return customer.getIdSabor();
            case 1: return customer.getNome();
            case 2:
                if(customer.getCodTipo()==1)
                    return "Simples";
                else if(customer.getCodTipo()==2)
                    return "Especial";
                else
                    return "Premium";
            default : return null;
        }
    }

}
