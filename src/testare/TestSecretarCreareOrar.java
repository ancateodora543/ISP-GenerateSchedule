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
		Grupa grupa3 = new Grupa("332", "AB");
		grupa3.adaugareMaterie("IRA");
		grupa3.adaugareMaterie("Baze de date");
		grupa3.adaugareMaterie("POO");
		grupa3.adaugareMaterie("SDA");
		grupa3.adaugareMaterie("Fizica");
		Secretar secretar1 = new Secretar();
		secretar1.creareMaterie(grupa3, DesfasurareMaterie.curs);
		secretar1.creareCelulaOrar();
		assertSame(Secretar.celuleOrar.size(), grupa3.getListaMaterii().size());
		for (CelulaOrar celula : Secretar.celuleOrar) {
			if (!numeMaterii.contains(celula.getMaterie().getNumeMaterie()))
				numeMaterii.add(celula.getMaterie().getNumeMaterie());
		}
		assertTrue(numeMaterii.toArray().equals(grupa3.getListaMaterii().toArray()));

	}

}
