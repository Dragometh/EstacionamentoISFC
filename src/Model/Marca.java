package Model;
import java.util.ArrayList;

public class Marca implements java.io.Serializable{
	// Atributos
	private String fabricante; // ou nome (da marca)
    private ArrayList<Modelo> listaModelos;
	
    // Construtores
    public Marca(String fabricante, ArrayList<Modelo> listaModelos) {
		super();
		this.fabricante = fabricante;
		this.listaModelos = listaModelos;
	}
    
    public Marca() {}
    
    // Getters & Setters
	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public ArrayList<Modelo> getListaModelos() {
		return listaModelos;
	}

	public void setListaModelos(ArrayList<Modelo> listaModelos) {
		this.listaModelos = listaModelos;
	}
	
	@Override
	public String toString() {
		return fabricante;
	}
}
