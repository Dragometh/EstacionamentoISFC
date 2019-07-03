package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerMenuPrinc implements ActionListener {
	private View.TelaMenuPrinc tela;
	
	public ControllerMenuPrinc(View.TelaMenuPrinc tela) {
		this.tela = tela;
		
		tela.pack();
		tela.setVisible(true);
		this.tela.setTitle("Menu principal");
		
		//Adicao de ActionListeners
		for(int i = 0; i < tela.getJMenuBar().getMenuCount(); i++) {
			for (int j = 0; j < tela.getJMenuBar().getMenu(i).getItemCount(); j++) {
				tela.getJMenuBar().getMenu(i).getItem(j).addActionListener(this);
			}
		}
		tela.getBtnRegistrarEntrada().addActionListener(this);
		tela.getBtnRegistrarSaida().addActionListener(this);
	}
	
	private javax.swing.JMenuItem menuBarHandler(int menu, int item) {
		return tela.getJMenuBar().getMenu(menu).getItem(item);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/** Sobre os itens do JMenuBar:
		 * getMenu(i) -> i = 0 = mnDados; i = 1 = mnRegistrar
		 * getMenu(i).getItem(j) -> para qualquer x (exceto VerCarros);
		 * j = 0 = mntn(Ver/Registrar)Proprietarios
		 * j = 1 = mntn(Ver/Registrar)Marcas
		 * j = 2 = mntn(Ver/Registrar)Usuarios
		 * i = 0; j = 3 = mntnVerCarros
		 */
		
		
		
		if (e.getSource() == menuBarHandler(0,0)) { 
			//mntnVerProprietarios
		} else if (e.getSource() == menuBarHandler(0,1)) {
			//mntnVerMarcas
		} else if (e.getSource() == menuBarHandler(0,2)) {
			//mntnVerUsuarios
		}else if (e.getSource() == menuBarHandler(0,3)) {
			View.TelaVerModel verCarro = new View.TelaVerModel("VerCarro");
		} else if (e.getSource() == menuBarHandler(1,0)) {
			View.TelaCadProprietario cadPropr = new View.TelaCadProprietario();
		} else if (e.getSource() == menuBarHandler(1,1)) {
			View.TelaCadMarcas cadMarca = new View.TelaCadMarcas();
		} else if (e.getSource() == menuBarHandler(1,2)) {
			View.TelaCadUser cadUser = new View.TelaCadUser();
		} else if (e.getSource() == tela.getBtnRegistrarEntrada()) {
			//Registro de Entradas
		} else if (e.getSource() == tela.getBtnRegistrarSaida()) {
			//Registro de Saidas
		}
		
	}
}
