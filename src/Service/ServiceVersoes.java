package Service;

import java.util.ArrayList;

import DAO.Dao;
import Model.Versao;

public class ServiceVersoes {
	private static Dao<Versao> dao = new Dao<Versao>("Versoes.ser");
	
	public static void Create(Versao obj) {
		dao.Create(obj);
	}
	
	public static ArrayList<Versao> Retrieve() {
		return dao.Retrieve();
	}

	public static Versao Retrieve(int id) {
		return dao.Retrieve(id);
	}

	public static void Update(int id, Versao obj) {
		dao.Update(id, obj);
	}

	public static void Delete(Versao obj) {
		dao.Delete(obj);
	}
}
