// Status panel


import javax.swing.*;

public class StatusPanel extends JFrame {
	private JLabel statusBar;
	private JPanel panel;
	
	public StatusPanel() {
		panel = new JPanel();
		
		statusBar = new JLabel("", LEFT);
		panel.add(statusBar);
	}
}