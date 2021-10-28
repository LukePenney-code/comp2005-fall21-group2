import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameSpace extends JButton{
	private ArrayList<GamePiece> stack;
	private int xcoord, ycoord;
	
	/**
	 * @param stack
	 */
	public GameSpace(int xcoord, int ycoord) {
		super();
		this.xcoord = xcoord;
		this.ycoord = ycoord;
		stack = new ArrayList<GamePiece>();
		//spaces that are not part of the game are black, otherwise spaces are white
		if (((xcoord == 0) || (xcoord == 7)) && ((ycoord > 5) || (ycoord < 2))) {
			this.setBackground(Color.black);
		}else if (((xcoord == 1) || (xcoord == 6)) && ((ycoord == 7) || (ycoord == 0))) {
			this.setBackground(Color.black);
		} else {
			this.setBackground(Color.white);
		}
	}


	public int getStackSize() {
		return stack.size();
	}
	
	public GamePiece topPiece() {
		return stack.get(stack.size() - 1);
		
	}
	
	public void removePiece() {
		// removes the bottom piece
		stack.remove(0);
	}
	
	public void addPiece(GamePiece newPiece) {
		stack.add(newPiece);
	}


	public int getXcoord() {
		return xcoord;
	}


	public void setXcoord(int xcoord) {
		this.xcoord = xcoord;
	}


	public int getYcoord() {
		return ycoord;
	}


	public void setYcoord(int ycoord) {
		this.ycoord = ycoord;
	}
	
	public Color initialColor() {
		// returns the color that the piece that starts on this space at the beginning of the game should be set to
		if ((xcoord < 4) && ((ycoord == 5) || (ycoord == 7))) {
			return Color.blue;
		}
		if (((xcoord == 1) || (xcoord == 3)) && (ycoord < 4)) {
			return Color.blue;
		}
		if ((xcoord > 3) && ((ycoord == 0) || (ycoord == 2))) {
			return Color.red;
		}
		if (((xcoord == 4) || (xcoord == 6)) && (ycoord > 3)) {
			return Color.red;
		}
		if ((xcoord > 3) && ((ycoord == 4) || (ycoord == 6))) {
			return Color.yellow;
		}
		if (((xcoord == 5) || (xcoord == 7)) && (ycoord > 3)) {
			return Color.yellow;
		}
		return Color.green;
	}
}