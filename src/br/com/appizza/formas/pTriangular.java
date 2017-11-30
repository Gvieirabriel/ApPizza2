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
public class pTriangular extends Forma{
    @Override
    public void setDimensao(double dimensao) {
        if(dimensao>20&&dimensao<60)
            super.setDimensao(dimensao);
        else
            System.out.println("Dimensao invalida");
    }
    
    @Override
    public void setDimensaoCmQuadrados(double dimensaoCmQuadrados) {
        if(dimensaoCmQuadrados>100&&dimensaoCmQuadrados<1600)
            super.setDimensao(Math.round(2*Math.sqrt(dimensaoCmQuadrados/Math.sqrt(3))));
        else
            System.out.println("Dimensao invalida");
    }
}
