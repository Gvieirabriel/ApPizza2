/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizza.modelo.tabela;

import br.com.appizza.formas.Forma;
import br.com.appizza.sabor.Sabor;
import br.com.pizza.dao.SaborDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gabriel
 */
public class ModeloTabelaItemPedido extends AbstractTableModel{

    private String[] colunas = new String[]{"Sabores","Forma","Valor"};
    private List<Forma> lista = new ArrayList();
    
    public ModeloTabelaItemPedido() {
        
    }
    
    public ModeloTabelaItemPedido(List<Forma> lista) {
        this.lista = lista;
    }
    
    
    public void AdicionaItemPedido(Forma f){
        this.lista.add(f);
        //this.fireTableRowsInserted(lista.size()-1,lista.size()-1);
    }
    
    public void limpaTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }
    
    public boolean removeItemPedido(Forma f) {
        int linha = this.lista.indexOf(f);
        boolean result = this.lista.remove(f);
        this.fireTableRowsDeleted(linha,linha);
        return result;
    }
    
    public List<Forma> getLista(int[] indices) {
        List<Forma> lista = new ArrayList();
        for(int i = 0; i < indices.length; i++){
            lista.add(this.lista.get(indices[i]));
        }
        return lista;
    }

    public void setLista(List<Forma> lista) {
        this.lista = lista;
        this.fireTableRowsInserted(0,lista.size()-1);
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
        Forma f = lista.get(rowIndex);
        String s;
        SaborDAO sab = new SaborDAO();
        Sabor sabor = new Sabor();
        Sabor sabor2 = new Sabor();
        if(f.getSabores().size()==1){
            sabor = sab.pesquisaId(f.getSabores().get(0).getIdSabor());
            s = sabor.getNome();
        }else{
            sabor = sab.pesquisaId(f.getSabores().get(0).getIdSabor());
            sabor2 = sab.pesquisaId(f.getSabores().get(1).getIdSabor());
            s = sabor.getNome()+" e "+sabor2.getNome();
        }
        switch (columnIndex){
            case 0: return s;
            case 1: return f.getForma();
            case 2: return f.getValor();
            default : return null;
        }
    }

    public Forma getItemPedido(int linhaClicada) {
        return lista.get(linhaClicada);
    }
    
}
