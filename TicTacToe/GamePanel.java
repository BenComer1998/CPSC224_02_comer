// Game panel

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {	
	
	Stats stats1;
	Stats stats2;
	TicTacToeBoard board;
	
	public GamePanel() {
		setLayout(new GridLayout(2, 1));
		
		stats1 = new Stats(1);
		stats2 = new Stats(2);
		board = new TicTacToeBoard();
		
		add(stats1, BorderLayout.WEST);
		add(stats2, BorderLayout.EAST);
		add(board, BorderLayout.SOUTH);
	}
}