package Service;

import java.util.ArrayList;

import DAO.Dao;
import Model.Categoria;

public class ServiceCategorias {
	private static Dao<Categoria> dao = new Dao<Categoria>("Categorias.ser");
	private static ArrayList<String> listaCarrocerias = new ArrayList<String>();
	private static ArrayList<String> listaClasseCarrocerias = new ArrayList<String>();
	
	public static void Create(Categoria obj) {
		dao.Create(obj);
	}
	
	public static void CreateFromLists() {
		for (String i: listaCarrocerias) {
			for (String j : listaClasseCarrocerias) {
				dao.Create(new Categoria(i, j));
			}
		}
	}
	
	public static ArrayList<Categoria> Retrieve() {
		return dao.Retrieve();
	}
	
	public static ArrayList<String> RetrieveCarrList() {
		return listaCarrocerias;
	}
	
	public static ArrayList<String> RetrieveClassList() {
		return listaClasseCarrocerias;
	}

	public static Categoria Retrieve(String carr, String carrClass) {
		for (Categoria cat: dao.Retrieve()) {
			if(cat.getCarroceria() == carr && cat.getClasse() == carrClass) {
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
