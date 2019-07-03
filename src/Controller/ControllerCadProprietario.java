package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import Model.Marca;
import Model.Modelo;
import Model.Versao;

public class ControllerCadProprietario implements ActionListener {
	private View.TelaCadProprietario tela;
	
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
		
		tela.getBtnRegistrar().addActionListener(this);
		tela.getMarcaCBox().addActionListener(this);
		tela.getModeloCBox().addActionListener(this);
		tela.getVersaoCBox().addActionListener(this);
		
		Service.Format.setFormatoCpf(tela.getFieldCpf());
		Service.Format.setFormatoFone(tela.getFieldFone());
		Service.Format.setFormatoRg(tela.getFieldRg());
		Service.Format.setFormatoPlaca(tela.getFieldPlaca());
	}
	/**
	public <E, T> void CBoxHandler(javax.swing.JComboBox<E> cBox, ArrayList<E> list, String methodToCall) {
		E selec = (E) cBox.getSelectedItem();
		
		T[] array = null;
		
		cBox.setEnabled(true);
		try {
			java.lang.reflect.Method method = selec.getClass().getMethod(methodToCall, selec.getClass());
			ArrayList<T> temp = (ArrayList<T>) method.invoke(selec);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	**/
	private void Registrar() {
		Model.Proprietario p = new Model.Proprietario();
		Model.Carro v = new Model.Carro();
		boolean infoValida = true;
		boolean camposEmBranco = false;
		
		switch(0) {
			case 0:
				if (!tela.getFieldNome().getText().isEmpty()) {
					p.setNome(tela.getFieldNome().getText());
				} else {
					System.out.println("H� campos do propriet�rio em branco!");
					camposEmBranco = true;
					break;
				}
			case 1:		
				if (tela.getFieldCpf().getValue() != null) {
					try {
						tela.getFieldCpf().commitEdit();
						p.setCpf(Long.parseLong((String)tela.getFieldCpf().getValue()));
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Campo do CPF deve ser completamente preenchido!");
						camposEmBranco = true;
						e.printStackTrace();
						break;
					}
				} else {
					System.out.println("H� campos do propriet�rio em branco!");
					camposEmBranco = true;
					break;
				}
			case 2:
				if (tela.getFieldFone().getValue() != null) {
					try {
						tela.getFieldFone().commitEdit();
						p.setFone(Long.parseLong((String)tela.getFieldFone().getValue()));
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Campo do Telefone deve ser completamente preenchido!");
						camposEmBranco = true;
						e.printStackTrace();
						break;
					}
				} else {
					System.out.println("H� campos do propriet�rio em branco!");
					camposEmBranco = true;
					break;
				}
			case 3:	
				if (tela.getFieldRg().getValue() != null) {
					try {
						tela.getFieldRg().commitEdit();
						p.setRg(Long.parseLong((String)tela.getFieldRg().getValue()));
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Campo do RG deve ser completamente preenchido!");
						camposEmBranco = true;
						e.printStackTrace();
						break;
					}
				} else {
					System.out.println("H� campos do propriet�rio em branco!");
					camposEmBranco = true;
					break;
				}
		}

		switch(0) {
			case 0:
				if (tela.getVersaoCBox().getSelectedItem() != tela.getVersaoCBox().getItemAt(0)) {
					v.setVersao((Versao)tela.getVersaoCBox().getSelectedItem());
				} else {
					System.out.println("H� campos do ve�culo em branco!");
					camposEmBranco = true;
					break;
				}
			case 1:
				if (tela.getFieldPlaca().getValue() != null) {
					v.setPlaca((String) tela.getFieldPlaca().getValue());
				} else {
					System.out.println("H� campos do ve�culo em branco!");
					camposEmBranco = true;
					break;
				}
			case 2:
				if (!tela.getFieldCor().getText().isEmpty()) {
					v.setCor(tela.getFieldCor().getText());
				} else {
					System.out.println("H� campos do ve�culo em branco!");
					camposEmBranco = true;
					break;
				}
		}
		if (!camposEmBranco) {
			for (Model.Proprietario dono : Service.ServiceProprietarios.Retrieve()) {
				if ((dono.getNome().equals(p.getNome()))
						|| (dono.getCpf() == p.getCpf())
						|| (dono.getRg() == p.getRg())
						|| (dono.getVeiculo().getPlaca().equals(v.getPlaca()))) {
					infoValida = false;
				}
			}
			
			if (infoValida) {
				v.setDono(p);
				p.setVeiculo(v);
				Service.ServiceProprietarios.Create(p);
				Service.ServiceCarros.Create(v);
			} else {
				JOptionPane.showMessageDialog(null, "Nome, RG, CPF ou Placa j� registrado no sistema!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "H� campos em branco/n�o selecionados!");
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == tela.getMarcaCBox()) {
			Marca marcaSelec = (Marca) tela.getMarcaCBox().getSelectedItem();
			Modelo[] modelosList = null;
			ArrayList<Modelo> temp = null;
			
			if (marcaSelec.getListaModelos() != null) {
				if (marcaSelec.getListaModelos().get(0).toString() == "Selecionar Modelo") {
					marcaSelec.getListaModelos().remove(0);
				}
				
				tela.getModeloCBox().setEnabled(true);
				if (tela.getVersaoCBox().isEnabled()) {
					tela.getVersaoCBox().setSelectedIndex(0);
					tela.getVersaoCBox().setEnabled(false);
				}
				temp = marcaSelec.getListaModelos();
				temp.add(0, new Modelo("Selecionar Modelo", null, null));
				modelosList = new Modelo[temp.size()];
				modelosList = temp.toArray(modelosList);
				tela.getModeloCBox().setModel(new DefaultComboBoxModel<Modelo>(modelosList));
			}
		} else if (ev.getSource() == tela.getModeloCBox()) {
			Modelo modeloSelec = (Modelo) tela.getModeloCBox().getSelectedItem();
			Versao[] versaoList = null;
			ArrayList<Versao> temp = null;
			
			if (modeloSelec.getListaVersoes() != null) {
				if (modeloSelec.getListaVersoes().get(0).toString() == "Selecionar Versao") {
					modeloSelec.getListaVersoes().remove(0);
				}
				tela.getVersaoCBox().setEnabled(true);
				temp = modeloSelec.getListaVersoes();
				temp.add(0, new Versao("Selecionar Versao", null, null, null));
				versaoList = new Versao[temp.size()];
				versaoList = temp.toArray(versaoList);
				tela.getVersaoCBox().setModel(new DefaultComboBoxModel<Versao>(versaoList));
			}
		} else if (ev.getSource() == tela.getBtnRegistrar()) {
			try {
				Registrar();
			} catch (Exception e) {
				System.err.println("Erro no registro!");
				e.printStackTrace();
			}
		}
	}
}
