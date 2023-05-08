package br.com.riverland.model;

import java.sql.SQLException;

import br.com.riverlandschool.dao.DAO;
import br.com.riverlandschool.view.FormCadastroAluno;

public class Usuario {
	
    private static String nome = "";
    private static String email = "";
    private static String senha = "";
    private static String tipoUsuario = "";
    private static String ra = "";
    private static String cpf = "";
    
    public Usuario() {}
    
	public Usuario(String nome, String email, String senha, String tipoUsuario, String ra, String cpf) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
		this.ra = ra;
		this.cpf = cpf;
	}

	
	public static void cadastrarAluno() {
		Usuario usuario = new Usuario(nome, email, senha, tipoUsuario, ra, cpf);
		usuario.setNome(FormCadastroAluno.txtNome.getText());
		usuario.setEmail(FormCadastroAluno.txtEmail.getText());
		usuario.setSenha(FormCadastroAluno.txtSenha.getText());
		usuario.setTipoUsuario(FormCadastroAluno.txtTipoUsuario.getText());
		usuario.setRa(FormCadastroAluno.txtRa.getText());
		usuario.setCpf(null);
		try {
			DAO.cadastrarAluno(usuario);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}


	public static String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public static String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public static String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public static String getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public static String getRa() {
		return ra;
	}


	public void setRa(String ra) {
		this.ra = ra;
	}


	public static String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

    
    
    
}
