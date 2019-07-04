package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import Model.Marca;
import Model.Modelo;
import Model.Versao;
import Model.Proprietario;
import Model.Carro;

public class ControllerAlterarModel implements ActionListener {
	private View.TelaAlterarModel tela;
	private String card;
	private Carro carroSelec;
	private Proprietario proprietarioSelec;
	private Marca marcaSelec;
	
	public ControllerAlterarModel(View.TelaAlterarModel tela, String card, Carro carroSelec) {
		super();
		this.carroSelec = carroSelec;
		init(tela, card);
	}
	
	public ControllerAlterarModel(View.TelaAlterarModel tela, String card, Proprietario proprietarioSelec) {
		super();
		this.proprietarioSelec = proprietarioSelec;
		init(tela, card);
	}
	
	public ControllerAlterarModel(View.TelaAlterarModel tela, String card, Marca marcaSelec) {
		super();
		this.marcaSelec = marcaSelec;
		init(tela, card);
	}
	
	private void init(View.TelaAlterarModel tela, String card) {
		this.tela = tela;
		this.card = card;
		tela.setVisible(true);
		tela.getCards().show(tela.getContentPane(), card);
		load();
	}
	
	private void load() {
		if (card == "AlterarCarro") {
			Service.Format.setFormatoPlaca(tela.getCarroPlacaField());
			
			Marca marcaSelec = carroSelec.getVersao().getModelo().getFabricante();
			Modelo modeloSelec = carroSelec.getVersao().getModelo();
			
			//Inicializando ComboBox de Marcas;
			ArrayList<Marca> temp = Service.ServiceMarcas.Retrieve();
			temp.add(0, new Marca("Selecionar marca", null));
			Marca[] marcasList = new Marca[temp.size()];
			marcasList = temp.toArray(marcasList);
			tela.getCarroMarcaCBox().setModel(new DefaultComboBoxModel<Marca>(marcasList));
			
			// Inicializando ComboBox de Modelos;
			Modelo[] modelosList = new Modelo[marcaSelec.getListaModelos().size()];
			ArrayList<Modelo> temp2 = marcaSelec.getListaModelos();
			temp2.add(0, new Modelo("Selecionar Modelo", null, null));
			modelosList = temp2.toArray(modelosList);
			tela.getCarroModeloCBox().setModel(new DefaultComboBoxModel<Modelo>(modelosList));
			
			// Inicializando ComboBox de Versao;
			Versao[] versaoList = new Versao[modeloSelec.getListaVersoes().size()];
			ArrayList<Versao> temp3 = modeloSelec.getListaVersoes();
			temp3.add(0, new Versao("Selecionar Versao", null, null, null));
			versaoList = temp3.toArray(versaoList);
			tela.getCarroVersaoCBox().setModel(new DefaultComboBoxModel<Versao>(versaoList));
			
			// BUG: Marca nao esta sendo selecionada no startup da tela.
			tela.getCarroMarcaCBox().setSelectedItem(marcaSelec);
			tela.getCarroModeloCBox().setSelectedItem(modeloSelec);
			tela.getCarroVersaoCBox().setSelectedItem(carroSelec.getVersao());
			tela.getCarroProprietario().setText(carroSelec.getProprietario().getNome());
			tela.getCarroCorField().setText(carroSelec.getCor());
			tela.getCarroPlacaField().setValue(carroSelec.getPlaca());

			tela.getCarroMarcaCBox().addActionListener(this);
			tela.getCarroModeloCBox().addActionListener(this);
			
			tela.getCarroConfirmar().addActionListener(this);
			tela.getCarroAlterarProprietario().addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (card == "AlterarCarro") {
			if (e.getSource() == tela.getCarroMarcaCBox()) {
				Marca marcaSelec = (Marca) tela.getCarroMarcaCBox().getSelectedItem();
				Modelo[] modelosList = null;
				if (tela.getCarroModeloCBox().isEnabled()) {
					tela.getCarroModeloCBox().setSelectedIndex(0);
					tela.getCarroModeloCBox().setEnabled(false);
				}
				
				if (marcaSelec.getListaModelos() != null) {
					if (marcaSelec.getListaModelos().get(0).toString() == "Selecionar Modelo") {
						marcaSelec.getListaModelos().remove(0);
					}
					
					if (tela.getCarroVersaoCBox().isEnabled()) {
						tela.getCarroVersaoCBox().setSelectedIndex(0);
						tela.getCarroVersaoCBox().setEnabled(false);
					}
					tela.getCarroModeloCBox().setEnabled(true);
					modelosList = new Modelo[marcaSelec.getListaModelos().size()];
					ArrayList<Modelo> temp = marcaSelec.getListaModelos();
					temp.add(0, new Modelo("Selecionar Modelo", null, null));
					modelosList = temp.toArray(modelosList);
					tela.getCarroModeloCBox().setModel(new DefaultComboBoxModel<Modelo>(modelosList));
				}
			} else if (e.getSource() == tela.getCarroModeloCBox()) {
				Modelo modeloSelec = (Modelo) tela.getCarroModeloCBox().getSelectedItem();
				Versao[] versaoList = null;
				if (tela.getCarroVersaoCBox().isEnabled()) {
					tela.getCarroVersaoCBox().setSelectedIndex(0);
					tela.getCarroVersaoCBox().setEnabled(false);
				}
				
				if (modeloSelec.getListaVersoes() != null) {
					if (modeloSelec.getListaVersoes().get(0).toString() == "Selecionar Versao") {
						modeloSelec.getListaVersoes().remove(0);
					}
					
					tela.getCarroVersaoCBox().setEnabled(true);
					versaoList = new Versao[modeloSelec.getListaVersoes().size()];
					ArrayList<Versao> temp = modeloSelec.getListaVersoes();
					temp.add(0, new Versao("Selecionar Versao", null, null, null));
					versaoList = temp.toArray(versaoList);
					tela.getCarroVersaoCBox().setModel(new DefaultComboBoxModel<Versao>(versaoList));
				}
			} else if (e.getSource() == tela.getCarroConfirmar()) {
				Carro carroUpdate = new Carro();
				carroUpdate.setProprietario(carroSelec.getProprietario());
				boolean camposEmBranco = false;
				boolean infoValida = true;
				
				switch(0) {
					case 0:
						if (tela.getCarroVersaoCBox().getSelectedItem() != tela.getCarroVersaoCBox().getItemAt(0)) {
							carroUpdate.setVersao((Versao)tela.getCarroVersaoCBox().getSelectedItem());
						} else {
							System.out.println("H\u00E1 campos em branco\u00E3 selecionados!");
							camposEmBranco = true;
							break;
						}
					case 1:
						if (tela.getCarroPlacaField().getValue() != null) {
							carroUpdate.setPlaca((String) tela.getCarroPlacaField().getValue());
						} else {
							System.out.println("H\u00E1 campos em branco\u00E3 selecionados!");
							camposEmBranco = true;
							break;
						}
					case 2:
						if (!tela.getCarroCorField().getText().isEmpty()) {
							carroUpdate.setCor(tela.getCarroCorField().getText());
						} else {
							System.out.println("H\u00E1 campos em branco\u00E3 selecionados!");
							camposEmBranco = true;
							break;
						}
				}
				if (!camposEmBranco) {
					int id = -1;
					ArrayList<Carro> list = Service.ServiceCarros.Retrieve();
					
					for (Carro c : list) {
						if (c.getProprietario().getNome().equals(carroSelec.getProprietario().getNome())) {
							id = list.indexOf(c);
						}
					}
					Service.ServiceCarros.Update(id, carroUpdate);
				} else {
					JOptionPane.showMessageDialog(null, "H\u00E1 campos em branco/n\u00E3o selecionados!");
				}
				
			} else if (e.getSource() == tela.getCarroAlterarProprietario()) {
				
			}
		}
	}
}
