package Service;

import java.util.ArrayList;

import DAO.Dao;
import Model.UsrSys;

public class ServiceUsers {
	private static Dao<UsrSys> dao = new Dao<UsrSys>("Usuarios.ser");
	
	public static void Create(UsrSys obj) {
		dao.Create(obj);
	}
	
	public static ArrayList<UsrSys> Retrieve() {
		return dao.Retrieve();
	}

	public static UsrSys Retrieve(int id) {
		return dao.Retrieve(id);
	}

	public static void Update(int id, UsrSys obj) {
		dao.Update(id, obj);
	}

	public static void Delete(UsrSys obj) {
		dao.Delete(obj);
	}
}
