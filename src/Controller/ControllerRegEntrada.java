package Controller;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import Model.Carro;
import Model.Log;
import Model.Proprietario;

public class ControllerRegEntrada implements ActionListener {
	View.TelaRegEntrada tela;
	
	public ControllerRegEntrada(View.TelaRegEntrada tela) {
		super();
		this.tela = tela;
		
		tela.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		tela.setModalityType(ModalityType.APPLICATION_MODAL);
		tela.setModal(true);
		tela.setVisible(true);
		tela.getOkButton().addActionListener(this);
		tela.getCancelButton().addActionListener(this);
		
		ArrayList<Carro> temp = Service.ServiceCarros.Retrieve();
		ArrayList<String> temp2 = new ArrayList<String>();
		for (Carro c: temp) {
			temp2.add(c.getPlaca());
		}
		temp2.add(0, "Selecionar Placa");
		String[] placasList = new String[temp2.size()];
		placasList = temp2.toArray(placasList);
		tela.getPlacaCBox().setModel(new DefaultComboBoxModel<String>(placasList));
		
		ArrayList<Proprietario> temp3 = Service.ServiceProprietarios.Retrieve();
		temp3.add(0, new Proprietario("Selecionar Proprietario", null, null, null, null));
		Proprietario[] donoList = new Proprietario[temp3.size()];
		donoList = temp3.toArray(donoList);
		tela.getProprietarioCBox().setModel(new DefaultComboBoxModel<Proprietario>(donoList));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "OK") {
			if ((tela.getProprietarioCBox().getSelectedIndex() != -1) 
					|| (tela.getProprietarioCBox().getSelectedIndex() != 0)) {
				int id = -1;
				ArrayList<Carro> list = Service.ServiceCarros.Retrieve();
				Proprietario dono = (Proprietario) tela.getProprietarioCBox().getSelectedItem();
				
				Log en = new Log(dono.getVeiculo(), "Entrada");
				Service.ServiceLog.Create(en);
			} else if ((tela.getPlacaCBox().getSelectedIndex() != -1)
					|| (tela.getPlacaCBox().getSelectedIndex() != 0)) {
				int id = tela.getPlacaCBox().getSelectedIndex() - 1; // -1 pois há a adição de "Selecionar Placa" na linha 28.
				
				Log en = new Log(Service.ServiceCarros.Retrieve(id), "Entrada");
				Service.ServiceLog.Create((Model.Log) en);
			}
		} else if (e.getActionCommand() == "Cancel") {
			tela.dispose();
		}
	}
}
