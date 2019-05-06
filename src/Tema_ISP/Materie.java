package Tema_ISP;

public class Materie {

	private int durata = 2;
	private String numeMaterie;
	private DesfasurareMaterie modDesfasurareMaterie;
	private Grupa grupa;
	private Profesor profesor;
	
	
	public Materie(Grupa grupa, String nume, DesfasurareMaterie desf, Profesor prof) {
		this(grupa,nume,desf);
		this.profesor = prof;
	}
	
	public Materie(Grupa grupa, String nume, DesfasurareMaterie desf) {
		this.grupa = grupa;
		this.numeMaterie = nume;
		this.modDesfasurareMaterie = desf;
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

	public DesfasurareMaterie getModDesfasurareMaterie() {
		return modDesfasurareMaterie;
	}

	public void setModDesfasurareMaterie(DesfasurareMaterie modDesfasurareMaterie) {
		this.modDesfasurareMaterie = modDesfasurareMaterie;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}
	
	

	
};
