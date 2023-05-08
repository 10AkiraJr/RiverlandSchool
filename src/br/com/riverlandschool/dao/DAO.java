package br.com.riverlandschool.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.riverland.model.Usuario;

public class DAO {

	
	public static void cadastrarAluno(Usuario usuario)throws SQLException {
		int response = JOptionPane.showConfirmDialog(null, "Deseja Realmente Cadastrar o Registro?", "Confirmar",JOptionPane.YES_NO_OPTION);
		
		
		if (response == JOptionPane.NO_OPTION) {
			JOptionPane.getDefaultLocale();
		} else if (response == JOptionPane.YES_OPTION) {
		
	    Connection conn = null;
	    try {
	    	conn = DriverManager.getConnection("jdbc:sqlite:src/br/com/riverlandschool/dao/Riverland.db");
	    	conn.setAutoCommit(false);
	    	String sql = "INSERT INTO USUARIOS (NOME, EMAIL, SENHA, TIPO_USUARIO, RA) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, usuario.getNome());
	        stmt.setString(2, usuario.getEmail());
	        stmt.setString(3, usuario.getSenha());
	        stmt.setString(4, usuario.getTipoUsuario());
	        stmt.setString(5, usuario.getRa());
			stmt.execute();
	    } catch (SQLException ex) {
	        throw new RuntimeException("Erro ao inserir aluno no banco de dados", ex);
	    } 
	}
	
}
}

