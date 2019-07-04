package DAO;

import java.util.ArrayList;

import Model.Categoria;

public class Dao<Obj> implements Interface<Obj> {
	private ArrayList<Obj> lista = new ArrayList<Obj>();
	private final Serial<Obj> serial = new Serial<Obj>();
	private String nomeArquivo;
	
	private void getData() {
		lista = serial.DeSerializar(nomeArquivo);
		
		//Inicializa dados caso haja um arquivo não-criado.
		if (lista == null) {
	    	if (nomeArquivo.equals("Categorias.ser")) {
	    		ArrayList<String> listaCarrocerias = new ArrayList<String>();
	    		ArrayList<String> listaClasseCarrocerias = new ArrayList<String>();
		    	listaCarrocerias.add("Hatchback");
				listaCarrocerias.add("Sedan");
				listaCarrocerias.add("Aventureiro");
				listaCarrocerias.add("Familiar");
				listaCarrocerias.add("Pickup");
				listaCarrocerias.add("SUV");
				listaCarrocerias.add("Esportivo");
				listaCarrocerias.add("Conversivel");
				listaCarrocerias.add("Van");
				listaCarrocerias.add("Jipe");
				listaCarrocerias.add("Furgao");
				listaCarrocerias.add("Caminhao");
				listaCarrocerias.add("Station Wagon");
				
				listaClasseCarrocerias.add("Subcompacto");
				listaClasseCarrocerias.add("Compacto");
				listaClasseCarrocerias.add("Medio");
				listaClasseCarrocerias.add("Grande");
		    	for (String i: listaCarrocerias) {
					for (String j : listaClasseCarrocerias) {
						Service.ServiceCategorias.Create(new Categoria(i, j));
					}
				}
		    	
		    	Service.ServiceCategorias.Retrieve();
	    	} else if (nomeArquivo.equals("Marcas.ser") || nomeArquivo.equals("Modelos.ser") || nomeArquivo.equals("Versoes.ser")) {
	    		Model.Marca m = new Model.Marca();
		    	Model.Modelo mo = new Model.Modelo();
		    	Model.Versao v = new Model.Versao();
		    	
		    	m.setNome("Volkswagen");
		    	m.setListaModelos(new java.util.ArrayList<Model.Modelo>());
		    	
		    	mo.setFabricante(m);
		    	mo.setNome("up!");
		    	mo.setListaVersoes(new java.util.ArrayList<Model.Versao>());
		    	
		    	v.setFabricante(m);
		    	v.setModelo(mo);
		    	v.setNome("move up!");
		    	
		    	Model.Categoria cat = Service.ServiceCategorias.Retrieve("Hatchback", "Subcompacto");
		    	v.setCategoria(cat);
		    	
		    	mo.getListaVersoes().add(v);
		    	m.getListaModelos().add(mo);
		    	
		    	Service.ServiceVersoes.Create(v);
		    	Service.ServiceModelos.Create(mo);
		    	Service.ServiceMarcas.Create(m);
		    	
		    	Service.ServiceMarcas.Retrieve();
		    	Service.ServiceModelos.Retrieve();
		    	Service.ServiceVersoes.Retrieve();	    	
	    	} else if (nomeArquivo.equals("Usuarios.ser")) {
	    		Model.UsrSys user = new Model.UsrSys("admin", "admin");
	    		Service.ServiceUsers.Create(user);
		    	Service.ServiceUsers.Retrieve();
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
	    		
	    		v.setProprietario(p);
	    		p.setVeiculo(v);
	    		
	    		Service.ServiceCarros.Create(v);
	    		Service.ServiceProprietarios.Create(p);
	    		
	    		Service.ServiceCarros.Retrieve();
	    		Service.ServiceProprietarios.Retrieve();
	    	} else if (nomeArquivo.equals("Logs.ser")) {
	    		Service.ServiceLog.Create(new Model.Log(Service.ServiceCarros.Retrieve(0), "Entrada"));
	    		
	    		Service.ServiceLog.Retrieve();
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
				System.out.println ("Objeto j\u00E1 está na lista!");
			}
		} else {
			System.out.println("Objeto \u00E9 nulo!");
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
