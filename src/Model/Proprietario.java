package Model;

public class Proprietario extends Pessoa implements java.io.Serializable{
	// Atributos
	private Carro veiculo;

	// Construtor
	public Proprietario() {super();}
	
	public Proprietario(String nome, Long cpf, Long rg, Long fone, Carro vehiculo) {
		super(nome, cpf, rg, fone);
		this.veiculo = vehiculo;
	}

	// Getters & Setters
	public Carro getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Carro veiculo) {
		this.veiculo = veiculo;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
}
