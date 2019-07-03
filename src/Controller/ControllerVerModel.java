package Controller;

public class ControllerVerModel {
	private View.TelaVerModel tela;
	
	public ControllerVerModel(View.TelaVerModel tela, String card) {
		super();
		this.tela = tela;
		tela.setVisible(true);
		tela.getCards().show(tela.getContentPane(), card);
		loadTable(card);
		
	}
	
	private void loadTable(String card) {
		javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel();
		int idCount = 0;
		
		if (card.equals("VerCarro")) {
			String col[] = {"ID", "Proprietário", "Placa"};
			java.util.ArrayList<Model.Carro> carroList = Service.ServiceCarros.Retrieve();
			
			for (int i = 0; i < col.length; i++) {
				tableModel.addColumn(col[i]);
			}
			
			for (Model.Carro c : carroList) {
				int id = carroList.indexOf(c);
				String dono = c.getDono().getNome();
				String placa = c.getPlaca();
				
				Object[] dados = {id, dono, placa};
				tableModel.addRow(dados);
			}
			
			tela.getTableCarro().setModel(tableModel);
		}
	}
}
