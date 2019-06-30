package Controller;

import Model.Versao;
import View.TelaLogin;

public class Main {
    public static void main(String[] args) {
    	/** CODIGO PARA STARTUP
    	Model.Marca m = new Model.Marca();
    	Model.Modelo mo = new Model.Modelo();
    	Model.Versao v = new Model.Versao();
    	
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
		
		Service.ServiceUsers.Create(new Model.UsrSys("admin", "admin"));
		**/
    	
    	//Inicializando listas de Marca, Modelo, Vers�o, Categorias e Usuarios
    	Service.ServiceCategorias.Retrieve();
    	Service.ServiceUsers.Retrieve();
    	Service.ServiceMarcas.Retrieve();
    	Service.ServiceModelos.Retrieve();
    	Service.ServiceVersoes.Retrieve();
    	Service.ServiceProprietarios.Retrieve();
    	Service.ServiceCarros.Retrieve();
		try {
			TelaLogin frameLogin = new TelaLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
