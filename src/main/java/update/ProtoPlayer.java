package update;

import ar.edu.unq.desapp.grupoB022015.model.Id;
import persistence.PlayerHome;

public class ProtoPlayer {

	Id id;
	String position;
	Integer goals;
	
	public ProtoPlayer(Id anId, String aPosition, Integer someGoals) {
		id = anId;
		position = aPosition;
		goals = someGoals;
	}

	public void updateReferencedPlayer() {
		PlayerHome.getInstance().get(id).setGoalsInRound(goals);		
	}

}
