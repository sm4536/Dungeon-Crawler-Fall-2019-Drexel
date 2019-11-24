package main;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import engine.GameEngine;
import parser.LevelCreationStepDefHelper;
import parser.LevelCreator;
import values.TestingTunableParameters;
import wrappers.MathWrapper;
import wrappers.ReaderWrapper;

public class OpponentMovementStepDefs extends LevelCreationStepDefHelper {

	private GameEngine gameEngine;
	MathWrapper mathWrapper = new MathWrapper();

	@Given("^the level design by introducing opponent is:$")
	public void the_level_design_by_introducing_opponent_is(List<String> levelStrings) throws Throwable {
		writeLevelFile(levelStrings);
		gameEngine = new GameEngine(
				new LevelCreator(TestingTunableParameters.FILE_LOCATION_PREFIX, new ReaderWrapper()));
	}

	@Then("^the opponent should move to random position$")
	public void the_opponent_should_move_to_random_position() throws Throwable {

	}

	@When("^the player moves up to opponent space and the opponent current position is above the player$")
	public void the_player_moves_up_to_opponent_space_and_the_opponent_current_position_is_above_the_player()
			throws Throwable {
		gameEngine.setOpponent(gameEngine.getPlayerXCoordinate() - 1, gameEngine.getPlayerYCoordinate());
		gameEngine.keyLeft();
	}

	@When("^the player moves down to opponent space and the opponent current position is below the player$")
	public void the_player_moves_down_to_opponent_space_and_the_opponent_current_position_is_below_the_player()
			throws Throwable {
		gameEngine.setOpponent(gameEngine.getPlayerXCoordinate() - 1, gameEngine.getPlayerYCoordinate());
		gameEngine.keyLeft();
	}

	@When("^the player moves left to opponent space and the opponent current position is left side of the player$")
	public void the_player_moves_left_to_opponent_space_and_the_opponent_current_position_is_left_side_of_the_player()
			throws Throwable {
		gameEngine.setOpponent(gameEngine.getPlayerXCoordinate() - 1, gameEngine.getPlayerYCoordinate());
		gameEngine.keyLeft();
	}

	@When("^the player moves right to opponent space and the opponent current position is right side of the player$")
	public void the_player_moves_right_to_opponent_space_and_the_opponent_current_position_is_right_side_of_the_player()
			throws Throwable {
		gameEngine.setOpponent(gameEngine.getPlayerXCoordinate() - 1, gameEngine.getPlayerYCoordinate());
		gameEngine.keyLeft();
	}

}
