package Model;
public class Versao implements java.io.Serializable{
	// Atributos
    private String nome;
    private Marca fabricante;
    private Modelo modelo;
    private Categoria categoria;

    // Construtores
    public Versao() {super();}
    
    public Versao(String nome, Marca fabricante, Modelo modelo, Categoria categoria) {
    	this.nome = nome;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.categoria = categoria;
    }

    // Getters & Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public Marca getFabricante() {
		return fabricante;
	}

	public void setFabricante(Marca fabricante) {
		this.fabricante = fabricante;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
