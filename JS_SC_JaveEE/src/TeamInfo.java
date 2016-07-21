import java.sql.SQLException;
import java.util.ArrayList;
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

import com.seanjohn.nhl.business.Player;
import com.seanjohn.nhl.business.Roster;
import com.seanjohn.nhl.business.Staff;
import com.seanjohn.nhl.business.Team;
import com.seanjohn.nhl.data.HibernateIO;
import com.seanjohn.nhl.data.RosterHIO;
import com.seanjohn.nhl.data.TeamHIO;

public class TeamInfo {
	public static void main(String[] args) {
		RosterHIO rosterIO = new RosterHIO();
		List<Roster> roster = new ArrayList<Roster>();
		try {
			roster = rosterIO.getRoster("LFS001");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("nhlLeagueContext");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		List<Roster> player = em.createQuery("select t from Roster t where t.team.teamId = :teamId", Roster.class)
//				.setParameter("teamId", "LFS001").getResultList();
//		
//	    em.getTransaction().commit();
		for (Roster t : roster) {
			//for(Roster r :t.getRoster()){
				System.out.println(t.getPlayer().getFirstName() + " " + t.getPlayer().getLastName() + " " + t.getJersey());
			//}
		}
		
	}
}