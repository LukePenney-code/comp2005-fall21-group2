import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class GameSpace extends JPanel{
	private Stack<GamePiece> pieces;
	private int stackSize;
	private int xcoord, ycoord;
	
	/**
	 * @param pieces
	 * @param stackSize
	 */
	public GameSpace(int xcoord, int ycoord) {
		
		this.xcoord = xcoord;
		this.ycoord = ycoord;
		pieces = new Stack();
		stackSize = pieces.size();
		this.setSize(50,50);
	}


	public int getStackSize() {
		return stackSize;
	}
	
	public GamePiece topPiece() {
		return pieces.lastElement();
		
	}
	
	public void removePiece() {
		pieces.pop();
	}
	
	public void addPiece(GamePiece newPiece) {
		pieces.push(newPiece);
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
}