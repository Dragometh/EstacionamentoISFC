package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import Model.Log;
import Model.Proprietario;
import View.TelaVerModel;

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
		tela.getBtnZerarEntradas().addActionListener(this);
		
		loadTable();
	}
	
	private javax.swing.JMenuItem menuBarHandler(int menu, int item) {
		return tela.getJMenuBar().getMenu(menu).getItem(item);
	}
	
	private void loadTable() {
		javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		String col[] = {"Propriet\u00E1rio", "Placa", "Hor\u00E1rio de entrada"};
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		for (int i = 0; i < col.length; i++) {
			tableModel.addColumn(col[i]);
		}
		
		ArrayList<Log> list = Service.ServiceLog.Retrieve();
		ArrayList<Log> entradaList = new ArrayList<Log>();
		
		for (Log l: list) {
			if (l.getTipo().equals("Entrada")) {
				entradaList.add(l);
			}
		}
		
		for (Log l: entradaList) {
			String dono = l.getCarro().getProprietario().getNome();
			String placa = l.getCarro().getPlaca();
			String tempo = l.getTempo().format(formatter);
			
			Object[] dados = {dono, placa, tempo};
			System.out.println (dados.toString());
			tableModel.addRow(dados);
		}
		
		tela.getLogTable().setModel(tableModel);
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
			View.TelaVerModel verProprietarios = new View.TelaVerModel("VerProprietario");
		} else if (e.getSource() == menuBarHandler(0,1)) {
			View.TelaVerModel verMarca = new View.TelaVerModel("VerMarca");
		} else if (e.getSource() == menuBarHandler(0,2)) {
			View.TelaVerModel verUser = new View.TelaVerModel("VerUsuario");
		}else if (e.getSource() == menuBarHandler(0,3)) {
			View.TelaVerModel verCarro = new View.TelaVerModel("VerCarro");
		} else if (e.getSource() == menuBarHandler(1,0)) {
			View.TelaCadProprietario cadPropr = new View.TelaCadProprietario();
		} else if (e.getSource() == menuBarHandler(1,1)) {
			View.TelaCadMarcas cadMarca = new View.TelaCadMarcas();
		} else if (e.getSource() == menuBarHandler(1,2)) {
			View.TelaCadUser cadUser = new View.TelaCadUser();
		} else if (e.getSource() == tela.getBtnRegistrarEntrada()) {
			View.TelaRegEntrada dialogRegistrarEntrada = new View.TelaRegEntrada();
			loadTable();
		} else if (e.getSource() == tela.getBtnRegistrarSaida()) {
			//Registro de Saidas
		} else if (e.getSource() == tela.getBtnZerarEntradas()) {
			Service.ServiceLog.Clear();
		}
		
	}
}
