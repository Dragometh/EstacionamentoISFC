package Model;
import java.util.ArrayList;

public class Modelo implements java.io.Serializable{
    // Atributos
	private String nome;
    private Marca fabricante;
    private ArrayList<Versao> listaVersoes;

    // Construtores
    public Modelo() {super();}
    
    public Modelo(String nome, Marca fabricante, ArrayList<Versao> listaVersoes) {
		super();
		this.nome = nome;
		this.fabricante = fabricante;
		this.listaVersoes = listaVersoes;
	}

    // Getters & Setters
  	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public ArrayList<Versao> getListaVersoes() {
		return listaVersoes;
	}

	public void setListaVersoes(ArrayList<Versao> listaVersoes) {
		this.listaVersoes = listaVersoes;
	}

	public Marca getFabricante() {
		return fabricante;
	}

	public void setFabricante(Marca fabricante) {
		this.fabricante = fabricante;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
