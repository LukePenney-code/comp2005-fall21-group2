import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartMenu implements ActionListener, KeyListener{
	private JLabel title,prompt, info;
	private JFrame frame;
	private JButton start,load,quit, easy, hard, easy2, hard2, easy3, hard3, easy4, hard4;
	private ImageIcon logo;
	
	public StartMenu() {
		
		title = new JLabel("Domination!");
		prompt = new JLabel("Player 1           Player 2           Player 3          Player 4");
		info = new JLabel("Press 'i' for the rules");
		frame = new JFrame("Start Menu");
		frame.setSize(850,870);
		frame.setVisible(true);
		logo = new ImageIcon("workingLogo.png");
		setUpLabel(frame,title,prompt,info,logo);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		start = new JButton();
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
		
		difficultySetting(frame, easy, hard, easy2, hard2, easy3, hard3, easy4, hard4);
		groupMemberNames();
		frame.addKeyListener(this);
		
		
		
		
		
	}
	


	private void setUpButtons(JFrame frame, JButton start, JButton load, JButton quit) {
		// TODO Auto-generated method stub
		ImageIcon startIcon = new ImageIcon("start.png");
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
		start.setIcon(startIcon);
		frame.getContentPane().add(start);
		start.setBackground(Color.YELLOW);
		start.addActionListener(this);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		start.setBorder(emptyBorder);
		quit.setBorder(emptyBorder);
		load.setBorder(emptyBorder);
	}
	
	private void difficultySetting(JFrame frame, JButton easy, JButton hard, JButton easy2, JButton hard2, JButton easy3, JButton hard3, JButton easy4, JButton hard4) {
		
		//Player 1 setup
		JButton human = new JButton("Human");
		human.setBounds(49, 760, 77, 60);
		frame.getContentPane().add(human);
		human.setBackground(Color.red);
		human.setFont(new Font("Bahaus 93", Font.BOLD,12));
		
		easy.setBounds(24, 700, 60, 60);
		frame.getContentPane().add(easy);
		hard.setBounds(84, 700, 60, 60);
		frame.getContentPane().add(hard);
		easy.setBackground(Color.red);
		hard.setBackground(Color.red);
		easy.setFont(new Font("Bahaus 93", Font.BOLD,11));
		hard.setFont(new Font("Bahaus 93", Font.BOLD,11));
		
		//Player 2 setup
		JButton human2 = new JButton("Human");
		human2.setBounds(200, 760, 77, 60);
		frame.getContentPane().add(human2);
		human2.setBackground(Color.cyan);
		human2.setFont(new Font("Bahaus 93", Font.BOLD,12));
		
		easy2.setBounds(180, 700, 60, 60);
		frame.getContentPane().add(easy2);
		hard2.setBounds(240, 700, 60, 60);
		frame.getContentPane().add(hard2);
		easy2.setBackground(Color.cyan);
		hard2.setBackground(Color.cyan);
		easy2.setFont(new Font("Bahaus 93", Font.BOLD,11));
		hard2.setFont(new Font("Bahaus 93", Font.BOLD,11));
		
		//Player 3 setup
		JButton human3 = new JButton("Human");
		human3.setBounds(360, 760, 77, 60);
		frame.getContentPane().add(human3);
		human3.setBackground(Color.green);
		human3.setFont(new Font("Bahaus 93", Font.BOLD,12));
		
		easy3.setBounds(340, 700, 60, 60);
		frame.getContentPane().add(easy3);
		hard3.setBounds(400, 700, 60, 60);
		frame.getContentPane().add(hard3);
		easy3.setBackground(Color.green);
		hard3.setBackground(Color.green);
		easy3.setFont(new Font("Bahaus 93", Font.BOLD,11));
		hard3.setFont(new Font("Bahaus 93", Font.BOLD,11));
		
		//Player 4 setup
		JButton human4 = new JButton("Human");
		human4.setBounds(510, 760, 77, 60);
		frame.getContentPane().add(human4);
		human4.setBackground(new Color(220,220,0));
		human4.setFont(new Font("Bahaus 93", Font.BOLD,12));
		
		easy4.setBounds(490, 700, 60, 60);
		frame.getContentPane().add(easy4);
		hard4.setBounds(550, 700, 60, 60);
		frame.getContentPane().add(hard4);
		easy4.setBackground(new Color(220,220,0));
		hard4.setBackground(new Color(220,220,0));
		easy4.setFont(new Font("Bahaus 93", Font.BOLD,11));
		hard4.setFont(new Font("Bahaus 93", Font.BOLD,11));
		
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
			new GameBoard();
			frame.dispose();
		}
		
		if(selected == quit) {
			frame.dispose();
		}
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		
		
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case 73 : JFrame infoMenu = new JFrame("Rules");
		           infoMenu.setSize(500,700);
				   infoMenu.setVisible(true);
				   
		//case 27 : frame.dispose();
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
