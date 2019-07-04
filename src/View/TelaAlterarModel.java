package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import Model.Marca;
import Model.Modelo;
import Model.Versao;

public class TelaAlterarModel extends JFrame {

	private JPanel contentPane;
	private JLabel carroProprietario;
	private JButton carroAlterarProprietario;
	private JFormattedTextField carroPlacaField;
	private JTextField carroCorField;
	private JComboBox<Model.Marca> carroMarcaCBox;
	private JComboBox<Model.Modelo> carroModeloCBox;
	private JComboBox<Model.Versao> carroVersaoCBox;
	private CardLayout cardLayout;
	private JButton carroConfirmar;
	private JPanel marcaCard;
	private JLabel marcaId;
	private JButton marcaConfirmar;
	private JLabel lblNome;

	public TelaAlterarModel(String card, Model.Carro carroSelec) {
		init();
		Controller.ControllerAlterarModel controller = new Controller.ControllerAlterarModel(this, card, carroSelec);
	}

	private void init() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		JPanel carroCard = new JPanel();
		contentPane.add(carroCard, "AlterarCarro");
		GridBagLayout gbl_carroCard = new GridBagLayout();
		gbl_carroCard.columnWidths = new int[]{22, 69, 241, 87, 0, 0};
		gbl_carroCard.rowHeights = new int[]{0, 26, 0, 28, 28, 28, 0, 0, 35, 0};
		gbl_carroCard.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_carroCard.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		carroCard.setLayout(gbl_carroCard);
		
		JLabel label_2 = new JLabel("Propriet\u00E1rio:");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 1;
		carroCard.add(label_2, gbc_label_2);
		
		carroProprietario = new JLabel("");
		GridBagConstraints gbc_carroProprietario = new GridBagConstraints();
		gbc_carroProprietario.anchor = GridBagConstraints.WEST;
		gbc_carroProprietario.insets = new Insets(0, 0, 5, 5);
		gbc_carroProprietario.gridx = 2;
		gbc_carroProprietario.gridy = 1;
		carroCard.add(carroProprietario, gbc_carroProprietario);
		
		carroAlterarProprietario = new JButton("Alterar");
		GridBagConstraints gbc_carroAlterarProprietario = new GridBagConstraints();
		gbc_carroAlterarProprietario.fill = GridBagConstraints.HORIZONTAL;
		gbc_carroAlterarProprietario.insets = new Insets(0, 0, 5, 5);
		gbc_carroAlterarProprietario.gridx = 3;
		gbc_carroAlterarProprietario.gridy = 1;
		carroCard.add(carroAlterarProprietario, gbc_carroAlterarProprietario);
		
		JLabel label_4 = new JLabel("Placa:");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 2;
		carroCard.add(label_4, gbc_label_4);
		
		carroPlacaField = new JFormattedTextField();
		GridBagConstraints gbc_carroPlacaField = new GridBagConstraints();
		gbc_carroPlacaField.gridwidth = 2;
		gbc_carroPlacaField.insets = new Insets(0, 0, 5, 5);
		gbc_carroPlacaField.fill = GridBagConstraints.HORIZONTAL;
		gbc_carroPlacaField.gridx = 2;
		gbc_carroPlacaField.gridy = 2;
		carroCard.add(carroPlacaField, gbc_carroPlacaField);
		
		JLabel label_6 = new JLabel("Cor:");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 1;
		gbc_label_6.gridy = 3;
		carroCard.add(label_6, gbc_label_6);
		
		carroCorField = new JTextField();
		GridBagConstraints gbc_carroCorField = new GridBagConstraints();
		gbc_carroCorField.gridwidth = 2;
		gbc_carroCorField.insets = new Insets(0, 0, 5, 5);
		gbc_carroCorField.fill = GridBagConstraints.HORIZONTAL;
		gbc_carroCorField.gridx = 2;
		gbc_carroCorField.gridy = 3;
		carroCard.add(carroCorField, gbc_carroCorField);
		carroCorField.setColumns(10);
		
		JLabel label_8 = new JLabel("Marca:");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.EAST;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 1;
		gbc_label_8.gridy = 4;
		carroCard.add(label_8, gbc_label_8);
		
		carroMarcaCBox = new JComboBox<Model.Marca>();
		GridBagConstraints gbc_carroMarcaCBox = new GridBagConstraints();
		gbc_carroMarcaCBox.gridwidth = 2;
		gbc_carroMarcaCBox.insets = new Insets(0, 0, 5, 5);
		gbc_carroMarcaCBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_carroMarcaCBox.gridx = 2;
		gbc_carroMarcaCBox.gridy = 4;
		carroCard.add(carroMarcaCBox, gbc_carroMarcaCBox);
		
		JLabel label_10 = new JLabel("Modelo:");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.anchor = GridBagConstraints.EAST;
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 1;
		gbc_label_10.gridy = 5;
		carroCard.add(label_10, gbc_label_10);
		
		carroModeloCBox = new JComboBox<Model.Modelo>();
		GridBagConstraints gbc_carroModeloCBox = new GridBagConstraints();
		gbc_carroModeloCBox.gridwidth = 2;
		gbc_carroModeloCBox.insets = new Insets(0, 0, 5, 5);
		gbc_carroModeloCBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_carroModeloCBox.gridx = 2;
		gbc_carroModeloCBox.gridy = 5;
		carroCard.add(carroModeloCBox, gbc_carroModeloCBox);
		
		JLabel label_12 = new JLabel("Vers\u00E3o:");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.anchor = GridBagConstraints.EAST;
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 1;
		gbc_label_12.gridy = 6;
		carroCard.add(label_12, gbc_label_12);
		
		carroVersaoCBox = new JComboBox<Model.Versao>();
		GridBagConstraints gbc_carroVersaoCBox = new GridBagConstraints();
		gbc_carroVersaoCBox.gridwidth = 2;
		gbc_carroVersaoCBox.insets = new Insets(0, 0, 5, 5);
		gbc_carroVersaoCBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_carroVersaoCBox.gridx = 2;
		gbc_carroVersaoCBox.gridy = 6;
		carroCard.add(carroVersaoCBox, gbc_carroVersaoCBox);
		
		carroConfirmar = new JButton("Confirmar Mudan\u00E7as");
		GridBagConstraints gbc_carroConfirmar = new GridBagConstraints();
		gbc_carroConfirmar.gridwidth = 2;
		gbc_carroConfirmar.gridx = 3;
		gbc_carroConfirmar.gridy = 8;
		carroCard.add(carroConfirmar, gbc_carroConfirmar);
		
		marcaCard = new JPanel();
		contentPane.add(marcaCard, "name_209165222927346");
		GridBagLayout gbl_marcaCard = new GridBagLayout();
		gbl_marcaCard.columnWidths = new int[]{22, 69, 241, 87, 0, 0};
		gbl_marcaCard.rowHeights = new int[]{0, 26, 0, 28, 28, 28, 0, 0, 35, 0};
		gbl_marcaCard.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_marcaCard.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		marcaCard.setLayout(gbl_marcaCard);
		
		marcaId = new JLabel("Id:");
		GridBagConstraints gbc_marcaId = new GridBagConstraints();
		gbc_marcaId.anchor = GridBagConstraints.EAST;
		gbc_marcaId.insets = new Insets(0, 0, 5, 5);
		gbc_marcaId.gridx = 1;
		gbc_marcaId.gridy = 1;
		marcaCard.add(marcaId, gbc_marcaId);
		
		lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 3;
		marcaCard.add(lblNome, gbc_lblNome);
		
		marcaConfirmar = new JButton("Confirmar Mudan\u00E7as");
		GridBagConstraints gbc_marcaConfirmar = new GridBagConstraints();
		gbc_marcaConfirmar.gridwidth = 2;
		gbc_marcaConfirmar.gridx = 3;
		gbc_marcaConfirmar.gridy = 8;
		marcaCard.add(marcaConfirmar, gbc_marcaConfirmar);
	}
	
	
	public JLabel getCarroProprietario() {
		return carroProprietario;
	}

	public JButton getCarroAlterarProprietario() {
		return carroAlterarProprietario;
	}

	public JFormattedTextField getCarroPlacaField() {
		return carroPlacaField;
	}

	public JTextField getCarroCorField() {
		return carroCorField;
	}

	public JComboBox<Model.Marca> getCarroMarcaCBox() {
		return carroMarcaCBox;
	}

	public JComboBox<Model.Modelo> getCarroModeloCBox() {
		return carroModeloCBox;
	}

	public JComboBox<Model.Versao> getCarroVersaoCBox() {
		return carroVersaoCBox;
	}

	public CardLayout getCards() {
		return cardLayout;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public JButton getCarroConfirmar() {
		return carroConfirmar;
	}
}
