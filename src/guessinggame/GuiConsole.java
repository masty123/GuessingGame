package guessinggame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/*
 * A GUI for guessing game 
 * @author Theeruth Borisuth
 */


public class GuiConsole {
	private static GuessingGame game ;
	//title of the game 
	private JFrame frame ;
	//Input field
	private JTextField input ;
	//Submit button
	private JButton enter ;
	//Command
	private JLabel label ;
	//A button for a loser, lolz.
	private JButton giveup ;
	//Hint
	private String consolehint ;
	//Hint text
	private JLabel hint ;
	//counter when clicked a button.
	private JLabel counter;// count button clicks
	//Constructor for gui
	public GuiConsole(GuessingGame game)
	{
		this.game =  game ;
		initComponents();
	}
	/*
	 * Initialize components()
	 */
	private void initComponents() {
	
		frame = new JFrame("Guess A Number!");
		label = new JLabel("Enter Your Guess :");
		input = new JTextField(10);
		input.setHorizontalAlignment(SwingConstants.CENTER);
		enter = new JButton("Enter");
		giveup = new JButton("Give up");
		hint = new JLabel(consolehint);
		counter = new JLabel(game.getHint());
		
		JPanel panel = new JPanel();
		JPanel hintPanel = new JPanel();
		panel.add(input);
		panel.add(enter);
		panel.add(giveup);
		hintPanel.setBorder(BorderFactory.createTitledBorder("hint"));
		hintPanel.add(hint);
		
		frame.add(panel,BorderLayout.CENTER);
		frame.add(hintPanel,BorderLayout.NORTH);
		frame.add(counter,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		ButtonListener listener = new ButtonListener();
		enter.addActionListener(listener);
		input.addActionListener(listener);

		GiveUp giveuplistener = new GiveUp();
		giveup.addActionListener(giveuplistener);
	}
	/**
	 * Display the graphic window
	 */
	public void run()
	{
		frame.setVisible(true);
	}
	/*
	 * Performing The Task of the button.
	 */
	class ButtonListener implements ActionListener
	{	private int count = 0 ;
		@Override
		public void actionPerformed(ActionEvent event)
		{
				try
				{
					int num = Integer.parseInt(input.getText().trim());
					game.setHint(num);
					if (game.guess(num))
					{
						
						consolehint = "CORRECT!! YOU'VE WON!";
						hint.setText(consolehint);
						JOptionPane.showMessageDialog(frame, consolehint);
						input.setEnabled(false);

					}
					else
					{
						consolehint = input.getText()+ " "+game.getHint() +"try again." ;
						hint.setText(consolehint);
					}
					input.setText("");
					
				Object source = event.getSource();
				System.out.println("Even source: "+ source.getClass().getName());
				String cmd = event.getActionCommand();
				System.out.println("Action command: "+cmd);
				
				count += 1;
				}catch (NumberFormatException E)
				{
					hint.setText("Wrong answer, please try again.");
				}
		}
	}
	/*
	 * Performing The Task of the giveup button.
	 */
	class  GiveUp implements ActionListener
	{	private int count = 0 ;
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(frame, consolehint);
			game.getRandomNumber(100);
			game.counter = 0 ;

			Object source = event.getSource();
			System.out.println("Even source: "+ source.getClass().getName());
			String cmd = event.getActionCommand();
			System.out.println("Action command: "+cmd);
		}
	}
	/*
	 * Main of the class.
	 */
	public static void main(String[]args)
	{	
		GuessingGame game = new GuessingGame(100);
		GuiConsole gui = new GuiConsole(game);
		gui.run();
		System.out.println("Lauching guessing game...");
	}
	
}
