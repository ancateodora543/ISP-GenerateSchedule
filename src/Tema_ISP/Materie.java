 package Tema_ISP;

public class Materie {

	private int durata;
	private String numeMaterie;
	private DesfasurareMaterie modDesfasurareMaterie;
	private Grupa grupa;
	private Profesor profesor;
	
	
	public void afisare() {
		System.out.println("Materie" + this.numeMaterie);
	}

	
	public String getNumeMaterie() {
		return numeMaterie;
	}


	public void setNumeMaterie(String numeMaterie) {
		this.numeMaterie = numeMaterie;
	}


	public void adaugareDurata(int durata) {
		this.durata = durata;
	}

	public void adaugareNumeMaterie(String numeMaterie) {
		this.numeMaterie = numeMaterie;
	}

	public void adaugareProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public void adaugareModDesfasurareMaterie(DesfasurareMaterie desf) {
		this.modDesfasurareMaterie = desf;
	}
	
	public void adaugareGrupa(Grupa grupa) {
		this.grupa = grupa;
	}
	

	
};
