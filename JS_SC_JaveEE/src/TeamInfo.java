import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seanjohn.nhl.business.Game;
import com.seanjohn.nhl.data.ScheduleHIO;

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