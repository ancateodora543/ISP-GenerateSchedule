package testare;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import Tema_ISP.CelulaOrar;
import Tema_ISP.DesfasurareMaterie;
import Tema_ISP.Grupa;
import Tema_ISP.Profesor;
import Tema_ISP.Secretar;

class TestSecretarCreareOrar {

	@Test
	void testCreareMaterie() {
		ArrayList<String> numeMaterii = new ArrayList<String>();
		ArrayList<Profesor> profesori = new ArrayList<Profesor>();
		Grupa grupa3 = new Grupa("332", "AB");
		grupa3.adaugareMaterie("IRA");
		grupa3.adaugareMaterie("Baze de date");
		grupa3.adaugareMaterie("POO");
		grupa3.adaugareMaterie("SDA");
		grupa3.adaugareMaterie("Fizica");
		Secretar secretar1 = new Secretar();
		
		Profesor prof1 = new Profesor("Caramihai Mihai");
		Profesor prof2 = new Profesor("Caramihai Simona");
		Profesor prof3 = new Profesor("Veizu Ileana");
		
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
		
		prof1.adaugareMaterie("SDA");
		prof1.adaugareMaterie("POO");
		prof2.adaugareMaterie("IRA");
		prof2.adaugareMaterie("Fizica");
		prof3.adaugareMaterie("Baze de date");
		
		secretar1.creareMaterie(grupa3, DesfasurareMaterie.curs);
		secretar1.creareCelulaOrar();
		
		assertSame(Secretar.celuleOrar.size(), grupa3.getListaMaterii().size());
		for (CelulaOrar celula : Secretar.celuleOrar) {
			if (!numeMaterii.contains(celula.getMaterie().getNumeMaterie()))
				numeMaterii.add(celula.getMaterie().getNumeMaterie());
			if(!profesori.contains(celula.getMaterie().getProfesor()))
				profesori.add(celula.getMaterie().getProfesor());
		}
		assertTrue(numeMaterii.containsAll(grupa3.getListaMaterii()));
		assertTrue(secretar1.getProfi().containsAll(profesori));
		
		Secretar secretar2 = new Secretar();

		secretar2.adaugareNumeMateriePredefinita("POO");
		secretar2.adaugareNumeMateriePredefinita("SDA");
		
		Grupa grupa4 = new Grupa("332", "AC");
		grupa4.adaugareMaterie("ISP");
		grupa4.adaugareMaterie("POO");
		grupa4.adaugareMaterie("SDA");
		
		
		Profesor prof4 = new Profesor("Anca Solot");
		prof4.adaugareMaterie("SDA");
		secretar2.adaugareProfesori(prof4);

		
		secretar2.creareMaterie(grupa4, DesfasurareMaterie.curs);
		secretar2.creareCelulaOrar();
		
		
		assertFalse(Secretar.celuleOrar.size() == grupa4.getListaMaterii().size());
		assertFalse(secretar2.getProfi().containsAll(profesori));

	}

}
