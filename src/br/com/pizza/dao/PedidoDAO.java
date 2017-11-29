/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizza.dao;

import br.com.appizza.pedido.Pedido;
import br.com.pizza.conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mths
 */
public class PedidoDAO {
    private final String incluir = "INSERT INTO Pedido(codCliente,valorTotal,estado) VALUES (?,?,?)";
    private final String atualizar = "UPDATE Pedido SET valorTotal= ?, estado= ?, WHERE idPedido = ?";
    private final String excluir = "DELETE FROM Pedido WHERE idPedido = ?";
    private final String listar = "SELECT pedido.idPedido, pedido.valorTotal, pedido.estado FROM Pedido";
    private final String listarPorCliente = "SELECT pedido.idPedido, pedido.valorTotal, pedido.estado FROM Pedido WHERE codCliente = (?)";

    public void inserirPedido(Pedido pedido, int codCliente){
         Connection con = null;
        PreparedStatement stmt1 = null;
        try{
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            stmt1 = con.prepareStatement(incluir,PreparedStatement.RETURN_GENERATED_KEYS);
            stmt1.setInt(1,codCliente);
            stmt1.setDouble(2, pedido.getValorTotal());
            stmt1.setString(3,"Aberto");
            stmt1.executeUpdate();
            con.commit();
        }catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir o Pedido no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt1.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt1. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());}
        }
    }

        public List<Pedido> listarPedido() throws SQLException, Exception{
        Connection con = null;
        PreparedStatement stmt1 = null;
        ResultSet rs = null;
        List<Pedido> lista = new ArrayList();
        try{
            con = ConnectionFactory.getConnection();
            stmt1 = con.prepareStatement(listar);
            rs = stmt1.executeQuery();
            while(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setNumeroPedido(rs.getInt("idPedido"));
                pedido.setValorTotal(rs.getFloat("valorTotal"));
                pedido.setStatus(rs.getString("estado"));

                lista.add(pedido);
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
        
        public List<Pedido> listarPedidoCliente(int codCliente) throws SQLException, Exception{
        Connection con = null;
        PreparedStatement stmt1 = null;
        ResultSet rs = null;
        List<Pedido> lista = new ArrayList();
        try{
            con = ConnectionFactory.getConnection();
            stmt1 = con.prepareStatement(listarPorCliente);
            stmt1.setInt(1,codCliente);
            rs = stmt1.executeQuery();
            while(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setNumeroPedido(rs.getInt("idPedido"));
                pedido.setValorTotal(rs.getFloat("valorTotal"));
                pedido.setStatus(rs.getString("estado"));

                lista.add(pedido);
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
        
        public void atualizar(Pedido pedido){
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(atualizar);
            stmt.setDouble(1,pedido.getValorTotal());
            stmt.setString(2,pedido.getStatus());
            stmt.setInt(3,pedido.getNumeroPedido());

            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexÃ£o. Ex="+ex.getMessage());}
        }
    }
        public void excluir(Pedido pedido) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(excluir);
            stmt.setInt(1,pedido.getNumeroPedido());
            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexÃ£o. Ex="+ex.getMessage());}
        }
    }
}
