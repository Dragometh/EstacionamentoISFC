package Model;
import java.util.ArrayList;

public class Marca implements java.io.Serializable{
	// Atributos
	private String nome; // ou nome (da marca)
    private ArrayList<Modelo> listaModelos;
	
    // Construtores
    public Marca() {super();}
    
    public Marca(String nome, ArrayList<Modelo> listaModelos) {
		super();
		this.nome = nome;
		this.listaModelos = listaModelos;
	}

    // Getters & Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Modelo> getListaModelos() {
		return listaModelos;
	}

	public void setListaModelos(ArrayList<Modelo> listaModelos) {
		this.listaModelos = listaModelos;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
