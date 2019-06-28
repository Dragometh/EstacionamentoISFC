package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class TelaCadProprietario extends JFrame {

	private JPanel contentPane;
	private JTextField fieldNome;
	private JTextField fieldCor;
	private JTable veicTable;
	private JFormattedTextField fieldCpf;
	private JFormattedTextField fieldRg;
	private JFormattedTextField fieldFone;
	private JRadioButton rdbtnNovoVeiculo;
	private JRadioButton rdbtnVeiculoExistente;
	private JComboBox<Model.Marca> marcaCBox;
	private JComboBox<Model.Modelo> modeloCBox;
	private JComboBox<Model.Versao> versaoCBox;
	private JFormattedTextField fieldPlaca;
	private JButton btnRegistrar;
	private JButton btnSair;
	private JPanel panelCards;
	private CardLayout cLayout;

	/**
	 * Create the frame.
	 */
	public TelaCadProprietario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{33, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel label = new JLabel("INFORMAÇÕES PESSOAIS");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		contentPane.add(label, gbc_label);
		
		JLabel lblVeculo = new JLabel("VEÍCULO");
		GridBagConstraints gbc_lblVeculo = new GridBagConstraints();
		gbc_lblVeculo.insets = new Insets(0, 0, 5, 0);
		gbc_lblVeculo.gridx = 1;
		gbc_lblVeculo.gridy = 0;
		contentPane.add(lblVeculo, gbc_lblVeculo);
		
		JPanel panelInfoPessoal = new JPanel();
		GridBagConstraints gbc_panelInfoPessoal = new GridBagConstraints();
		gbc_panelInfoPessoal.anchor = GridBagConstraints.WEST;
		gbc_panelInfoPessoal.fill = GridBagConstraints.VERTICAL;
		gbc_panelInfoPessoal.insets = new Insets(0, 0, 5, 5);
		gbc_panelInfoPessoal.gridx = 0;
		gbc_panelInfoPessoal.gridy = 1;
		contentPane.add(panelInfoPessoal, gbc_panelInfoPessoal);
		GridBagLayout gbl_panelInfoPessoal = new GridBagLayout();
		gbl_panelInfoPessoal.columnWidths = new int[]{121, 142, 0};
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
		gbl_panelInfoVeiculo.rowHeights = new int[]{0, 0, 0};
		gbl_panelInfoVeiculo.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelInfoVeiculo.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelInfoVeiculo.setLayout(gbl_panelInfoVeiculo);
		
		rdbtnNovoVeiculo = new JRadioButton("Novo Veículo");
		GridBagConstraints gbc_rdbtnNovoVeculo = new GridBagConstraints();
		gbc_rdbtnNovoVeculo.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNovoVeculo.gridx = 0;
		gbc_rdbtnNovoVeculo.gridy = 0;
		panelInfoVeiculo.add(rdbtnNovoVeiculo, gbc_rdbtnNovoVeculo);
		
		rdbtnVeiculoExistente = new JRadioButton("Veículo Existente");
		GridBagConstraints gbc_rdbtnVeculoExistente = new GridBagConstraints();
		gbc_rdbtnVeculoExistente.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnVeculoExistente.gridx = 1;
		gbc_rdbtnVeculoExistente.gridy = 0;
		panelInfoVeiculo.add(rdbtnVeiculoExistente, gbc_rdbtnVeculoExistente);
		
		panelCards = new JPanel();
		GridBagConstraints gbc_panelCards = new GridBagConstraints();
		gbc_panelCards.gridwidth = 2;
		gbc_panelCards.insets = new Insets(0, 0, 0, 5);
		gbc_panelCards.fill = GridBagConstraints.BOTH;
		gbc_panelCards.gridx = 0;
		gbc_panelCards.gridy = 1;
		panelInfoVeiculo.add(panelCards, gbc_panelCards);
		cLayout = new CardLayout(0, 0);
		panelCards.setLayout(cLayout);
		
		JPanel panelVeicNovo = new JPanel();
		panelCards.add(panelVeicNovo, "Novos");
		GridBagLayout gbl_panelVeicNovo = new GridBagLayout();
		gbl_panelVeicNovo.columnWidths = new int[]{0, 0, 0};
		gbl_panelVeicNovo.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelVeicNovo.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelVeicNovo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelVeicNovo.setLayout(gbl_panelVeicNovo);
		
		JLabel lblMarca = new JLabel("Marca: ");
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.anchor = GridBagConstraints.EAST;
		gbc_lblMarca.gridx = 0;
		gbc_lblMarca.gridy = 0;
		panelVeicNovo.add(lblMarca, gbc_lblMarca);
		
		marcaCBox = new JComboBox<Model.Marca>();
		GridBagConstraints gbc_marcaCBox = new GridBagConstraints();
		gbc_marcaCBox.insets = new Insets(0, 0, 5, 0);
		gbc_marcaCBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_marcaCBox.gridx = 1;
		gbc_marcaCBox.gridy = 0;
		panelVeicNovo.add(marcaCBox, gbc_marcaCBox);
		
		JLabel lblModelo = new JLabel("Modelo:");
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.anchor = GridBagConstraints.EAST;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 0;
		gbc_lblModelo.gridy = 1;
		panelVeicNovo.add(lblModelo, gbc_lblModelo);
		
		modeloCBox = new JComboBox<Model.Modelo>();
		GridBagConstraints gbc_modeloCBox = new GridBagConstraints();
		gbc_modeloCBox.insets = new Insets(0, 0, 5, 0);
		gbc_modeloCBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_modeloCBox.gridx = 1;
		gbc_modeloCBox.gridy = 1;
		panelVeicNovo.add(modeloCBox, gbc_modeloCBox);
		
		JLabel lblVerso = new JLabel("Versão: ");
		GridBagConstraints gbc_lblVerso = new GridBagConstraints();
		gbc_lblVerso.anchor = GridBagConstraints.EAST;
		gbc_lblVerso.insets = new Insets(0, 0, 5, 5);
		gbc_lblVerso.gridx = 0;
		gbc_lblVerso.gridy = 2;
		panelVeicNovo.add(lblVerso, gbc_lblVerso);
		
		versaoCBox = new JComboBox<Model.Versao>();
		GridBagConstraints gbc_versaoCBox = new GridBagConstraints();
		gbc_versaoCBox.insets = new Insets(0, 0, 5, 0);
		gbc_versaoCBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_versaoCBox.gridx = 1;
		gbc_versaoCBox.gridy = 2;
		panelVeicNovo.add(versaoCBox, gbc_versaoCBox);
		
		JLabel lblPlaca = new JLabel("Placa: ");
		GridBagConstraints gbc_lblPlaca = new GridBagConstraints();
		gbc_lblPlaca.anchor = GridBagConstraints.EAST;
		gbc_lblPlaca.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlaca.gridx = 0;
		gbc_lblPlaca.gridy = 3;
		panelVeicNovo.add(lblPlaca, gbc_lblPlaca);
		
		fieldPlaca = new JFormattedTextField();
		GridBagConstraints gbc_fieldPlaca = new GridBagConstraints();
		gbc_fieldPlaca.insets = new Insets(0, 0, 5, 0);
		gbc_fieldPlaca.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldPlaca.gridx = 1;
		gbc_fieldPlaca.gridy = 3;
		panelVeicNovo.add(fieldPlaca, gbc_fieldPlaca);
		
		JLabel lblCor = new JLabel("Cor:");
		GridBagConstraints gbc_lblCor = new GridBagConstraints();
		gbc_lblCor.anchor = GridBagConstraints.EAST;
		gbc_lblCor.insets = new Insets(0, 0, 0, 5);
		gbc_lblCor.gridx = 0;
		gbc_lblCor.gridy = 4;
		panelVeicNovo.add(lblCor, gbc_lblCor);
		
		fieldCor = new JTextField();
		GridBagConstraints gbc_fieldCor = new GridBagConstraints();
		gbc_fieldCor.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldCor.gridx = 1;
		gbc_fieldCor.gridy = 4;
		panelVeicNovo.add(fieldCor, gbc_fieldCor);
		fieldCor.setColumns(10);
		
		JPanel panelVeicExistentes = new JPanel();
		panelCards.add(panelVeicExistentes, "Existentes");
		GridBagLayout gbl_panelVeicExistentes = new GridBagLayout();
		gbl_panelVeicExistentes.columnWidths = new int[]{0, 0};
		gbl_panelVeicExistentes.rowHeights = new int[]{0, 0};
		gbl_panelVeicExistentes.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelVeicExistentes.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelVeicExistentes.setLayout(gbl_panelVeicExistentes);
		
		veicTable = new JTable();
		veicTable.setShowVerticalLines(false);
		veicTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints gbc_veicTable = new GridBagConstraints();
		gbc_veicTable.fill = GridBagConstraints.BOTH;
		gbc_veicTable.gridx = 0;
		gbc_veicTable.gridy = 0;
		panelVeicExistentes.add(veicTable, gbc_veicTable);
		
		btnRegistrar = new JButton("Registrar");
		GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
		gbc_btnRegistrar.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnRegistrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistrar.gridx = 0;
		gbc_btnRegistrar.gridy = 2;
		contentPane.add(btnRegistrar, gbc_btnRegistrar);
		
		btnSair = new JButton("Sair");
		GridBagConstraints gbc_btnSair = new GridBagConstraints();
		gbc_btnSair.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnSair.gridx = 1;
		gbc_btnSair.gridy = 2;
		contentPane.add(btnSair, gbc_btnSair);
		
		Controller.ControllerCadProprietario controller = new Controller.ControllerCadProprietario(this);
	}

	//Getters
	public JTextField getFieldNome() {
		return fieldNome;
	}

	public JTextField getFieldCor() {
		return fieldCor;
	}

	public JTable getVeicTable() {
		return veicTable;
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

	public JRadioButton getRdbtnNovoVeiculo() {
		return rdbtnNovoVeiculo;
	}

	public JRadioButton getRdbtnVeiculoExistente() {
		return rdbtnVeiculoExistente;
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

	public JButton getBtnSair() {
		return btnSair;
	}
	
	public JPanel getPanelCards() {
		return panelCards;
	}
	
	public CardLayout getCardLayout() {
		return cLayout;
	}
}
