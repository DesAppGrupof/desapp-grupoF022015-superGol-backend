package update;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.model.Id;
import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.builders.PlayerBuilder;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.InvalidUpdateDataException;
import ar.edu.unq.desapp.grupoB022015.model.positions.Defender;
import ar.edu.unq.desapp.grupoB022015.model.positions.Forward;
import junit.framework.TestCase;
import persistence.PlayerHome;

public class UpdateManagerTest extends TestCase {

	@Test
	public void test_addUncheckedPlayer_withInvalidData_Id(){
		PlayerHome.getInstance().reset();
		Player player = mock(Player.class);
		when(player.id()).thenReturn(new Id(0));
		
		try{
			UpdateManager.getInstance().addUncheckedPlayer(new Id(1), new Defender(), 0);
			fail();
		}catch(InvalidUpdateDataException e){
			assertTrue(true);
		}		
	}
	
	@Test
	public void test_addUncheckedPlayer_withInvalidData_Position(){
		PlayerHome.getInstance().reset();
		Player player = mock(Player.class);
		when(player.id()).thenReturn(new Id(0));
		when(player.getPosition()).thenReturn(mock(Forward.class));
		PlayerHome.getInstance().save(player);
		
		try{
			UpdateManager.getInstance().addUncheckedPlayer(new Id(0), new Defender(), 0);
			fail();
		}catch(InvalidUpdateDataException e){
			assertTrue(true);
		}	
	}
	
	@Test
	public void test_addUncheckedPlayer_withValidData(){
		PlayerHome.getInstance().reset();
		Player player = PlayerBuilder.anyPlayer().defender().build();
		PlayerHome.getInstance().save(player);
		
		try{
			UpdateManager.getInstance().addUncheckedPlayer(new Id(0), new Defender(), 0);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}
}
