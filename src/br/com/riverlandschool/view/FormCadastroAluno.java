package br.com.riverlandschool.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.riverland.model.Usuario;
import br.com.riverlandschool.dao.DAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

public class FormCadastroAluno extends JFrame {

	private JPanel contentPane;
	public static JTextField txtNome;
	public static JTextField txtEmail;
	public static JTextField txtSenha;
	public static JTextField txtTipoUsuario;
	public static JTextField txtRa;

	/**
	 * Create the frame.
	 */
	public FormCadastroAluno() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 36, 200, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 67, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(10, 92, 200, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 123, 46, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(10, 148, 200, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		
		JLabel lblTipoUsuario = new JLabel("Tipo de usuário:");
		lblTipoUsuario.setBounds(243, 11, 110, 14);
		contentPane.add(lblTipoUsuario);
		
		txtTipoUsuario = new JTextField();
		txtTipoUsuario.setBounds(243, 36, 166, 20);
		contentPane.add(txtTipoUsuario);
		txtTipoUsuario.setColumns(10);
		
		
//		JComboBox comboBoxTipoUsuario = new JComboBox();
//		comboBoxTipoUsuario.setBounds(243, 36, 166, 20);
//		comboBoxTipoUsuario.addItem("Aluno");
//		comboBoxTipoUsuario.addItem("Professor");
//		comboBoxTipoUsuario.addItem("Coordenador");
//		contentPane.add(comboBoxTipoUsuario);
		
		JLabel lblRa = new JLabel("RA:");
		lblRa.setBounds(243, 67, 46, 14);
		contentPane.add(lblRa);
		
		txtRa = new JTextField();
		txtRa.setBounds(243, 92, 166, 20);
		contentPane.add(txtRa);
		txtRa.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(335, 227, 89, 23);
		contentPane.add(btnSalvar);
		DAO dao = new DAO();
		btnSalvar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Usuario.cadastrarAluno(); 
		    	txtNome.setText("");
		    	txtEmail.setText("");
		    	txtSenha.setText("");
		    	txtTipoUsuario.setText("");
		    	txtRa.setText("");
//		    	String nome = txtNome.getText();
//		        String email = txtEmail.getText();
//		        String senha = txtSenha.getText();
//		        String tipoUsuario = comboBoxTipoUsuario.getSelectedItem().toString();
//		        String ra = txtRa.getText();
//
//		        // Cria um novo objeto Aluno com os dados do formulário
//		        Usuario usuario = new Usuario(nome, email, senha, tipoUsuario, ra, null);
//
//		        // Salva o objeto Aluno usando a classe DAO
//		        try {
//					dao.cadastrarAluno(usuario);
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//
//		        // Fecha a janela de cadastro após salvar o aluno
//		        dispose();
		    }
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(236, 227, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        txtNome.setText("");
		        txtEmail.setText("");
		        txtSenha.setText("");
		        txtTipoUsuario.setText("");
		        txtRa.setText("");
		    }
		});
	}
}
