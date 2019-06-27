package Model;

public class Carro implements java.io.Serializable{
    // Atributos
	private String placa;
    private String cor;
    private Marca marca;
    private Proprietario dono;
    
    // Construtores
    public Carro(String placa, String cor, Marca marca, Proprietario dono) {
    	this.placa = placa;
        this.cor = cor;
        this.marca = marca;
        this.dono = dono;
    }

    // Getters & Setters   
	public String getPlaca() {
        return placa;
    }
	
	public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

	public Proprietario getDono() {
		return dono;
	}

	public void setDono(Proprietario dono) {
		this.dono = dono;
	}
}
