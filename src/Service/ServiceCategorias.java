package Service;

import java.util.ArrayList;

import DAO.Dao;
import Model.Categoria;

public class ServiceCategorias {
	private static Dao<Categoria> dao = new Dao<Categoria>("Categorias.ser");
	
	public static void Create(Categoria obj) {
		dao.Create(obj);
	}
	
	public static ArrayList<Categoria> Retrieve() {
		return dao.Retrieve();
	}

	public static Categoria Retrieve(String carr, String carrClass) {
		for (Categoria cat: dao.Retrieve()) {
			if(cat.toString().equals(carr + " " + carrClass)) {
				return cat;
			}
		}
		return null;
	}

	public static void Update(int id, Categoria obj) {
		dao.Update(id, obj);
	}

	public static void Delete(Categoria obj) {
		dao.Delete(obj);
	}
}
