import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class GameBoard extends JFrame implements ActionListener {
	
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel bottomPanel;
    private JPanel gameBoard;
    private GameSpace [][] gameSpaces;
    private int numPlayers, rows, columns;
    private Color setupColor; //used to set the color of the piece that starts in each space at the beginning of the game
    private JButton quit, colorBlindButton;
    
    public GameBoard(){
    	
    	rows = 8;
    	columns = 8;
    	
    	topPanel = new JPanel();
    	//bottomPanel = new JPanel();
    	//rightPanel = new JPanel();
    	leftPanel = new JPanel();
    	gameBoard = new JPanel();
    	quit = new JButton("Quit");
    	colorBlindButton = new JButton("Toggle Color Defiency Settings");
    	colorBlindButton.addActionListener(this);
    	quit.addActionListener(this);
    	topPanel.add(quit);
    	topPanel.add(colorBlindButton);
    	
    	
    	this.setSize(500,500);
    	
    	topPanel.setLayout(new FlowLayout());
    	topPanel.setSize(200,200);
    	//bottomPanel.setLayout(new FlowLayout());
    	
    	gameBoard.setLayout(new GridLayout(rows, columns));
    	gameBoard.setSize(500,500);
    	
    	gameSpaces = new GameSpace[rows][columns];
    	for (int y = 0; y < rows; y++) {
    		for (int x = 0 ; x < columns; x++) {
    			gameSpaces[x][y] = new GameSpace(x, y);
    			gameSpaces[x][y].setSize(20,20);
    			gameSpaces[x][y].setOpaque(true);
    			gameSpaces[x][y].setBorderPainted(true);
    			if (gameSpaces[x][y].getColor() != Color.black) {
    				setupColor = gameSpaces[x][y].initialColor();
    				gameSpaces[x][y].addPiece(new GamePiece(setupColor));
    			}
    			gameBoard.add(gameSpaces[x][y]);
    		}
    	}
    	getContentPane().setLayout(new BorderLayout());
		getContentPane().add(topPanel, BorderLayout.NORTH);
		//getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		//getContentPane().add(rightPanel, BorderLayout.EAST);
		getContentPane().add(leftPanel, BorderLayout.WEST);
		getContentPane().add(gameBoard, BorderLayout.CENTER);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object selected = e.getSource();
		if(selected.equals(quit)) {
			String response = JOptionPane.showInputDialog(gameBoard, "Would You Like To Save? \n Type 'yes' or 'no'");
			response.toLowerCase();
			if(response.equals(response)) {
				System.exit(0);
			}
		if(selected.equals(colorBlindButton)) {
			
		}
		}
	}
    
    
   

	


	
	
}