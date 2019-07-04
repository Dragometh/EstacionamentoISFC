package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.Dialog.ModalityType;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

public class TelaRegEntrada extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JComboBox placaCBox;
	private JComboBox proprietarioCBox;
	private JButton okButton;
	private JButton cancelButton;

	public TelaRegEntrada() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(300, 175));
		setBounds(100, 100, 300, 100);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblSelecioneUmProprietrio = new JLabel("Selecione um propriet\u00E1rio ou um ve\u00EDculo: ");
			GridBagConstraints gbc_lblSelecioneUmProprietrio = new GridBagConstraints();
			gbc_lblSelecioneUmProprietrio.gridwidth = 2;
			gbc_lblSelecioneUmProprietrio.insets = new Insets(0, 0, 5, 0);
			gbc_lblSelecioneUmProprietrio.gridx = 0;
			gbc_lblSelecioneUmProprietrio.gridy = 0;
			contentPanel.add(lblSelecioneUmProprietrio, gbc_lblSelecioneUmProprietrio);
		}
		{
			JLabel lblProprietrio = new JLabel("Propriet\u00E1rio:");
			GridBagConstraints gbc_lblProprietrio = new GridBagConstraints();
			gbc_lblProprietrio.anchor = GridBagConstraints.SOUTHEAST;
			gbc_lblProprietrio.insets = new Insets(0, 0, 5, 5);
			gbc_lblProprietrio.gridx = 0;
			gbc_lblProprietrio.gridy = 2;
			contentPanel.add(lblProprietrio, gbc_lblProprietrio);
		}
		{
			proprietarioCBox = new JComboBox();
			GridBagConstraints gbc_proprietarioCBox = new GridBagConstraints();
			gbc_proprietarioCBox.anchor = GridBagConstraints.SOUTH;
			gbc_proprietarioCBox.insets = new Insets(0, 0, 5, 0);
			gbc_proprietarioCBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_proprietarioCBox.gridx = 1;
			gbc_proprietarioCBox.gridy = 2;
			contentPanel.add(proprietarioCBox, gbc_proprietarioCBox);
		}
		{
			JLabel lblVeculo = new JLabel("Placa:");
			GridBagConstraints gbc_lblVeculo = new GridBagConstraints();
			gbc_lblVeculo.anchor = GridBagConstraints.SOUTHEAST;
			gbc_lblVeculo.insets = new Insets(0, 0, 0, 5);
			gbc_lblVeculo.gridx = 0;
			gbc_lblVeculo.gridy = 3;
			contentPanel.add(lblVeculo, gbc_lblVeculo);
		}
		{
			placaCBox = new JComboBox();
			GridBagConstraints gbc_placaCBox = new GridBagConstraints();
			gbc_placaCBox.anchor = GridBagConstraints.SOUTH;
			gbc_placaCBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_placaCBox.gridx = 1;
			gbc_placaCBox.gridy = 3;
			contentPanel.add(placaCBox, gbc_placaCBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		Controller.ControllerRegEntrada controller = new Controller.ControllerRegEntrada(this);
	}

	public JComboBox getPlacaCBox() {
		return placaCBox;
	}

	public JComboBox getProprietarioCBox() {
		return proprietarioCBox;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}
}
