package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import Model.Marca;
import Model.Modelo;
import Model.Versao;

public class TelaCadProprietario extends JFrame {

	private JPanel contentPane;
	private JTextField fieldNome;
	private JFormattedTextField fieldCpf;
	private JFormattedTextField fieldRg;
	private JFormattedTextField fieldFone;
	private JButton btnRegistrar;
	private JTextField fieldCor;
	private JComboBox<Marca> marcaCBox;
	private JComboBox<Modelo> modeloCBox;
	private JComboBox<Versao> versaoCBox;
	private JFormattedTextField fieldPlaca;

	/**
	 * Create the frame.
	 */
	public TelaCadProprietario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 730, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{33, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblInformaesPessoais = new JLabel("INFORMA\u00C7\u00D5ES PESSOAIS");
		GridBagConstraints gbc_lblInformaesPessoais = new GridBagConstraints();
		gbc_lblInformaesPessoais.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformaesPessoais.gridx = 0;
		gbc_lblInformaesPessoais.gridy = 0;
		contentPane.add(lblInformaesPessoais, gbc_lblInformaesPessoais);
		
		JLabel lblVeculo = new JLabel("VE\u00CDCULO");
		GridBagConstraints gbc_lblVeculo = new GridBagConstraints();
		gbc_lblVeculo.insets = new Insets(0, 0, 5, 0);
		gbc_lblVeculo.gridx = 1;
		gbc_lblVeculo.gridy = 0;
		contentPane.add(lblVeculo, gbc_lblVeculo);
		
		JPanel panelInfoPessoal = new JPanel();
		GridBagConstraints gbc_panelInfoPessoal = new GridBagConstraints();
		gbc_panelInfoPessoal.fill = GridBagConstraints.BOTH;
		gbc_panelInfoPessoal.insets = new Insets(0, 0, 5, 5);
		gbc_panelInfoPessoal.gridx = 0;
		gbc_panelInfoPessoal.gridy = 1;
		contentPane.add(panelInfoPessoal, gbc_panelInfoPessoal);
		GridBagLayout gbl_panelInfoPessoal = new GridBagLayout();
		gbl_panelInfoPessoal.columnWidths = new int[]{78, 142, 0};
		gbl_panelInfoPessoal.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelInfoPessoal.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelInfoPessoal.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelInfoPessoal.setLayout(gbl_panelInfoPessoal);
		
		JLabel lblNome = new JLabel("Nome completo: ");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		panelInfoPessoal.add(lblNome, gbc_lblNome);
		
		fieldNome = new JTextField();
		GridBagConstraints gbc_fieldNome = new GridBagConstraints();
		gbc_fieldNome.fill = GridBagConstraints.BOTH;
		gbc_fieldNome.insets = new Insets(0, 0, 5, 0);
		gbc_fieldNome.gridx = 1;
		gbc_fieldNome.gridy = 0;
		panelInfoPessoal.add(fieldNome, gbc_fieldNome);
		fieldNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.anchor = GridBagConstraints.EAST;
		gbc_lblCpf.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpf.gridx = 0;
		gbc_lblCpf.gridy = 1;
		panelInfoPessoal.add(lblCpf, gbc_lblCpf);
		
		fieldCpf = new JFormattedTextField();
		fieldCpf.setFocusLostBehavior(JFormattedTextField.PERSIST);
		GridBagConstraints gbc_fieldCpf = new GridBagConstraints();
		gbc_fieldCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldCpf.insets = new Insets(0, 0, 5, 0);
		gbc_fieldCpf.gridx = 1;
		gbc_fieldCpf.gridy = 1;
		panelInfoPessoal.add(fieldCpf, gbc_fieldCpf);
		
		JLabel lblRg = new JLabel("RG:");
		GridBagConstraints gbc_lblRg = new GridBagConstraints();
		gbc_lblRg.anchor = GridBagConstraints.EAST;
		gbc_lblRg.insets = new Insets(0, 0, 5, 5);
		gbc_lblRg.gridx = 0;
		gbc_lblRg.gridy = 2;
		panelInfoPessoal.add(lblRg, gbc_lblRg);
		
		fieldRg = new JFormattedTextField();
		fieldRg.setFocusLostBehavior(JFormattedTextField.PERSIST);
		GridBagConstraints gbc_fieldRg = new GridBagConstraints();
		gbc_fieldRg.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldRg.insets = new Insets(0, 0, 5, 0);
		gbc_fieldRg.gridx = 1;
		gbc_fieldRg.gridy = 2;
		panelInfoPessoal.add(fieldRg, gbc_fieldRg);
		
		JLabel lblFone = new JLabel("Telefone:");
		GridBagConstraints gbc_lblFone = new GridBagConstraints();
		gbc_lblFone.anchor = GridBagConstraints.EAST;
		gbc_lblFone.insets = new Insets(0, 0, 5, 5);
		gbc_lblFone.gridx = 0;
		gbc_lblFone.gridy = 3;
		panelInfoPessoal.add(lblFone, gbc_lblFone);
		
		fieldFone = new JFormattedTextField();
		fieldFone.setFocusLostBehavior(JFormattedTextField.PERSIST);
		GridBagConstraints gbc_fieldFone = new GridBagConstraints();
		gbc_fieldFone.insets = new Insets(0, 0, 5, 0);
		gbc_fieldFone.fill = GridBagConstraints.BOTH;
		gbc_fieldFone.gridx = 1;
		gbc_fieldFone.gridy = 3;
		panelInfoPessoal.add(fieldFone, gbc_fieldFone);
		
		JPanel panelInfoVeiculo = new JPanel();
		GridBagConstraints gbc_panelInfoVeiculo = new GridBagConstraints();
		gbc_panelInfoVeiculo.insets = new Insets(0, 0, 5, 0);
		gbc_panelInfoVeiculo.fill = GridBagConstraints.BOTH;
		gbc_panelInfoVeiculo.gridx = 1;
		gbc_panelInfoVeiculo.gridy = 1;
		contentPane.add(panelInfoVeiculo, gbc_panelInfoVeiculo);
		GridBagLayout gbl_panelInfoVeiculo = new GridBagLayout();
		gbl_panelInfoVeiculo.columnWidths = new int[]{0, 0, 0};
		gbl_panelInfoVeiculo.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelInfoVeiculo.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelInfoVeiculo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelInfoVeiculo.setLayout(gbl_panelInfoVeiculo);
		
		JLabel lblMarca = new JLabel("Marca: ");
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.anchor = GridBagConstraints.EAST;
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.gridx = 0;
		gbc_lblMarca.gridy = 0;
		panelInfoVeiculo.add(lblMarca, gbc_lblMarca);
		
		marcaCBox = new JComboBox<Marca>();
		GridBagConstraints gbc_marcaCBox = new GridBagConstraints();
		gbc_marcaCBox.insets = new Insets(0, 0, 5, 0);
		gbc_marcaCBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_marcaCBox.gridx = 1;
		gbc_marcaCBox.gridy = 0;
		panelInfoVeiculo.add(marcaCBox, gbc_marcaCBox);
		
		JLabel lblModelo = new JLabel("Modelo:");
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.anchor = GridBagConstraints.EAST;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 0;
		gbc_lblModelo.gridy = 1;
		panelInfoVeiculo.add(lblModelo, gbc_lblModelo);
		
		modeloCBox = new JComboBox<Modelo>();
		GridBagConstraints gbc_modeloCBox = new GridBagConstraints();
		gbc_modeloCBox.insets = new Insets(0, 0, 5, 0);
		gbc_modeloCBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_modeloCBox.gridx = 1;
		gbc_modeloCBox.gridy = 1;
		panelInfoVeiculo.add(modeloCBox, gbc_modeloCBox);
		
		JLabel lblVersao = new JLabel("Vers\u00E3o:");
		GridBagConstraints gbc_lblVersao = new GridBagConstraints();
		gbc_lblVersao.anchor = GridBagConstraints.EAST;
		gbc_lblVersao.insets = new Insets(0, 0, 5, 5);
		gbc_lblVersao.gridx = 0;
		gbc_lblVersao.gridy = 2;
		panelInfoVeiculo.add(lblVersao, gbc_lblVersao);
		
		versaoCBox = new JComboBox<Versao>();
		GridBagConstraints gbc_versaoCBox = new GridBagConstraints();
		gbc_versaoCBox.insets = new Insets(0, 0, 5, 0);
		gbc_versaoCBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_versaoCBox.gridx = 1;
		gbc_versaoCBox.gridy = 2;
		panelInfoVeiculo.add(versaoCBox, gbc_versaoCBox);
		
		JLabel lblPlaca = new JLabel("Placa: ");
		GridBagConstraints gbc_lblPlaca = new GridBagConstraints();
		gbc_lblPlaca.anchor = GridBagConstraints.EAST;
		gbc_lblPlaca.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlaca.gridx = 0;
		gbc_lblPlaca.gridy = 3;
		panelInfoVeiculo.add(lblPlaca, gbc_lblPlaca);
		
		fieldPlaca = new JFormattedTextField();
		fieldPlaca.setFocusLostBehavior(JFormattedTextField.PERSIST);
		GridBagConstraints gbc_fieldPlaca = new GridBagConstraints();
		gbc_fieldPlaca.insets = new Insets(0, 0, 5, 0);
		gbc_fieldPlaca.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldPlaca.gridx = 1;
		gbc_fieldPlaca.gridy = 3;
		panelInfoVeiculo.add(fieldPlaca, gbc_fieldPlaca);
		
		JLabel lblCor = new JLabel("Cor:");
		GridBagConstraints gbc_lblCor = new GridBagConstraints();
		gbc_lblCor.anchor = GridBagConstraints.EAST;
		gbc_lblCor.insets = new Insets(0, 0, 0, 5);
		gbc_lblCor.gridx = 0;
		gbc_lblCor.gridy = 4;
		panelInfoVeiculo.add(lblCor, gbc_lblCor);
		
		fieldCor = new JTextField();
		fieldCor.setColumns(10);
		GridBagConstraints gbc_fieldCor = new GridBagConstraints();
		gbc_fieldCor.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldCor.gridx = 1;
		gbc_fieldCor.gridy = 4;
		panelInfoVeiculo.add(fieldCor, gbc_fieldCor);
		
		btnRegistrar = new JButton("Registrar");
		GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
		gbc_btnRegistrar.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnRegistrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistrar.gridx = 0;
		gbc_btnRegistrar.gridy = 2;
		contentPane.add(btnRegistrar, gbc_btnRegistrar);
		
		Controller.ControllerCadProprietario controller = new Controller.ControllerCadProprietario(this);
	}

	//Getters
	public JTextField getFieldNome() {
		return fieldNome;
	}

	public JTextField getFieldCor() {
		return fieldCor;
	}

	public JFormattedTextField getFieldCpf() {
		return fieldCpf;
	}

	public JFormattedTextField getFieldRg() {
		return fieldRg;
	}

	public JFormattedTextField getFieldFone() {
		return fieldFone;
	}

	public JComboBox<Model.Marca> getMarcaCBox() {
		return marcaCBox;
	}

	public JComboBox<Model.Modelo> getModeloCBox() {
		return modeloCBox;
	}

	public JComboBox<Model.Versao> getVersaoCBox() {
		return versaoCBox;
	}

	public JFormattedTextField getFieldPlaca() {
		return fieldPlaca;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
}
