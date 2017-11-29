/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizza.dao;

import br.com.appizza.formas.Tipo;
import br.com.pizza.conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class TipoDAO {
    private final String incluir = "INSERT INTO Tipo(tipo,valorCmQuadrado) VALUES (?,?)";
    private final String atualizar = "UPDATE tipo SET tipo = ?, valorCmQuadrado = ? WHERE idTipo = ?";
    private final String excluir = "DELETE FROM tipo WHERE idTipo = ?";
    private final String pesquisaTipo = "SELECT valorCmQuadrado FROM tipo WHERE idTipo = ?";
    private final String atualizarValorPizzaCm = "UPDATE tipo SET ValorCmQuadrado = ? WHERE tipo LIKE ?";
    
    public void inserirTipo(Tipo tipo) throws SQLException{
        Connection con = null;
        PreparedStatement stmt1 = null;
        try{
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            
            stmt1 = con.prepareStatement(incluir,PreparedStatement.RETURN_GENERATED_KEYS);
            stmt1.setString(1,tipo.getTipo());
            stmt1.setFloat(2,tipo.getValorCmQuadrado());
            stmt1.executeUpdate();
            con.commit();
        }catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir o Tipo no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt1.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt1. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());}
        }
    }
    
    public boolean tipoTemTipo(){
        Connection con = null;
        PreparedStatement stmt1 = null;
        ResultSet rs = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt1 = con.prepareStatement(pesquisaTipo);
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
        }
    }
    
    public void atualizarTipo(Tipo tipo){
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(atualizar);
            stmt.setString(1,tipo.getTipo());
            stmt.setFloat(2,tipo.getValorCmQuadrado());
            stmt.setInt(3,tipo.getIdTipo()+1);
            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexÃ£o. Ex="+ex.getMessage());}
        }
    }
    
    public void excluirTipo(Tipo tipo) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(excluir);
            stmt.setInt(1,tipo.getIdTipo()+1);
            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexÃ£o. Ex="+ex.getMessage());}
        }
    }
    
    public void atualizarValorPizzaCm(float valorCmQuadrado,String tipo) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(atualizarValorPizzaCm);
            stmt.setFloat(1,valorCmQuadrado);
            stmt.setString(2,tipo);
            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexÃ£o. Ex="+ex.getMessage());}
        }
    }
    
    public double pesquisarValTipo(int idTipo) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(pesquisaTipo);
            stmt.setInt(1,idTipo);
            rs = stmt.executeQuery();
            double val = 0;
            while(rs.next()){
                val = rs.getInt("valorCmQuadrado");
            }
            return val;          
        }catch (SQLException ex) {
            throw new RuntimeException("Erro listar. Origem="+ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar result set. Ex="+ex.getMessage());}
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexÃ£o. Ex="+ex.getMessage());}
        }
    }
}
