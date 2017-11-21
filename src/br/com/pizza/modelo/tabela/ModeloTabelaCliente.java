
package br.com.pizza.modelo.tabela;

import br.com.appizza.cliente.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Leticia
 */
public class ModeloTabelaCliente extends AbstractTableModel{
    
    private String[] colunas = new String[]{"Id","Nome","Sobrenome","Telefone"};
    private List<Cliente> lista = new ArrayList();
    
    public ModeloTabelaCliente(){
    }
    
    public ModeloTabelaCliente(List<Cliente> lista) {
        this.lista = lista;
    }
    
    public void AdicionaCliente(Cliente cliente){
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
    
    public boolean removeCliente(Cliente cliente) {
        int linha = this.lista.indexOf(cliente);
        boolean result = this.lista.remove(cliente);
        this.fireTableRowsDeleted(linha,linha);
        return result;
    }
    
    public List<Cliente> getLista(int[] indices) {
        List<Cliente> lista = new ArrayList();
        for(int i = 0; i < indices.length; i++){
            lista.add(this.lista.get(indices[i]));
        }
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
        this.fireTableRowsInserted(0,lista.size()-1);
    }
    
    public Cliente getCliente(int linha){
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
        Cliente customer = lista.get(rowIndex);
        switch (columnIndex){
            case 0: return customer.getIdCliente();
            case 1: return customer.getNome();
            case 2: return customer.getSobrenome();
            case 3: return customer.getTelefone();
            default : return null;
        }
    }
    
}
