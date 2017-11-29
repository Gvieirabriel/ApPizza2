/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appizza.formas;

import br.com.appizza.sabor.Sabor;
import br.com.pizza.dao.TipoDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class Forma {
    private int codForma;
    private int codPedido;
    private List<Sabor> sabores;
    private String forma;
    private double dimensao;
    private double valor;
    
    
    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Sabor> getSabores() {
        return sabores;
    }

    public void setSabores(List<Sabor> sabores) {
        this.sabores = sabores;
    }
    
    public void calculaValor(){
        if(sabores.size()==1)
            try {
                this.valor = this.getDimensao()*dimensaoPorTipo(sabores.get(0).getCodTipo());
            } catch (SQLException ex) {
                Logger.getLogger(Forma.class.getName()).log(Level.SEVERE, null, ex);
            }
        else
            for(int i = 0; i < sabores.size(); i++)
                try {
                    this.valor += this.getDimensao()*dimensaoPorTipo(sabores.get(i).getCodTipo());
                } catch (SQLException ex) {
                    Logger.getLogger(Forma.class.getName()).log(Level.SEVERE, null, ex);
                }
        this.valor = this.valor/2;   
    }
    
    public double dimensaoPorTipo(int i) throws SQLException{
        TipoDAO t = new TipoDAO();
        return t.pesquisarValTipo(i);
    }

    public int getCodForma() {
        return codForma;
    }

    public void setCodForma(int codForma) {
        this.codForma = codForma;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }
}
