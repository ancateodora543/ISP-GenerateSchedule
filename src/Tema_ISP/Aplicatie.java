package Tema_ISP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Aplicatie {

	private static HashMap<String, String> conturi = new HashMap<String, String>();

	public static HashMap<String, String> getConturi() {
		return conturi;
	}

	public void setConturi(HashMap<String, String> conturi) {
		Aplicatie.conturi = conturi;
	}

	public static void main(String[] args) throws IOException {

		// grupe
		Grupa grupa1 = new Grupa("332", "AB");
		grupa1.adaugareMaterie("IRA");
		grupa1.adaugareMaterie("Baze de date");
		grupa1.adaugareMaterie("POO");
		grupa1.adaugareMaterie("SDA");
		grupa1.adaugareMaterie("Fizica");

		// profesori
		Profesor prof1 = new Profesor("Caramihai Mihai");
		Profesor prof2 = new Profesor("Caramihai Simona");
		Profesor prof3 = new Profesor("Veizu Ileana");

		prof1.adaugareMaterie("SDA");
		prof1.adaugareMaterie("POO");
		prof2.adaugareMaterie("IRA");
		prof2.adaugareMaterie("Fizica");
		prof3.adaugareMaterie("Baze de date");
	

		// secretar
		Secretar secretar1 = new Secretar();
		secretar1.adaugareNumeMateriePredefinita("Matematica");
		secretar1.adaugareNumeMateriePredefinita("Fizica");
		secretar1.adaugareNumeMateriePredefinita("Chimie");
		secretar1.adaugareNumeMateriePredefinita("Baze de date");
		secretar1.adaugareNumeMateriePredefinita("POO");
		secretar1.adaugareNumeMateriePredefinita("SDA");
		secretar1.adaugareNumeMateriePredefinita("IRA");

		secretar1.adaugareProfesori(prof1);
		secretar1.adaugareProfesori(prof2);
		secretar1.adaugareProfesori(prof3);
		
		secretar1.creareMaterie(grupa1, DesfasurareMaterie.curs);
		secretar1.creareMaterie(grupa1, DesfasurareMaterie.laborator);
		secretar1.creareCelulaOrar();
		
		//afisare orar grupa
		/*secretar1.afisareOrar();
		secretar1.salvareOrar("date.txt");
		*/
		//orar prof - materie
		/*ArrayList<CelulaOrar> orarProf = prof1.vizualizareOrarMaterieProfesor("SDA");
		for(CelulaOrar cel : orarProf)
			cel.afisare();*/
		
		ArrayList<CelulaOrar> orarGrupa = grupa1.vizualizareOrarZilnic("Luni");
		for(CelulaOrar cel : orarGrupa)
			cel.afisare();

	}

}
