import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

public class StartMenu implements ActionListener, KeyListener, Serializable{
	private JLabel title,prompt, info,rules;
	private JFrame frame;
	private JButton start,load,quit, easy, hard, easy2, hard2, easy3, hard3, easy4, hard4, human1,human2,human3,human4;
	private ImageIcon logo;
	private int player_one_type, player_two_type, player_three_type, player_four_type;
	private GameBoard game;
	
	
	public StartMenu() {
		
		title = new JLabel("Domination!");
		prompt = new JLabel("Player 1           Player 2           Player 3          Player 4");
		info = new JLabel("Press 'i' for the rules");
		frame = new JFrame("Start Menu");
		frame.setSize(850,870);
		frame.setVisible(true);
		logo = new ImageIcon("C://Users//Luke Penney//Pictures//workingLogo.png");
		setUpLabel(frame,title,prompt,info,logo);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		start = new JButton("Start");
		load = new JButton("Load");
		quit = new JButton("Quit");
		setUpButtons(frame,start, load, quit);
		hard = new JButton("Hard");
		easy = new JButton("Easy");
		easy2 = new JButton("Easy");
		hard2 = new JButton("Hard");
		easy3 = new JButton("Easy");
		hard3 = new JButton("Hard");
		easy4 = new JButton("Easy");
		hard4 = new JButton("Hard");
		human1 = new JButton("Human");
		human2 = new JButton("Human");
		human3 = new JButton("Human");
		human4 = new JButton("Human");
		rules = new JLabel("<html>-You can move a piece on top of another piece or an empty space in one direction either horizontally or vertically but NOT diagonally.<br>-If you control a stack( your piece is on top of the stack) you can move multiple spaces, again not diagonally and only in one direction, but the space you are moving on to cannot be controlled by another colour. You can also choose to not move all pieces and leave the rest. You can only move to the amount of pieces you got in the stack or the amount of pieces you intend on moving.<br> -If a stack has more than 5 pieces you can remove the rest from the bottom and keep them as reserve pieces which can later be used in the game. You can only use pieces of your colour as reserve pieces but you can remove and keep pieces of another colour.<br>-The game ends when only one player can move the stacks. Meaning a player has a piece on top of every single stack. Last player who can make a move wins the game.</html>");
		
		difficultySetting(frame, easy, hard, easy2, hard2, easy3, hard3, easy4, hard4);
		groupMemberNames();
		frame.addKeyListener(this);
		
		
		
	}
	


	private void setUpButtons(JFrame frame, JButton start, JButton load, JButton quit) {
		// TODO Auto-generated method stub
		//ImageIcon startIcon = new ImageIcon("start.png");
		load.setBounds(20, 300, 100, 100);
		frame.getContentPane().add(load);
		load.setBackground(Color.RED);
		load.setFont(new Font("Bahaus 93", Font.PLAIN,20));
		quit.setBounds(20, 410, 100, 100);
		frame.getContentPane().add(quit);
		quit.setBackground(Color.RED);
		quit.setFont(new Font("Bahaus 93", Font.PLAIN,20));
		quit.addActionListener(this);
		start.setBounds(700, 550, 110, 100);
		load.addActionListener(this);
		//start.setIcon(startIcon);
		frame.getContentPane().add(start);
		start.setBackground(Color.RED);
		start.setFont(new Font("Bahaus 93", Font.PLAIN,20));
		start.addActionListener(this);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		start.setBorder(emptyBorder);
		quit.setBorder(emptyBorder);
		load.setBorder(emptyBorder);
	}
	
	private void difficultySetting(JFrame frame, JButton easy, JButton hard, JButton easy2, JButton hard2, JButton easy3, JButton hard3, JButton easy4, JButton hard4) {
		
		//Player 1 setup
		
		human1.setBounds(49, 760, 77, 60);
		frame.getContentPane().add(human1);
		human1.setBackground(Color.red);
		human1.setFont(new Font("Bahaus 93", Font.BOLD,12));
		human1.addActionListener(this);
		
		easy.setBounds(24, 700, 60, 60);
		frame.getContentPane().add(easy);
		hard.setBounds(84, 700, 60, 60);
		frame.getContentPane().add(hard);
		easy.setBackground(Color.red);
		hard.setBackground(Color.red);
		easy.setFont(new Font("Bahaus 93", Font.BOLD,11));
		hard.setFont(new Font("Bahaus 93", Font.BOLD,11));
		easy.addActionListener(this);
		hard.addActionListener(this);
		
		//Player 2 setup
		
		human2.setBounds(200, 760, 77, 60);
		frame.getContentPane().add(human2);
		human2.setBackground(Color.green);
		human2.setFont(new Font("Bahaus 93", Font.BOLD,12));
		human2.addActionListener(this);
		
		easy2.setBounds(180, 700, 60, 60);
		frame.getContentPane().add(easy2);
		hard2.setBounds(240, 700, 60, 60);
		frame.getContentPane().add(hard2);
		easy2.setBackground(Color.green);
		hard2.setBackground(Color.green);
		easy2.setFont(new Font("Bahaus 93", Font.BOLD,11));
		hard2.setFont(new Font("Bahaus 93", Font.BOLD,11));
		easy2.addActionListener(this);
		hard2.addActionListener(this);
		
		//Player 3 setup
		
		human3.setBounds(360, 760, 77, 60);
		frame.getContentPane().add(human3);
		human3.setBackground(Color.cyan);
		human3.setFont(new Font("Bahaus 93", Font.BOLD,12));
		human3.addActionListener(this);
		
		easy3.setBounds(340, 700, 60, 60);
		frame.getContentPane().add(easy3);
		hard3.setBounds(400, 700, 60, 60);
		frame.getContentPane().add(hard3);
		easy3.setBackground(Color.cyan);
		hard3.setBackground(Color.cyan);
		easy3.setFont(new Font("Bahaus 93", Font.BOLD,11));
		hard3.setFont(new Font("Bahaus 93", Font.BOLD,11));
		easy3.addActionListener(this);
		hard3.addActionListener(this);
		//Player 4 setup
		;
		human4.setBounds(510, 760, 77, 60);
		frame.getContentPane().add(human4);
		human4.setBackground(new Color(220,220,0));
		human4.setFont(new Font("Bahaus 93", Font.BOLD,12));
		human4.addActionListener(this);
		
		easy4.setBounds(490, 700, 60, 60);
		frame.getContentPane().add(easy4);
		hard4.setBounds(550, 700, 60, 60);
		frame.getContentPane().add(hard4);
		easy4.setBackground(new Color(220,220,0));
		hard4.setBackground(new Color(220,220,0));
		easy4.setFont(new Font("Bahaus 93", Font.BOLD,11));
		hard4.setFont(new Font("Bahaus 93", Font.BOLD,11));
		easy4.addActionListener(this);
		hard4.addActionListener(this);
		
	}



	private void setUpLabel(JFrame frame, JLabel title, JLabel prompt, JLabel info, ImageIcon logo) {
		// TODO Auto-generated method stub
		title.setIcon(logo);
		frame.add(title);
		frame.getContentPane().add(prompt);
		title.setVerticalTextPosition(JLabel.TOP);
		title.setHorizontalTextPosition(JLabel.CENTER);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("Algerian", Font.BOLD, 75));
		title.setForeground(Color.red);
		title.setBounds(120, 1, 600, 600);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.yellow);
		prompt.setBounds(50, 650, 580, 50);
		prompt.setFont(new Font("MV Boli",Font.BOLD,16));
		frame.getContentPane().add(info);
		info.setBounds(650, 160, 150, 20);
		info.setFont(new Font("Times new roman",Font.BOLD,16));
		info.setForeground(Color.red);
		
		
	}
	
	public void groupMemberNames() {
		JLabel luke = new JLabel("Luke");
		JLabel evan = new JLabel("Evan");
		JLabel farhan = new JLabel("Farhan");
		JLabel raveen = new JLabel("Raveen");
		frame.getContentPane().add(raveen);
		frame.getContentPane().add(luke);
		frame.getContentPane().add(evan);
		frame.getContentPane().add(farhan);
		luke.setBounds(20, 30, 100, 100);
		luke.setForeground(Color.red);
		luke.setFont(new Font("Algerian", Font.BOLD, 16));
		evan.setBounds(20, 50, 100, 100);
		evan.setForeground(Color.red);
		evan.setFont(new Font("Algerian", Font.BOLD, 16));
		farhan.setBounds(20, 70, 100, 100);
		farhan.setForeground(Color.red);
		farhan.setFont(new Font("Algerian", Font.BOLD, 16));
		raveen.setBounds(20, 90, 100, 100);
		raveen.setForeground(Color.red);
		raveen.setFont(new Font("Algerian", Font.BOLD, 16));
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object selected = e.getSource();
		if(selected == start) {
			new GameBoard(player_one_type, player_two_type, player_three_type, player_four_type);
			frame.dispose();
		}
		if(selected==load){
			new GameBoard(player_one_type, player_two_type, player_three_type, player_four_type).load();

		}
		
		if(selected == quit) {
			frame.dispose();
		}
		if(selected == easy) {
			this.player_one_type = 1;
						
		}
		if(selected == hard) {
			this.player_one_type = 2;
			//players[0].setType(2);
		}
		if(selected == easy2) {
			this.player_two_type = 1;
			//players[1].setType(1);
		}
		if(selected == hard2) {
			this.player_two_type = 2;
			//players[1].setType(2);
		}
		if(selected == easy3) {
			this.player_three_type = 1;
			//players[2].setType(1);
		}
		if(selected == hard3) {
			this.player_three_type = 2;
			//players[2].setType(2);
		}
		if(selected == easy4) {
			this.player_four_type = 1;
			//players[3].setType(1);
		}
		if(selected == hard4) {
			this.player_four_type = 2;
			//players[3].setType(2);
		}
		if(selected == human1) {
			this.player_one_type = 0;
		}
		if(selected == human2) {
			this.player_two_type = 0;
		}
		if(selected == human3) {
			this.player_three_type = 0;
		}
		if(selected == human4) {
			this.player_four_type = 0;
		}
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		
		
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		JFrame infoMenu = new JFrame("Rules");
		switch(e.getKeyCode()){
		case 73 : 
		           infoMenu.setSize(500,700);
				   infoMenu.setVisible(true);
				   infoMenu.getContentPane().add(rules);
		
		}
		if(e.getKeyCode() == 27) {
			frame.dispose();
		}
		
		
		
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
