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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{83, 53, 39, 58, 15, 90, 75, 0};
		gbl_contentPane.rowHeights = new int[]{31, 14, 20, 14, 20, 14, 20, 14, 20, 43, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblSistema = new JLabel("INFORMAÇÕES CADASTRAIS");
		lblSistema.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblSistema = new GridBagConstraints();
		gbc_lblSistema.anchor = GridBagConstraints.SOUTH;
		gbc_lblSistema.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSistema.insets = new Insets(0, 0, 5, 5);
		gbc_lblSistema.gridwidth = 2;
		gbc_lblSistema.gridx = 0;
		gbc_lblSistema.gridy = 0;
		contentPane.add(lblSistema, gbc_lblSistema);
		
		JLabel lblInformaesPessoais = new JLabel("INFORMAÇÕES PESSOAIS");
		lblInformaesPessoais.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblInformaesPessoais = new GridBagConstraints();
		gbc_lblInformaesPessoais.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblInformaesPessoais.insets = new Insets(0, 0, 5, 0);
		gbc_lblInformaesPessoais.gridwidth = 3;
		gbc_lblInformaesPessoais.gridx = 4;
		gbc_lblInformaesPessoais.gridy = 0;
		contentPane.add(lblInformaesPessoais, gbc_lblInformaesPessoais);
		
		JLabel lblUsuario = new JLabel("Nome de Usu\u00E1rio:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridwidth = 3;
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 1;
		contentPane.add(lblUsuario, gbc_lblUsuario);
		
		JLabel lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNome.insets = new Insets(0, 0, 5, 0);
		gbc_lblNome.gridwidth = 3;
		gbc_lblNome.gridx = 4;
		gbc_lblNome.gridy = 1;
		contentPane.add(lblNome, gbc_lblNome);
		
		userField = new JTextField();
		GridBagConstraints gbc_userField = new GridBagConstraints();
		gbc_userField.fill = GridBagConstraints.BOTH;
		gbc_userField.insets = new Insets(0, 0, 5, 5);
		gbc_userField.gridwidth = 3;
		gbc_userField.gridx = 0;
		gbc_userField.gridy = 2;
		contentPane.add(userField, gbc_userField);
		userField.setColumns(10);
		
		nomeField = new JTextField();
		GridBagConstraints gbc_nomeField = new GridBagConstraints();
		gbc_nomeField.fill = GridBagConstraints.BOTH;
		gbc_nomeField.insets = new Insets(0, 0, 5, 0);
		gbc_nomeField.gridwidth = 3;
		gbc_nomeField.gridx = 4;
		gbc_nomeField.gridy = 2;
		contentPane.add(nomeField, gbc_nomeField);
		nomeField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridwidth = 3;
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 3;
		contentPane.add(lblSenha, gbc_lblSenha);
		
		JLabel lblCpf = new JLabel("CPF:");
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCpf.insets = new Insets(0, 0, 5, 0);
		gbc_lblCpf.gridwidth = 3;
		gbc_lblCpf.gridx = 4;
		gbc_lblCpf.gridy = 3;
		contentPane.add(lblCpf, gbc_lblCpf);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridwidth = 3;
		gbc_passwordField.gridx = 0;
		gbc_passwordField.gridy = 4;
		contentPane.add(passwordField, gbc_passwordField);
		
		cpfField = new JFormattedTextField();
		cpfField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		cpfField.setLocale(new Locale("pt", "BR"));
		GridBagConstraints gbc_cpfField = new GridBagConstraints();
		gbc_cpfField.fill = GridBagConstraints.BOTH;
		gbc_cpfField.insets = new Insets(0, 0, 5, 0);
		gbc_cpfField.gridwidth = 3;
		gbc_cpfField.gridx = 4;
		gbc_cpfField.gridy = 4;
		contentPane.add(cpfField, gbc_cpfField);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:");
		GridBagConstraints gbc_lblConfirmarSenha = new GridBagConstraints();
		gbc_lblConfirmarSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblConfirmarSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmarSenha.gridwidth = 3;
		gbc_lblConfirmarSenha.gridx = 0;
		gbc_lblConfirmarSenha.gridy = 5;
		contentPane.add(lblConfirmarSenha, gbc_lblConfirmarSenha);
		
		JLabel lblRG = new JLabel("RG:");
		GridBagConstraints gbc_lblRG = new GridBagConstraints();
		gbc_lblRG.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRG.insets = new Insets(0, 0, 5, 0);
		gbc_lblRG.gridwidth = 3;
		gbc_lblRG.gridx = 4;
		gbc_lblRG.gridy = 5;
		contentPane.add(lblRG, gbc_lblRG);
		
		confirmPassField = new JPasswordField();
		GridBagConstraints gbc_confirmPassField = new GridBagConstraints();
		gbc_confirmPassField.fill = GridBagConstraints.BOTH;
		gbc_confirmPassField.insets = new Insets(0, 0, 5, 5);
		gbc_confirmPassField.gridwidth = 3;
		gbc_confirmPassField.gridx = 0;
		gbc_confirmPassField.gridy = 6;
		contentPane.add(confirmPassField, gbc_confirmPassField);
		
				rgField = new JFormattedTextField();
				rgField.setFocusLostBehavior(JFormattedTextField.COMMIT);
				rgField.setLocale(new Locale("pt", "BR"));
				GridBagConstraints gbc_rgField = new GridBagConstraints();
				gbc_rgField.fill = GridBagConstraints.BOTH;
				gbc_rgField.insets = new Insets(0, 0, 5, 0);
				gbc_rgField.gridwidth = 3;
				gbc_rgField.gridx = 4;
				gbc_rgField.gridy = 6;
				contentPane.add(rgField, gbc_rgField);
		
		JLabel lblFone = new JLabel("Telefone:");
		GridBagConstraints gbc_lblFone = new GridBagConstraints();
		gbc_lblFone.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFone.insets = new Insets(0, 0, 5, 0);
		gbc_lblFone.gridwidth = 3;
		gbc_lblFone.gridx = 4;
		gbc_lblFone.gridy = 7;
		contentPane.add(lblFone, gbc_lblFone);
		
		foneField = new JFormattedTextField();
		foneField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		foneField.setLocale(new Locale("pt", "BR"));
		GridBagConstraints gbc_foneField = new GridBagConstraints();
		gbc_foneField.fill = GridBagConstraints.BOTH;
		gbc_foneField.insets = new Insets(0, 0, 5, 0);
		gbc_foneField.gridwidth = 3;
		gbc_foneField.gridx = 4;
		gbc_foneField.gridy = 8;
		contentPane.add(foneField, gbc_foneField);
		
		btnRegistrar = new JButton("Registrar");
		GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
		gbc_btnRegistrar.fill = GridBagConstraints.BOTH;
		gbc_btnRegistrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistrar.gridx = 0;
		gbc_btnRegistrar.gridy = 10;
		contentPane.add(btnRegistrar, gbc_btnRegistrar);
		
		btnLimpar = new JButton("Limpar Campos");
		GridBagConstraints gbc_btnLimpar = new GridBagConstraints();
		gbc_btnLimpar.fill = GridBagConstraints.BOTH;
		gbc_btnLimpar.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimpar.gridwidth = 2;
		gbc_btnLimpar.gridx = 1;
		gbc_btnLimpar.gridy = 10;
		contentPane.add(btnLimpar, gbc_btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.gridx = 6;
		gbc_btnCancelar.gridy = 10;
		contentPane.add(btnCancelar, gbc_btnCancelar);
		
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
