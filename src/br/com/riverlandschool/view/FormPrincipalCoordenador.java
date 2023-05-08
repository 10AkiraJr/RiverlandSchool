package br.com.riverlandschool.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class FormPrincipalCoordenador extends JFrame {

	private JPanel contentPane;
	private JTextField txtTeste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrincipalCoordenador frame = new FormPrincipalCoordenador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormPrincipalCoordenador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Título da tela
		JLabel lblTitulo = new JLabel("Bem-vindo(a), Coordenador(a)!");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(65, 71, 317, 30);
		contentPane.add(lblTitulo);

		// Botão de Cadastro de Aluno
		JButton btnCadastroAluno = new JButton("Cadastro de Aluno");
		btnCadastroAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastroAluno.setBounds(65, 130, 150, 30);
		contentPane.add(btnCadastroAluno);

		// Botão de Cadastro de Professor
		JButton btnCadastroProfessor = new JButton("Cadastro de Professor");
		btnCadastroProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastroProfessor.setBounds(225, 130, 170, 30);
		contentPane.add(btnCadastroProfessor);
		
		// Ação do botão Cadastro de Aluno
		btnCadastroAluno.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				FormCadastroAluno formCadastroAluno = new FormCadastroAluno();
				formCadastroAluno.setVisible(true);
			}
		});
		
		// Ação do botão Cadastro de Professor
		btnCadastroProfessor.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				FormCadastroProfessor formCadastroProfessor = new FormCadastroProfessor();
				formCadastroProfessor.setVisible(true);
			}
		});
	}
}
