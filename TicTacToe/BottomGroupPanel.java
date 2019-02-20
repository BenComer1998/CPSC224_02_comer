// BottomGroupPanel


import javax.swing.*;

public class BottomGroupPanel extends JPanel {
	private StandardButtons buttons;
	private StatusPanel status;
	private JPanel panel;
	
	public BottomGroupPanel {
		panel = new JPanel();
		setLayout(new BorderLayout());
		
		buttons = new StandardButtons();
		status = new StatusPanel();
		
		panel.add(buttons, BorderLayout.NORTH);
		panel.add(status, BorderLayout.SOUTH);
	}
}