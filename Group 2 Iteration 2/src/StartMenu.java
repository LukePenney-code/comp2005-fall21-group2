import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu implements ActionListener{
	private JLabel title,prompt;
	private JFrame frame;
	private JButton start,load,quit, easy, hard;
	private ImageIcon logo;
	
	public StartMenu() {
		
		title = new JLabel("Domination");
		prompt = new JLabel("What Difficulty would you like to play on?");
		frame = new JFrame("Start Menu");
		frame.setSize(850,850);
		frame.setVisible(true);
		logo = new ImageIcon("C://Users//Luke Penney//Pictures//pixlr-bg-result (1).png");
		setUpLabel(frame,title,prompt,logo);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		start = new JButton("Start");
		load = new JButton("Load");
		quit = new JButton("Quit");
		setUpButtons(frame,start, load, quit);
		hard = new JButton("Hard");
		easy = new JButton("Easy");
		difficultySetting(frame, easy, hard);
		
		
		
		
		
	}
	


	private void setUpButtons(JFrame frame, JButton start, JButton load, JButton quit) {
		// TODO Auto-generated method stub
		load.setBounds(20, 300, 100, 100);
		frame.getContentPane().add(load);
		load.setBackground(Color.RED);
		quit.setBounds(20, 400, 100, 100);
		frame.getContentPane().add(quit);
		quit.setBackground(Color.RED);
		start.setBounds(700, 600, 100, 100);
		frame.getContentPane().add(start);
		start.setBackground(Color.RED);
		start.addActionListener(this);
	}
	
	private void difficultySetting(JFrame frame, JButton easy, JButton hard) {
		easy.setBounds(200, 700, 200, 100);
		frame.getContentPane().add(easy);
		hard.setBounds(410, 700, 200, 100);
		frame.getContentPane().add(hard);
		easy.setBackground(Color.red);
		hard.setBackground(Color.red);
		
		
	}



	private void setUpLabel(JFrame frame, JLabel title, JLabel prompt, ImageIcon logo) {
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
		frame.getContentPane().setBackground(Color.YELLOW);
		prompt.setBounds(250, 650, 400, 50);
		prompt.setFont(new Font("MV Boli",Font.BOLD,16));
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object selected = e.getSource();
		if(selected == start) {
			new GameBoard();
			frame.dispose();
		}
		
	}
	

}
