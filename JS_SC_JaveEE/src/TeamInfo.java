import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javassist.expr.NewArray;

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

import com.seanjohn.nhl.business.Game;
import com.seanjohn.nhl.business.Player;
import com.seanjohn.nhl.business.Roster;
import com.seanjohn.nhl.business.Staff;
import com.seanjohn.nhl.business.Team;
import com.seanjohn.nhl.data.HibernateIO;
import com.seanjohn.nhl.data.RosterHIO;
import com.seanjohn.nhl.data.ScheduleHIO;
import com.seanjohn.nhl.data.TeamHIO;

public class TeamInfo {
	public static void main(String[] args) {
		ScheduleHIO scheduleIO = new ScheduleHIO();
		List<Game> games;
		try {
			games = scheduleIO.getTeamSchedule("LFS001");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			games = new ArrayList<Game>();
		}
		
		for (Game t : games) {
			//for(Roster r :t.getRoster()){
				System.out.println(t.getGameDate() + " " + t.getHome().getTeamname() + " " + t.getVisitor().getTeamname());
			//}
		}
		
	}
}