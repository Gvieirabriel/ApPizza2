/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appizza.formas;

import java.util.List;

/**
 *
 * @author Gabriel
 */
public class Forma {

    private List<String> tipos;
    private List<String> sabores;
    private String forma;
    private double dimensao;
    private String observacoes;
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

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<String> getTipos() {
        return tipos;
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }

    public List<String> getSabores() {
        return sabores;
    }

    public void setSabores(List<String> sabores) {
        this.sabores = sabores;
    }
    
    public void calculaValor(){
        if(tipos.size()==1)
            this.valor = dimensaoPorTipo(0);
        else
            for(int i = 0; i < tipos.size(); i++)
                this.valor += dimensaoPorTipo(i);
        this.valor = this.valor/2;   
    }
    
    public double dimensaoPorTipo(int i){
        if(tipos.get(i).equals("SIMPLES"))//Simples = 1 real Especial = 2 Premium = 3
            return this.dimensao;
        else if(tipos.get(i).equals("ESPECIAL"))
            return this.dimensao*2;
        else
            return this.dimensao*3;
    }
}
