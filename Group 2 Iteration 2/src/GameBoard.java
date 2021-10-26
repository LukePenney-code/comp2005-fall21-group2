import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class GameBoard extends JFrame {
	
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel bottomPanel;
    private JPanel gameBoard;
    private GameSpace [][] gameSpaces;
    private int numPlayers, rows, columns;
    
    
    public GameBoard(){
    	
    	rows = 5;
    	columns = 5;
    	
    	topPanel = new JPanel();
    	//bottomPanel = new JPanel();
    	//rightPanel = new JPanel();
    	//leftPanel = new JPanel();
    	gameBoard = new JPanel();
    	
    	this.setSize(500,500);
    	
    	topPanel.setLayout(new FlowLayout());
    	topPanel.setSize(200,200);
    	//bottomPanel.setLayout(new FlowLayout());
    	
    	gameBoard.setLayout(new GridLayout());
    	gameBoard.setSize(500,500);
    	
    	gameSpaces = new GameSpace[rows][columns];
    	for (int x = 0 ; x < columns; x++) {
    		for ( int y = 0; y < rows; y++) {
    			Border raisedBevel = BorderFactory.createRaisedBevelBorder();
    			gameSpaces[x][y] = new GameSpace(x, y);
    			gameSpaces[x][y].setSize(20,20);
    			gameSpaces[x][y].setOpaque(true);
    			gameSpaces[x][y].setBorder(raisedBevel);
    			gameBoard.add(gameSpaces[x][y]);
    		}
    	}
    	getContentPane().setLayout(new BorderLayout());
		getContentPane().add(topPanel, BorderLayout.NORTH);
		//getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		//getContentPane().add(rightPanel, BorderLayout.EAST);
		//getContentPane().add(leftPanel, BorderLayout.WEST);
		getContentPane().add(gameBoard, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
    }


	
}