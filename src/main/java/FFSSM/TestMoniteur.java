package FFSSM;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;
public class TestMoniteur {
	Licence l1 , l2;
	Plongeur p, p2;
	Club c, c2;
	Moniteur m;
	Site s;
	Plongee pl, pl2;
	
	@BeforeEach
	public void setup() {
		p = new Plongeur("55", "Ntamack", "Romain", "Toulouse", "0647864467", LocalDate.now(), 5, GroupeSanguin.AMOINS);
		p2= new Plongeur("55", "Ntamack", "Romain", "Toulouse", "0647864467", LocalDate.now().minusYears(2), 5, GroupeSanguin.AMOINS);
		
		m = new Moniteur("66", "Dupont", "Antoine", "Toulouse", "0643568765", LocalDate.now(), 5, GroupeSanguin.APLUS, 6776);
		c = new Club(m, "Stade Toulousain", "098644976");
		c2 = new Club(m, "Stade Toulousain U20", "06423568864");

		l1  = new Licence(p, "1234", LocalDate.of(2022, 12, 11), c );
		l2  = new Licence(p, "1234", LocalDate.of(2021, 12, 11), c );
		p.ajouteLicence("14567", LocalDate.of(2022, 12, 11), c);
		p2.ajouteLicence("345", LocalDate.of(2021, 12, 11), c);
		s = new Site("toulouse", "magnifique");
		pl = new Plongee(s,m, LocalDate.now(), 4, 3);
		pl2 = new Plongee(s,m, LocalDate.now(), 5, 6);

		pl.ajouteParticipant(p);
		pl2.ajouteParticipant(p2);
		c.organisePlongee(pl);
		c.organisePlongee(pl2);
		m.nouvelleEmbauche(c, LocalDate.of(2021, 5, 24));
		m.nouvelleEmbauche(c2, LocalDate.of(2022, 5, 24));

	}
	@Test
	public void testNouvelleEmbauche() {
		assertEquals(m.employeurActuel().get(), c2);
		Embauche e = new Embauche(LocalDate.of(2021, 12, 25), m, c);
		assertEquals(m.employeurActuel().get(), c);
	}
	
	
}
