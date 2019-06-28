package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import Model.Categoria;
import Model.Marca;
import Model.Modelo;
import Model.Versao;
import View.TelaCadMarcas;

public class ControllerCadMarcas implements ActionListener{
	private TelaCadMarcas tela;

	public ControllerCadMarcas(TelaCadMarcas tela) {
		super();
		this.tela = tela;
		tela.setVisible(true);
		tela.setTitle("Cadastro de Modelos, Marcas e Versoes");
		
		tela.getBtnMarcasRegistrar().addActionListener(this);
		tela.getBtnModelosRegistrar().addActionListener(this);
		tela.getBtnVersoesRegistrar().addActionListener(this);
		tela.getBtnMarcas().addActionListener(this);
		tela.getBtnModelos().addActionListener(this);
		tela.getBtnVersoes().addActionListener(this);
		tela.getVersoesMarcaCBox().addActionListener(this);
		
	}

	private void Registrar(String classe) {
		switch(classe) {
		case "Marca":
			if (!tela.getMarcasNomeField().getText().isEmpty()) {
				boolean marcaNomeInvalido = false;
				Marca marca = new Marca();
				
				marca.setFabricante(tela.getMarcasNomeField().getText());
				marca.setListaModelos(new ArrayList<Modelo>());
				
				for (Marca m : Service.ServiceMarcas.Retrieve()) {
					if (m.getFabricante().equals(marca.getFabricante())) {
						marcaNomeInvalido = true;
					}
				}
				
				if (!marcaNomeInvalido) {
					Service.ServiceMarcas.Create(marca);
				} else {
					JOptionPane.showMessageDialog(null, "Marca já está registrada!");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Há campos em branco/não selecionados!");
			}
			
			
			
			break;
		case "Modelo":
			if (!tela.getModeloNomeField().getText().isEmpty() 
			&& tela.getModelosMarcaCBox().getSelectedItem() != tela.getModelosMarcaCBox().getItemAt(0)) {
				boolean modeloNomeInvalido = false;
				Modelo modelo = new Modelo();
				
				modelo.setFabricante((Marca)tela.getModelosMarcaCBox().getSelectedItem());
				modelo.setNome(tela.getModeloNomeField().getText());
				modelo.setListaVersoes(new ArrayList<Versao>());
				
				for (Modelo m: Service.ServiceModelos.Retrieve()) {
					if (m.getNome().equals(modelo.getNome()) && m.getFabricante().equals(modelo.getFabricante())) {
						modeloNomeInvalido = true;
						break;
					}
				}
				
				System.out.println(modeloNomeInvalido);
				System.out.println(modelo.getFabricante());
				System.out.println(modelo.getNome());
				
				if (!modeloNomeInvalido) {
					Marca fabric = (Marca) tela.getModelosMarcaCBox().getSelectedItem();
					fabric.getListaModelos().add(modelo);
					for (Marca m : Service.ServiceMarcas.Retrieve()) {
						if (m.getFabricante().equals(fabric.getFabricante())) {
							System.out.println("Marca m: " + m.getFabricante() + "\nMarca fabric: " + fabric.getFabricante());
							Service.ServiceMarcas.Update(tela.getModelosMarcaCBox().getSelectedIndex() - 1, fabric); // -1 devido ao index = 0("Selecionar X") adicionado aos ComboBoxes.
							break;
						}
					}
					Service.ServiceModelos.Create(modelo);
				} else {
					JOptionPane.showMessageDialog(null, "Modelo já está registrado dentro dessa marca!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Há campos em branco/não selecionados!");
			}
			
			break;
		case "Versao":
			if (!tela.getVersaoNomeField().getText().isEmpty()
			&& tela.getVersoesMarcaCBox().getSelectedItem() != tela.getVersoesMarcaCBox().getItemAt(0)
			&& tela.getVersoesModeloCBox().getSelectedItem() != tela.getVersoesModeloCBox().getItemAt(0)
			&& !tela.getVersoesCarroceriaCBox().getSelectedItem().equals(tela.getVersoesCarroceriaCBox().getItemAt(0))  
			&& !tela.getVersoesClasseCBox().getSelectedItem().equals(tela.getVersoesClasseCBox().getItemAt(0))){
				boolean versaoNomeInvalido = false;
				Versao versao = new Versao();
				
				versao.setNome(tela.getVersaoNomeField().getText());
				versao.setFabricante((Marca)tela.getVersoesMarcaCBox().getSelectedItem());
				versao.setModelo((Modelo)tela.getVersoesModeloCBox().getSelectedItem());
				versao.setCategoria(Service.ServiceCategorias.Retrieve((String)tela.getVersoesCarroceriaCBox().getSelectedItem(),(String) tela.getVersoesClasseCBox().getSelectedItem()));
				
				for (Versao v: Service.ServiceVersoes.Retrieve()) {
					if (v.getNome().equals(versao.getNome()) && v.getModelo().equals(versao.getModelo())) {
						versaoNomeInvalido = true;
						break;
					}
				}
				
				if (!versaoNomeInvalido) {
					Modelo modelo = (Modelo) tela.getVersoesModeloCBox().getSelectedItem();
					modelo.getListaVersoes().add(versao);
					for (Modelo m : Service.ServiceModelos.Retrieve()) {
						if (m.getNome().equals(modelo.getNome())) {
							System.out.println("Modelo m: " + m.getNome() + "\nModelo modelo: " + modelo.getNome());
							Service.ServiceModelos.Update(tela.getVersoesModeloCBox().getSelectedIndex() - 1, modelo); // -1 devido ao index = 0("Selecionar X") adicionado aos ComboBoxes.
							break;
						}
					}
					
					for (Marca ma: Service.ServiceMarcas.Retrieve()) {
						for (Modelo mo: ma.getListaModelos()) {
							System.out.println(ma.getListaModelos().toString());
							if (mo.getNome().equals(modelo.getNome())) {
								ma.getListaModelos().set(ma.getListaModelos().indexOf(mo), modelo);
								Service.ServiceMarcas.Update(tela.getVersoesMarcaCBox().getSelectedIndex() - 1, ma);
								System.out.println(ma.getListaModelos().toString());
								break;
							}
						}
					}
					Service.ServiceVersoes.Create(versao);
				} else {
					JOptionPane.showMessageDialog(null, "Essa versao já está registrada dentro desse modelo!");
				} 
				break;
			} else {
				JOptionPane.showMessageDialog(null, "Há campos em branco/não selecionados!");
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tela.getBtnMarcasRegistrar()) {
			Registrar("Marca");
			
		} else if (e.getSource() == tela.getBtnModelosRegistrar()) {
			Registrar("Modelo");
			
		} else if (e.getSource() == tela.getBtnVersoesRegistrar()) {
			Registrar("Versao");
			
		} else if (e.getSource() == tela.getBtnMarcas()) {
			tela.getCards().show(tela.getCardPanels(),"Marcas");
			
		} else if (e.getSource() == tela.getBtnModelos()) {
			ArrayList<Marca> temp = Service.ServiceMarcas.Retrieve();
			temp.add(0, new Marca("Selecionar marca", null));
			Marca[] marcasList = new Marca[temp.size()];
			marcasList = temp.toArray(marcasList);
			tela.getModelosMarcaCBox().setModel(new DefaultComboBoxModel<Marca>(marcasList));
			tela.getCards().show(tela.getCardPanels(),"Modelos");
			
		} else if (e.getSource() == tela.getBtnVersoes()) {
			ArrayList<String> catCarrAux = new ArrayList<String>();
			ArrayList<String> catClassAux = new ArrayList<String>();
			
			catCarrAux.add(0, "Selecionar Carroceria");
			catClassAux.add(0, "Selecionar Classe da Carroceria");
			
			for (Categoria c : Service.ServiceCategorias.Retrieve()) {
				if(!catCarrAux.contains(c.getCarroceria())) {
					catCarrAux.add(c.getCarroceria());	
				}
				if (!catClassAux.contains(c.getClasse())) {
					catClassAux.add(c.getClasse());
				}
			}
			
			String[] catCarrList = new String[catCarrAux.size()];
			catCarrList = catCarrAux.toArray(catCarrList);
			
			String[] catClassList = new String[catClassAux.size()];
			catClassList = catClassAux.toArray(catClassList);
			
			Marca[] marcasList2 = new Marca[Service.ServiceMarcas.Retrieve().size()];
			ArrayList<Marca> temp = Service.ServiceMarcas.Retrieve();
			temp.add(0, new Marca("Selecionar marca", null));
			marcasList2 = temp.toArray(marcasList2);
			
			tela.getCards().show(tela.getCardPanels(),"Versoes");
			
			tela.getVersoesMarcaCBox().setModel(new DefaultComboBoxModel<Marca>(marcasList2));
			tela.getVersoesModeloCBox().setEnabled(false);
			tela.getVersoesMarcaCBox().setSelectedIndex(0);
			tela.getVersoesCarroceriaCBox().setModel(new DefaultComboBoxModel<String>(catCarrList));
			tela.getVersoesCarroceriaCBox().setSelectedIndex(0);
			tela.getVersoesClasseCBox().setModel(new DefaultComboBoxModel<String>(catClassList));
			tela.getVersoesClasseCBox().setSelectedIndex(0);

		} else if (e.getSource() == tela.getVersoesMarcaCBox()) {
			Marca marcaSelec = (Marca) tela.getVersoesMarcaCBox().getSelectedItem();
			Modelo[] modelosList2 = null;
			
			if (marcaSelec.getListaModelos() != null) {
				tela.getVersoesModeloCBox().setEnabled(true);
				modelosList2 = new Modelo[marcaSelec.getListaModelos().size()];
				ArrayList<Modelo> temp = marcaSelec.getListaModelos();
				temp.add(0, new Modelo("Selecionar Modelo", null, null));
				modelosList2 = temp.toArray(modelosList2);
				tela.getVersoesModeloCBox().setModel(new DefaultComboBoxModel<Modelo>(modelosList2));
			}
		}
	}
}
