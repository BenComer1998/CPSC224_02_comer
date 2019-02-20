// TicTacToe



import java.swing.*;
import java.awt.*;
import java.awt.event.*;



public class TicTacToe extends JFrame {
	public static final int PANEL_WIDTH = 500;
	public static final int PANEL_HEIGHT = 500;
	
	public static final int ROWS = 3;
	public static final int COLUMNS = 3;
	// 2D JButton ARRAY!!! (Hint from Nadra)
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
	
	public TicTacToe() {
		
	}
	
}