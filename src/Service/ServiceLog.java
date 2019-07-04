package Service;

import java.util.ArrayList;

import DAO.Dao;
import Model.Log;

public class ServiceLog {
	private static Dao<Log> dao = new Dao<Log>("Logs.ser");
	
	public static void Create(Log obj) {
		dao.Create(obj);
	}
	
	public static ArrayList<Log> Retrieve() {
		return dao.Retrieve();
	}

	public static Log Retrieve(int id) {
		return dao.Retrieve(id);
	}

	public static void Update(int id, Log obj) {
		dao.Update(id, obj);
	}

	public static void Delete(Log obj) {
		dao.Delete(obj);
	}
	
	public static void Clear() {
		dao.Retrieve().clear();
	}
}
