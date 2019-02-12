import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
	public static void main(String args[]) {
		String blanks;
		String entry;
		String word;
		int numberOfLetters;
		int strikes;
		char input;
		boolean isExit = false;

    String list[];
		list = new String [100];

		boolean letterList[];
		letterList = new boolean [26]; // a is 0, b is 1, c is 2 ... z is 25

		do {
			menu();
				if (input == '1') {
					word = getWord(true, list); // Gets a random word
					numberOfLetters = word.length();
				}
				else if (input == '2') {
					word = getWord(false, list); // Gets a word prompt
					numberOfLetters = word.length();
				}
				else if (input == '3') {
					isExit = true;
				}

			if (!isExit) {
				char wordArray = convertToArray(word);
				boolean solvedArray[];
				solvedArray = new boolean [numberOfLetters];
				int blanksLeft = numberOfLetters;

				makeAllFalse(wordArray);
				makeAllFalse(solvedArray);

				do {
					for (int i = 0; i <= numberOfLetters; i++){
						if (solvedArray[i]==false){
							blanks += "_";
						}
						else{
							blanks += wordArray[i];
						}
					}// Print out the blanks (or letters)
					entry = JOptionPane.showInputDialog(blanks + "\n\nEnter a letter:");// Prompt the user for an entry
					input = entry.charAt(0);
					if (!isLetter(input))
						JOptionPane.showMessageDialog(null, "Please only guess a letter.");// Prompt user for re-entry
					else if (isGuessed(input, letterList))
						JOptionPane.showMessageDialog(null, "You have already guessed this letter. Guess a different letter.");// Prompt user for re-entry
					else {
						input = capitalize(input);
						letterList[input - 'A'] = true; // Using 'A' as starting point (0)
						if (isCorrect(input, wordArray, solvedArray, blanksLeft)) {
							JOptionPane.showMessageDialog(null, "You guessed a correct letter!");// Print out a box saying yay
						}
						else {
							strikes++;
							JOptionPane.showMessageDialog(null, "Whoops! That letter is not in the word.");
						}
					}
					blanksLeft = countBlanksLeft(solvedArray, numberOfLetters);
				} while (blanksLeft != 0 && strikes < 6);

				if (blanksLeft == 0) {
					JOptionPane.showMessageDialog(null, "You solved the word!");// Print out congratulatory message, ask to play again?
				}
				else {
					JOptionPane.showMessageDialog(null, "You ran out of tries. Better luck next time!");// Print out apologetic message, ask to play again?
				}
			}
		} while (!isExit);
	}


	public static char menu() {
		String menuInput;
		menuInput = JOptionPane.showInputDialog("\tMENU:\n1. 1 PLAYER (random word)\n2. 2 PLAYERS (user input)\n3. EXIT");
		input = menuInput.charAt(0);
		if (input == '1' || '2' || '3'){
			return input;
		}
		else {
			JOptionPane.showMessageDialog(null, "Please enter a valid option.");
			return menu();
		}
	}

	public static void fillList(String list[]) {
		list = { "MUMMIFIED" , "CRAZY" , "PUREED" , "POLITICS" , "ALPHABET"
			   , "GARRISON" , "FRIENDLY" , "SMART" , "YESTERDAY" , "MONSTROUS"
			   , "BRINK" , "INSANITY" , "GRILL" , "DECRIES" , "SUMMATION"
			   , "HORRIFY" , "SWISH" , "RENDITION" , "EXPECTATIONS" , "FARAWAY"
			   , "GUESSING" , "HANGMAN" , "NAMASTE" , "ZEN" , "HUNGRIER"
			   , "VEXED" , "JAMMED" , "JAMAICAN" , "EVERYONE" , "OBVIOUS"
			   , "UNKEPT" , "NOWADAYS" , "JELLYBEAN" , "INSOFAR" , "BOOKKEEPER"
			   , "MENIAL" , "AWESOME" , "VENOMOUS" , "GHASTLY" , "WEDDING"
			   , "QUESTIONNAIRE" , "CRABCAKES" , "TAXING" , "FRENZY" , "OMEGA"
			   , "MAPLE" , "SQUIRREL" , "BONZAI" , "OBLIVION" , "SHAMING"
			   , "APPLIED" , "PIKACHU" , "WESTERN" , "ALEXANDRIAN" , "RENTAL"
			   , "CONSUMING" , "ERUPT" , "CRATEROUS" , "KINDLY" , "VOLCANIC"
			   , "DEFIANT" , "TRIVIAL" , "RELAX" , "JOVIAL" , "QDOBA"
			   , "REGENT" , "XENOMORPH" , "PINKY" , "ENVY" , "POSTERIOR"
			   , "STERNUM" , "CREDIBLE" , "HAVARTI" , "FENCING" , "YUMMY"
			   , "SOUNDERS" , "ROCKETS" , "MARLINS" , "EAGLES" , "STORM"
			   , "DWINDLING" , "TUPAC" , "EXCUSE" , "WORLDLY" , "BREATH"
			   , "BONANZA" , "POPCORN" , "NEBULA" , "LIFELIKE" , "DEODORANT"
			   , "JUMBLED" , "CROSSWORD" , "OPENER" , "INKLING" , "KENNEL"
			   , "SEMBLANCE" , "LENGTH" , "COLUMN" , "WRECK" , "HUNDRED" } // That's a hundred words
	}

	public static char capitalize(char letter) {
		return toUpperCase(letter);
	}

	public static boolean isGuessed(char letter, boolean letterList[]) {
		int index = capitalize(letter) - 'A';
		return letterList[index];
	}

	public static boolean isCorrect(char letter, char wordArray[], boolean solvedArray[], int blanksLeft) {
		boolean letterFound = false;
		int letters = blanksLeft;
		for (int i = 0; i < letters; ++i) {
			if (solvedArray[i])
				letters++;
			else if (wordArray[i] == letter) {
				solvedArray[i] = true;
				letterFound = true;
			}
		}
		return letterFound;
	}

	public static char[] convertToArray(String word) {
		return word.toCharArray();
	}

	public static void makeAllFalse(boolean array[], int length) {
		for (int i = 0; i < length; ++i) {
			array[i] = false;
		}
	}

	public static int countBlanksLeft(boolean solvedArray[], int numberOfLetters) {
		int blanksLeft = 0;
		for (int i = 0; i < numberOfLetters; ++i) {
			if (!solvedArray[i])
				blanksLeft++;
		}
		return blanksLeft;
	}

	public static String getWord(boolean isRandom, String list[]) {
			if (isRandom) {
				return list[Random.nextInt(99)];
			}
			else {
				boolean isValid = false;
				String entry = JOptionPane.showInputDialog("Enter a word for the other player to guess:");
				do {
					boolean allLetters = true;
					if (entry != null) {
						int numberOfLetters = entry.length();
						for (int i = 0; i < numberOfLetters && allLetters; ++i) {
							if (!isLetter(entry[i])) {
								allLetters = false;
							}
						}

						if (allLetters) {
							isValid = true;
						}
						else {
							entry = JOptionPane.showInputDialog("Please only enter letters as input.");
						}

					}
					else {
						entry = JOptionPane.showInputDialog("Please enter a word of at least one letter.");
					}
				} while (!isValid);
			}
		}

}
