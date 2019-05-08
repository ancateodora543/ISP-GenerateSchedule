package testare;

import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Tema_ISP.Grupa;
import Tema_ISP.Profesor;
import Tema_ISP.Secretar;

class TestSecretarAdministrareConturi {

	@Test
	void creareContGrupa() {
		//verifica daca se creeaza un singur cont pentru grupa 332
		Secretar secretar1 = new Secretar();
		Grupa grupa2 = new Grupa("332", "AB");
		assertTrue(secretar1.creareContGrupa(grupa2));
		assertFalse(secretar1.creareContGrupa(grupa2));

	}

	@Test
	void creareContProfesor() {
		//verifica daca se creeaza un singur cont pentru profesorul1
		Secretar secretar1 = new Secretar();
		Profesor profesor1 = new Profesor("Radulescu");
		assertTrue(secretar1.creareContProfesor(profesor1));
		assertFalse(secretar1.creareContProfesor(profesor1));
	}

	@Test
	void testStergereContGrupa() {
		//verifica daca se sterge contul grupei 332, contul se va sterga doar daca userul este diferit de null
		Grupa grupa1 = new Grupa("332", "AB");
		Secretar secretar1 = new Secretar();
		grupa1.setUser("grupamea");
		assertTrue(secretar1.stergereContGrupa(grupa1));
		Grupa grupa2 = new Grupa("332", "AC");
		grupa2.setUser(null);
		assertFalse(secretar1.stergereContGrupa(grupa2));

	}

	@Test
	void testModificareContStudent() {
		//verificam daca modificarile se executa cu succes pentru grupa 331
		Grupa grupa2 = new Grupa("332", "AB");
		Secretar secretar2 = new Secretar();
		//testul se va executa daca numele grupei este valid, este format din cifre
		secretar2.modificareContStudent(grupa2, "nume", "331");
		assertFalse("332".equals(grupa2.getNume()));
		//ambele nume de grupe vor fi la fel acum, deoarece numele de grupa nu este valid
		secretar2.modificareContStudent(grupa2, "nume", "abc");
		assertSame("331", grupa2.getNume());
		//testul se va executa daca noua valoarea a serie exista in lista de serii definite in Secretar
		secretar2.modificareContStudent(grupa2, "serie", "AC");
		assertNotSame("AB", grupa2.getSerie());
		//testul se va executa dar modificarile nu se vor intampla deoarece seria nu este in lista de serii definite in Secretar
		secretar2.modificareContStudent(grupa2, "serie", "321");
		assertSame("AC", grupa2.getSerie());
	}

	@Test
	void testStergereContProfesor() {
		//verifica daca se sterge contul profesorului, contul se va sterge doar daca userul este diferit de null
		Profesor profesor1 = new Profesor("Caramihai", "cara");
		Secretar secretar1 = new Secretar();
		assertTrue(secretar1.stergereContProfesor(profesor1));
		Profesor profesor2 = new Profesor("Caramihai");
		profesor2.setUser(null);
		assertFalse(secretar1.stergereContProfesor(profesor2));
	}

	@Test
	void testModificareContProfesor() {
		//testul se va executa doar daca valoarea noua furnizata este valida, daca contine doar litere si daca criteriul exista
		Profesor profesor2 = new Profesor("Caramihai");
		Secretar secretar2 = new Secretar();
		secretar2.modificareContProfesor(profesor2, "nume", "Mariana");
		assertTrue("Mariana".equals(profesor2.getNume()));
		secretar2.modificareContProfesor(profesor2, "nume", "85697");
		assertFalse("85697".equals(profesor2.getNume()));
	}

	@Test
	void testValidareGrupa() {
		//testul se va executa doar daca valoarea noua este valida, adica daca la grupa, numele este format din cifre
		//pentru serie numele trebuie sa fie in lista predefinita de serii din Secretar
		//si daca criteriul pe care trebuie sa il modificam exista
		Secretar secretar2 = new Secretar();
		assertFalse(secretar2.validareGrupa("nume", "abc"));
		assertTrue(secretar2.validareGrupa("nume", "331"));
		assertFalse(secretar2.validareGrupa("alaba", "331"));
		assertTrue(secretar2.validareGrupa("serie", "AB"));
		assertFalse(secretar2.validareGrupa("serie", "331"));

	}

	@Test
	void testValidareProf() {
		//testul se va executa doar daca valoarea noua este valida, adica daca numele este format doar din litere
		//si daca criteriul pe care trebuie sa il modificam exista
		Secretar secretar2 = new Secretar();
		assertTrue(secretar2.validareProf("nume", "Caramihai"));
		assertFalse(secretar2.validareProf("nume", "856"));
		assertTrue(secretar2.validareProf("alal", "Caramihai"));

	}

}
