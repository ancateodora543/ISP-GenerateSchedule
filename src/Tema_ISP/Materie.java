package Tema_ISP;

public class Materie {

	private int durata;
	private String numeMaterie;
	private DesfasurareMaterie modDesfasurareMaterie;
	private Grupa grupa;
	private Profesor profesor;
	
	public Materie(Grupa grupa, String nume, DesfasurareMaterie desf, Profesor prof) {
		this.grupa = grupa;
		this.numeMaterie = nume;
		this.modDesfasurareMaterie = desf;
		if(desf == DesfasurareMaterie.curs)
			this.durata = 3;
		else 
			this.durata = 2;	
		this.profesor = prof;
	}

	public int getDurata() {
		return durata;
	}

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

	public Profesor getProfesor() {
		return profesor;
	}

	public Grupa getGrupa() {
		return grupa;
	}

	
};
