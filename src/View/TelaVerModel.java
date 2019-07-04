package View;

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
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;

public class TelaVerModel extends JFrame {
	private JButton carroVerDadosVersao;
	private JLabel carroVersao;
	private JButton carroVerDadosModelo;
	private JLabel carroModelo;
	private JButton carroVerDadosMarca;
	private JLabel carroMarca;
	private JLabel carroCor;
	private JLabel carroPlaca;
	private JButton carroVerDadosProprietario;
	private JLabel carroDono;
	private JLabel carroIdValue;
	private JTable tableCarro;
	private CardLayout cl_contentPane;
	private JButton carroAlterar;
	private JButton proprietarioAlterar;
	private JTable tableProprietario;
	private JButton userAlterar;
	private JTable tableUser;
	private JButton marcaBtnVerMarcas;
	private JButton marcaBtnVerModelos;
	private JButton marcaBtnVerVersoes;
	private JButton marcaAlterar;
	private CardLayout cl_marcaInfoCardsPanel;
	private JTable marcaMarcaTable;
	private JTable marcaModeloTable;
	private JTable marcaVersaoTable;
	private JPanel marcaInfoCardsPanel;

	public TelaVerModel(String card) {
		Font helpFont = new Font("Tahoma", Font.PLAIN, 12);
		Map<TextAttribute, Object> helpFontAttributes = new HashMap<>(helpFont.getAttributes());
		helpFontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cl_contentPane = new CardLayout(0, 0);
		contentPane.setLayout(cl_contentPane);
		
		JPanel marcaCardPanel = new JPanel();
		contentPane.add(marcaCardPanel, "VerMarca");
		GridBagLayout gbl_marcaCardPanel = new GridBagLayout();
		gbl_marcaCardPanel.columnWidths = new int[]{90, 430, 0};
		gbl_marcaCardPanel.rowHeights = new int[]{140, 0};
		gbl_marcaCardPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_marcaCardPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		marcaCardPanel.setLayout(gbl_marcaCardPanel);
		
		JPanel marcaButtonPanel = new JPanel();
		GridBagConstraints gbc_marcaButtonPanel = new GridBagConstraints();
		gbc_marcaButtonPanel.fill = GridBagConstraints.VERTICAL;
		gbc_marcaButtonPanel.anchor = GridBagConstraints.WEST;
		gbc_marcaButtonPanel.insets = new Insets(0, 0, 0, 5);
		gbc_marcaButtonPanel.gridx = 0;
		gbc_marcaButtonPanel.gridy = 0;
		marcaCardPanel.add(marcaButtonPanel, gbc_marcaButtonPanel);
		GridBagLayout gbl_marcaButtonPanel = new GridBagLayout();
		gbl_marcaButtonPanel.columnWidths = new int[]{0, 0};
		gbl_marcaButtonPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_marcaButtonPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_marcaButtonPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		marcaButtonPanel.setLayout(gbl_marcaButtonPanel);
		
		marcaBtnVerMarcas = new JButton("Ver Marcas");
		GridBagConstraints gbc_marcaBtnVerMarcas = new GridBagConstraints();
		gbc_marcaBtnVerMarcas.fill = GridBagConstraints.HORIZONTAL;
		gbc_marcaBtnVerMarcas.insets = new Insets(0, 0, 5, 0);
		gbc_marcaBtnVerMarcas.gridx = 0;
		gbc_marcaBtnVerMarcas.gridy = 0;
		marcaButtonPanel.add(marcaBtnVerMarcas, gbc_marcaBtnVerMarcas);
		
		marcaBtnVerModelos = new JButton("Ver Modelos");
		GridBagConstraints gbc_marcaBtnVerModelos = new GridBagConstraints();
		gbc_marcaBtnVerModelos.fill = GridBagConstraints.HORIZONTAL;
		gbc_marcaBtnVerModelos.insets = new Insets(0, 0, 5, 0);
		gbc_marcaBtnVerModelos.gridx = 0;
		gbc_marcaBtnVerModelos.gridy = 1;
		marcaButtonPanel.add(marcaBtnVerModelos, gbc_marcaBtnVerModelos);
		
		marcaBtnVerVersoes = new JButton("Ver Vers\u00F5es");
		GridBagConstraints gbc_marcaBtnVerVersoes = new GridBagConstraints();
		gbc_marcaBtnVerVersoes.fill = GridBagConstraints.HORIZONTAL;
		gbc_marcaBtnVerVersoes.insets = new Insets(0, 0, 5, 0);
		gbc_marcaBtnVerVersoes.gridx = 0;
		gbc_marcaBtnVerVersoes.gridy = 2;
		marcaButtonPanel.add(marcaBtnVerVersoes, gbc_marcaBtnVerVersoes);
		
		marcaAlterar = new JButton("Alterar Selecionado");
		GridBagConstraints gbc_marcaAlterar = new GridBagConstraints();
		gbc_marcaAlterar.insets = new Insets(0, 0, 5, 0);
		gbc_marcaAlterar.fill = GridBagConstraints.HORIZONTAL;
		gbc_marcaAlterar.anchor = GridBagConstraints.SOUTH;
		gbc_marcaAlterar.gridx = 0;
		gbc_marcaAlterar.gridy = 7;
		marcaButtonPanel.add(marcaAlterar, gbc_marcaAlterar);
		
		JLabel marcaHelp = new JLabel("Precisa de ajuda?");
		GridBagConstraints gbc_marcaHelp = new GridBagConstraints();
		gbc_marcaHelp.anchor = GridBagConstraints.SOUTH;
		gbc_marcaHelp.gridx = 0;
		gbc_marcaHelp.gridy = 8;
		marcaButtonPanel.add(marcaHelp, gbc_marcaHelp);
		marcaHelp.setToolTipText("Selecione um elemento qualquer na lista para ver seus dados.");
		marcaHelp.setForeground(Color.BLUE);
		marcaHelp.setFont(helpFont.deriveFont(helpFontAttributes));
		
		marcaInfoCardsPanel = new JPanel();
		GridBagConstraints gbc_marcaInfoCardsPanel = new GridBagConstraints();
		gbc_marcaInfoCardsPanel.fill = GridBagConstraints.BOTH;
		gbc_marcaInfoCardsPanel.gridx = 1;
		gbc_marcaInfoCardsPanel.gridy = 0;
		marcaCardPanel.add(marcaInfoCardsPanel, gbc_marcaInfoCardsPanel);
		cl_marcaInfoCardsPanel = new CardLayout(0, 0);
		marcaInfoCardsPanel.setLayout(cl_marcaInfoCardsPanel);
		
		JPanel marcaVersaoInfoCard = new JPanel();
		marcaInfoCardsPanel.add(marcaVersaoInfoCard, "Versao");
		GridBagLayout gbl_marcaVersaoInfoCard = new GridBagLayout();
		gbl_marcaVersaoInfoCard.columnWidths = new int[]{0, 0};
		gbl_marcaVersaoInfoCard.rowHeights = new int[]{0, 0};
		gbl_marcaVersaoInfoCard.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_marcaVersaoInfoCard.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		marcaVersaoInfoCard.setLayout(gbl_marcaVersaoInfoCard);
		
		JScrollPane marcaVersaoTableScrollPane = new JScrollPane();
		GridBagConstraints gbc_marcaVersaoTableScrollPane = new GridBagConstraints();
		gbc_marcaVersaoTableScrollPane.fill = GridBagConstraints.BOTH;
		gbc_marcaVersaoTableScrollPane.gridx = 0;
		gbc_marcaVersaoTableScrollPane.gridy = 0;
		marcaVersaoInfoCard.add(marcaVersaoTableScrollPane, gbc_marcaVersaoTableScrollPane);
		
		marcaVersaoTable = new JTable();
		marcaVersaoTable.setShowVerticalLines(false);
		marcaVersaoTable.setShowGrid(false);
		marcaVersaoTable.setFillsViewportHeight(true);
		marcaVersaoTableScrollPane.setViewportView(marcaVersaoTable);
		
		JPanel marcaModeloInfoCard = new JPanel();
		marcaInfoCardsPanel.add(marcaModeloInfoCard, "Modelo");
		GridBagLayout gbl_marcaModeloInfoCard = new GridBagLayout();
		gbl_marcaModeloInfoCard.columnWidths = new int[]{75, 0};
		gbl_marcaModeloInfoCard.rowHeights = new int[]{0, 0};
		gbl_marcaModeloInfoCard.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_marcaModeloInfoCard.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		marcaModeloInfoCard.setLayout(gbl_marcaModeloInfoCard);
		
		JScrollPane marcaModeloTableScrollPane = new JScrollPane();
		GridBagConstraints gbc_marcaModeloTableScrollPane = new GridBagConstraints();
		gbc_marcaModeloTableScrollPane.fill = GridBagConstraints.BOTH;
		gbc_marcaModeloTableScrollPane.gridx = 0;
		gbc_marcaModeloTableScrollPane.gridy = 0;
		marcaModeloInfoCard.add(marcaModeloTableScrollPane, gbc_marcaModeloTableScrollPane);
		
		marcaModeloTable = new JTable();
		marcaModeloTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		marcaModeloTable.setShowGrid(false);
		marcaModeloTable.setFillsViewportHeight(true);
		marcaModeloTable.setShowVerticalLines(false);
		marcaModeloTableScrollPane.setViewportView(marcaModeloTable);
		
		JPanel marcaMarcaInfoCard = new JPanel();
		marcaInfoCardsPanel.add(marcaMarcaInfoCard, "Marca");
		GridBagLayout gbl_marcaMarcaInfoCard = new GridBagLayout();
		gbl_marcaMarcaInfoCard.columnWidths = new int[]{348, 0};
		gbl_marcaMarcaInfoCard.rowHeights = new int[]{261, 0};
		gbl_marcaMarcaInfoCard.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_marcaMarcaInfoCard.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		marcaMarcaInfoCard.setLayout(gbl_marcaMarcaInfoCard);
		
		JScrollPane marcaMarcaTableScrollPane = new JScrollPane();
		GridBagConstraints gbc_marcaMarcaTableScrollPane = new GridBagConstraints();
		gbc_marcaMarcaTableScrollPane.fill = GridBagConstraints.BOTH;
		gbc_marcaMarcaTableScrollPane.gridx = 0;
		gbc_marcaMarcaTableScrollPane.gridy = 0;
		marcaMarcaInfoCard.add(marcaMarcaTableScrollPane, gbc_marcaMarcaTableScrollPane);
		
		marcaMarcaTable = new JTable();
		marcaMarcaTable.setShowGrid(false);
		marcaMarcaTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		marcaMarcaTable.setShowVerticalLines(false);
		marcaMarcaTable.setFillsViewportHeight(true);
		marcaMarcaTableScrollPane.setViewportView(marcaMarcaTable);
		
		JPanel userCardPanel = new JPanel();
		contentPane.add(userCardPanel, "VerUser");
		GridBagLayout gbl_userCardPanel = new GridBagLayout();
		gbl_userCardPanel.columnWidths = new int[]{430, 0, 0};
		gbl_userCardPanel.rowHeights = new int[]{0, 0};
		gbl_userCardPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_userCardPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		userCardPanel.setLayout(gbl_userCardPanel);
		
		JPanel userInfoPanel = new JPanel();
		GridBagConstraints gbc_userInfoPanel = new GridBagConstraints();
		gbc_userInfoPanel.fill = GridBagConstraints.BOTH;
		gbc_userInfoPanel.insets = new Insets(0, 0, 0, 5);
		gbc_userInfoPanel.gridx = 0;
		gbc_userInfoPanel.gridy = 0;
		userCardPanel.add(userInfoPanel, gbc_userInfoPanel);
		GridBagLayout gbl_userInfoPanel = new GridBagLayout();
		gbl_userInfoPanel.columnWidths = new int[]{22, 69, 200, 87, 0, 0};
		gbl_userInfoPanel.rowHeights = new int[]{26, 0, 28, 28, 28, 0, 0, 0, 35, 0};
		gbl_userInfoPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_userInfoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		userInfoPanel.setLayout(gbl_userInfoPanel);
		
		userAlterar = new JButton("Alterar Dados");
		GridBagConstraints gbc_userAlterar = new GridBagConstraints();
		gbc_userAlterar.anchor = GridBagConstraints.SOUTH;
		gbc_userAlterar.gridwidth = 2;
		gbc_userAlterar.insets = new Insets(0, 0, 0, 5);
		gbc_userAlterar.gridx = 0;
		gbc_userAlterar.gridy = 8;
		userInfoPanel.add(userAlterar, gbc_userAlterar);
		
		JLabel userHelp = new JLabel("Precisa de ajuda?");
		userHelp.setToolTipText("Selecione um elemento qualquer na lista para ver seus dados.");
		userHelp.setForeground(Color.BLUE);
		userHelp.setFont(helpFont.deriveFont(helpFontAttributes));
		GridBagConstraints gbc_userHelp = new GridBagConstraints();
		gbc_userHelp.insets = new Insets(0, 0, 0, 5);
		gbc_userHelp.anchor = GridBagConstraints.SOUTHEAST;
		gbc_userHelp.gridwidth = 2;
		gbc_userHelp.gridx = 3;
		gbc_userHelp.gridy = 8;
		userInfoPanel.add(userHelp, gbc_userHelp);
		
		JPanel userLoadPanel = new JPanel();
		GridBagConstraints gbc_userLoadPanel = new GridBagConstraints();
		gbc_userLoadPanel.fill = GridBagConstraints.BOTH;
		gbc_userLoadPanel.gridx = 1;
		gbc_userLoadPanel.gridy = 0;
		userCardPanel.add(userLoadPanel, gbc_userLoadPanel);
		GridBagLayout gbl_userLoadPanel = new GridBagLayout();
		gbl_userLoadPanel.columnWidths = new int[]{0, 0};
		gbl_userLoadPanel.rowHeights = new int[]{0, 0};
		gbl_userLoadPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_userLoadPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		userLoadPanel.setLayout(gbl_userLoadPanel);
		
		JScrollPane userTableScrollPane = new JScrollPane();
		GridBagConstraints gbc_userTableScrollPane = new GridBagConstraints();
		gbc_userTableScrollPane.fill = GridBagConstraints.BOTH;
		gbc_userTableScrollPane.gridx = 0;
		gbc_userTableScrollPane.gridy = 0;
		userLoadPanel.add(userTableScrollPane, gbc_userTableScrollPane);
		
		tableUser = new JTable();
		tableUser.setShowGrid(false);
		tableUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableUser.setShowVerticalLines(false);
		tableUser.setFillsViewportHeight(true);
		userTableScrollPane.setViewportView(tableUser);
		
		JPanel proprietarioCardPanel = new JPanel();
		contentPane.add(proprietarioCardPanel, "VerProprietario");
		GridBagLayout gbl_proprietarioCardPanel = new GridBagLayout();
		gbl_proprietarioCardPanel.columnWidths = new int[]{430, 0, 0};
		gbl_proprietarioCardPanel.rowHeights = new int[]{0, 0};
		gbl_proprietarioCardPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_proprietarioCardPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		proprietarioCardPanel.setLayout(gbl_proprietarioCardPanel);
		
		JPanel proprietarioInfoPanel = new JPanel();
		GridBagConstraints gbc_proprietarioInfoPanel = new GridBagConstraints();
		gbc_proprietarioInfoPanel.fill = GridBagConstraints.BOTH;
		gbc_proprietarioInfoPanel.insets = new Insets(0, 0, 0, 5);
		gbc_proprietarioInfoPanel.gridx = 0;
		gbc_proprietarioInfoPanel.gridy = 0;
		proprietarioCardPanel.add(proprietarioInfoPanel, gbc_proprietarioInfoPanel);
		GridBagLayout gbl_proprietarioInfoPanel = new GridBagLayout();
		gbl_proprietarioInfoPanel.columnWidths = new int[]{22, 69, 200, 87, 0, 0};
		gbl_proprietarioInfoPanel.rowHeights = new int[]{26, 0, 28, 28, 28, 0, 0, 0, 35, 0};
		gbl_proprietarioInfoPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_proprietarioInfoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		proprietarioInfoPanel.setLayout(gbl_proprietarioInfoPanel);
		
		proprietarioAlterar = new JButton("Alterar Dados");
		GridBagConstraints gbc_proprietarioAlterar = new GridBagConstraints();
		gbc_proprietarioAlterar.anchor = GridBagConstraints.SOUTH;
		gbc_proprietarioAlterar.gridwidth = 2;
		gbc_proprietarioAlterar.insets = new Insets(0, 0, 0, 5);
		gbc_proprietarioAlterar.gridx = 0;
		gbc_proprietarioAlterar.gridy = 8;
		proprietarioInfoPanel.add(proprietarioAlterar, gbc_proprietarioAlterar);
		
		JLabel proprietarioHelp = new JLabel("Precisa de ajuda?");
		proprietarioHelp.setToolTipText("Selecione um elemento qualquer na lista para ver seus dados.");
		proprietarioHelp.setForeground(Color.BLUE);
		proprietarioHelp.setFont(helpFont.deriveFont(helpFontAttributes));
		GridBagConstraints gbc_proprietarioHelp = new GridBagConstraints();
		gbc_proprietarioHelp.insets = new Insets(0, 0, 0, 5);
		gbc_proprietarioHelp.anchor = GridBagConstraints.SOUTHEAST;
		gbc_proprietarioHelp.gridwidth = 2;
		gbc_proprietarioHelp.gridx = 3;
		gbc_proprietarioHelp.gridy = 8;
		proprietarioInfoPanel.add(proprietarioHelp, gbc_proprietarioHelp);

		JPanel proprietarioLoadPanel = new JPanel();
		GridBagConstraints gbc_proprietarioLoadPanel = new GridBagConstraints();
		gbc_proprietarioLoadPanel.fill = GridBagConstraints.BOTH;
		gbc_proprietarioLoadPanel.gridx = 1;
		gbc_proprietarioLoadPanel.gridy = 0;
		proprietarioCardPanel.add(proprietarioLoadPanel, gbc_proprietarioLoadPanel);
		GridBagLayout gbl_proprietarioLoadPanel = new GridBagLayout();
		gbl_proprietarioLoadPanel.columnWidths = new int[]{0, 0};
		gbl_proprietarioLoadPanel.rowHeights = new int[]{0, 0};
		gbl_proprietarioLoadPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_proprietarioLoadPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		proprietarioLoadPanel.setLayout(gbl_proprietarioLoadPanel);
		
		JScrollPane tableProprietarioScrollPane = new JScrollPane();
		GridBagConstraints gbc_tableProprietarioScrollPane = new GridBagConstraints();
		gbc_tableProprietarioScrollPane.fill = GridBagConstraints.BOTH;
		gbc_tableProprietarioScrollPane.gridx = 0;
		gbc_tableProprietarioScrollPane.gridy = 0;
		proprietarioLoadPanel.add(tableProprietarioScrollPane, gbc_tableProprietarioScrollPane);
		
		tableProprietario = new JTable();
		tableProprietario.setShowGrid(false);
		tableProprietario.setShowVerticalLines(false);
		tableProprietario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableProprietario.setFillsViewportHeight(true);
		tableProprietarioScrollPane.setViewportView(tableProprietario);
		
		JPanel carroCardPanel = new JPanel();
		contentPane.add(carroCardPanel, "VerCarro");
		GridBagLayout gbl_carroCardPanel = new GridBagLayout();
		gbl_carroCardPanel.columnWidths = new int[]{430, 0, 0};
		gbl_carroCardPanel.rowHeights = new int[]{0, 0};
		gbl_carroCardPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_carroCardPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		carroCardPanel.setLayout(gbl_carroCardPanel);
		
		JPanel carroInfoPanel = new JPanel();
		GridBagConstraints gbc_carroInfoPanel = new GridBagConstraints();
		gbc_carroInfoPanel.insets = new Insets(0, 0, 0, 5);
		gbc_carroInfoPanel.fill = GridBagConstraints.BOTH;
		gbc_carroInfoPanel.gridx = 0;
		gbc_carroInfoPanel.gridy = 0;
		carroCardPanel.add(carroInfoPanel, gbc_carroInfoPanel);
		GridBagLayout gbl_carroInfoPanel = new GridBagLayout();
		gbl_carroInfoPanel.columnWidths = new int[]{22, 69, 200, 87, 0, 0};
		gbl_carroInfoPanel.rowHeights = new int[]{26, 0, 28, 28, 28, 0, 0, 0, 35, 0};
		gbl_carroInfoPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_carroInfoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		carroInfoPanel.setLayout(gbl_carroInfoPanel);
		
		JLabel lblId = new JLabel("ID:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 0;
		carroInfoPanel.add(lblId, gbc_lblId);
		
		carroIdValue = new JLabel("");
		GridBagConstraints gbc_carroIdValue = new GridBagConstraints();
		gbc_carroIdValue.anchor = GridBagConstraints.WEST;
		gbc_carroIdValue.insets = new Insets(0, 0, 5, 5);
		gbc_carroIdValue.gridx = 2;
		gbc_carroIdValue.gridy = 0;
		carroInfoPanel.add(carroIdValue, gbc_carroIdValue);
		
		JLabel lblDono = new JLabel("Propriet\u00E1rio:");
		GridBagConstraints gbc_lblDono = new GridBagConstraints();
		gbc_lblDono.anchor = GridBagConstraints.EAST;
		gbc_lblDono.insets = new Insets(0, 0, 5, 5);
		gbc_lblDono.gridx = 1;
		gbc_lblDono.gridy = 2;
		carroInfoPanel.add(lblDono, gbc_lblDono);
		
		carroDono = new JLabel("");
		GridBagConstraints gbc_carroDono = new GridBagConstraints();
		gbc_carroDono.anchor = GridBagConstraints.WEST;
		gbc_carroDono.insets = new Insets(0, 0, 5, 5);
		gbc_carroDono.gridx = 2;
		gbc_carroDono.gridy = 2;
		carroInfoPanel.add(carroDono, gbc_carroDono);
		
		carroVerDadosProprietario = new JButton("Ver Dados");
		carroVerDadosProprietario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_carroVerDadosDono = new GridBagConstraints();
		gbc_carroVerDadosDono.insets = new Insets(0, 0, 5, 5);
		gbc_carroVerDadosDono.gridx = 3;
		gbc_carroVerDadosDono.gridy = 2;
		carroInfoPanel.add(carroVerDadosProprietario, gbc_carroVerDadosDono);
		
		JLabel lblPlaca = new JLabel("Placa:");
		GridBagConstraints gbc_lblPlaca = new GridBagConstraints();
		gbc_lblPlaca.anchor = GridBagConstraints.EAST;
		gbc_lblPlaca.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlaca.gridx = 1;
		gbc_lblPlaca.gridy = 3;
		carroInfoPanel.add(lblPlaca, gbc_lblPlaca);
		
		carroPlaca = new JLabel("");
		GridBagConstraints gbc_carroPlaca = new GridBagConstraints();
		gbc_carroPlaca.anchor = GridBagConstraints.WEST;
		gbc_carroPlaca.insets = new Insets(0, 0, 5, 5);
		gbc_carroPlaca.gridx = 2;
		gbc_carroPlaca.gridy = 3;
		carroInfoPanel.add(carroPlaca, gbc_carroPlaca);
		
		JLabel lblCor = new JLabel("Cor:");
		GridBagConstraints gbc_lblCor = new GridBagConstraints();
		gbc_lblCor.anchor = GridBagConstraints.EAST;
		gbc_lblCor.insets = new Insets(0, 0, 5, 5);
		gbc_lblCor.gridx = 1;
		gbc_lblCor.gridy = 4;
		carroInfoPanel.add(lblCor, gbc_lblCor);
		
		carroCor = new JLabel("");
		GridBagConstraints gbc_carroCor = new GridBagConstraints();
		gbc_carroCor.anchor = GridBagConstraints.WEST;
		gbc_carroCor.insets = new Insets(0, 0, 5, 5);
		gbc_carroCor.gridx = 2;
		gbc_carroCor.gridy = 4;
		carroInfoPanel.add(carroCor, gbc_carroCor);
		
		JLabel lblMarca = new JLabel("Marca:");
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.anchor = GridBagConstraints.EAST;
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.gridx = 1;
		gbc_lblMarca.gridy = 5;
		carroInfoPanel.add(lblMarca, gbc_lblMarca);
		
		carroMarca = new JLabel("");
		GridBagConstraints gbc_carroMarca = new GridBagConstraints();
		gbc_carroMarca.anchor = GridBagConstraints.WEST;
		gbc_carroMarca.insets = new Insets(0, 0, 5, 5);
		gbc_carroMarca.gridx = 2;
		gbc_carroMarca.gridy = 5;
		carroInfoPanel.add(carroMarca, gbc_carroMarca);
		
		carroVerDadosMarca = new JButton("Ver Dados");
		GridBagConstraints gbc_carroVerDadosMarca = new GridBagConstraints();
		gbc_carroVerDadosMarca.insets = new Insets(0, 0, 5, 5);
		gbc_carroVerDadosMarca.gridx = 3;
		gbc_carroVerDadosMarca.gridy = 5;
		carroInfoPanel.add(carroVerDadosMarca, gbc_carroVerDadosMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.anchor = GridBagConstraints.EAST;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 1;
		gbc_lblModelo.gridy = 6;
		carroInfoPanel.add(lblModelo, gbc_lblModelo);
		
		carroModelo = new JLabel("");
		GridBagConstraints gbc_carroModelo = new GridBagConstraints();
		gbc_carroModelo.anchor = GridBagConstraints.WEST;
		gbc_carroModelo.insets = new Insets(0, 0, 5, 5);
		gbc_carroModelo.gridx = 2;
		gbc_carroModelo.gridy = 6;
		carroInfoPanel.add(carroModelo, gbc_carroModelo);
		
		carroVerDadosModelo = new JButton("Ver Dados");
		GridBagConstraints gbc_btnVerDadosModelo = new GridBagConstraints();
		gbc_btnVerDadosModelo.insets = new Insets(0, 0, 5, 5);
		gbc_btnVerDadosModelo.gridx = 3;
		gbc_btnVerDadosModelo.gridy = 6;
		carroInfoPanel.add(carroVerDadosModelo, gbc_btnVerDadosModelo);
		
		JLabel lblVersao = new JLabel("Vers\u00E3o:");
		GridBagConstraints gbc_lblVersao = new GridBagConstraints();
		gbc_lblVersao.anchor = GridBagConstraints.EAST;
		gbc_lblVersao.insets = new Insets(0, 0, 5, 5);
		gbc_lblVersao.gridx = 1;
		gbc_lblVersao.gridy = 7;
		carroInfoPanel.add(lblVersao, gbc_lblVersao);
		
		carroVersao = new JLabel("");
		GridBagConstraints gbc_carroVersao = new GridBagConstraints();
		gbc_carroVersao.anchor = GridBagConstraints.WEST;
		gbc_carroVersao.insets = new Insets(0, 0, 5, 5);
		gbc_carroVersao.gridx = 2;
		gbc_carroVersao.gridy = 7;
		carroInfoPanel.add(carroVersao, gbc_carroVersao);
		
		carroVerDadosVersao = new JButton("Ver Dados");
		GridBagConstraints gbc_carroVerDadosVersao = new GridBagConstraints();
		gbc_carroVerDadosVersao.insets = new Insets(0, 0, 5, 5);
		gbc_carroVerDadosVersao.gridx = 3;
		gbc_carroVerDadosVersao.gridy = 7;
		carroInfoPanel.add(carroVerDadosVersao, gbc_carroVerDadosVersao);
		
		carroAlterar = new JButton("Alterar Dados");
		GridBagConstraints gbc_carroAlterar = new GridBagConstraints();
		gbc_carroAlterar.anchor = GridBagConstraints.SOUTH;
		gbc_carroAlterar.gridwidth = 2;
		gbc_carroAlterar.insets = new Insets(0, 0, 0, 5);
		gbc_carroAlterar.gridx = 0;
		gbc_carroAlterar.gridy = 8;
		carroInfoPanel.add(carroAlterar, gbc_carroAlterar);
		JLabel carroHelp = new JLabel("Precisa de ajuda?");
		carroHelp.setToolTipText("Selecione um elemento qualquer na lista para ver seus dados.");
		carroHelp.setForeground(Color.BLUE);
		carroHelp.setFont(helpFont.deriveFont(helpFontAttributes));
		
		
		GridBagConstraints gbc_carroHelp = new GridBagConstraints();
		gbc_carroHelp.gridwidth = 2;
		gbc_carroHelp.anchor = GridBagConstraints.SOUTHEAST;
		gbc_carroHelp.insets = new Insets(0, 0, 0, 5);
		gbc_carroHelp.gridx = 3;
		gbc_carroHelp.gridy = 8;
		carroInfoPanel.add(carroHelp, gbc_carroHelp);
		
		JPanel carroLoadPanel = new JPanel();
		GridBagConstraints gbc_carroLoadPanel = new GridBagConstraints();
		gbc_carroLoadPanel.fill = GridBagConstraints.BOTH;
		gbc_carroLoadPanel.gridx = 1;
		gbc_carroLoadPanel.gridy = 0;
		carroCardPanel.add(carroLoadPanel, gbc_carroLoadPanel);
		GridBagLayout gbl_carroLoadPanel = new GridBagLayout();
		gbl_carroLoadPanel.columnWidths = new int[]{0, 0};
		gbl_carroLoadPanel.rowHeights = new int[]{0, 0};
		gbl_carroLoadPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_carroLoadPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		carroLoadPanel.setLayout(gbl_carroLoadPanel);
		
		JScrollPane tableCarroScrollPane = new JScrollPane();
		GridBagConstraints gbc_tableCarroScrollPane = new GridBagConstraints();
		gbc_tableCarroScrollPane.fill = GridBagConstraints.BOTH;
		gbc_tableCarroScrollPane.gridx = 0;
		gbc_tableCarroScrollPane.gridy = 0;
		carroLoadPanel.add(tableCarroScrollPane, gbc_tableCarroScrollPane);
		
		tableCarro = new JTable();
		tableCarro.setShowGrid(false);
		tableCarro.setShowVerticalLines(false);
		tableCarro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCarro.setFillsViewportHeight(true);
		tableCarroScrollPane.setViewportView(tableCarro);
		
		Controller.ControllerVerModel controller = new Controller.ControllerVerModel(this, card);
	}
	public JPanel getMarcaInfoCardsPanel() {
		return marcaInfoCardsPanel;
	}
	public JLabel getCarroIdValue() {
		return carroIdValue;
	}
	
	public JButton getProprietarioAlterar() {
		return proprietarioAlterar;
	}
	
	public JTable getTableProprietario() {
		return tableProprietario;
	}
	
	public JButton getUserAlterar() {
		return userAlterar;
	}
	
	public JTable getTableUser() {
		return tableUser;
	}
	
	public JButton getMarcaBtnVerMarcas() {
		return marcaBtnVerMarcas;
	}
	
	public JButton getMarcaBtnVerModelos() {
		return marcaBtnVerModelos;
	}
	
	public JButton getMarcaBtnVerVersoes() {
		return marcaBtnVerVersoes;
	}
	
	public JButton getMarcaAlterar() {
		return marcaAlterar;
	}
	
	public CardLayout getMarcaCards() {
		return cl_marcaInfoCardsPanel;
	}
	
	public JTable getMarcaMarcaTable() {
		return marcaMarcaTable;
	}
	
	public JTable getMarcaModeloTable() {
		return marcaModeloTable;
	}
	
	public JTable getMarcaVersaoTable() {
		return marcaVersaoTable;
	}
	
	public CardLayout getCards() {
		return cl_contentPane;
	}
	
	public JButton getCarroAlterar() {
		return carroAlterar;
	}
	
	public JButton getCarroVerDadosVersao() {
		return carroVerDadosVersao;
	}
	
	public JButton getCarroVerDadosModelo() {
		return carroVerDadosModelo;
	}
	
	public JButton getCarroVerDadosMarca() {
		return carroVerDadosMarca;
	}
	
	public JButton getCarroVerDadosProprietario() {
		return carroVerDadosProprietario;
	}
	
	public JLabel getCarroVersao() {
		return carroVersao;
	}

	public JLabel getCarroModelo() {
		return carroModelo;
	}

	public JLabel getCarroMarca() {
		return carroMarca;
	}

	public JLabel getCarroCor() {
		return carroCor;
	}

	public JLabel getCarroPlaca() {
		return carroPlaca;
	}

	public JLabel getCarroDono() {
		return carroDono;
	}

	public JLabel getCarroId() {
		return carroIdValue;
	}

	public JTable getTableCarro() {
		return tableCarro;
	}
}
