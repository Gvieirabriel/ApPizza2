/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appizza.formas;

/**
 *
 * @author Gabriel
 */
public class Forma {
    
    private String tipo[];
    private String sabor[];
    private String forma;
    private float dimensao;
    
    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public float getDimensao() {
        return dimensao;
    }

    public void setDimensao(float dimensao) {
        this.dimensao = dimensao;
    }

    public String[] getTipo() {
        return tipo;
    }

    public void setTipo(String[] tipo) {
        this.tipo = tipo;
    }

    public String[] getSabor() {
        return sabor;
    }

    public void setSabor(String[] sabor) {
        this.sabor = sabor;
    }
}