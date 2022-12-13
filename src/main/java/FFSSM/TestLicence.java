package FFSSM;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;
public class TestLicence {
	Licence l1 , l2;
	Personne p;
	Club c;
	Moniteur m;
	Site s;
	
	@BeforeEach
	public void setup() {
		p = new Plongeur("55", "Ntamack", "Romain", "Toulouse", "0647864467", LocalDate.now(), 5, GroupeSanguin.AMOINS);
		m = new Moniteur("66", "Dupont", "Antoine", "Toulouse", "0643568765", LocalDate.now(), 5, GroupeSanguin.APLUS, 6776);
		c = new Club(m, "Stade Toulousain", "098644976");
		l1  = new Licence(p, "1234", LocalDate.of(2022, 12, 11), c );
		l2  = new Licence(p, "1234", LocalDate.of(2021, 12, 11), c );

		s = new Site("test", "magnifique");
		
	}
	@Test
	public void testAjoutPlongee() {
		Plongee plongee = new Plongee(s, m, LocalDate.now(), 15, 12);
		l1.ajouterPlongees(plongee);
		assertTrue(l1.plongees.contains(plongee));
	}
	
	@Test
	public void testEstValide() {
		assertFalse(l2.estValide(LocalDate.now()));
		assertTrue(l1.estValide(LocalDate.now()));
	}
	
}
