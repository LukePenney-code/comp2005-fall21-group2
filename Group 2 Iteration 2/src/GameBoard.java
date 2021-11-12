import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.Random;
import java.util.ArrayList;
import java.lang.Math.*;

public class GameBoard extends JFrame implements ActionListener, MouseListener {
	
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel bottomPanel;
    private JPanel gameBoard;
    private GameSpace [][] gameSpaces;
    private int numPlayers, rows, columns;
    private Color setupColor; //used to set the color of the piece that starts in each space at the beginning of the game
    private JButton quit, colorBlindButton, save, load;
    private JLabel info;
    private JLabel currentTurn;
    private GameSpace moveFrom; //space that has been selected to move from
    private GameSpace moveTo; //space that has been selected to move to
    private Boolean moveFromSelected; //true when a space has already been selected to move from, used to determine if a space has been selected to move from or move to
    private int turn; //current turn, 1 to 4
    private ArrayList<GamePiece> transferStack; //used when making moves
    
    public GameBoard(){
    	
    	rows = 8;
    	columns = 8;
    	moveFromSelected = false;
    	Random rand = new Random();
    	turn = rand.nextInt(4) + 1;
    	
    	topPanel = new JPanel();
    	bottomPanel = new JPanel();
    	rightPanel = new JPanel();
    	leftPanel = new JPanel();
    	gameBoard = new JPanel();
    	quit = new JButton("Quit");
    	save = new JButton("Save");
    	load = new JButton("Load");
    	colorBlindButton = new JButton("Toggle Color Defiency Settings");
    	colorBlindButton.addActionListener(this);
    	quit.addActionListener(this);
    	currentTurn = new JLabel(this.getTurnColorString() + "'s turn");
    	topPanel.add(save);
    	topPanel.add(load);
    	topPanel.add(quit);
    	topPanel.add(colorBlindButton);
    	topPanel.add(currentTurn);
    	
    	
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
    			gameSpaces[x][y].addMouseListener(this);
    			if (gameSpaces[x][y].getColor() != Color.black) {
    				setupColor = gameSpaces[x][y].initialColor();
    				gameSpaces[x][y].addPiece(new GamePiece(setupColor));
    				gameSpaces[x][y].update();
    			}
    			gameBoard.add(gameSpaces[x][y]);
    		}
    	}
    	getContentPane().setLayout(new BorderLayout());
		getContentPane().add(topPanel, BorderLayout.NORTH);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		getContentPane().add(rightPanel, BorderLayout.EAST);
		getContentPane().add(leftPanel, BorderLayout.WEST);
		getContentPane().add(gameBoard, BorderLayout.CENTER);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
    }
    
    public void nextTurn() {
    	if (turn == 4) {
    		turn = 1;
    	}else {
    		turn++;
    	}
    	currentTurn.setText(this.getTurnColorString() + "'s turn");
    }
    
   
    
    public Color getTurnColor() {
    	// returns color of player whose turn it currently is
    	if (turn == 1) {
    		return Color.red;
    	}
    	if (turn == 2) {
    		return Color.green;
    	}
    	if (turn == 3) {
    		return Color.cyan;
    	}
    	if (turn == 4) {
    		return Color.yellow;
    	}
    	return null;
    }
    
    public String getTurnColorString() {
    	// returns color of player whose turn it currently is
    	if (turn == 1) {
    		return "red";
    	}
    	if (turn == 2) {
    		return "green";
    	}
    	if (turn == 3) {
    		return "cyan";
    	}
    	if (turn == 4) {
    		return "yellow";
    	}
    	return null;
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
		}
		if(selected.equals(colorBlindButton)) {
			info = new JLabel("Color Blind Mode is Active");
			topPanel.add(info);
			info.setVisible(true);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object selected = e.getSource();
		if (selected instanceof GameSpace) {
			if (moveFromSelected) {
				moveTo = (GameSpace) selected;
				if (moveTo.equals(moveFrom)) {
					//unselect space
					moveFromSelected = false;
					moveFrom.setBackground(Color.white);
				}else if (!(moveTo.getColor().equals(Color.black))) {
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
						moveFrom.update();
						moveTo.update();
						this.nextTurn();
					}
				}
			}else {
				//space has been selected to move from
				moveFrom = (GameSpace) selected;
				if (moveFrom.topPiece().getColor().equals(this.getTurnColor())) {
					moveFromSelected = true;
					moveFrom.setBackground(Color.gray);
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
    
   

	


	
	
