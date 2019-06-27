package View;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import Controller.ControllerCadUser;

import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;

public class TelaCadUser extends JFrame {
	private JPanel contentPane;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JTextField nomeField;
	private JPasswordField confirmPassField;
	private JPasswordField passwordField;
	private JTextField userField;
	private JButton btnLimpar;
	private JFormattedTextField cpfField;
	private JFormattedTextField rgField;
	private JFormattedTextField foneField;

	/**
	 * Create the panel.
	 */
	public TelaCadUser() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 390);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(371, 327, 75, 23);
		contentPane.add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(10, 327, 83, 23);
		contentPane.add(btnRegistrar);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Consolas", Font.PLAIN, 26));
		lblRegistro.setBounds(169, 0, 112, 49);
		contentPane.add(lblRegistro);
		
		JLabel lblUsuario = new JLabel("Nome de Usu\u00E1rio:");
		lblUsuario.setBounds(10, 71, 180, 14);
		contentPane.add(lblUsuario);
		
		userField = new JTextField();
		userField.setBounds(10, 96, 180, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 127, 180, 14);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 152, 180, 20);
		contentPane.add(passwordField);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:");
		lblConfirmarSenha.setBounds(10, 183, 180, 14);
		contentPane.add(lblConfirmarSenha);
		
		confirmPassField = new JPasswordField();
		confirmPassField.setBounds(10, 208, 180, 20);
		contentPane.add(confirmPassField);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(266, 71, 180, 14);
		contentPane.add(lblNome);
		
		nomeField = new JTextField();
		nomeField.setBounds(266, 96, 180, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(266, 127, 180, 14);
		contentPane.add(lblCpf);
		
		JLabel lblRG = new JLabel("RG:");
		lblRG.setBounds(266, 183, 180, 14);
		contentPane.add(lblRG);
		
		JLabel lblSistema = new JLabel("Informa\u00E7\u00F5es cadastrais");
		lblSistema.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSistema.setBounds(10, 46, 146, 14);
		contentPane.add(lblSistema);
		
		JLabel label = new JLabel("Informa\u00E7\u00F5es pessoais");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(266, 46, 146, 14);
		contentPane.add(label);
		
		JLabel lblFone = new JLabel("Telefone:");
		lblFone.setBounds(266, 239, 180, 14);
		contentPane.add(lblFone);
		
		btnLimpar = new JButton("Limpar Campos");
		btnLimpar.setBounds(103, 327, 105, 23);
		contentPane.add(btnLimpar);
		
		cpfField = new JFormattedTextField();
		cpfField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		cpfField.setBounds(266, 152, 178, 20);
		cpfField.setLocale(new Locale("pt", "BR"));
		contentPane.add(cpfField);

		rgField = new JFormattedTextField();
		rgField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		rgField.setBounds(266, 208, 178, 20);
		rgField.setLocale(new Locale("pt", "BR"));
		contentPane.add(rgField);
		
		foneField = new JFormattedTextField();
		foneField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		foneField.setBounds(266, 264, 178, 20);
		foneField.setLocale(new Locale("pt", "BR"));
		contentPane.add(foneField);
		
		Controller.ControllerCadUser cCad = new Controller.ControllerCadUser(this);

		/** NumberFormat formato = NumberFormat.getIntegerInstance();
		* NumberFormatter formatador = new NumberFormatter(formato);
		* formatador.setValueClass(Integer.class);
		* formatador.setMinimum(0);
		* formatador.setMaximum(Integer.MAX_VALUE);
		* formatador.setAllowsInvalid(false);
		* formatador.setCommitsOnValidEdit(true);
		*/
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JFormattedTextField getRgField() {
		return rgField;
	}

	public JFormattedTextField getCpfField() {
		return cpfField;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public JPasswordField getConfirmPassField() {
		return confirmPassField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getUserField() {
		return userField;
	}
	
	public JFormattedTextField getFoneField() {
		return foneField;
	}
	
	public JButton getBtnLimpar() {
		return btnLimpar;
	}
}
