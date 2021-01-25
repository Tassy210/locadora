package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.bean.Cliente;

public class ClienteDAO {

	public void create(Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO cliente (nome, cpf, email, phone) VALUES (?, ?, ?, ?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCpf());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTelefone());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o cliente: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Cliente> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cliente m = new Cliente();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("Nome"));
				m.setTelefone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setCpf(rs.getString("cpf"));
				
				clientes.add(m);
				
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar as informações: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
		return clientes;
	
	}
	
	public Cliente read(int Id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cliente m = new Cliente();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente WHERE id=?");
			stmt.setInt(1 , Id);

			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
			
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("Nome"));
				m.setTelefone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setCpf(rs.getString("cpf"));
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar as informações: " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return m;
		
		
	}
	
	public void update(Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE cliente SET nome=?, telefone=?, email=?, cpf=? WHERE id=?");
			
			stmt.setString(1, c.getNome());
			stmt.setString(2,  c.getTelefone());
			stmt.setString(3,  c.getEmail());
			stmt.setString(4,  c.getCpf());
			stmt.setInt(5, c.getId());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Mudanças salvas com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar:" + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}

	public void remove(int clienteId) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM cliente WHERE id=?");
			
			stmt.setInt(1, clienteId);
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar:" + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
