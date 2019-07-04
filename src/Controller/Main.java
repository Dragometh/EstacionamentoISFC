package Controller;

import View.TelaLogin;

public class Main {
    public static void main(String[] args) {	
    	//Inicializando listas dos serviços
    	Service.ServiceUsers.Retrieve();
    	Service.ServiceCategorias.Retrieve();
    	
    	Service.ServiceMarcas.Retrieve();
    	Service.ServiceModelos.Retrieve();
    	Service.ServiceVersoes.Retrieve();
    	
    	Service.ServiceProprietarios.Retrieve();
    	Service.ServiceCarros.Retrieve();
    	
    	Service.ServiceLog.Retrieve();
		try {
			TelaLogin frameLogin = new TelaLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
