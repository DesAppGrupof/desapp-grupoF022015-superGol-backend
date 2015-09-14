package update;

import static org.mockito.Mockito.*;
import org.junit.Test;
import ar.edu.unq.desapp.grupoB022015.model.Id;
import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.positions.Forward;
import junit.framework.TestCase;
import persistence.PlayerHome;

public class ProtoPlayerTest extends TestCase {
	
	@Test
	public void test_updateReferencedPlayer(){
		PlayerHome.getInstance().reset();
		Player player = mock(Player.class);
		when(player.id()).thenReturn(new Id(0));
		when(player.getPosition()).thenReturn(mock(Forward.class));
		PlayerHome.getInstance().save(player);
		
		new ProtoPlayer(new Id(0), 3).updateReferencedPlayer();
		
		verify(player).setGoalsInLastRound(3);
	}
}
