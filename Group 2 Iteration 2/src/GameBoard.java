import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.Random;
import java.util.ArrayList;
import java.lang.Math.*;

public class GameBoard extends JFrame implements ActionListener {
	
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel bottomPanel;
    private JPanel gameBoard;
    private GameSpace [][] gameSpaces;
    private int numPlayers, rows, columns;
    private Color setupColor; //used to set the color of the piece that starts in each space at the beginning of the game
    private Color defaultButtonColor; //used when button is selected/deselected
    private JButton quit, colorBlindButton, save, load, reserve;
    private JLabel colorBlindInfo, currentTurn, reserveInfo, colorKey;
    private GameSpace moveFrom; //space that has been selected to move from
    private GameSpace moveTo; //space that has been selected to move to
    private boolean moveFromSelected; //true when a space has already been selected to move from, used to determine if a space has been selected to move from or move to
    private int turn; //current turn, 0 to 3
    private ArrayList<GamePiece> transferStack; //used when making moves
    private boolean colorBlindOn;
    private Player currentPlayer;
    private Player[] players;
    private int noMoveCount; //Counts how many players in a row cannot move. If 3 players cannot move the 4th player wins.
    
    public GameBoard(){
    	
    	rows = 8;
    	columns = 8;
    	moveFromSelected = false;
    	Random rand = new Random();
    	colorBlindOn = false;
    	noMoveCount = 0;
    	
    	turn = rand.nextInt(4);
    	players = new Player[4];
    	players[0] = new Player(0, Color.red);
    	players[1] = new Player(0, Color.green);
    	players[2] = new Player(0, Color.cyan);
    	players[3] = new Player(0, Color.yellow);
    	currentPlayer = players[turn];
    	
    	topPanel = new JPanel();
    	//bottomPanel = new JPanel();
    	rightPanel = new JPanel();
    	leftPanel = new JPanel();
    	gameBoard = new JPanel();
    	colorBlindInfo = new JLabel(" ");
		topPanel.add(colorBlindInfo);
		colorBlindInfo.setVisible(true);
    	quit = new JButton("Quit");
    	colorBlindButton = new JButton("Toggle Color Defiency Settings");
    	colorBlindButton.addActionListener(this);
    	quit.addActionListener(this);
    	save = new JButton("Save");
    	save.addActionListener(e -> { save();} );
    	load = new JButton("Load");
    	load.addActionListener(e -> { load();});
    	reserve = new JButton("Reserve");
    	defaultButtonColor = reserve.getBackground();
    	reserve.addActionListener(this);
    	
    	currentTurn = new JLabel(this.getTurnColorString() + "'s turn");
    	topPanel.add(quit);
    	topPanel.add(colorBlindButton);
    	topPanel.add(currentTurn);
    	topPanel.add(save);
    	topPanel.add(load);
    	topPanel.add(reserve);
    	
    	this.setSize(500,500);
    	
    	topPanel.setLayout(new FlowLayout());
    	topPanel.setSize(200,200);
    	//bottomPanel.setLayout(new FlowLayout());
    	
    	gameBoard.setLayout(new GridLayout(rows, columns));
    	gameBoard.setSize(800,800);
    	
    	gameSpaces = new GameSpace[rows][columns];
    	for (int y = 0; y < rows; y++) {
    		for (int x = 0 ; x < columns; x++) {
    			gameSpaces[x][y] = new GameSpace(x, y);
    			gameSpaces[x][y].setSize(20,20);
    			gameSpaces[x][y].setOpaque(true);
    			gameSpaces[x][y].setBorderPainted(true);
    			gameSpaces[x][y].addActionListener(this);
    			if (gameSpaces[x][y].getColor() != Color.black) {
    				setupColor = gameSpaces[x][y].initialColor();
    				gameSpaces[x][y].addPiece(new GamePiece(setupColor));
    				gameSpaces[x][y].updateVisual();
    			
    			}
    			gameBoard.add(gameSpaces[x][y]);
    		}
    	}
    	reserveInfo = new JLabel("<html>Reserve:<br/>Red: 0<br/>Green: 0<br/>Blue: 0<br/>Yellow: 0<html>");
    	reserveInfo.setForeground(Color.white);
    	gameSpaces[7][0].add(reserveInfo);
    	colorKey = new JLabel(" ");
    	gameSpaces[7][7].add(colorKey);
    	
    	getContentPane().setLayout(new BorderLayout());
		getContentPane().add(topPanel, BorderLayout.NORTH);
		//getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		getContentPane().add(rightPanel, BorderLayout.EAST);
		getContentPane().add(leftPanel, BorderLayout.WEST);
		getContentPane().add(gameBoard, BorderLayout.CENTER);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
    }
    public void updateReserveInfo() {
    	reserveInfo.setText("<html>Reserve:<br/>Red: " + players[0].getReserve() + "<br/>Green: " + players[1].getReserve() + "<br/>Blue: " +
    			players[2].getReserve() + "<br/>Yellow: "+ players[3].getReserve() + "<html>");
    }
    
    public void nextTurn() {
    	if (turn == 3) {
    		turn = 0;
    	}else {
    		turn++;
    	}
    	currentPlayer = players[turn];
    	if (noMoveCount == 3) {
    		this.declareWinner();
    	}else {
	    	if (!(this.isMovePossible())) {
	    		noMoveCount++;
	    		this.nextTurn();
	    	}
	    	currentTurn.setText(this.getTurnColorString() + "'s turn");
    	}
    }
    
    public boolean isMovePossible() {
    	//finish this
    	return true; //placeholder
    }
    
    public void declareWinner() {
    	colorBlindInfo.setText(this.getTurnColorString() + " wins!");
    	currentTurn.setText("Click Reset to play again");
    	// gameWon = true, use this to stop button clicks
    }
    
    public Color getTurnColor() {
    	// returns color of player whose turn it currently is
    	return currentPlayer.getColor();
    }
    
    public String getTurnColorString() {
    	// returns color of player whose turn it currently is
    	if (turn == 0) {
    		return "red";
    	}
    	if (turn == 1) {
    		return "green";
    	}
    	if (turn == 2) {
    		return "blue";
    	}
    	if (turn == 3) {
    		return "yellow";
    	}
    	return null;
    }
    public void save() {
		/*
		 * JFrame popUp = new JFrame(); JTextBox saveField = new
		 * JTextBox("Enter save name"); popUp.add(saveField); String saveName =
		 * saveField.getText(); popUp.setVisible(true);
		 */
    	SaveLoadGame data = new SaveLoadGame();
    	try {
    		ResourceManager.save(data, "1.save");
    		
    	} catch(Exception e1) {
    		System.out.println("Could not save" + e1.getMessage());
    	}
    }
    public void load() {
    	
    	
    }
    
    public void setColorBlind() {
    	if (colorBlindOn) {
			for (int y = 0; y < rows; y++) {
		    	for (int x = 0 ; x < columns; x++) {
		    		if (!(gameSpaces[x][y].getColor().equals(Color.black))) {
			    		for (int i = 0; i < 5; i++) {
			    			int j = (gameSpaces[x][y].getStackSize() - 1) - i;
			    			if (gameSpaces[x][y].getPieceColor(i).equals(Color.red)) {
			    				gameSpaces[x][y].getLabel(j).setText("O O O O O");
			    			}else if (gameSpaces[x][y].getPieceColor(i).equals(Color.cyan)) {
			    				gameSpaces[x][y].getLabel(j).setText("| | | | |");
			    			}else if (gameSpaces[x][y].getPieceColor(i).equals(Color.yellow)) {
			    				gameSpaces[x][y].getLabel(j).setText("- - - - -");
			    			}else if (gameSpaces[x][y].getPieceColor(i).equals(Color.green)) {
			    				gameSpaces[x][y].getLabel(j).setText("X X X X X");
			    			}else if (gameSpaces[x][y].getPieceColor(i).equals(Color.white)) {
			    				gameSpaces[x][y].getLabel(i).setText(" ");
			    			}
			    		}
		    		}
		    	}
			}
		}else {
			for (int y = 0; y < rows; y++) {
		   		for (int x = 0 ; x < columns; x++) {
		   			if (!(gameSpaces[x][y].getColor().equals(Color.black))) {
		   				for (int i = 0; i < 5; i++) {
		   					gameSpaces[x][y].getLabel(i).setText(" ");
		   				}
		    		}
		    	}
			}
		}
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object selected = e.getSource();
		if(selected.equals(quit)) {
			String response = JOptionPane.showInputDialog(gameBoard, "Would You Like To Save? \n Type 'yes' or 'no'");
			response.toLowerCase();
			if(response.equals("no")) {
				System.exit(0);
			}
			if(response.equals("yes")) {
				save();
			}
		}
		if (selected.equals(colorBlindButton)) {
			if (colorBlindOn) {
				colorBlindOn = false;
				colorBlindInfo.setText(" ");
				colorKey.setText(" ");
			}else {
				colorBlindOn = true;
				colorBlindInfo.setText("Color Blind Mode is Active");
				colorKey.setText("<html>Color key:<br/>Red: O<br/>Green: X<br/>Blue: |<br/>Yellow: -<html>");
				colorKey.setForeground(Color.white);
			}
			this.setColorBlind();
		}
		if (selected.equals(reserve)) {
			if (!(moveFromSelected) && reserve.getBackground().equals(defaultButtonColor) && (currentPlayer.getReserve() > 0)) {
				reserve.setBackground(Color.gray);
				moveFromSelected = true;
			}else if (moveFromSelected && reserve.getBackground().equals(Color.gray)) {
				reserve.setBackground(defaultButtonColor);
				moveFromSelected = false;
			}
		}
		if (selected instanceof GameSpace) {
			if (moveFromSelected) {
				moveTo = (GameSpace) selected;
				if (!(moveTo.getColor().equals(Color.black))) {
					if (reserve.getBackground().equals(Color.gray)) {
						//make reserve move
						reserve.setBackground(defaultButtonColor);
						moveFromSelected = false;
						currentPlayer.decrementReserve();
						moveTo.addPiece(new GamePiece(currentPlayer.getColor()));
						int toReserve = moveTo.updateStack(this.getTurnColor()); //updateStack must come before updateVisual
						currentPlayer.incrementReserve(toReserve);
						moveTo.updateVisual();
						this.updateReserveInfo();
						this.nextTurn();
						this.setColorBlind();
					}else if (moveTo.equals(moveFrom)) {
						//unselect space
						moveFromSelected = false;
						moveFrom.setBackground(Color.white);
					}else {
						//space has been selected to move to
						int xDist = Math.abs(moveTo.getXcoord() - moveFrom.getXcoord());
						int yDist = Math.abs(moveTo.getYcoord() - moveFrom.getYcoord());
						int distance = xDist + yDist;
						if ((distance <= moveFrom.getStackSize()) && ((xDist == 0) || (yDist == 0))) {
							moveFromSelected = false;
							moveFrom.setBackground(Color.white);
							transferStack = new ArrayList<GamePiece>();
							int i = 0;
							while (i < distance) {
								transferStack.add(moveFrom.topPiece());
								moveFrom.removeTop();
								i++;
							}
							i--;
							while (i >= 0) {
								moveTo.addPiece(transferStack.get(i));
								i--;
							}
							moveFrom.updateVisual();
							int toReserve = moveTo.updateStack(this.getTurnColor());
							currentPlayer.incrementReserve(toReserve);
							moveTo.updateVisual();
							this.updateReserveInfo();
							this.nextTurn();
							this.setColorBlind();
						}
					}
				}
			}else {
				//space has been selected to move from
				moveFrom = (GameSpace) selected;
				if (!(moveFrom.getColor().equals(Color.black)) && (moveFrom.getStackSize() > 0)) {
					if (moveFrom.topPiece().getColor().equals(this.getTurnColor())) {
						moveFromSelected = true;
						moveFrom.setBackground(Color.gray);
					}
				}
			}
		}
	}
}
    
   

	


	
	
