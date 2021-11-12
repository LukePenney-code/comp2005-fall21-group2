
public class GameState {

	private int playerTurn,width,height;
	private GameState[][] spaces;
	
	/**
	 * @param playerTurn
	 * @param spaces
	 */
	public GameState() {
		
		playerTurn = playerTurn;
		spaces = new GameState[width][height];
		
		
	}
	public GameState[][] copy() {
		
		GameState[][] currentState = spaces;
		return currentState;
	}
	
	
}
