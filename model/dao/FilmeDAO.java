package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Cliente;
import model.bean.Filme;

public class FilmeDAO {
	
	public void create(Filme f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO FILME (titulo, categoria, sinopse, tempo, img3d, dublado) VALUES"
					+ "(?,?,?,?,?,?)");
			stmt.setString(1, f.getTitulo());
			stmt.setString(2, f.getCategoria());
			stmt.setString(3, f.getSinopse());
			stmt.setInt(4, f.getTempo());
			stmt.setBoolean(5, f.isImagem3d());
			stmt.setBoolean(6, f.isDublado());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Filme Salvo com sucesso!");
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Filme> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Filme> movies = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM filme");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Filme m = new Filme();
				m.setIdFilme(rs.getInt("idFilme"));
				m.setTitulo(rs.getString("titulo"));
				m.setTempo(rs.getInt("tempo"));
				m.setDublado(rs.getBoolean("dublado"));
				m.setCategoria(rs.getString("categoria"));
				m.setImagem3d(rs.getBoolean("img3d"));
				m.setSinopse(rs.getString("sinopse"));
				
				movies.add(m);
				
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar as informações: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return movies;
	
	}
	
	public Filme read(int idFilme) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Filme m = new Filme();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM filme WHERE id=? LIMIT 1");
			stmt.setInt(1, idFilme);
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				m.setIdFilme(rs.getInt("idFilme"));
				m.setTitulo(rs.getString("titulo"));
				m.setTempo(rs.getInt("tempo"));
				m.setDublado(rs.getBoolean("dublado"));
				m.setCategoria(rs.getString("categoria"));
				m.setImagem3d(rs.getBoolean("img3d"));
				m.setSinopse(rs.getString("sinopse"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return m;
	}
	
	public void update(Filme f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE movie SET title=?, length=?, dubbed=?, category=?, image3d=?, synopsis=? WHERE id=?");
			
			stmt.setString(1, f.getTitulo());
			stmt.setString(6, f.getSinopse());
			stmt.setInt(2, f.getTempo());
			stmt.setBoolean(5, f.isImagem3d());
			stmt.setBoolean(3, f.isDublado());
			stmt.setString(4, f.getCategoria());
			stmt.setInt(7, f.getIdFilme());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Mudanças salvas com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar:" + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	public void remove(int idFilme) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM filme WHERE idFilme=?");
			
			stmt.setInt(1, idFilme);
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Filme excluído com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar:" + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
