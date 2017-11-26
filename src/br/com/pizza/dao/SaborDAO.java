/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizza.dao;

import br.com.appizza.sabor.Sabor;
import br.com.pizza.conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leticia
 */
public class SaborDAO {
    private final String incluir = "INSERT INTO sabor(nome,codTipo) VALUES (?,?)";
    private final String atualizar = "UPDATE sabor SET nome = ?, codTipo = ? WHERE idSabor = ?";
    private final String excluir = "DELETE FROM sabor WHERE idSabor = ?";
    private final String listar = "SELECT sabor.idSabor, sabor.nome, sabor.codTipo FROM sabor";
    
    public void inserirSabor(Sabor sabor) throws SQLException{
        Connection con = null;
        PreparedStatement stmt1 = null;
        try{
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            stmt1 = con.prepareStatement(incluir,PreparedStatement.RETURN_GENERATED_KEYS);
            stmt1.setString(1, sabor.getNome());
            stmt1.setInt(2, sabor.getCodTipo()+1);
            stmt1.executeUpdate();
            con.commit();
        }catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir o Sabor no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt1.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt1. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());}
        }
    } 
    
    public List<Sabor> listarSabor() throws SQLException, Exception{
        Connection con = null;
        PreparedStatement stmt1 = null;
        ResultSet rs = null;
        List<Sabor> lista = new ArrayList();
        try{
            con = ConnectionFactory.getConnection();
            stmt1 = con.prepareStatement(listar);
            rs = stmt1.executeQuery();
            while(rs.next()){
                Sabor sabor = new Sabor();
                sabor.setCodTipo(rs.getInt("codTipo"));
                sabor.setIdSabor(rs.getInt("idSabor"));
                sabor.setNome(rs.getString("nome"));
                lista.add(sabor);
            }
            return lista;
        }catch (SQLException ex) {
            throw new RuntimeException("Erro listar. Origem="+ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar result set. Ex="+ex.getMessage());}
            try{stmt1.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());}
        }
    }
    
    public void atualizarSabor(Sabor sabor){
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(atualizar);
            stmt.setString(1,sabor.getNome());
            stmt.setInt(2,sabor.getCodTipo()+1);
            stmt.setInt(3,sabor.getIdSabor());
            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexÃ£o. Ex="+ex.getMessage());}
        }
    }
    
    public void excluirSabor(Sabor sabor) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(excluir);
            stmt.setInt(1,sabor.getIdSabor());
            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexÃ£o. Ex="+ex.getMessage());}
        }
    }
}
