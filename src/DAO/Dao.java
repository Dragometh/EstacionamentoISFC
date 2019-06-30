package DAO;

import java.util.ArrayList;

public class Dao<Obj> implements Interface<Obj> {
	private ArrayList<Obj> lista = new ArrayList<Obj>();
	private final Serial<Obj> serial = new Serial<Obj>();
	private String nomeArquivo;
	
	private void getData() {
		lista = serial.DeSerializar(nomeArquivo);
		if (lista == null) {
	    	if (nomeArquivo.equals("Categorias.ser")) {
		    	Service.ServiceCategorias.RetrieveCarrList().add("Hatchback");
				Service.ServiceCategorias.RetrieveCarrList().add("Sedan");
				Service.ServiceCategorias.RetrieveCarrList().add("Aventureiro");
				Service.ServiceCategorias.RetrieveCarrList().add("Familiar");
				Service.ServiceCategorias.RetrieveCarrList().add("Pickup");
				Service.ServiceCategorias.RetrieveCarrList().add("SUV");
				Service.ServiceCategorias.RetrieveCarrList().add("Esportivo");
				Service.ServiceCategorias.RetrieveCarrList().add("Conversivel");
				Service.ServiceCategorias.RetrieveCarrList().add("Van");
				Service.ServiceCategorias.RetrieveCarrList().add("Jipe");
				Service.ServiceCategorias.RetrieveCarrList().add("Furgao");
				Service.ServiceCategorias.RetrieveCarrList().add("Caminhao");
				Service.ServiceCategorias.RetrieveCarrList().add("Station Wagon");
				
				Service.ServiceCategorias.RetrieveClassList().add("Subcompacto");
				Service.ServiceCategorias.RetrieveClassList().add("Compacto");
				Service.ServiceCategorias.RetrieveClassList().add("Medio");
				Service.ServiceCategorias.RetrieveClassList().add("Grande");
		    	Service.ServiceCategorias.CreateFromLists();
	    	} else if (nomeArquivo.equals("Marcas.ser") || nomeArquivo.equals("Modelos.ser") || nomeArquivo.equals("Versoes.ser")) {
	    		Model.Marca m = new Model.Marca();
		    	Model.Modelo mo = new Model.Modelo();
		    	Model.Versao v = new Model.Versao();
		    	
		    	m.setFabricante("Volkswagen");
		    	m.setListaModelos(new java.util.ArrayList<Model.Modelo>());
		    	
		    	mo.setFabricante(m);
		    	mo.setNome("up!");
		    	mo.setListaVersoes(new java.util.ArrayList<Model.Versao>());
		    	
		    	v.setFabricante(m);
		    	v.setModelo(mo);
		    	v.setNome("move up!");
		    	
		    	Model.Categoria cat = Service.ServiceCategorias.Retrieve("Hatch", "Subcompacto");
		    	v.setCategoria(cat);
		    	
		    	mo.getListaVersoes().add(v);
		    	m.getListaModelos().add(mo);
		    	
		    	Service.ServiceVersoes.Create(v);
		    	Service.ServiceModelos.Create(mo);
		    	Service.ServiceMarcas.Create(m);
	    	} else if (nomeArquivo.equals("Usuarios.ser")) {
	    		Service.ServiceUsers.Create(new Model.UsrSys("admin", "admin"));
	    	} else if (nomeArquivo.equals("Veiculos.ser") || nomeArquivo.equals("Proprietarios.ser")) {
	    		Model.Proprietario p = new Model.Proprietario();
	    		Model.Carro v = new Model.Carro();
	    		p.setNome("John Doe");
	    		p.setCpf(Long.valueOf("32132132132"));
	    		p.setRg(Long.valueOf("12312312312"));
	    		p.setFone(Long.valueOf("933218600"));
	    		
	    		v.setCor("Preto");
	    		v.setPlaca("XYZ1234");
	    		v.setVersao(Service.ServiceVersoes.Retrieve(0));
	    		
	    		v.setDono(p);
	    		p.setVeiculo(v);
	    		
	    		Service.ServiceCarros.Create(v);
	    		Service.ServiceProprietarios.Create(p);
	    	}
		}
	}
	
	public Dao(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	@Override
	public void Create(Obj obj) {
		if (obj != null) {
			if (lista == null) {
				lista = new ArrayList<Obj>();
				lista.add(obj);
				serial.Serializar(lista, nomeArquivo);
			} else if (!lista.contains(obj)){
				lista.add(obj);
				serial.Serializar(lista, nomeArquivo);
			} else {
				System.out.println ("Objeto já está na lista!");
			}
		} else {
			System.out.println("Objeto é nulo!");
		}
	}

	@Override
	public ArrayList<Obj> Retrieve() {
		getData();
		return lista;
	}

	@Override
	public Obj Retrieve(int id) {
		getData();
		return lista.get(id);
	}

	@Override
	public void Update(int id, Obj obj) {
		getData();
		lista.set(id, obj);
		serial.Serializar(lista, nomeArquivo);
		
	}

	@Override
	public void Delete(Obj obj) {
		getData();
		if (lista.contains(obj)) {
			lista.remove(obj);
			serial.Serializar(lista, nomeArquivo);
		} else {
			System.out.println("Objeto não esta contido na lista!");
		}
	}
}
