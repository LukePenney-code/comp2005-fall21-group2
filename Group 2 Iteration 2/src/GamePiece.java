import java.awt.*;
import javax.swing.*;
public class GamePiece{
	
	private Color color;
	/**
	 * @param color 
	 */
	public GamePiece(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color newColor) {
		this.color = newColor;
	}
}