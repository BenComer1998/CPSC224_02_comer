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
					// Print out a box that says to try it again
				}
			} while (!isValid);
			
			if (!isExit) {
				char wordArray = convertToArray(word)
				for (int i = 0; i < 26; ++i) {
					letterList[i] = false;
				}
	
				while (!isSolved && strikes < 6) {
					// Print out the blanks (or letters)
					// Prompt the user for an entry
					if (!isLetter(input))
						// Prompt user for re-entry
					else if (isGuessed(input, letterList))
						// Prompt user for re-entry
					else {
						input = capitalize(input);
						letterList[input - 'A'] = true; // Using 'A' as starting point (0)
						
						
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
			   , "UNKEPT" , "NOWADAYS" , "ELDERLY" , "INSOFAR" , "BOOKKEEPER"
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
	
	public static boolean isGuessed(char letter, boolean letterList[26]) {
		int index = capitalize(letter) - 'A';
		return letterList[index];
	}
	
	public static boolean isCorrect(char letter, char wordArray[]) {
		// Returns whether or not the letter is contained in wordArray
	}
	
	public static char[] convertToArray(String word) {
		return word.toCharArray();
	}
}