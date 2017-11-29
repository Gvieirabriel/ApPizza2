/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizza.dao;

import br.com.appizza.formas.Forma;
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
 * @author Gabriel
 */
public class FormaDAO {
    private final String incluir = "INSERT INTO Forma(codPedido,valorUnitario,nomeForma,codSabor,codSabor2,dimensaoLado) VALUES (?,?,?,?,?,?)";
    private final String incluir2 = "INSERT INTO Forma(codPedido,valorUnitario,nomeForma,codSabor,codSabor2,dimensaoLado) VALUES (?,?,?,?,?,?)";
    private final String atualizar = "UPDATE Forma SET valorUnitario= ?, nomeForma= ?,codSabor=?,dimensaoLado=? WHERE idForma = ?";
    private final String atualizar2 = "UPDATE Forma SET valorUnitario= ?, nomeForma= ?,codSabor=?,codSabor2=?,dimensaoLado=? WHERE idForma = ?";
    private final String excluir = "DELETE * FROM Forma WHERE idForma = ?";
    private final String listar = "SELECT codPedido,idForma,valorUnitario,nomeForma,codSabor,codSabor2,dimensaoLado FROM Forma f WHERE codPedido = ?";
    
    public void inserirFormaUmSabor(Forma f){
        Connection con = null;
        PreparedStatement stmt1 = null;
        try{
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            stmt1 = con.prepareStatement(incluir,PreparedStatement.RETURN_GENERATED_KEYS);
            stmt1.setInt(1,f.getCodPedido());
            stmt1.setDouble(2, f.getValor());
            stmt1.setString(3,f.getForma());
            stmt1.setInt(4,f.getSabores().get(0).getIdSabor());
            stmt1.setInt(5,1);
            stmt1.setDouble(6,f.getDimensao());
            stmt1.executeUpdate();
            con.commit();
        }catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir o Forma no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt1.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt1. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());}
        }
    }
    
    public void inserirFormaDoisUmSabor(Forma f){
        Connection con = null;
        PreparedStatement stmt1 = null;
        try{
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            stmt1 = con.prepareStatement(incluir2,PreparedStatement.RETURN_GENERATED_KEYS);
            stmt1.setInt(1,f.getCodPedido());
            stmt1.setDouble(2, f.getValor());
            stmt1.setString(3,f.getForma());
            stmt1.setInt(4,f.getSabores().get(0).getIdSabor());
            stmt1.setInt(5,f.getSabores().get(1).getIdSabor());
            stmt1.setDouble(6,f.getDimensao());
            stmt1.executeUpdate();
            con.commit();
        }catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir o Forma no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt1.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt1. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());}
        }
    }

    public List<Forma> listarForma(int codF) throws SQLException, Exception{
        Connection con = null;
        PreparedStatement stmt1 = null;
        ResultSet rs = null;
        List<Forma> lista = new ArrayList();
        try{
            con = ConnectionFactory.getConnection();
            stmt1 = con.prepareStatement(listar);
            stmt1.setInt(1,codF);
            rs = stmt1.executeQuery();
            while(rs.next()){
                Forma f = new Forma();
                List<Sabor> s = new ArrayList();
                Sabor sab = new Sabor();
                Sabor sab2 = new Sabor();
                f.setCodForma(rs.getInt("idForma"));
                f.setDimensao(rs.getDouble("dimensaoLado"));
                f.setValor(rs.getDouble("valorUnitario"));
                f.setForma(rs.getString("nomeForma"));
                f.setCodPedido(rs.getInt("codPedido"));  
                sab.setIdSabor(rs.getInt("codSabor"));
                s.add(sab);
                sab2.setIdSabor(rs.getInt("codSabor2"));
                s.add(sab2);
                f.setSabores(s);
                lista.add(f);
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
        
    public void atualizar1(Forma f){
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(atualizar);
            stmt.setDouble(1, f.getValor());
            stmt.setString(2,f.getForma());
            stmt.setInt(3,f.getSabores().get(0).getIdSabor());
            stmt.setDouble(4,f.getDimensao());
            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexÃ£o. Ex="+ex.getMessage());}
        }
    }
    
    public void atualizar2(Forma f){
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(atualizar2);
            stmt.setDouble(1, f.getValor());
            stmt.setString(2,f.getForma());
            stmt.setInt(3,f.getSabores().get(0).getIdSabor());
            stmt.setInt(4,f.getSabores().get(1).getIdSabor());
            stmt.setDouble(5,f.getDimensao());
            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexÃ£o. Ex="+ex.getMessage());}
        }
    }
        
    public void excluir(Forma f) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(excluir);
            stmt.setInt(1,f.getCodForma());
            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexÃ£o. Ex="+ex.getMessage());}
        }
    }
}
