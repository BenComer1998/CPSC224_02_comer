import javax.swing.JOptionPane;

public class Hangman {
	public static void main(String args[]) {
		String word;
		int numberOfLetters;
		int strikes;
		char input;
		boolean isExit = false;
		boolean isValid = false;
		boolean isSolved = false;
		boolean playAgain;
		
		String list[];
		
		boolean letterList[];
		letterList = new boolean [26];
		
		do {
			// Print menu
			do {
				if (input == '1') {
					word = getWord(true); // Gets a random word
					numberOfLetters = word.length();
					isValid = true;
				}
				else if (input == '2') {
					word = getWord(false); // Gets a word prompt
					numberOfLetters = word.length();
					isValid = true;
				}
				else if (input == '3') {
					isExit = true;
					isValid = true;
				}
				else {
					// Print out a box with stuff
				}
			} while (!isValid);
			
			if (!isExit) {
				char wordArray = convertToArray(word)
				boolean solvedArray[];
				solvedArray = new boolean [numberOfLetters];
				int blanksLeft = numberOfLetters;
				
				makeAllFalse(wordArray);
				makeAllFalse(solvedArray);
	
				while (!isSolved && strikes < 6) {
					// Print out the blanks (or letters)
					// Prompt the user for an entry
					if (!isLetter(input))
						// Prompt user for re-entry
					else if (isGuessed(input, letterList))
						// Prompt user for re-entry
					else {
						capitalize(input);
						letterList[input - 'A'] = true; // Using 'A' as starting point (0)
						if (isCorrect(input, wordArray, solvedArray, blanksLeft)) {
							// Print out a box saying yay
						}
						else {
							addStrike(strikes);
							// Print out a box saying boo
						}
					}
				}
				
			}
		} while (playAgain && !isExit);
	}

	public static String getWord(boolean isRandom) {
		// include fillList if isRandom
	}
	
	public static void menu() {
		
	}
	
	public static void addStrike(int strikes) {
		strikes++;
	}
	
	public static void fillList(String list[]) {
		list = new String [100];
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
	
	public static void capitalize(char letter) {
		letter = toUpperCase(letter);
	}
	
	public static boolean isGuessed(char letter, boolean letterList[]) {
		int index = capitalize(letter) - 'A';
		return letterList[index];
	}
	
	public static boolean isCorrect(char letter, char wordArray[], boolean solvedArray[], int blanksLeft) {
		boolean letterFound = false;
		int lettersMinusSolved = blanksLeft;
		for (int i = 0; i < lettersMinusSolved; ++i) {
			if (solvedArray[i])
				lettersMinusSolved--;
			else {
				if (wordArray[i] == letter) {
					blanksLeft--;
					solvedArray[i] = true;
					letterFound = true;
				}
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
	
}