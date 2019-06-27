package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import Model.UsrSys;
import View.TelaCadUser;

public class ControllerCadUser implements ActionListener{
	private TelaCadUser tela;
	private DefaultFormatterFactory formatadorCpfFactory;
	private DefaultFormatterFactory formatadorRgFactory;
	private DefaultFormatterFactory formatadorFoneFactory;
	
	public ControllerCadUser(TelaCadUser tela) {
		super();
		this.tela = tela;
		tela.setVisible(true);
		
		//Adição de ActionListeners
		tela.getBtnCancelar().addActionListener(this);
		tela.getBtnRegistrar().addActionListener(this);
		tela.getBtnLimpar().addActionListener(this);
		
		// Logica para formatação de campos numéricos
		MaskFormatter formatadorCpf;
		MaskFormatter formatadorRg;
		MaskFormatter formatadorFone;
		try {
			formatadorCpf = new MaskFormatter("###.###.###-##");
			formatadorCpf.setValidCharacters("0123456789");
			formatadorCpf.setCommitsOnValidEdit(true);
			formatadorCpf.setPlaceholderCharacter('_');
			formatadorCpf.setValueContainsLiteralCharacters(false);
			formatadorCpfFactory = new DefaultFormatterFactory(formatadorCpf);
			
			// TODO: RG possui formatos diferentes entre estados. Procurar um workaround decente para este problema.
			formatadorRg = new MaskFormatter("###.###.###-##");
			formatadorRg.setValidCharacters("0123456789");;
			formatadorRg.setCommitsOnValidEdit(true);
			formatadorRg.setPlaceholderCharacter('_');
			formatadorRg.setValueContainsLiteralCharacters(false);
			formatadorRgFactory = new DefaultFormatterFactory(formatadorRg);
			
			formatadorFone = new MaskFormatter("#####-####");
			formatadorFone.setValidCharacters("0123456789");
			formatadorFone.setCommitsOnValidEdit(true);
			formatadorFone.setPlaceholderCharacter('_');
			formatadorFone.setValueContainsLiteralCharacters(false);
			formatadorFoneFactory = new DefaultFormatterFactory(formatadorFone);
			
			tela.getCpfField().setFormatterFactory(formatadorCpfFactory);
			tela.getRgField().setFormatterFactory(formatadorRgFactory);
			tela.getFoneField().setFormatterFactory(formatadorFoneFactory);
		} catch (Exception e) {
			System.err.println("ERRO: " + e.getMessage());
		}
			
	}
	
	private void Registrar() {
		UsrSys u = new UsrSys();
		boolean usuariosValidos = true;
		boolean senhasValidas = false;
		boolean camposEmBranco = false;
		
		try {

			tela.getFoneField().commitEdit();
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		
		// Detecção de campos em branco
		switch(0) {
			case 0:
				if (!tela.getUserField().getText().isEmpty()) {
					u.setUsername(tela.getUserField().getText());
				} else {
					System.out.println("Campos em branco!");
					camposEmBranco = true;
					break;
				}
			case 1:
				if (!tela.getNomeField().getText().isEmpty()) {
					u.setNome(tela.getNomeField().getText());
				} else {
					System.out.println("Campos em branco!");
					camposEmBranco = true;
					break;
				}
			case 2:
				if (tela.getRgField().getValue() != null) {
					try {
						tela.getRgField().commitEdit();
						u.setRg(Long.parseLong((String) tela.getRgField().getValue()));
						System.out.println(u.getRg());
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Campo do RG deve ser completamente preenchido!");
						e.printStackTrace();
						break;
					}
				} else {
					System.out.println("Campos em branco!");
					camposEmBranco = true;
					break;
				}
			case 3:
				if (tela.getCpfField().getValue() != null) {
					try {
						tela.getCpfField().commitEdit();
						u.setCpf(Long.parseLong((String) tela.getCpfField().getValue()));
						System.out.println(u.getCpf());
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Campo do CPF deve ser completamente preenchido!");
						e.printStackTrace();
						break;
					}
				} else {
					System.out.println("Campos em branco!");
					camposEmBranco = true;
					break;
				}
			case 4:
				if (tela.getFoneField().getValue() != null) {
					try {
						u.setFone(Long.parseLong((String) tela.getFoneField().getValue()));
						System.out.println(u.getFone());
					} catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Campo do Telefone deve ser completamente preenchido!");
						e.printStackTrace();
						break;
					}
					break;
				} else {
					System.out.println("Campos em branco!");
					camposEmBranco = true;
					break;
				}
		}
			
		if (!camposEmBranco) {
			// Confere a senha
			if (Arrays.equals(tela.getPasswordField().getPassword(), tela.getConfirmPassField().getPassword())) {
				u.setPassword(String.valueOf(tela.getPasswordField().getPassword()));
				senhasValidas = true;
			}
			for(UsrSys usr : Service.ServiceUsers.Retrieve()) {
				if (u.getUsername().equals(usr.getUsername())) {
					usuariosValidos = false;
					break;
				}
			}
			if (usuariosValidos && senhasValidas) {
				JOptionPane.showMessageDialog(null, "Usuario criado com sucesso!");
				Service.ServiceUsers.Create(u);
				Limpar();
			} else if (!usuariosValidos) {
				JOptionPane.showMessageDialog(null, "Nome de usuario já existe!");
				tela.getPasswordField().setText("");
				tela.getConfirmPassField().setText("");
			} else if (!senhasValidas) {
				JOptionPane.showMessageDialog(null, "As senhas não conferem!");
				tela.getPasswordField().setText("");
				tela.getConfirmPassField().setText("");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Há campos em branco!");
		}
	}
	
	private void Limpar() {
		tela.getUserField().setText("");
		tela.getPasswordField().setText("");
		tela.getConfirmPassField().setText("");
		tela.getRgField().setValue(null);
		tela.getCpfField().setValue(null);
		tela.getNomeField().setText("");
		tela.getFoneField().setValue(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tela.getBtnRegistrar()) {
			Registrar();
		} else if (e.getSource() == tela.getBtnLimpar()) {
			Limpar();
		} else if (e.getSource() == tela.getBtnCancelar()) {
			tela.dispose();
		}
	}
}
