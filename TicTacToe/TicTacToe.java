import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

enum Fill {
	EMPTY, EX, OH
}

public class TicTacToe extends JFrame {
	private JPanel panel;
	public static final int FRAME_WIDTH = 500;
	public static final int FRAME_HEIGHT = 500;
	public static Font boldFont = new Font("Arial", Font.BOLD, 24);	

	private static Fill currentPlayer = Fill.EX; ///FIX ME
	private int turnNumber = 1;

	private static final int ROWS = 3;
	private static final int COLUMNS = 3;

	public String xName = "Player 1";
	public int xWins = 0;
	public String oName = "Player 2";
	public int oWins = 0;
	
	ImageIcon pokeball = new ImageIcon("Pokeball.png");
	ImageIcon unknownx = new ImageIcon("Unknown_X.png");
	ImageIcon unknowno = new ImageIcon("Unknown_O.png");

	public StatsGroup stats = new StatsGroup();
	private TicTacToeBoard board = new TicTacToeBoard();
	private BottomGroupPanel bottomGroup = new BottomGroupPanel();

	public TicTacToe() {
		setTitle("Tic-Tac-Toe");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		add(stats, BorderLayout.NORTH);
		add(board);
		add(bottomGroup, BorderLayout.SOUTH);

		// pack();
		setVisible(true);
	}

	// adds a player loss
	public void addXWin(){
		xWins++;
	}
	// adds a player win
	public void addOWin(){
		oWins++;
	}
	
	public void updateWins() {
		stats.statsPlayer1.numberOfWins.setText(String.valueOf(xWins));
		stats.statsPlayer1.numberOfLosses.setText(String.valueOf(oWins));
		stats.statsPlayer2.numberOfWins.setText(String.valueOf(oWins));
		stats.statsPlayer2.numberOfLosses.setText(String.valueOf(xWins));
	}

	public static Fill getCurrentPlayer() {
		return currentPlayer;
	}

	private static void setCurrentPlayer(Fill player) {
		currentPlayer = player;
	}

	public void incrementTurn(){
		board.incrementTurn();
	}

	public static void toggleCurrentPlayer() {
		if (getCurrentPlayer() == Fill.EX)
			setCurrentPlayer(Fill.OH);
		else if (getCurrentPlayer() == Fill.OH)
			setCurrentPlayer(Fill.EX);
		else // The game starts with EX
			setCurrentPlayer(Fill.EX);
	}

	public class TicTacToeBoard extends JPanel {

	private JButton[][] boxes;
	private Fill[][] status;

	public TicTacToeBoard() {
		setLayout(new GridLayout(ROWS, COLUMNS));

		boxes = new JButton [ROWS][COLUMNS];
		status = new Fill [ROWS][COLUMNS];

		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLUMNS; ++col) {
				boxes[row][col] = new JButton(pokeball);
				boxes[row][col].addActionListener(new TTTButtonListener());
				status[row][col] = Fill.EMPTY;
				add(boxes[row][col]);
			}
		}
		
		disableBoard();
	}

		private class TTTButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Fill currentPlayer = TicTacToe.getCurrentPlayer();
				if (e.getSource() == boxes[0][0]) {
					boxes[0][0].setEnabled(false);
					if (currentPlayer == Fill.EX) {
						boxes[0][0].setIcon(unknownx);
						status[0][0] = Fill.EX;
					}
					else if (currentPlayer == Fill.OH) {
						boxes[0][0].setIcon(unknowno);
						status[0][0] = Fill.OH;
					}
				}
				else if (e.getSource() == boxes[0][1]) {
					boxes[0][1].setEnabled(false);
					if (currentPlayer == Fill.EX) {
						boxes[0][1].setIcon(unknownx);
						status[0][1] = Fill.EX;
					}
					else if (currentPlayer == Fill.OH) {
						boxes[0][1].setIcon(unknowno);
						status[0][1] = Fill.OH;
					}
				}
				else if (e.getSource() == boxes[0][2]) {
					boxes[0][2].setEnabled(false);
					if (currentPlayer == Fill.EX) {
						boxes[0][2].setIcon(unknownx);
						status[0][2] = Fill.EX;
					}
					else if (currentPlayer == Fill.OH) {
						boxes[0][2].setIcon(unknowno);
						status[0][2] = Fill.OH;
					}
				}
				else if (e.getSource() == boxes[1][0]) {
					boxes[1][0].setEnabled(false);
					if (currentPlayer == Fill.EX) {
						boxes[1][0].setIcon(unknownx);
						status[1][0] = Fill.EX;
					}
					else if (currentPlayer == Fill.OH) {
						boxes[1][0].setIcon(unknowno);
						status[1][0] = Fill.OH;
					}
				}
				else if (e.getSource() == boxes[1][1]) {
					boxes[1][1].setEnabled(false);
					if (currentPlayer == Fill.EX) {
						boxes[1][1].setIcon(unknownx);
						status[1][1] = Fill.EX;
					}
					else if (currentPlayer == Fill.OH) {
						boxes[1][1].setIcon(unknowno);
						status[1][1] = Fill.OH;
					}
				}
				else if (e.getSource() == boxes[1][2]) {
					boxes[1][2].setEnabled(false);
					if (currentPlayer == Fill.EX) {
						boxes[1][2].setIcon(unknownx);
						status[1][2] = Fill.EX;
					}
					else if (currentPlayer == Fill.OH) {
						boxes[1][2].setIcon(unknowno);
						status[1][2] = Fill.OH;
					}
				}
				else if (e.getSource() == boxes[2][0]) {
					boxes[2][0].setEnabled(false);
					if (currentPlayer == Fill.EX) {
						boxes[2][0].setIcon(unknownx);
						status[2][0] = Fill.EX;
					}
					else if (currentPlayer == Fill.OH) {
						boxes[2][0].setIcon(unknowno);
						status[2][0] = Fill.OH;
					}
				}
				else if (e.getSource() == boxes[2][1]) {
					boxes[2][1].setEnabled(false);
					if (currentPlayer == Fill.EX) {
						boxes[2][1].setIcon(unknownx);
						status[2][1] = Fill.EX;
					}
					else if (currentPlayer == Fill.OH) {
						boxes[2][1].setIcon(unknowno);
						status[2][1] = Fill.OH;
					}
				}
				else if (e.getSource() == boxes[2][2]) {
					boxes[2][2].setEnabled(false);
					if (currentPlayer == Fill.EX) {
						boxes[2][2].setIcon(unknownx);
						status[2][2] = Fill.EX;
					}
					else if (currentPlayer == Fill.OH) {
						boxes[2][2].setIcon(unknowno);
						status[2][2] = Fill.OH;
					}
				}

				if (turnNumber > 4 && isTicTacToe()) {
					if (currentPlayer == Fill.EX){
						JOptionPane.showMessageDialog(null, xName + " Wins!");
						addXWin();
					}
					else {
						JOptionPane.showMessageDialog(null, oName + " Wins!");
						addOWin();
					}
					updateWins();
					disableBoard();
					bottomGroup.statusBar.setText("Press \"New Game\" to play again.");
				}
				else if (turnNumber == 9) {
					JOptionPane.showMessageDialog(null, "Cat\'s Game!");
					bottomGroup.statusBar.setText("Press \"New Game\" to play again.");
				}
				else {
					TicTacToe.toggleCurrentPlayer();
					if (TicTacToe.getCurrentPlayer() == Fill.EX) {
						bottomGroup.statusBar.setText(xName + "\'s turn.");
					}
					else {
						bottomGroup.statusBar.setText(oName + "\'s turn.");
					}
					incrementTurn();
				}
			}
		}

		private boolean isTicTacToe() {
			Fill currentPlayer = TicTacToe.getCurrentPlayer();

			return (
				(status[0][0] == currentPlayer && // First row
				status[0][1] == currentPlayer &&
				status[0][2] == currentPlayer) ||
				(status[1][0] == currentPlayer && // Second row
				status[1][1] == currentPlayer &&
				status[1][2] == currentPlayer) ||
				(status[2][0] == currentPlayer && // Third row
				status[2][1] == currentPlayer &&
				status[2][2] == currentPlayer) ||
				(status[0][0] == currentPlayer && // First column
				status[1][0] == currentPlayer &&
				status[2][0] == currentPlayer) ||
				(status[0][1] == currentPlayer && // Second column
				status[1][1] == currentPlayer &&
				status[2][1] == currentPlayer) ||
				(status[0][2] == currentPlayer && // Third column
				status[1][2] == currentPlayer &&
				status[2][2] == currentPlayer) ||
				(status[0][0] == currentPlayer && // Diagonal TL->BR
				status[1][1] == currentPlayer &&
				status[2][2] == currentPlayer) ||
				(status[0][2] == currentPlayer && // Diagonal TR->BL
				status[1][1] == currentPlayer &&
				status[2][0] == currentPlayer));
		}

		public void resetTurnNumber() {
			turnNumber = 1;
		}
		public void incrementTurn() {
			turnNumber++;
		}

		public void resetBoard() {
			for (int row = 0; row < ROWS; ++row) {
				for (int col = 0; col < COLUMNS; ++col) {
					boxes[row][col].setEnabled(true);
					boxes[row][col].setIcon(pokeball);
					status[row][col] = Fill.EMPTY;
				}
			}
		}
		
		public void disableBoard() {
			for (int row = 0; row < ROWS; ++row) {
				for (int col = 0; col < COLUMNS; ++col) {
					boxes[row][col].setEnabled(false);
				}
			}
		}
	}

	public class StatsGroup extends JPanel {
		public StatsPanel statsPlayer1;
		public StatsPanel statsPlayer2;

		public StatsGroup() {
			statsPlayer1 = new StatsPanel(1);
			statsPlayer2 = new StatsPanel(2);

			add(statsPlayer1);
			add(statsPlayer2);
		}

		public void resetStats() {
			xWins = 0;
			oWins = 0;
		}
	}

	public class StatsPanel extends JPanel {
		private char symbol;

		private JTextField setName; // To set name
		private JLabel numberOfWins; // To show wins
		private JLabel numberOfLosses; // To show losses
		private JLabel winsLabel; // "Wins:"
		private JLabel lossesLabel; // "Losses:"
		private JLabel nameLabel; // "Name:"

		public StatsPanel(int player){
			// Create grid layout for StatsPanel
			setLayout(new GridLayout(3, 2));

			// Create editable text field.
			setName = new JTextField("Player " + player, 8);

			// Create Labels
			winsLabel = new JLabel("Wins:");
			lossesLabel = new JLabel("Losses:");
			nameLabel = new JLabel ("Name:");

			if (player == 1) {
				numberOfWins = new JLabel (String.valueOf(xWins));
				numberOfLosses = new JLabel (String.valueOf(oWins));
				symbol = 'X';
			}
			else {
				numberOfLosses = new JLabel (String.valueOf(xWins));
				numberOfWins = new JLabel (String.valueOf(oWins));
				symbol = 'O';
			}

			//create labeled border
			setBorder(BorderFactory.createTitledBorder("Player " + player + " (" + symbol + "):"));

			// Add text field and labels to panel
			add(nameLabel);
			add(setName);
			add(winsLabel);
			add(numberOfWins);
			add(lossesLabel);
			add(numberOfLosses);
		}

		public String getName(int player) {
			setName.setEditable(false);
			return setName.getText();
		}
	}

	public class BottomGroupPanel extends JPanel{
		private JButton newGameButton;
		private JButton resetButton;
		private JButton exitButton;
		public JLabel statusBar;
		private JPanel buttonsPanel;

		public BottomGroupPanel() {
			setLayout(new BorderLayout());

			buildButtonsPanel();
			statusBar = new JLabel("Welcome to Tic-Tac-Toe!");

			Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
			statusBar.setBorder(border);

			add(buttonsPanel, BorderLayout.NORTH);
			add(statusBar, BorderLayout.SOUTH);
		}

		private void buildButtonsPanel() {
			buttonsPanel = new JPanel();

			newGameButton = new JButton("New Game");
			resetButton = new JButton("Reset");
			exitButton = new JButton("Exit");

			newGameButton.addActionListener(new NewGameButtonListener());
			resetButton.addActionListener(new ResetButtonListener());
			exitButton.addActionListener(new ExitButtonListener());

			buttonsPanel.add(newGameButton);
			buttonsPanel.add(resetButton);
			buttonsPanel.add(exitButton);
		}
		private class NewGameButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				xName = stats.statsPlayer1.getName(1);
				oName = stats.statsPlayer2.getName(2);
				board.resetTurnNumber();
				board.resetBoard();
				setCurrentPlayer(Fill.EX);
				bottomGroup.statusBar.setText(xName + "\'s turn.");
			}
		}

		private class ResetButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				int confirmButton = JOptionPane.YES_NO_OPTION;
				int selection = JOptionPane.showConfirmDialog(null, "This will end the game and set the win/loss stats to 0. Are you sure?", "Are you sure?", confirmButton);

				if (selection == JOptionPane.YES_OPTION) {
					stats.statsPlayer1.setName.setText("Player 1");
					stats.statsPlayer1.setName.setEditable(true);
					stats.statsPlayer2.setName.setText("Player 2");
					stats.statsPlayer2.setName.setEditable(true);
					
					stats.resetStats();
					updateWins();
					
					board.resetBoard();
					board.disableBoard();
					
					bottomGroup.statusBar.setText("Welcome to Tic-Tac-Toe!");
				}
			}
		}

		private class ExitButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		new TicTacToe();
	}
}
