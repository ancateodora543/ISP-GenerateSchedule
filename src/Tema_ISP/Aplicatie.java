package Tema_ISP;

import java.util.HashMap;

public class Aplicatie {

	private static HashMap<String, String> conturi = new HashMap<String, String>();
	

	public static HashMap<String, String> getConturi() {
		return conturi;
	}

	public void setConturi(HashMap<String, String> conturi) {
		Aplicatie.conturi = conturi;
	}
	
	

	public static void main(String[] args) {

		//grupe
		Grupa grupa1 = new Grupa("332","AB");
		grupa1.adaugareMaterie("IRA");
		grupa1.adaugareMaterie("Baze de date");
		grupa1.adaugareMaterie("POO");
		grupa1.adaugareMaterie("SDA");
		grupa1.adaugareMaterie("Fizica");

		//profesori
		Profesor prof1 = new Profesor("Caramihai Mihai");
		Profesor prof2 = new Profesor("Caramihai Simona");
		Profesor prof3 = new Profesor("Veizu Ileana");
		
		prof1.adaugareMaterie("SDA");
		prof1.adaugareMaterie("POO");
		prof2.adaugareMaterie("IRA");
		prof2.adaugareMaterie("Fizica");
		prof3.adaugareMaterie("Baze de date");
		
		//secretar
		Secretar secretar1 = new Secretar();
		secretar1.adaugareNumeMateriePredefinita("Matematica");
		secretar1.adaugareNumeMateriePredefinita("Fizica");
		secretar1.adaugareNumeMateriePredefinita("Chimie");
		secretar1.adaugareNumeMateriePredefinita("Baze de date");
		secretar1.adaugareNumeMateriePredefinita("POO");
		secretar1.adaugareNumeMateriePredefinita("SDA");
		secretar1.adaugareNumeMateriePredefinita("IRA");
		
		
		secretar1.creareMaterie(grupa1, DesfasurareMaterie.curs);
		
	}

}
