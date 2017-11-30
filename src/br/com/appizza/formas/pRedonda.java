/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appizza.formas;

import static java.lang.Math.PI;

/**
 *
 * @author Gabriel
 */
public class pRedonda extends Forma {
    
    @Override
    public void setDimensao(double dimensao) {
        if(dimensao>7&&dimensao<23)
            super.setDimensao(dimensao);
        else
            System.out.println("Dimensao invalida");
    }
    
    @Override
    public void setDimensaoCmQuadrados(double dimensaoCmQuadrados) {
        if(dimensaoCmQuadrados>100&&dimensaoCmQuadrados<1600)
            super.setDimensao(Math.round(Math.sqrt(dimensaoCmQuadrados/PI)));
        else
            System.out.println("Dimensao invalida");
    }
}
