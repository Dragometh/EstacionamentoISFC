package Model;

public class Log implements java.io.Serializable{
	private Carro carro;
	private java.time.LocalDateTime tempo;
	private String tipo;
	
	public Log(Carro carro, String tipo) {
		super();
		this.carro = carro;
		this.tempo = java.time.LocalDateTime.now();
		this.tipo = tipo;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public java.time.LocalDateTime getTempo() {
		return tempo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
