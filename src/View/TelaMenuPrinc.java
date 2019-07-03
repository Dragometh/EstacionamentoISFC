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
import javax.swing.JLabel;
import java.awt.Font;


public class TelaMenuPrinc extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JButton btnRegistrarEntrada;
	private JButton btnRegistrarSaida;

	/**
	 * Create the frame.
	 */
	public TelaMenuPrinc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 201, 275);
		
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
		gbl_contentPane.rowHeights = new int[]{35, 45, 45, 45, 41, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEstacionamento = new JLabel("ESTACIONAMENTO");
		lblEstacionamento.setFont(new Font("Consolas", Font.PLAIN, 22));
		GridBagConstraints gbc_lblEstacionamento = new GridBagConstraints();
		gbc_lblEstacionamento.insets = new Insets(0, 0, 5, 0);
		gbc_lblEstacionamento.gridx = 0;
		gbc_lblEstacionamento.gridy = 0;
		contentPane.add(lblEstacionamento, gbc_lblEstacionamento);
		
		btnRegistrarEntrada = new JButton("REGISTRAR ENTRADA");
		btnRegistrarEntrada.setFont(new Font("Consolas", Font.BOLD, 14));
		GridBagConstraints gbc_btnRegistrarEntrada = new GridBagConstraints();
		gbc_btnRegistrarEntrada.fill = GridBagConstraints.BOTH;
		gbc_btnRegistrarEntrada.insets = new Insets(0, 0, 5, 0);
		gbc_btnRegistrarEntrada.gridx = 0;
		gbc_btnRegistrarEntrada.gridy = 1;
		contentPane.add(btnRegistrarEntrada, gbc_btnRegistrarEntrada);
		
		btnRegistrarSaida = new JButton("REGISTRAR SA\u00CDDA");
		btnRegistrarSaida.setFont(new Font("Consolas", Font.BOLD, 14));
		GridBagConstraints gbc_btnRegistrarSaida = new GridBagConstraints();
		gbc_btnRegistrarSaida.fill = GridBagConstraints.BOTH;
		gbc_btnRegistrarSaida.insets = new Insets(0, 0, 5, 0);
		gbc_btnRegistrarSaida.gridx = 0;
		gbc_btnRegistrarSaida.gridy = 2;
		contentPane.add(btnRegistrarSaida, gbc_btnRegistrarSaida);
		
		JLabel lblHelp = new JLabel("Precisa de ajuda?");
		lblHelp.setToolTipText("Use o menu de \"Dados\" para alterar e visualizar dados, e o menu de \"Registrar\" para cadastrar dados.");
		lblHelp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblHelp = new GridBagConstraints();
		gbc_lblHelp.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblHelp.gridx = 0;
		gbc_lblHelp.gridy = 4;
		contentPane.add(lblHelp, gbc_lblHelp);
		
		Controller.ControllerMenuPrinc controller = new Controller.ControllerMenuPrinc(this);
	}

	public JButton getBtnRegistrarEntrada() {
		return btnRegistrarEntrada;
	}

	public JButton getBtnRegistrarSaida() {
		return btnRegistrarSaida;
	}
}
