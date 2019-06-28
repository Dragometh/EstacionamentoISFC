package Controller;

import View.TelaLogin;
import View.TelaMenuPrinc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

import Model.UsrSys;

public class ControllerLogin implements ActionListener {
	private TelaLogin tela;

	public ControllerLogin(TelaLogin telaLogin) {
		super();
		this.tela = telaLogin;
		this.tela.setTitle("Login");
		
		tela.pack();
		telaLogin.setVisible(true);
		telaLogin.getBtnConfirm().addActionListener(this);
		telaLogin.getPasswordField().addActionListener(this);
		telaLogin.getUserField().addActionListener(this);
	}

	private void confirmLogin() {
		try {
			String username = this.tela.getUserField().getText();
			char[] password = this.tela.getPasswordField().getPassword();
			boolean userConfirmed = false;
			boolean passwordConfirmed = false;
			
			if (username.length() == 0 || password.length == 0) {
				JOptionPane.showMessageDialog(null, "Usuario e/ou senha em branco!");
			} else {
				for (UsrSys u : Service.ServiceUsers.Retrieve()) {
					if (u.getUsername().equals(username)) {
						userConfirmed = true;
						if (Arrays.equals(u.getPassword().toCharArray(), password)) {
							passwordConfirmed = true;
						}
						break;
					}
				}
				
				if (userConfirmed) {
					if (passwordConfirmed) {
						TelaMenuPrinc telaMenuP = new TelaMenuPrinc();
						tela.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Senha invalida!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Usuario invalido!");
				}
				
			}
		} catch(NullPointerException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.tela.getBtnConfirm()) {
			confirmLogin();
		} else if (e.getSource() == this.tela.getPasswordField()) {
			confirmLogin();
		} else if (e.getSource() == this.tela.getUserField()) {
			tela.getPasswordField().requestFocus();
		}
	}
}
