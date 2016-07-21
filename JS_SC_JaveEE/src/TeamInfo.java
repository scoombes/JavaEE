import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.eclipse.persistence.internal.jpa.metadata.listeners.EntityClassListener;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.seanjohn.nhl.business.Player;
import com.seanjohn.nhl.business.Roster;
import com.seanjohn.nhl.business.Staff;
import com.seanjohn.nhl.business.Team;
import com.seanjohn.nhl.data.HibernateIO;
import com.seanjohn.nhl.data.TeamHIO;

public class TeamInfo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("nhlLeagueContext");
		EntityManager em = emf.createEntityManager();

		 //List<Roster> players =;
		 TypedQuery<Roster> q = em.createQuery("select p from Roster p WHERE p.team.teamId = :id",
		 Roster.class);
		 q.setParameter("id", "GDT001");
		 List<Roster> players = q.getResultList();
		 

//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery q = cb.createQuery(Player.class);
//		Root<Player> c = q.from(Player.class);
//		q.select(c);
//		TypedQuery<Player> query = em.createQuery(q);
//		List<Player> players = query.getResultList();
		for (Roster r : players) {
			//for (Roster r : t.getRoster()) {
			Player t = r.getPlayer();
				System.out.println(t.getFirstName() + " " + t.getLastName()
						+ " " + r.getJersey());
			//}

		}
	}
}