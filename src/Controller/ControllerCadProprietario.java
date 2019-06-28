package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import Model.Marca;
import Model.Modelo;
import Model.Versao;

public class ControllerCadProprietario implements ActionListener {
	private View.TelaCadProprietario tela;
	private javax.swing.ButtonGroup bGroup = new javax.swing.ButtonGroup();
	
	public ControllerCadProprietario(View.TelaCadProprietario tela) {
		super();
		this.tela = tela;
		tela.setVisible(true);
		tela.pack();
		tela.setTitle("Registro de Proprietarios e Veiculos");
		tela.getModeloCBox().setEnabled(false);
		tela.getVersaoCBox().setEnabled(false);
		
		ArrayList<Marca> temp = Service.ServiceMarcas.Retrieve();
		temp.add(0, new Marca("Selecionar marca", null));
		Marca[] marcasList = new Marca[temp.size()];
		marcasList = temp.toArray(marcasList);
		tela.getMarcaCBox().setModel(new DefaultComboBoxModel<Marca>(marcasList));
		
		bGroup.add(tela.getRdbtnNovoVeiculo());
		bGroup.add(tela.getRdbtnVeiculoExistente());
		
		tela.getRdbtnNovoVeiculo().setSelected(true);
		tela.getCardLayout().show(tela.getPanelCards(), "Novos");
		
		tela.getRdbtnNovoVeiculo().addActionListener(this);
		tela.getRdbtnVeiculoExistente().addActionListener(this);
		tela.getBtnRegistrar().addActionListener(this);
		tela.getBtnSair().addActionListener(this);
		tela.getMarcaCBox().addActionListener(this);
		tela.getModeloCBox().addActionListener(this);
		tela.getVersaoCBox().addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == tela.getRdbtnNovoVeiculo()) {	
			tela.getCardLayout().show(tela.getPanelCards(), "Novos");
		} else if (ev.getSource() == tela.getRdbtnVeiculoExistente()) {
			tela.getCardLayout().show(tela.getPanelCards(), "Existentes");
		} else if (ev.getSource() == tela.getBtnSair()) {
			tela.dispose();
		} else if (ev.getSource() == tela.getMarcaCBox()) {
			Marca marcaSelec = (Marca) tela.getMarcaCBox().getSelectedItem();
			Modelo[] modelosList = null;
			
			if (marcaSelec.getListaModelos() != null) {
				tela.getModeloCBox().setEnabled(true);
				ArrayList<Modelo> temp = marcaSelec.getListaModelos();
				temp.add(0, new Modelo("Selecionar Modelo", null, null));
				modelosList = new Modelo[temp.size()];
				modelosList = temp.toArray(modelosList);
				tela.getModeloCBox().setModel(new DefaultComboBoxModel<Modelo>(modelosList));
			}
		} else if (ev.getSource() == tela.getModeloCBox()) {
			Modelo modeloSelec = (Modelo) tela.getModeloCBox().getSelectedItem();
			Versao[] versaoList = null;
			
			if (modeloSelec.getListaVersoes() != null) {
				tela.getVersaoCBox().setEnabled(true);
				ArrayList<Versao> temp = modeloSelec.getListaVersoes();
				temp.add(0, new Versao("Selecionar Modelo", null, null, null));
				versaoList = new Versao[temp.size()];
				versaoList = temp.toArray(versaoList);
				tela.getVersaoCBox().setModel(new DefaultComboBoxModel<Versao>(versaoList));
			}
		}
	}
}
