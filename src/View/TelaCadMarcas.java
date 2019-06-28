package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class TelaCadMarcas extends JFrame {

	private JPanel contentPane;
	private JTextField marcasNomeField;
	private JTextField modeloNomeField;
	private JTextField versaoNomeField;
	private JButton btnMarcasRegistrar;
	private JComboBox<Model.Marca> modelosMarcaCBox;
	private JButton btnModelosRegistrar;
	private JComboBox<Model.Marca> versoesMarcaCBox;
	private JComboBox<Model.Modelo> versoesModeloCBox;
	private JButton btnVersoes;
	private JButton btnSair;
	private JButton btnModelos;
	private JButton btnMarcas;
	private CardLayout cl_cardPanels;
	private JPanel cardPanels;
	private JLabel lblCarroceria;
	private JComboBox<String> versoesCarroceriaCBox;
	private JLabel lblClasseDaCarroceria;
	private JComboBox<String> versoesClasseCBox;
	private JButton btnVersoesRegistrar;

	public TelaCadMarcas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{156, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel btnPanel = new JPanel();
		GridBagConstraints gbc_btnPanel = new GridBagConstraints();
		gbc_btnPanel.insets = new Insets(0, 0, 0, 5);
		gbc_btnPanel.fill = GridBagConstraints.BOTH;
		gbc_btnPanel.gridx = 0;
		gbc_btnPanel.gridy = 0;
		contentPane.add(btnPanel, gbc_btnPanel);
		GridBagLayout gbl_btnPanel = new GridBagLayout();
		gbl_btnPanel.columnWidths = new int[]{0, 0};
		gbl_btnPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_btnPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_btnPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		btnPanel.setLayout(gbl_btnPanel);
		
		btnMarcas = new JButton("Registrar Novas Marcas");
		GridBagConstraints gbc_btnMarcas = new GridBagConstraints();
		gbc_btnMarcas.fill = GridBagConstraints.BOTH;
		gbc_btnMarcas.insets = new Insets(0, 0, 5, 0);
		gbc_btnMarcas.gridx = 0;
		gbc_btnMarcas.gridy = 0;
		btnPanel.add(btnMarcas, gbc_btnMarcas);
		
		btnModelos = new JButton("Registrar Novos Modelos");
		btnModelos.setToolTipText("Registrar novos modelos em marcas existentes");
		GridBagConstraints gbc_btnModelos = new GridBagConstraints();
		gbc_btnModelos.fill = GridBagConstraints.BOTH;
		gbc_btnModelos.insets = new Insets(0, 0, 5, 0);
		gbc_btnModelos.gridx = 0;
		gbc_btnModelos.gridy = 1;
		btnPanel.add(btnModelos, gbc_btnModelos);
		
		btnVersoes = new JButton("Registrar Novas Vers\u00F5es");
		btnVersoes.setToolTipText("Registrar nova vers\u00E3o de um modelo existente");
		GridBagConstraints gbc_btnVersoes = new GridBagConstraints();
		gbc_btnVersoes.fill = GridBagConstraints.BOTH;
		gbc_btnVersoes.insets = new Insets(0, 0, 5, 0);
		gbc_btnVersoes.gridx = 0;
		gbc_btnVersoes.gridy = 2;
		btnPanel.add(btnVersoes, gbc_btnVersoes);
		
		btnSair = new JButton("Sair");
		GridBagConstraints gbc_btnSair = new GridBagConstraints();
		gbc_btnSair.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnSair.gridx = 0;
		gbc_btnSair.gridy = 3;
		btnPanel.add(btnSair, gbc_btnSair);
		
		cardPanels = new JPanel();
		GridBagConstraints gbc_cardPanels = new GridBagConstraints();
		gbc_cardPanels.fill = GridBagConstraints.BOTH;
		gbc_cardPanels.gridx = 1;
		gbc_cardPanels.gridy = 0;
		contentPane.add(cardPanels, gbc_cardPanels);
		cl_cardPanels = new CardLayout(0,0);
		cardPanels.setLayout(cl_cardPanels);
		
		JPanel cardPanelMarcas = new JPanel();
		cardPanels.add(cardPanelMarcas, "Marcas");
		GridBagLayout gbl_cardPanelMarcas = new GridBagLayout();
		gbl_cardPanelMarcas.columnWidths = new int[]{0, 0, 0};
		gbl_cardPanelMarcas.rowHeights = new int[]{33, 0, 0};
		gbl_cardPanelMarcas.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_cardPanelMarcas.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		cardPanelMarcas.setLayout(gbl_cardPanelMarcas);
		
		JLabel lblMarcasNome = new JLabel("Nome do Fabricante:");
		GridBagConstraints gbc_lblMarcasNome = new GridBagConstraints();
		gbc_lblMarcasNome.anchor = GridBagConstraints.EAST;
		gbc_lblMarcasNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarcasNome.gridx = 0;
		gbc_lblMarcasNome.gridy = 0;
		cardPanelMarcas.add(lblMarcasNome, gbc_lblMarcasNome);
		
		marcasNomeField = new JTextField();
		GridBagConstraints gbc_marcasNomeField = new GridBagConstraints();
		gbc_marcasNomeField.insets = new Insets(0, 0, 5, 0);
		gbc_marcasNomeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_marcasNomeField.gridx = 1;
		gbc_marcasNomeField.gridy = 0;
		cardPanelMarcas.add(marcasNomeField, gbc_marcasNomeField);
		marcasNomeField.setColumns(10);
		
		btnMarcasRegistrar = new JButton("Registrar");
		GridBagConstraints gbc_btnMarcasRegistrar = new GridBagConstraints();
		gbc_btnMarcasRegistrar.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnMarcasRegistrar.gridx = 1;
		gbc_btnMarcasRegistrar.gridy = 1;
		cardPanelMarcas.add(btnMarcasRegistrar, gbc_btnMarcasRegistrar);
		
		JPanel cardPanelModelos = new JPanel();
		cardPanels.add(cardPanelModelos, "Modelos");
		GridBagLayout gbl_cardPanelModelos = new GridBagLayout();
		gbl_cardPanelModelos.columnWidths = new int[]{0, 0, 0};
		gbl_cardPanelModelos.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_cardPanelModelos.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_cardPanelModelos.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		cardPanelModelos.setLayout(gbl_cardPanelModelos);
		
		JLabel lblModelosMarca = new JLabel("Escolha uma marca:");
		GridBagConstraints gbc_lblModelosMarca = new GridBagConstraints();
		gbc_lblModelosMarca.anchor = GridBagConstraints.EAST;
		gbc_lblModelosMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelosMarca.gridx = 0;
		gbc_lblModelosMarca.gridy = 0;
		cardPanelModelos.add(lblModelosMarca, gbc_lblModelosMarca);
		
		modelosMarcaCBox = new JComboBox<Model.Marca>();
		GridBagConstraints gbc_modelosMarcaCBox = new GridBagConstraints();
		gbc_modelosMarcaCBox.insets = new Insets(0, 0, 5, 0);
		gbc_modelosMarcaCBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_modelosMarcaCBox.gridx = 1;
		gbc_modelosMarcaCBox.gridy = 0;
		cardPanelModelos.add(modelosMarcaCBox, gbc_modelosMarcaCBox);
		
		JLabel lblModelosNome = new JLabel("Nome do Modelo:");
		GridBagConstraints gbc_lblModelosNome = new GridBagConstraints();
		gbc_lblModelosNome.anchor = GridBagConstraints.EAST;
		gbc_lblModelosNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelosNome.gridx = 0;
		gbc_lblModelosNome.gridy = 1;
		cardPanelModelos.add(lblModelosNome, gbc_lblModelosNome);
		
		modeloNomeField = new JTextField();
		GridBagConstraints gbc_modeloNomeField = new GridBagConstraints();
		gbc_modeloNomeField.insets = new Insets(0, 0, 5, 0);
		gbc_modeloNomeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_modeloNomeField.gridx = 1;
		gbc_modeloNomeField.gridy = 1;
		cardPanelModelos.add(modeloNomeField, gbc_modeloNomeField);
		modeloNomeField.setColumns(10);
		
		btnModelosRegistrar = new JButton("Registrar");
		GridBagConstraints gbc_btnModelosRegistrar = new GridBagConstraints();
		gbc_btnModelosRegistrar.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnModelosRegistrar.gridx = 1;
		gbc_btnModelosRegistrar.gridy = 3;
		cardPanelModelos.add(btnModelosRegistrar, gbc_btnModelosRegistrar);
		
		JPanel cardPanelVersoes = new JPanel();
		cardPanels.add(cardPanelVersoes, "Versoes");
		GridBagLayout gbl_cardPanelVersoes = new GridBagLayout();
		gbl_cardPanelVersoes.columnWidths = new int[]{0, 0, 0};
		gbl_cardPanelVersoes.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_cardPanelVersoes.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_cardPanelVersoes.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		cardPanelVersoes.setLayout(gbl_cardPanelVersoes);
		
		JLabel lblVersoesMarca = new JLabel("Escolha uma marca:");
		GridBagConstraints gbc_lblVersoesMarca = new GridBagConstraints();
		gbc_lblVersoesMarca.anchor = GridBagConstraints.EAST;
		gbc_lblVersoesMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblVersoesMarca.gridx = 0;
		gbc_lblVersoesMarca.gridy = 0;
		cardPanelVersoes.add(lblVersoesMarca, gbc_lblVersoesMarca);
		
		versoesMarcaCBox = new JComboBox<Model.Marca>();
		GridBagConstraints gbc_versoesMarcaCBox = new GridBagConstraints();
		gbc_versoesMarcaCBox.insets = new Insets(0, 0, 5, 0);
		gbc_versoesMarcaCBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_versoesMarcaCBox.gridx = 1;
		gbc_versoesMarcaCBox.gridy = 0;
		cardPanelVersoes.add(versoesMarcaCBox, gbc_versoesMarcaCBox);
		
		JLabel lblVersoesModelo = new JLabel("Escolha um modelo:");
		GridBagConstraints gbc_lblVersoesModelo = new GridBagConstraints();
		gbc_lblVersoesModelo.anchor = GridBagConstraints.EAST;
		gbc_lblVersoesModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblVersoesModelo.gridx = 0;
		gbc_lblVersoesModelo.gridy = 1;
		cardPanelVersoes.add(lblVersoesModelo, gbc_lblVersoesModelo);
		
		versoesModeloCBox = new JComboBox<Model.Modelo>();
		GridBagConstraints gbc_versoesModeloCBox = new GridBagConstraints();
		gbc_versoesModeloCBox.insets = new Insets(0, 0, 5, 0);
		gbc_versoesModeloCBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_versoesModeloCBox.gridx = 1;
		gbc_versoesModeloCBox.gridy = 1;
		cardPanelVersoes.add(versoesModeloCBox, gbc_versoesModeloCBox);
		
		JLabel lblVersoesNome = new JLabel("Nome da Vers\u00E3o:");
		GridBagConstraints gbc_lblVersoesNome = new GridBagConstraints();
		gbc_lblVersoesNome.anchor = GridBagConstraints.EAST;
		gbc_lblVersoesNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblVersoesNome.gridx = 0;
		gbc_lblVersoesNome.gridy = 2;
		cardPanelVersoes.add(lblVersoesNome, gbc_lblVersoesNome);
		
		versaoNomeField = new JTextField();
		GridBagConstraints gbc_versaoNomeField = new GridBagConstraints();
		gbc_versaoNomeField.insets = new Insets(0, 0, 5, 0);
		gbc_versaoNomeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_versaoNomeField.gridx = 1;
		gbc_versaoNomeField.gridy = 2;
		cardPanelVersoes.add(versaoNomeField, gbc_versaoNomeField);
		versaoNomeField.setColumns(10);
		
		lblCarroceria = new JLabel("Carroceria:");
		GridBagConstraints gbc_lblCarroceria = new GridBagConstraints();
		gbc_lblCarroceria.anchor = GridBagConstraints.EAST;
		gbc_lblCarroceria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCarroceria.gridx = 0;
		gbc_lblCarroceria.gridy = 3;
		cardPanelVersoes.add(lblCarroceria, gbc_lblCarroceria);
		
		versoesCarroceriaCBox = new JComboBox<String>();
		GridBagConstraints gbc_versoesCarroceriaCBox = new GridBagConstraints();
		gbc_versoesCarroceriaCBox.insets = new Insets(0, 0, 5, 0);
		gbc_versoesCarroceriaCBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_versoesCarroceriaCBox.gridx = 1;
		gbc_versoesCarroceriaCBox.gridy = 3;
		cardPanelVersoes.add(versoesCarroceriaCBox, gbc_versoesCarroceriaCBox);
		
		lblClasseDaCarroceria = new JLabel("Classe da Carroceria:");
		GridBagConstraints gbc_lblClasseDaCarroceria = new GridBagConstraints();
		gbc_lblClasseDaCarroceria.anchor = GridBagConstraints.EAST;
		gbc_lblClasseDaCarroceria.insets = new Insets(0, 0, 5, 5);
		gbc_lblClasseDaCarroceria.gridx = 0;
		gbc_lblClasseDaCarroceria.gridy = 4;
		cardPanelVersoes.add(lblClasseDaCarroceria, gbc_lblClasseDaCarroceria);
		
		versoesClasseCBox = new JComboBox<String>();
		GridBagConstraints gbc_versoesClasseCBox = new GridBagConstraints();
		gbc_versoesClasseCBox.insets = new Insets(0, 0, 5, 0);
		gbc_versoesClasseCBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_versoesClasseCBox.gridx = 1;
		gbc_versoesClasseCBox.gridy = 4;
		cardPanelVersoes.add(versoesClasseCBox, gbc_versoesClasseCBox);
		
		btnVersoesRegistrar = new JButton("Registrar");
		GridBagConstraints gbc_btnVersoesRegistrar = new GridBagConstraints();
		gbc_btnVersoesRegistrar.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnVersoesRegistrar.gridx = 1;
		gbc_btnVersoesRegistrar.gridy = 5;
		cardPanelVersoes.add(btnVersoesRegistrar, gbc_btnVersoesRegistrar);
		
		Controller.ControllerCadMarcas controller = new Controller.ControllerCadMarcas(this);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getMarcasNomeField() {
		return marcasNomeField;
	}

	public JTextField getModeloNomeField() {
		return modeloNomeField;
	}

	public JTextField getVersaoNomeField() {
		return versaoNomeField;
	}

	public JButton getBtnMarcasRegistrar() {
		return btnMarcasRegistrar;
	}

	public JComboBox<Model.Marca> getModelosMarcaCBox() {
		return modelosMarcaCBox;
	}

	public JButton getBtnModelosRegistrar() {
		return btnModelosRegistrar;
	}

	public JComboBox<Model.Marca> getVersoesMarcaCBox() {
		return versoesMarcaCBox;
	}

	public JComboBox<Model.Modelo> getVersoesModeloCBox() {
		return versoesModeloCBox;
	}

	public JButton getBtnVersoesRegistrar() {
		return btnVersoesRegistrar;
	}

	public JButton getBtnVersoes() {
		return btnVersoes;
	}

	public JButton getBtnSair() {
		return btnSair;
	}

	public JButton getBtnModelos() {
		return btnModelos;
	}

	public JButton getBtnMarcas() {
		return btnMarcas;
	}
	
	public CardLayout getCards() {
		return cl_cardPanels;
	}

	public JPanel getCardPanels() {
		return cardPanels;
	}

	public CardLayout getCl_cardPanels() {
		return cl_cardPanels;
	}

	public JLabel getLblCarroceria() {
		return lblCarroceria;
	}

	public JComboBox<String> getVersoesCarroceriaCBox() {
		return versoesCarroceriaCBox;
	}

	public JLabel getLblClasseDaCarroceria() {
		return lblClasseDaCarroceria;
	}

	public JComboBox<String> getVersoesClasseCBox() {
		return versoesClasseCBox;
	}
}
