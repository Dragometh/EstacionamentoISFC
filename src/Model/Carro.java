package Model;

public class Carro implements java.io.Serializable{
    // Atributos
	private String placa;
    private String cor;
    private Versao versao;
    private Proprietario proprietario;
    
    // Construtores
    public Carro() {super();}
    
    public Carro(String placa, String cor, Versao versao, Proprietario proprietario) {
    	this.placa = placa;
        this.cor = cor;
        this.versao = versao;
        this.proprietario = proprietario;
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

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
}
