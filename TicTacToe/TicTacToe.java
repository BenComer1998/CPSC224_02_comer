// TicTacToe



import java.swing.*;
import java.awt.*;
import java.awt.event.*;



public class TicTacToe extends JFrame {
	public static final int FRAME_WIDTH = 500;
	public static final int FRAME_HEIGHT = 500;
	
	public static final int ROWS = 3;
	public static final int COLUMNS = 3;
	// 2D JButton ARRAY!!! (Hint from Guizani)
	public int board[][];
	board = new int [ROWS] [COLUMNS];
	
	public enum Fill {
		EMPTY, EX, OH
	}
	private int currentPlayer;
	
	public enum GameState {
		GAME_SETUP, GAME_IN_PROGRESS, POST_GAME
	}
	private int gameState;
	
	// private GamePanel gamePanel;
	private BottomGroupPanel bottomPanel;
	
	public TicTacToe() {
		setTitle("Tic-Tac-Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		// gamePanel = new GamePanel();
		bottomPanel = new BottomGroupPanel();
		
		// add(gamePanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TicTacToe();
	}
}