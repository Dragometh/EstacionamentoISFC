package DAO;

import java.util.ArrayList;
import java.util.List;
import Model.UsrSys;

public class Dao<Obj> implements Interface<Obj> {
	private ArrayList<Obj> lista = new ArrayList<>();
	private final Serial<Obj> serial = new Serial<>();
	private String nomeArquivo;
	
	public Dao(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	@Override
	public void Create(Obj obj) {
		lista.add(obj);
		serial.Serializar(lista, nomeArquivo);
	}

	@Override
	public ArrayList<Obj> Retrieve() {
		lista = serial.DeSerializar(nomeArquivo);
		return lista;
	}

	@Override
	public Obj Retrieve(int id) {
		lista = serial.DeSerializar(nomeArquivo);
		return lista.get(id);
	}

	@Override
	public void Update(int id, Obj obj) {
		lista = serial.DeSerializar(nomeArquivo);
		lista.set(id, obj);
		serial.Serializar(lista, nomeArquivo);
		
	}

	@Override
	public void Delete(Obj obj) {
		lista = serial.DeSerializar(nomeArquivo);
		lista.remove(obj);
		serial.Serializar(lista, nomeArquivo);
	}

}
