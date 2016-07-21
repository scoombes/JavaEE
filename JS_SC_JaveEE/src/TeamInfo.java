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

import com.seanjohn.nhl.business.Staff;
import com.seanjohn.nhl.business.Team;
import com.seanjohn.nhl.data.HibernateIO;
import com.seanjohn.nhl.data.TeamHIO;

public class TeamInfo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("nhlLeagueContext");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Team> team = em.createQuery("select t from Team t", Team.class).getResultList();
		
	    em.getTransaction().commit();
		for (Team t : team) {
			System.out.println(t.getTeamname() + " " + t.getHeadCoach().getFirstName()+ " " + t.getHeadCoach().getLastName());
		}
	}
}