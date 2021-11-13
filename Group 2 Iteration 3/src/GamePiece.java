import java.awt.*;
import javax.swing.*;
public class GamePiece{
	
	private Color color;
	private int playerNum;
	/**
	 * @param xCoord
	 * @param yCoord
	 * @param color
	 * @param playerNum
	 * @param color 
	 */
	public GamePiece(Color color) {
		
		this.color = color;
		playerNum = 0;
	}
	
	public int getPlayerNum() {
		return playerNum;
	}
	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color newColor) {
		this.color = newColor;
	}
}