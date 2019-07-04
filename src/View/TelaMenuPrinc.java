package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import java.awt.Dialog.ModalExclusionType;


public class TelaMenuPrinc extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JTable logTable;
	private JButton btnRegistrarSaida;
	private JButton btnRegistrarEntrada;
	private JButton btnZerarEntradas;

	/**
	 * Create the frame.
	 */
	public TelaMenuPrinc() {
		setMinimumSize(new Dimension(600, 380));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 339);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDados = new JMenu("Dados");
		menuBar.add(mnDados);
		
		JMenuItem mntmVerProprietarios = new JMenuItem("Propriet\u00E1rios");
		mnDados.add(mntmVerProprietarios);

		JMenuItem mntmVerMarcas = new JMenuItem("Marcas e Modelos");
		mnDados.add(mntmVerMarcas);
		
		JMenuItem mntmVerUsers = new JMenuItem("Usu\u00E1rios do Sistema");
		mnDados.add(mntmVerUsers);
		
		JMenuItem mntmVerAutomoveis = new JMenuItem("Ve\u00EDculos");
		mnDados.add(mntmVerAutomoveis);
		
		JMenu mnRegistrar = new JMenu("Registrar");
		menuBar.add(mnRegistrar);
		
		JMenuItem mntmRegistrarProprietarios = new JMenuItem("Propriet\u00E1rios");
		mnRegistrar.add(mntmRegistrarProprietarios);
		
		JMenuItem mntmRegistrarMarcas = new JMenuItem("Marcas e Modelos");
		mnRegistrar.add(mntmRegistrarMarcas);
		
		JMenuItem mntmRegistrarUsuarios = new JMenuItem("Usu\u00E1rios do Sistema");
		mnRegistrar.add(mntmRegistrarUsuarios);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{125, 0};
		gbl_contentPane.rowHeights = new int[]{35, 264, 41, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEstacionamento = new JLabel("ESTACIONAMENTO");
		lblEstacionamento.setFont(new Font("Consolas", Font.PLAIN, 22));
		GridBagConstraints gbc_lblEstacionamento = new GridBagConstraints();
		gbc_lblEstacionamento.insets = new Insets(0, 0, 5, 0);
		gbc_lblEstacionamento.gridx = 0;
		gbc_lblEstacionamento.gridy = 0;
		contentPane.add(lblEstacionamento, gbc_lblEstacionamento);
		
		JLabel lblHelp = new JLabel("Precisa de ajuda?");
		lblHelp.setForeground(Color.BLUE);
		lblHelp.setToolTipText("Use o menu de \"Dados\" para alterar e visualizar dados, e o menu de \"Registrar\" para cadastrar dados.");
		lblHelp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		Font font = lblHelp.getFont();
		Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		JPanel logPanel = new JPanel();
		GridBagConstraints gbc_logPanel = new GridBagConstraints();
		gbc_logPanel.insets = new Insets(0, 0, 5, 0);
		gbc_logPanel.fill = GridBagConstraints.BOTH;
		gbc_logPanel.gridx = 0;
		gbc_logPanel.gridy = 1;
		contentPane.add(logPanel, gbc_logPanel);
		GridBagLayout gbl_logPanel = new GridBagLayout();
		gbl_logPanel.columnWidths = new int[]{75, 0, 0};
		gbl_logPanel.rowHeights = new int[]{0, 0};
		gbl_logPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_logPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		logPanel.setLayout(gbl_logPanel);
		
		JPanel logBtnPanel = new JPanel();
		GridBagConstraints gbc_logBtnPanel = new GridBagConstraints();
		gbc_logBtnPanel.insets = new Insets(0, 0, 0, 5);
		gbc_logBtnPanel.fill = GridBagConstraints.BOTH;
		gbc_logBtnPanel.gridx = 0;
		gbc_logBtnPanel.gridy = 0;
		logPanel.add(logBtnPanel, gbc_logBtnPanel);
		GridBagLayout gbl_logBtnPanel = new GridBagLayout();
		gbl_logBtnPanel.columnWidths = new int[]{0, 0};
		gbl_logBtnPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_logBtnPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_logBtnPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		logBtnPanel.setLayout(gbl_logBtnPanel);
		
		btnRegistrarEntrada = new JButton("Registrar Entrada");
		GridBagConstraints gbc_btnRegistrarEntrada = new GridBagConstraints();
		gbc_btnRegistrarEntrada.insets = new Insets(0, 0, 5, 0);
		gbc_btnRegistrarEntrada.gridx = 0;
		gbc_btnRegistrarEntrada.gridy = 0;
		logBtnPanel.add(btnRegistrarEntrada, gbc_btnRegistrarEntrada);
		
		btnRegistrarSaida = new JButton("Registrar Sa\u00EDda");
		GridBagConstraints gbc_btnRegistrarSaida = new GridBagConstraints();
		gbc_btnRegistrarSaida.insets = new Insets(0, 0, 5, 0);
		gbc_btnRegistrarSaida.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRegistrarSaida.gridx = 0;
		gbc_btnRegistrarSaida.gridy = 1;
		logBtnPanel.add(btnRegistrarSaida, gbc_btnRegistrarSaida);
		
		btnZerarEntradas = new JButton("Zerar Entradas");
		GridBagConstraints gbc_btnZerarEntradas = new GridBagConstraints();
		gbc_btnZerarEntradas.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnZerarEntradas.gridx = 0;
		gbc_btnZerarEntradas.gridy = 2;
		logBtnPanel.add(btnZerarEntradas, gbc_btnZerarEntradas);
		
		JPanel logInfoPanel = new JPanel();
		GridBagConstraints gbc_logInfoPanel = new GridBagConstraints();
		gbc_logInfoPanel.fill = GridBagConstraints.BOTH;
		gbc_logInfoPanel.gridx = 1;
		gbc_logInfoPanel.gridy = 0;
		logPanel.add(logInfoPanel, gbc_logInfoPanel);
		GridBagLayout gbl_logInfoPanel = new GridBagLayout();
		gbl_logInfoPanel.columnWidths = new int[]{0, 0};
		gbl_logInfoPanel.rowHeights = new int[]{0, 0};
		gbl_logInfoPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_logInfoPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		logInfoPanel.setLayout(gbl_logInfoPanel);
		
		JScrollPane logTableScrollPane = new JScrollPane();
		GridBagConstraints gbc_logTableScrollPane = new GridBagConstraints();
		gbc_logTableScrollPane.fill = GridBagConstraints.BOTH;
		gbc_logTableScrollPane.gridx = 0;
		gbc_logTableScrollPane.gridy = 0;
		logInfoPanel.add(logTableScrollPane, gbc_logTableScrollPane);
		
		logTable = new JTable();
		logTable.setFillsViewportHeight(true);
		logTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		logTable.setShowGrid(false);
		logTable.setShowVerticalLines(false);
		logTableScrollPane.setViewportView(logTable);
		lblHelp.setFont(font.deriveFont(attributes));
		
		GridBagConstraints gbc_lblHelp = new GridBagConstraints();
		gbc_lblHelp.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblHelp.gridx = 0;
		gbc_lblHelp.gridy = 2;
		contentPane.add(lblHelp, gbc_lblHelp);
		
		Controller.ControllerMenuPrinc controller = new Controller.ControllerMenuPrinc(this);
	}
	
	public JButton getBtnZerarEntradas() {
		return btnZerarEntradas;
	}

	public JTable getLogTable() {
		return logTable;
	}

	public JButton getBtnRegistrarEntrada() {
		return btnRegistrarEntrada;
	}

	public JButton getBtnRegistrarSaida() {
		return btnRegistrarSaida;
	}
}
