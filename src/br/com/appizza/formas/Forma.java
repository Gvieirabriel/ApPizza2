/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appizza.formas;

import br.com.appizza.sabor.Sabor;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class Forma {
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
            this.valor = dimensaoPorTipo(0);
        else
            for(int i = 0; i < sabores.size(); i++)
                this.valor += dimensaoPorTipo(i);
        this.valor = this.valor/2;   
    }
    
    public double dimensaoPorTipo(int i){
        if(sabores.get(i).getCodTipo() == 1)//Simples = 1 real Especial = 2 Premium = 3
            return this.dimensao;
        else if(sabores.get(i).getCodTipo() == 2)
            return this.dimensao*2;
        else
            return this.dimensao*3;
    }
}
