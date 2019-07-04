package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JOptionPane;

import Model.UsrSys;
import View.TelaCadUser;

public class ControllerCadUser implements ActionListener{
	private TelaCadUser tela;
	
	public ControllerCadUser(TelaCadUser tela) {
		super();
		this.tela = tela;
		tela.setVisible(true);
		tela.pack();
		tela.setTitle("Cadastro de Usuarios");
		
		//Adição de ActionListeners
		tela.getBtnRegistrar().addActionListener(this);
		tela.getBtnLimpar().addActionListener(this);
		
		Service.Format.setFormatoCpf(tela.getCpfField());
		Service.Format.setFormatoFone(tela.getFoneField());
		Service.Format.setFormatoRg(tela.getRgField());
	}
	
	private void Registrar() {
		UsrSys u = new UsrSys();
		boolean usuariosValidos = true;
		boolean senhasValidas = false;
		boolean camposEmBranco = false;
		
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
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Campo do RG deve ser completamente preenchido!");
						camposEmBranco = true;
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
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Campo do CPF deve ser completamente preenchido!");
						camposEmBranco = true;
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
						tela.getFoneField().commitEdit();
						u.setFone(Long.parseLong((String) tela.getFoneField().getValue()));
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Campo do Telefone deve ser completamente preenchido!");
						camposEmBranco = true;
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
			JOptionPane.showMessageDialog(null, "H\u00E1 campos em branco!");
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
		}
	}
}
