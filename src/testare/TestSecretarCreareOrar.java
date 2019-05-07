package testare;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import Tema_ISP.CelulaOrar;
import Tema_ISP.DesfasurareMaterie;
import Tema_ISP.Grupa;
import Tema_ISP.Secretar;

class TestSecretarCreareOrar {

	@Test
	void testCreareMaterie() {
		ArrayList<String> numeMaterii = new ArrayList<String>();
		Grupa grupa1 = new Grupa("332", "AB");
		grupa1.adaugareMaterie("IRA");
		grupa1.adaugareMaterie("Baze de date");
		grupa1.adaugareMaterie("POO");
		grupa1.adaugareMaterie("SDA");
		grupa1.adaugareMaterie("Fizica");
		Secretar secretar1 = new Secretar();
		secretar1.creareMaterie(grupa1, DesfasurareMaterie.curs);
		assertTrue(secretar1.celuleOrar.size() == grupa1.getListaMaterii().size());
		for (CelulaOrar celula : secretar1.celuleOrar) {
			if (!numeMaterii.contains(celula.getMaterie().getNumeMaterie()))
				numeMaterii.add(celula.getMaterie().getNumeMaterie());
		}
		assertTrue(numeMaterii.toArray().equals(grupa1.getListaMaterii().toArray()));

	}

}
