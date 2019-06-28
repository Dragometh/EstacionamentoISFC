package Model;

public class Pessoa implements java.io.Serializable{
	// Atributos
	private String nome;
	private Long cpf;
	private Long rg;
	private Long fone;
	
	// Construtores
	public Pessoa() {super();}
	
	public Pessoa(String nome, Long cpf, Long rg, Long fone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.fone = fone;
	}
	
	// Getters & Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public Long getRg() {
		return rg;
	}
	public void setRg(Long rg) {
		this.rg = rg;
	}
	public Long getFone() {
		return fone;
	}
	public void setFone(Long fone) {
		this.fone = fone;
	}
}
