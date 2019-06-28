package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import Model.Marca;
import Model.Modelo;
import Model.Versao;

public class ControllerCadProprietario implements ActionListener {
	private View.TelaCadProprietario tela;
	private javax.swing.ButtonGroup bGroup = new javax.swing.ButtonGroup();
	private DefaultFormatterFactory formatadorCpfFactory;
	private DefaultFormatterFactory formatadorRgFactory;
	private DefaultFormatterFactory formatadorFoneFactory;
	
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
		tela.getMarcaCBox().addActionListener(this);
		tela.getModeloCBox().addActionListener(this);
		tela.getVersaoCBox().addActionListener(this);
		
		// Logica para formatação de campos numéricos
		MaskFormatter formatadorCpf;
		MaskFormatter formatadorRg;
		MaskFormatter formatadorFone;
		try {
			formatadorCpf = new MaskFormatter("###.###.###-##");
			formatadorCpf.setValidCharacters("0123456789");
			formatadorCpf.setCommitsOnValidEdit(true);
			formatadorCpf.setPlaceholderCharacter('_');
			formatadorCpf.setValueContainsLiteralCharacters(false);
			formatadorCpfFactory = new DefaultFormatterFactory(formatadorCpf);
			
			// TODO: RG possui formatos diferentes entre estados. Procurar um workaround decente para este problema.
			formatadorRg = new MaskFormatter("###.###.###-##");
			formatadorRg.setValidCharacters("0123456789");;
			formatadorRg.setCommitsOnValidEdit(true);
			formatadorRg.setPlaceholderCharacter('_');
			formatadorRg.setValueContainsLiteralCharacters(false);
			formatadorRgFactory = new DefaultFormatterFactory(formatadorRg);
			
			formatadorFone = new MaskFormatter("#####-####");
			formatadorFone.setValidCharacters("0123456789");
			formatadorFone.setCommitsOnValidEdit(true);
			formatadorFone.setPlaceholderCharacter('_');
			formatadorFone.setValueContainsLiteralCharacters(false);
			formatadorFoneFactory = new DefaultFormatterFactory(formatadorFone);
			
			tela.getFieldCpf().setFormatterFactory(formatadorCpfFactory);
			tela.getFieldRg().setFormatterFactory(formatadorRgFactory);
			tela.getFieldFone().setFormatterFactory(formatadorFoneFactory);
		} catch (Exception e) {
			System.err.println("ERRO: " + e.getMessage());
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == tela.getRdbtnNovoVeiculo()) {	
			tela.getCardLayout().show(tela.getPanelCards(), "Novos");
		} else if (ev.getSource() == tela.getRdbtnVeiculoExistente()) {
			tela.getCardLayout().show(tela.getPanelCards(), "Existentes");
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
		} else if (ev.getSource() == tela.getBtnRegistrar()) {
			Model.Proprietario p = new Model.Proprietario();
			p.setNome(tela.getFieldNome().getText());
			p.setCpf(Long.parseLong((String)tela.getFieldCpf().getValue()));
			p.setFone(Long.parseLong((String)tela.getFieldFone().getValue()));
			p.setRg(Long.parseLong((String)tela.getFieldRg().getValue()));
			
			Model.Carro v = new Model.Carro();
			v.setDono(p);
			v.setVersao((Versao)tela.getVersaoCBox().getSelectedItem());
			v.setPlaca(tela.getFieldCor().getText());
			v.setCor(tela.getFieldCor().getText());
			
			
		}
	}
}
