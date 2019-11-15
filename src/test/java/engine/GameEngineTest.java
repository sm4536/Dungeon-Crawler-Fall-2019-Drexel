package engine;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import java.awt.Component;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import parser.LevelCreator;
import tiles.TileType;
import ui.GameFrame;

public class GameEngineTest {

	private static final int ZERO = 0;
	private static final int ONE = 1;
	
	GameEngine gameEngine;
	int actualX;
	int actualY;
	
	@Before
	public void setUp() throws Exception {
		LevelCreator levelCreator = Mockito.mock(LevelCreator.class);
		gameEngine = new GameEngine(levelCreator);
		int level = 1;
		Mockito.verify(levelCreator, Mockito.times(level)).createLevel(gameEngine, level);
		TileType tileType = TileType.PLAYER;
		gameEngine.addTile(ZERO, ONE, tileType);
		actualX = gameEngine.getPlayerXCoordinate();
		actualY = gameEngine.getPlayerYCoordinate();
		
	}

	@Test
	public void run() {
		GameFrame gameFrame = Mockito.mock(GameFrame.class);
		Component component = Mockito.mock(Component.class);
		Mockito.when(gameFrame.getComponents()).thenReturn(new Component[] { component });
		gameEngine.run(gameFrame);
		Mockito.verify(component, Mockito.times(1)).repaint();
	}

	@Test
	public void add_and_get_tile() {
		TileType tileType = TileType.PASSABLE;
		gameEngine.addTile(ZERO, ONE, TileType.PASSABLE);
		TileType actual = gameEngine.getTileFromCoordinates(ZERO, ONE);
		assertThat(actual, equalTo(tileType));
	}

	@Test
	public void set_and_get_horizontal_dimension() {
		gameEngine.setLevelHorizontalDimension(ONE);
		int actual = gameEngine.getLevelHorizontalDimension();
		assertThat(actual, equalTo(ONE));
	}

	@Test
	public void set_and_get_vertical_dimension() {
		gameEngine.setLevelVerticalDimension(ONE);
		int actual = gameEngine.getLevelVerticalDimension();
		assertThat(actual, equalTo(ONE));
	}

	@Test
	public void add_and_get_player_coordinates() {
		assertThat(actualX, equalTo(ZERO));
		assertThat(actualY, equalTo(ONE));
	}

	@Test
	public void set_and_get_exit() {
		boolean exit = true;
		gameEngine.setExit(exit);
		boolean actual = gameEngine.isExit();
		assertThat(actual, equalTo(exit));
	}

	@Test
	public void key_left() {
		// TODO Should I start with this test?
		gameEngine.keyLeft();
		assertEquals(actualX -1,gameEngine.getPlayerXCoordinate());
		assertEquals(actualY,gameEngine.getPlayerYCoordinate());
	}

	@Test
	public void key_right() {
		// TODO Should I start with this test?
		gameEngine.keyRight();
		assertEquals(actualX +1,gameEngine.getPlayerXCoordinate());
		assertEquals(actualY,gameEngine.getPlayerYCoordinate());
	}

	@Test
	public void key_up() {
		// TODO Should I start with this test?
		gameEngine.keyUp();
		assertEquals(actualX,gameEngine.getPlayerXCoordinate());
		assertEquals(actualY-1,gameEngine.getPlayerYCoordinate());
	}

	@Test
	public void key_down() {
		// TODO Should I start with this test?
		gameEngine.keyDown();
		assertEquals(actualX,gameEngine.getPlayerXCoordinate());
		assertEquals(actualY+1,gameEngine.getPlayerYCoordinate());
	}
	

	
	
}
