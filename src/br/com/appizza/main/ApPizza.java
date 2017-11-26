/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appizza.main;

import br.com.appizza.sabor.Sabor;
import br.com.pizza.conexao.ConnectionFactory;
import br.com.pizza.telas.TelaInicial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        if(!verificaTipos())
          cadastraTipos();
    }

    private static void cadastraTipos() {
        Connection con = null;
        PreparedStatement stmt1 = null;
        try{
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            String incluirTipos = "INSERT INTO Tipo(tipo) VALUES (?)";
            stmt1 = con.prepareStatement(incluirTipos,PreparedStatement.RETURN_GENERATED_KEYS);
            stmt1.setString(1, "Simples");
            stmt1.executeUpdate();
            stmt1.setString(1, "Especial");
            stmt1.executeUpdate();
            stmt1.setString(1, "Premium");
            stmt1.executeUpdate();
            con.commit();
        }catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir o Sabor no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt1.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt1. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());}
        }
    }

    private static boolean verificaTipos() {
        Connection con = null;
        PreparedStatement stmt1 = null;
        ResultSet rs = null;
        try{
            con = ConnectionFactory.getConnection();
            String pesquisaTipos = "SELECT tipo.tipo FROM tipo";
            stmt1 = con.prepareStatement(pesquisaTipos);
            rs = stmt1.executeQuery();
            if(rs.next()){
                return true;
            }
            return false;
        }catch (SQLException ex) {
            throw new RuntimeException("Erro listar. Origem="+ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar result set. Ex="+ex.getMessage());}
            try{stmt1.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());}
        }}
    
}
