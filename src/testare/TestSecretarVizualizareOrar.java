package testare;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Tema_ISP.CelulaOrar;
import Tema_ISP.DesfasurareMaterie;
import Tema_ISP.Grupa;
import Tema_ISP.Profesor;
import Tema_ISP.Secretar;

class TestSecretarVizualizareOrar {

	@Test
	void testAfisareOrar() {
		ArrayList<CelulaOrar> orarZi = new ArrayList<CelulaOrar>();
		ArrayList<CelulaOrar> profiOrar = new ArrayList<CelulaOrar>();
		ArrayList<CelulaOrar> profiOrarZi = new ArrayList<CelulaOrar>();
		ArrayList<CelulaOrar> profMaterii = new ArrayList<CelulaOrar>();
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
		prof1.adaugareMaterie("Franceza");
		prof2.adaugareMaterie("IRA");
		prof2.adaugareMaterie("Fizica");
		prof3.adaugareMaterie("Baze de date");

		secretar1.creareMaterie(grupa3, DesfasurareMaterie.curs);
		secretar1.creareCelulaOrar();
		Grupa grupa4 = new Grupa("331", "AC");
		assertEquals(Secretar.celuleOrar, grupa3.vizualizareOrarSaptamana());
		assertNotEquals(Secretar.celuleOrar, grupa4.vizualizareOrarSaptamana());

		for (CelulaOrar celule : Secretar.celuleOrar) {
			if (celule.getSala().getZi() == "Luni") {
				orarZi.add(celule);
			}
		}

		assertEquals(orarZi, grupa3.vizualizareOrarZilnic("Luni"));
		assertNotEquals(orarZi, grupa3.vizualizareOrarZilnic("Marti"));
		assertNotEquals(orarZi, grupa3.vizualizareOrarZilnic("Sambata"));
		assertNotEquals(orarZi, grupa4.vizualizareOrarZilnic("Luni"));

		for (CelulaOrar celula : Secretar.celuleOrar) {
			if (celula.getMaterie().getProfesor() == prof1) {
				profiOrar.add(celula);
			}
			if (celula.getSala().getZi().equals("Luni") && celula.getMaterie().getProfesor() == prof1) {
				profiOrarZi.add(celula);

			}
		}

		for (CelulaOrar celula : Secretar.celuleOrar) {
			if (celula.getMaterie().getNumeMaterie().equals("SDA") && celula.getMaterie().getProfesor() == prof1) {
				profMaterii.add(celula);
			}
		}

		assertEquals(profiOrar, prof1.vizualizareOrarProfesor());
		assertNotEquals(profiOrar, prof2.vizualizareOrarProfesor());
		assertNotEquals(profiOrar, prof2.vizualizareOrarZi("Luni"));
		assertEquals(profiOrarZi, prof1.vizualizareOrarZi("Luni"));
		assertNotEquals(profiOrarZi, prof1.vizualizareOrarZi("Sambata"));
		assertNotEquals(profiOrarZi, prof1.vizualizareOrarZi("Marti"));
		assertNotEquals(profMaterii, prof1.vizualizareOrarMaterieProfesor("IRA"));
		assertNotEquals(profMaterii, prof1.vizualizareOrarMaterieProfesor("Franceza"));
		assertEquals(profMaterii, prof1.vizualizareOrarMaterieProfesor("SDA"));

	}

}
