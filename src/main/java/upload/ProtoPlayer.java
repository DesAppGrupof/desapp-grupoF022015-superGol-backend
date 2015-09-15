package upload;

import ar.edu.unq.desapp.grupoB022015.model.Id;
import persistence.PlayerHome;

public class ProtoPlayer {

	Id id;
	Integer goals;
	
	public ProtoPlayer(Id anId, Integer someGoals) {
		id = anId;
		goals = someGoals;
	}

	public void updateReferencedPlayer() {
		PlayerHome.getInstance().get(id).setGoalsInLastRound(goals);		
	}

}
