package Service;

import java.util.ArrayList;

import DAO.Dao;
import Model.Proprietario;

public class ServiceProprietarios {
	private static Dao<Proprietario> dao = new Dao<Proprietario>("Proprietarios.ser");
	
	public static void Create(Proprietario obj) {
		dao.Create(obj);
	}
	
	public static ArrayList<Proprietario> Retrieve() {
		return dao.Retrieve();
	}

	public static Proprietario Retrieve(int id) {
		return dao.Retrieve(id);
	}

	public static void Update(int id, Proprietario obj) {
		dao.Update(id, obj);
	}

	public static void Delete(Proprietario obj) {
		dao.Delete(obj);
	}
}
