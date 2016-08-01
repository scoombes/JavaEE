import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.seanjohn.nhl.business.Game;
import com.seanjohn.nhl.business.Schedule;
import com.seanjohn.nhl.business.ScheduleSessionBean;
import com.seanjohn.nhl.business.Team;
import com.seanjohn.nhl.data.ScheduleHIO;
import com.seanjohn.nhl.data.TeamHIO;


public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SQLException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("nhlLeagueContext");
		EntityManager em = emf.createEntityManager();
		
		ScheduleSessionBean sbean = new ScheduleSessionBean();
		
		TeamHIO teamio = new TeamHIO();
		Team team = teamio.getTeams().get(1);
		System.out.println(team.getTeamname());
		
		Schedule s = em.createQuery("SELECT S FROM Schedule s", Schedule.class).getSingleResult();
		
		System.out.println(s.toString());
		for (Team t : teamio.getTeams()) {
			//System.out.println(g.getHome().getTeamname());
			System.out.println(sbean.getNextGame(t, s));
		}
	}

}
