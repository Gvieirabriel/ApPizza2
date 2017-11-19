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
public class pQuadrada extends Forma {
    
    @Override
    public void setDimensao(double dimensao) {
        if(dimensao>10&&dimensao<40)
            super.setDimensao(dimensao);
        else
            System.out.println("Dimensao invalida");
    }
    
    public void setDimensaoCmQuadrados(double dimensaoCmQuadrados) {
        if(dimensaoCmQuadrados>100&&dimensaoCmQuadrados<1600)
            super.setDimensao(Math.sqrt(dimensaoCmQuadrados));
        else
            System.out.println("Dimensao invalida");
    }
}
