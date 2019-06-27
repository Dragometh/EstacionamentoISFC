package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerLogin;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaLogin extends JFrame {
	// Atributos
	private JPanel contentPane;
	private JButton btnConfirm;
	private JLabel lblLogin;
	private JTextField userField;
	private JPasswordField passwordField;
	
	// Construtor - Cria a Tela
	public TelaLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConfirm = new JButton("Confirmar");
		btnConfirm.setBounds(95, 196, 89, 23);
		contentPane.add(btnConfirm);
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Consolas", Font.PLAIN, 26));
		lblLogin.setBounds(56, 11, 78, 49);
		contentPane.add(lblLogin);
		
		JLabel lblUser = new JLabel("Usu\u00E1rio:");
		lblUser.setBounds(10, 71, 57, 14);
		contentPane.add(lblUser);
		
		userField = new JTextField();
		userField.setBounds(10, 96, 174, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 127, 57, 14);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 152, 174, 20);
		contentPane.add(passwordField);
		
		Controller.ControllerLogin cLogin = new Controller.ControllerLogin(this);
	}
	// Getters
	
	public JButton getBtnConfirm() {
		return this.btnConfirm;
	}
	
	public JTextField getUserField() {
		return this.userField;
	}
	
	public JPasswordField getPasswordField() {
		return this.passwordField;
	}
}
