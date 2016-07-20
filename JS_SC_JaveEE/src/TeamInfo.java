import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.internal.jpa.metadata.listeners.EntityClassListener;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.seanjohn.nhl.business.Team;

public class TeamInfo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("nhlLeagueContext");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Team> teams = em.createQuery("from Team", Team.class).getResultList();
		em.getTransaction().commit();
		for (Team t : teams) {
			System.out.println(t.getTeamId() + " " + t.getTeamname());
		}
	}
}