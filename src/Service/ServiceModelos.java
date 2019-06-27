package Service;

import java.util.ArrayList;

import DAO.Dao;
import Model.Modelo;

public class ServiceModelos {
	private static Dao<Modelo> dao = new Dao<Modelo>("Modelos.ser");
	
	public static void Create(Modelo obj) {
		dao.Create(obj);
	}
	
	public static ArrayList<Modelo> Retrieve() {
		return dao.Retrieve();
	}

	public static Modelo Retrieve(int id) {
		return dao.Retrieve(id);
	}

	public static void Update(int id, Modelo obj) {
		dao.Update(id, obj);
	}

	public static void Delete(Modelo obj) {
		dao.Delete(obj);
	}
}
