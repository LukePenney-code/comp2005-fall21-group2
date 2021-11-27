import java.awt.Color;

public class Player {
	
	private int type; // 0 for human, 1 for easy, 2 for hard
	private Color color;
	private int reserve;
	
	public Player(int type, Color color) {
		this.color = color;
		this.type = type;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public int getReserve() {
		return this.reserve;
	}
	
	public void incrementReserve(int amount) {
		reserve = reserve + amount;
	}
	
	public void decrementReserve() {
		reserve--;
	}
}