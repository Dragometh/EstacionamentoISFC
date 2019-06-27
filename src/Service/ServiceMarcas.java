package Service;

import java.util.ArrayList;

import DAO.Dao;
import Model.Marca;

public class ServiceMarcas {
	private static Dao<Marca> dao = new Dao<Marca>("Marcas.ser");
	
	public static void Create(Marca obj) {
		dao.Create(obj);
	}
	
	public static ArrayList<Marca> Retrieve() {
		return dao.Retrieve();
	}

	public static Marca Retrieve(int id) {
		return dao.Retrieve(id);
	}

	public static void Update(int id, Marca obj) {
		dao.Update(id, obj);
	}

	public static void Delete(Marca obj) {
		dao.Delete(obj);
	}
}
