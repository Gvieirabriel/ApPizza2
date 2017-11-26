/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizza.dao;

import br.com.appizza.cliente.Cliente;
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
public class ClienteDAO {
    private final String incluir = "INSERT INTO cliente(nome,sobrenome,telefone) VALUES (?,?,?)";
    private final String atualizar = "UPDATE cliente SET nome = ?, sobrenome = ?, telefone = ? WHERE idCliente = ?";
    private final String excluir = "DELETE FROM cliente WHERE idCliente = ?";
    private final String listar = "SELECT cliente.idCliente, cliente.nome, cliente.sobrenome, cliente.telefone FROM cliente";
    private final String pesquisa = "SELECT cliente.idCliente, cliente.nome, cliente.sobrenome, cliente.telefone FROM cliente WHERE cliente.sobrenome LIKE ?";
    private final String pesquisaTel = "SELECT cliente.idCliente, cliente.nome, cliente.sobrenome, cliente.telefone FROM cliente WHERE cliente.telefone LIKE ?";
    
    public void inserirCliente(Cliente cliente) throws SQLException{
        Connection con = null;
        PreparedStatement stmt1 = null;
        try{
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            
            stmt1 = con.prepareStatement(incluir,PreparedStatement.RETURN_GENERATED_KEYS);
            stmt1.setString(1,cliente.getNome());
            stmt1.setString(2,cliente.getSobrenome());
            stmt1.setString(3,cliente.getTelefone());
            stmt1.executeUpdate();
            con.commit();
        }catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir o Cliente no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt1.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt1. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());}
        }
    }
    
    public List<Cliente> listarCliente() throws SQLException, Exception{
        Connection con = null;
        PreparedStatement stmt1 = null;
        ResultSet rs = null;
        List<Cliente> lista = new ArrayList();
        try{
            con = ConnectionFactory.getConnection();
            stmt1 = con.prepareStatement(listar);
            rs = stmt1.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSobrenome(rs.getString("sobrenome"));
                cliente.setTelefone(rs.getString("telefone"));
                lista.add(cliente);
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
    
    public void atualizarCliente(Cliente cliente){
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(atualizar);
            stmt.setString(1,cliente.getNome());
            stmt.setString(2,cliente.getSobrenome());
            stmt.setString(3,cliente.getTelefone());
            stmt.setInt(4,cliente.getIdCliente());
            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexÃ£o. Ex="+ex.getMessage());}
        }
    }
    
    public void excluirCliente(Cliente cliente) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(excluir);
            stmt.setInt(1,cliente.getIdCliente());
            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexÃ£o. Ex="+ex.getMessage());}
        }
    }
    
    public List<Cliente> pesquisa(String sobrenome){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(pesquisa);
            stmt.setString(1,"%"+sobrenome+"%");
            rs = stmt.executeQuery();
            List<Cliente> lista = new ArrayList();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNome(rs.getString("nome"));
                c.setSobrenome(rs.getString("sobrenome"));
                c.setTelefone(rs.getString("telefone"));
                lista.add(c);
            }
            return lista;          
        }catch (SQLException ex) {
            throw new RuntimeException("Erro listar. Origem="+ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar result set. Ex="+ex.getMessage());}
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexÃ£o. Ex="+ex.getMessage());}
        }
    }

    public List<Cliente> pesquisaTel(String tel) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(pesquisaTel);
            stmt.setString(1,tel);
            rs = stmt.executeQuery();
            List<Cliente> lista = new ArrayList();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNome(rs.getString("nome"));
                c.setSobrenome(rs.getString("sobrenome"));
                c.setTelefone(rs.getString("telefone"));;
                lista.add(c);
            }
            return lista;         
        }catch (SQLException ex) {
            throw new RuntimeException("Erro listar. Origem="+ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar result set. Ex="+ex.getMessage());}
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexÃ£o. Ex="+ex.getMessage());}
        }
    }
}
