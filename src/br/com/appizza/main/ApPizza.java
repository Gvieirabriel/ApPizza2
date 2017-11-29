/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appizza.main;

import br.com.appizza.formas.Tipo;
import br.com.pizza.dao.TipoDAO;
import br.com.pizza.telas.TelaInicial;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class ApPizza {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TelaInicial t = new TelaInicial();
        t.setVisible(true);
        t.setTitle("ApPizza");
    }
}
