package testare;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Tema_ISP.Grupa;
import Tema_ISP.Secretar;

class TestSecretarAdministrareConturi {

	@Test
	void testStergereContGrupa() {
		Grupa grupa1 = new Grupa("332","AB");
		Secretar secretar1 = new Secretar();
		secretar1.stergereContGrupa(grupa1);
		assertNull(grupa1.getUser());
		
		Grupa grupa2 = new Grupa();
		grupa2.setUser(null);
		secretar1.stergereContGrupa(grupa2);
		assertNotNull(grupa2);
		
	}

	@Test
	void testModificareContStudent() {
		Grupa grupa1 = new Grupa("332","AB");
		Secretar secretar1 = new Secretar();
		secretar1.modificareContStudent(grupa1, "nume", "331");
		assertNotSame("332", grupa1.getNume());
		secretar1.modificareContStudent(grupa1, "nume", "ABC");
		assertSame("331", grupa1.getNume());
		secretar1.modificareContStudent(grupa1, "serie", "AC");
		assertNotSame("AB", grupa1.getSerie());
		secretar1.modificareContStudent(grupa1, "serie", "321");
		assertSame("AB", grupa1.getSerie());
		
		
		
	}

	@Test
	void testStergereContProfesor() {
		fail("Not yet implemented");
	}

	@Test
	void testModificareContProfesor() {
		fail("Not yet implemented");
	}

	@Test
	void testValidareGrupa() {
		fail("Not yet implemented");
	}

	@Test
	void testValidareProf() {
		fail("Not yet implemented");
	}

}
