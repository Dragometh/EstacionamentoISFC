package Model;

public class Categoria implements java.io.Serializable{
	//Atributos
	private String carroceria;
	private String classe;
	
	//Constructors
	public Categoria() {
		super();
	}
	public Categoria ( String carroceria, String classe) {
		super();
		this.carroceria = carroceria;
		this.classe = classe;
	}
	
	//Getters e Setters
	public String getCarroceria() {
		return carroceria;
	}

	public void setCarroceria(String carroceria) {
		this.carroceria = carroceria;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	@Override
	public String toString() {
		if (carroceria != classe) {
			return carroceria + " " + classe;
		} else {
			return carroceria;
		}
	}
}
