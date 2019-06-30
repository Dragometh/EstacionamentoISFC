package Service;

import java.util.ArrayList;

import DAO.Dao;
import Model.Carro;

public class ServiceCarros {
private static Dao<Carro> dao = new Dao<Carro>("Veiculos.ser");
	
	public static void Create(Carro obj) {
		dao.Create(obj);
	}
	
	public static ArrayList<Carro> Retrieve() {
		return dao.Retrieve();
	}

	public static Carro Retrieve(int id) {
		return dao.Retrieve(id);
	}

	public static void Update(int id, Carro obj) {
		dao.Update(id, obj);
	}

	public static void Delete(Carro obj) {
		dao.Delete(obj);
	}
}
