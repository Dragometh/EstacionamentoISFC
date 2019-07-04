package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ControllerVerModel implements ActionListener, ListSelectionListener{
	private View.TelaVerModel tela;
	private String card;
	private Model.Carro carroSelec;
	private Model.Proprietario proprietarioSelec;
	private Model.Marca marcaSelec;
	private Model.UsrSys userSelec; 
	
	public ControllerVerModel(View.TelaVerModel tela, String card) {
		super();
		this.tela = tela;
		this.card = card;
		tela.setVisible(true);
		tela.getCards().show(tela.getContentPane(), card);
		loadTable(card);
		tela.getCarroAlterar().setEnabled(false);
		
		if (card == "VerCarro") {
			tela.getCarroAlterar().addActionListener(this);
			tela.getCarroVerDadosProprietario().addActionListener(this);
			tela.getCarroVerDadosMarca().addActionListener(this);
			tela.getCarroVerDadosModelo().addActionListener(this);
			tela.getCarroVerDadosVersao().addActionListener(this);
		} else if (card == "VerMarca") {
			tela.getMarcaCards().show(tela.getMarcaInfoCardsPanel(),"Marca");
			
			tela.getMarcaBtnVerModelos().setEnabled(false);
			tela.getMarcaBtnVerVersoes().setEnabled(false);
			
			tela.getMarcaAlterar().addActionListener(this);
			tela.getMarcaBtnVerMarcas().addActionListener(this);
			tela.getMarcaBtnVerModelos().addActionListener(this);
			tela.getMarcaBtnVerVersoes().addActionListener(this);
		}
	}
	
	private void loadTable(String card) {
		if (card.equals("VerCarro")) {
			javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			
			String col[] = {"ID", "Propriet\u00E1rio", "Placa"};
			java.util.ArrayList<Model.Carro> carroList = Service.ServiceCarros.Retrieve();
			
			for (int i = 0; i < col.length; i++) {
				tableModel.addColumn(col[i]);
			}
			
			
			for (Model.Carro c : carroList) {
				int id = carroList.indexOf(c);
				String dono = c.getProprietario().getNome();
				String placa = c.getPlaca();
				
				Object[] dados = {id, dono, placa};
				tableModel.addRow(dados);
			}
			
			tela.getTableCarro().setModel(tableModel);
			tela.getTableCarro().getSelectionModel().addListSelectionListener(this);
		} else if (card.equals("VerMarca")) {
			javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			
			String col[] = {"ID", "Nome do Fabricante", "Modelos"};
			java.util.ArrayList<Model.Marca> marcaList = Service.ServiceMarcas.Retrieve();
			
			for (int i = 0; i < col.length; i++) {
				tableModel.addColumn(col[i]);
			}
			
			for (Model.Marca m : marcaList) {
				int id = marcaList.indexOf(m);
				String nome = m.getNome();
				String listaModelos = m.getListaModelos().toString();
				
				Object[] dados = {id, nome, listaModelos};
				tableModel.addRow(dados);
			}
			
			tela.getMarcaMarcaTable().setModel(tableModel);
			tela.getMarcaMarcaTable().getSelectionModel().addListSelectionListener(this);
			tela.getMarcaModeloTable().getSelectionModel().addListSelectionListener(this);
			tela.getMarcaVersaoTable().getSelectionModel().addListSelectionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (card == "VerCarro") {
			if (e.getSource() == tela.getCarroAlterar()) {
				View.TelaAlterarModel updateModel = new View.TelaAlterarModel("AlterarCarro", carroSelec);
				tela.dispose();
			}
		} else if (card == "VerMarca") {
			if (e.getSource() == tela.getMarcaBtnVerMarcas()) {
				tela.getMarcaCards().show(tela.getMarcaInfoCardsPanel(), "Marca");
			} else if (e.getSource() == tela.getMarcaBtnVerModelos()) {
				tela.getMarcaCards().show(tela.getMarcaInfoCardsPanel(), "Modelo");
				
				javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel() {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				
				String col[] = {"ID", "Nome do Modelo", "Versoes"};
				java.util.ArrayList<Model.Modelo> modeloList = Service.ServiceModelos.Retrieve();
				
				for (int i = 0; i < col.length; i++) {
					tableModel.addColumn(col[i]);
				}
				
				for (Model.Modelo m : modeloList) {
					int id = modeloList.indexOf(m);
					String nome = m.getNome();
					String listaVersoes = m.getListaVersoes().toString();
					
					Object[] dados = {id, nome, listaVersoes};
					tableModel.addRow(dados);
				}
				
				tela.getMarcaModeloTable().setModel(tableModel);
			} else if (e.getSource() == tela.getMarcaBtnVerVersoes()) {
				tela.getMarcaCards().show(tela.getMarcaInfoCardsPanel(), "Versao");
				
				javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel() {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				
				String col[] = {"ID", "Nome da Versao", "Categoria"};
				java.util.ArrayList<Model.Versao> versaoList = Service.ServiceVersoes.Retrieve();
				
				for (int i = 0; i < col.length; i++) {
					tableModel.addColumn(col[i]);
				}
				
				for (Model.Versao v : versaoList) {
					int id = versaoList.indexOf(v);
					String nome = v.getNome();
					String categoria = v.getCategoria().toString();
					
					Object[] dados = {id, nome, categoria};
					tableModel.addRow(dados);
				}
				
				tela.getMarcaVersaoTable().setModel(tableModel);
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (card.equals("VerCarro")) {
			if (e.getSource() == tela.getTableCarro().getSelectionModel()) {
				tela.getCarroId().setText(String.valueOf(tela.getTableCarro().getSelectedRow()));
				carroSelec = Service.ServiceCarros.Retrieve(tela.getTableCarro().getSelectedRow());
				tela.getCarroDono().setText(carroSelec.getProprietario().getNome());
				tela.getCarroPlaca().setText(carroSelec.getPlaca());
				tela.getCarroCor().setText(carroSelec.getCor());
				tela.getCarroMarca().setText(carroSelec.getVersao().getModelo().getFabricante().getNome());
				tela.getCarroModelo().setText(carroSelec.getVersao().getModelo().getNome());
				tela.getCarroVersao().setText(carroSelec.getVersao().getNome());
				tela.getCarroAlterar().setEnabled(true);
			} 
		} else if (card.equals("VerMarca")) {
			if (e.getSource() == tela.getMarcaMarcaTable().getSelectionModel()) {
				tela.getMarcaBtnVerModelos().setEnabled(true);
			} else if (e.getSource() == tela.getMarcaModeloTable().getSelectionModel()) {
				tela.getMarcaBtnVerVersoes().setEnabled(true);
			}
		}
	}
}
