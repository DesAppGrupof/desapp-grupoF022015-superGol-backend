package update;

import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.model.Id;
import junit.framework.TestCase;
import persistence.PlayerHome;
import upload.InitializeManager;

public class InitializemanagerTest extends TestCase{
	
	@Test
	public void test_save_positive(){
		PlayerHome.getInstance().reset();
		new InitializeManager().save("playersName", "Goalkeeper", "aRealTeam");
		
		assertTrue(PlayerHome.getInstance().existIdentifier(new Id(0)));
	}
	
	@Test
	public void test_save_namePositionDispelled(){
		PlayerHome.getInstance().reset();
		String badNamePosition = "Goalkeeeeeeeeeeeper";
		new InitializeManager().save("playersName", badNamePosition, "aRealTeam");
		
		assertFalse(PlayerHome.getInstance().existIdentifier(new Id(0)));
	}

}
