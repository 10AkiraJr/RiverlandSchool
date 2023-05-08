package br.com.riverlandschool.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FormLoginEscola {

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	FormLoginEscola window = new FormLoginEscola();
                    window.frame.setLocationRelativeTo(null);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public FormLoginEscola() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
    	    	
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Username:");
        lblNewLabel.setBounds(65, 69, 70, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Password:");
        lblNewLabel_1.setBounds(65, 118, 70, 14);
        frame.getContentPane().add(lblNewLabel_1);

        usernameField = new JTextField();
        usernameField.setBounds(145, 66, 200, 20);
        frame.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(145, 115, 200, 20);
        frame.getContentPane().add(passwordField);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = usernameField.getText();
                String senha = new String(passwordField.getPassword());

                if (isValidUser(email, senha)) {
                    if (isUserCoordenador(email)) {

                    	FormPrincipalCoordenador principal = new FormPrincipalCoordenador();
            			principal.setVisible(true);
                        System.out.println("Redirecionando para a tela de coordenação");
                    } 
                    else if (isUserProfessor(email)) {

                    	FormPrincipalProfessor principal = new FormPrincipalProfessor();
            			principal.setVisible(true);
                        System.out.println("Redirecionando para a tela de Professor");
                    } 
                    else if (isUserAluno(email)) {

                    	FormPrincipalAluno principal = new FormPrincipalAluno();
            			principal.setVisible(true);
                        System.out.println("Redirecionando para a tela de aluno");
                    }
                } else {
                    System.out.println("Usuário e/ou senha inválidos");
                }
            }
        });
        btnNewButton.setBounds(145, 171, 89, 23);
        frame.getContentPane().add(btnNewButton);
    }
    
    private boolean isValidUser(String email, String senha) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean isValid = false;
        try {
            // Abrir conexão com o banco de dados
            conn = DriverManager.getConnection("jdbc:sqlite:src/br/com/riverlandschool/dao/Riverland.db");

            // Preparar consulta SQL
            String sql = "SELECT COUNT(*) FROM USUARIOS WHERE EMAIL = ? AND SENHA = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            // Executar consulta SQL e obter resultado
            rs = stmt.executeQuery();
            int count = rs.getInt(1);

            // Verificar se há exatamente um usuário com as credenciais fornecidas
            isValid = (count == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if (!isValid) {
            JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos", "Erro de autenticação", JOptionPane.ERROR_MESSAGE);
        }
        return isValid;
    }

    
    private boolean isUserCoordenador(String email) {
        boolean isCoordenador = false;
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:src/br/com/riverlandschool/dao/Riverland.db");
            String sql = "SELECT TIPO_USUARIO FROM USUARIOS WHERE EMAIL = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String tipoUsuario = rs.getString("TIPO_USUARIO");
                isCoordenador = tipoUsuario.equalsIgnoreCase("Coordenador");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCoordenador;
    }
    
    
    private boolean isUserProfessor(String email) {
        boolean isCoordenador = false;
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:src/br/com/riverlandschool/dao/Riverland.db");
            String sql = "SELECT TIPO_USUARIO FROM USUARIOS WHERE EMAIL = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String tipoUsuario = rs.getString("TIPO_USUARIO");
                isCoordenador = tipoUsuario.equalsIgnoreCase("Professor");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCoordenador;
    }
    
    
    private boolean isUserAluno(String email) {
        boolean isCoordenador = false;
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:src/br/com/riverlandschool/dao/Riverland.db");
            String sql = "SELECT TIPO_USUARIO FROM USUARIOS WHERE EMAIL = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String tipoUsuario = rs.getString("TIPO_USUARIO");
                isCoordenador = tipoUsuario.equalsIgnoreCase("Aluno");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCoordenador;
    }
    
    



    
}
