// Standard Button Panel


import javax.swing.*;
import java.awt.*;

public class StandardButtons extends JPanel {
	private JButton newGameButton;
	private JButton resetButton;
	private JButton exitButton;
	private JPanel panel;
	
	// Constructor
	public StandardButtons() {
		setLayout(new GridLayout(1, 3));

		newGameButton = new JButton("New Game");
		resetButton = new JButton("Reset");
		exitButton = new JButton("Exit");
		
		newGameButton.addActionListener(new NewGameButtonListener());
		resetButton.addActionListener(new ResetButtonListener());
		exitButton.addActionListener(new ExitButtonListener());
		
		panel = new JPanel();
		panel.add(newGameButton);
		panel.add(resetButton);
		panel.add(exitButton);
	}
	
	private class NewGameButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class ResetButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class ExitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}