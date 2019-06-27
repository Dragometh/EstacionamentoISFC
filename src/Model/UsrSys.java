package Model;

// Classe para usuários do sistema

public class UsrSys extends Pessoa implements java.io.Serializable{
	// Atributos
	private String username;
	private String password;
	
	// Construtores
	public UsrSys() {
		super();
	}
	
	public UsrSys(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public UsrSys(String primeiroNome, Long cpf, Long rg, Long fone, String username, String password) {
		super(primeiroNome, cpf, rg, fone);
		this.username = username;
		this.password = password;
	}

	// Getters & Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
