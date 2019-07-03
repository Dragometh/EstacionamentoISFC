package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class TelaVerModel extends JFrame {

	private JPanel contentPane;
	private JButton btnVerDadosVersao;
	private JLabel lblVersaoStr;
	private JButton btnVerDadosModelo;
	private JLabel lblModeloStr;
	private JButton btnVerDadosMarca;
	private JLabel lblMarcaStr;
	private JLabel lblCorStr;
	private JLabel lblPlacaStr;
	private JButton btnVerDadosDono;
	private JLabel lblDonoStr;
	private JLabel lblIdValue;
	private JTable tableCarro;
	private CardLayout cardLayout;

	public TelaVerModel(String card) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 762, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		JPanel carroCardPanel = new JPanel();
		contentPane.add(carroCardPanel, "VerCarro");
		GridBagLayout gbl_carroCardPanel = new GridBagLayout();
		gbl_carroCardPanel.columnWidths = new int[]{507, 0, 0};
		gbl_carroCardPanel.rowHeights = new int[]{0, 0};
		gbl_carroCardPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_carroCardPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		carroCardPanel.setLayout(gbl_carroCardPanel);
		
		JPanel infoPanel = new JPanel();
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.insets = new Insets(0, 0, 0, 5);
		gbc_infoPanel.fill = GridBagConstraints.BOTH;
		gbc_infoPanel.gridx = 0;
		gbc_infoPanel.gridy = 0;
		carroCardPanel.add(infoPanel, gbc_infoPanel);
		GridBagLayout gbl_infoPanel = new GridBagLayout();
		gbl_infoPanel.columnWidths = new int[]{22, 69, 241, 87, 0};
		gbl_infoPanel.rowHeights = new int[]{26, 0, 28, 28, 28, 0, 0, 0, 0};
		gbl_infoPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_infoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		infoPanel.setLayout(gbl_infoPanel);
		
		JLabel lblId = new JLabel("ID:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 0;
		infoPanel.add(lblId, gbc_lblId);
		
		lblIdValue = new JLabel("");
		GridBagConstraints gbc_lblIdValue = new GridBagConstraints();
		gbc_lblIdValue.anchor = GridBagConstraints.WEST;
		gbc_lblIdValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdValue.gridx = 2;
		gbc_lblIdValue.gridy = 0;
		infoPanel.add(lblIdValue, gbc_lblIdValue);
		
		JLabel lblDono = new JLabel("Propriet\u00E1rio:");
		GridBagConstraints gbc_lblDono = new GridBagConstraints();
		gbc_lblDono.anchor = GridBagConstraints.EAST;
		gbc_lblDono.insets = new Insets(0, 0, 5, 5);
		gbc_lblDono.gridx = 1;
		gbc_lblDono.gridy = 2;
		infoPanel.add(lblDono, gbc_lblDono);
		
		lblDonoStr = new JLabel("");
		GridBagConstraints gbc_lblDonoStr = new GridBagConstraints();
		gbc_lblDonoStr.anchor = GridBagConstraints.WEST;
		gbc_lblDonoStr.insets = new Insets(0, 0, 5, 5);
		gbc_lblDonoStr.gridx = 2;
		gbc_lblDonoStr.gridy = 2;
		infoPanel.add(lblDonoStr, gbc_lblDonoStr);
		
		btnVerDadosDono = new JButton("Ver Dados");
		btnVerDadosDono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnVerDadosDono = new GridBagConstraints();
		gbc_btnVerDadosDono.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerDadosDono.gridx = 3;
		gbc_btnVerDadosDono.gridy = 2;
		infoPanel.add(btnVerDadosDono, gbc_btnVerDadosDono);
		
		JLabel lblPlaca = new JLabel("Placa:");
		GridBagConstraints gbc_lblPlaca = new GridBagConstraints();
		gbc_lblPlaca.anchor = GridBagConstraints.EAST;
		gbc_lblPlaca.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlaca.gridx = 1;
		gbc_lblPlaca.gridy = 3;
		infoPanel.add(lblPlaca, gbc_lblPlaca);
		
		lblPlacaStr = new JLabel("");
		GridBagConstraints gbc_lblPlacaStr = new GridBagConstraints();
		gbc_lblPlacaStr.anchor = GridBagConstraints.WEST;
		gbc_lblPlacaStr.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlacaStr.gridx = 2;
		gbc_lblPlacaStr.gridy = 3;
		infoPanel.add(lblPlacaStr, gbc_lblPlacaStr);
		
		JLabel lblCor = new JLabel("Cor:");
		GridBagConstraints gbc_lblCor = new GridBagConstraints();
		gbc_lblCor.anchor = GridBagConstraints.EAST;
		gbc_lblCor.insets = new Insets(0, 0, 5, 5);
		gbc_lblCor.gridx = 1;
		gbc_lblCor.gridy = 4;
		infoPanel.add(lblCor, gbc_lblCor);
		
		lblCorStr = new JLabel("");
		GridBagConstraints gbc_lblCorStr = new GridBagConstraints();
		gbc_lblCorStr.anchor = GridBagConstraints.WEST;
		gbc_lblCorStr.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorStr.gridx = 2;
		gbc_lblCorStr.gridy = 4;
		infoPanel.add(lblCorStr, gbc_lblCorStr);
		
		JLabel lblMarca = new JLabel("Marca:");
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.anchor = GridBagConstraints.EAST;
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.gridx = 1;
		gbc_lblMarca.gridy = 5;
		infoPanel.add(lblMarca, gbc_lblMarca);
		
		lblMarcaStr = new JLabel("");
		GridBagConstraints gbc_lblMarcaStr = new GridBagConstraints();
		gbc_lblMarcaStr.anchor = GridBagConstraints.WEST;
		gbc_lblMarcaStr.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarcaStr.gridx = 2;
		gbc_lblMarcaStr.gridy = 5;
		infoPanel.add(lblMarcaStr, gbc_lblMarcaStr);
		
		btnVerDadosMarca = new JButton("Ver Dados");
		GridBagConstraints gbc_btnVerDadosMarca = new GridBagConstraints();
		gbc_btnVerDadosMarca.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerDadosMarca.gridx = 3;
		gbc_btnVerDadosMarca.gridy = 5;
		infoPanel.add(btnVerDadosMarca, gbc_btnVerDadosMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.anchor = GridBagConstraints.EAST;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 1;
		gbc_lblModelo.gridy = 6;
		infoPanel.add(lblModelo, gbc_lblModelo);
		
		lblModeloStr = new JLabel("");
		GridBagConstraints gbc_lblModeloStr = new GridBagConstraints();
		gbc_lblModeloStr.anchor = GridBagConstraints.WEST;
		gbc_lblModeloStr.insets = new Insets(0, 0, 5, 5);
		gbc_lblModeloStr.gridx = 2;
		gbc_lblModeloStr.gridy = 6;
		infoPanel.add(lblModeloStr, gbc_lblModeloStr);
		
		btnVerDadosModelo = new JButton("Ver Dados");
		GridBagConstraints gbc_btnVerDadosModelo = new GridBagConstraints();
		gbc_btnVerDadosModelo.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerDadosModelo.gridx = 3;
		gbc_btnVerDadosModelo.gridy = 6;
		infoPanel.add(btnVerDadosModelo, gbc_btnVerDadosModelo);
		
		JLabel lblVersao = new JLabel("Vers\u00E3o:");
		GridBagConstraints gbc_lblVersao = new GridBagConstraints();
		gbc_lblVersao.anchor = GridBagConstraints.EAST;
		gbc_lblVersao.insets = new Insets(0, 0, 0, 5);
		gbc_lblVersao.gridx = 1;
		gbc_lblVersao.gridy = 7;
		infoPanel.add(lblVersao, gbc_lblVersao);
		
		lblVersaoStr = new JLabel("");
		GridBagConstraints gbc_lblVersaoStr = new GridBagConstraints();
		gbc_lblVersaoStr.anchor = GridBagConstraints.WEST;
		gbc_lblVersaoStr.insets = new Insets(0, 0, 0, 5);
		gbc_lblVersaoStr.gridx = 2;
		gbc_lblVersaoStr.gridy = 7;
		infoPanel.add(lblVersaoStr, gbc_lblVersaoStr);
		
		btnVerDadosVersao = new JButton("Ver Dados");
		GridBagConstraints gbc_btnVerDadosVersao = new GridBagConstraints();
		gbc_btnVerDadosVersao.gridx = 3;
		gbc_btnVerDadosVersao.gridy = 7;
		infoPanel.add(btnVerDadosVersao, gbc_btnVerDadosVersao);
		
		JPanel loadPanel = new JPanel();
		GridBagConstraints gbc_loadPanel = new GridBagConstraints();
		gbc_loadPanel.fill = GridBagConstraints.BOTH;
		gbc_loadPanel.gridx = 1;
		gbc_loadPanel.gridy = 0;
		carroCardPanel.add(loadPanel, gbc_loadPanel);
		GridBagLayout gbl_loadPanel = new GridBagLayout();
		gbl_loadPanel.columnWidths = new int[]{0, 0};
		gbl_loadPanel.rowHeights = new int[]{0, 0, 0};
		gbl_loadPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_loadPanel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		loadPanel.setLayout(gbl_loadPanel);
		
		JScrollPane tableCarroScrollPane = new JScrollPane();
		GridBagConstraints gbc_tableCarroScrollPane = new GridBagConstraints();
		gbc_tableCarroScrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_tableCarroScrollPane.fill = GridBagConstraints.BOTH;
		gbc_tableCarroScrollPane.gridx = 0;
		gbc_tableCarroScrollPane.gridy = 0;
		loadPanel.add(tableCarroScrollPane, gbc_tableCarroScrollPane);
		
		tableCarro = new JTable();
		tableCarro.setShowVerticalLines(false);
		tableCarro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCarro.setFillsViewportHeight(true);
		tableCarroScrollPane.setViewportView(tableCarro);
		
		JButton btnCarregar = new JButton("Carregar Selecionado");
		GridBagConstraints gbc_btnCarregar = new GridBagConstraints();
		gbc_btnCarregar.gridx = 0;
		gbc_btnCarregar.gridy = 1;
		loadPanel.add(btnCarregar, gbc_btnCarregar);
		
		Controller.ControllerVerModel controller = new Controller.ControllerVerModel(this, card);
	}
	public CardLayout getCards() {
		return cardLayout;
	}
	
	public JButton getBtnVerDadosVersao() {
		return btnVerDadosVersao;
	}

	public JLabel getLblVersaoStr() {
		return lblVersaoStr;
	}

	public JButton getBtnVerDadosModelo() {
		return btnVerDadosModelo;
	}

	public JLabel getLblModeloStr() {
		return lblModeloStr;
	}

	public JButton getBtnVerDadosMarca() {
		return btnVerDadosMarca;
	}

	public JLabel getLblMarcaStr() {
		return lblMarcaStr;
	}

	public JLabel getLblCorStr() {
		return lblCorStr;
	}

	public JLabel getLblPlacaStr() {
		return lblPlacaStr;
	}

	public JButton getBtnVerDadosDono() {
		return btnVerDadosDono;
	}

	public JLabel getLblDonoStr() {
		return lblDonoStr;
	}

	public JLabel getLblIdValue() {
		return lblIdValue;
	}

	public JTable getTableCarro() {
		return tableCarro;
	}
}
