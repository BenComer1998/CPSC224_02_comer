// BottomGroupPanel


import javax.swing.*;

public class BottomGroupPanel extends JFrame {
	private StandardButtons buttons;
	private StatusPanel status;
	private JPanel panel;
	
	public BottomGroupPanel {
		setLayout(new GridLayout(2, 1));
		panel = new JPanel();
		
		buttons = new StandardButtons();
		status = new StatusPanel();
		
		panel.add(buttons);
		panel.add(status);
	}
}