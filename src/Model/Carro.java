package Model;

public class Carro implements java.io.Serializable{
    // Atributos
	private String placa;
    private String cor;
    private Versao versao;
    private Proprietario dono;
    
    // Construtores
    public Carro() {super();}
    
    public Carro(String placa, String cor, Versao versao, Proprietario dono) {
    	this.placa = placa;
        this.cor = cor;
        this.versao = versao;
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

    public Versao getVersao() {
        return versao;
    }

    public void setVersao(Versao versao) {
        this.versao = versao;
    }

	public Proprietario getDono() {
		return dono;
	}

	public void setDono(Proprietario dono) {
		this.dono = dono;
	}
}
