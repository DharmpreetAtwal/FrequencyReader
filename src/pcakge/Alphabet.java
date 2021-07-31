package pcakge;
import java.nio.charset.StandardCharsets;

/**
 * <h2> Enumeration Description: </h2>
 * <p1> Contains the alphabet for all the languages</p1>
 * @author dharmpreetatwal
 */
public enum Alphabet {

	ENGLISH("ENG", "ABCDEFGHIJKLMNOPQRSTUVWXYZ’'", 1),
	FRENCH("FRE", "AÀÂÄÆBCÇDEÈÉÊËFGHIÎÏJKLMNOÔŒPQRSTUÛÜÙVWXYŸZ'’", 2),
	SPANISH("SPA", "AÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚÜVWXYZ'’", 3),
	ITALIAN("ITA", "AÀBCDEÈÉFGHIÌJKLMNOÒÓPQRSTUÙVWXYZ'’", 4),
	GREEK("GRE", "ΑΆΒΓΔΕΈΖΗΉΘΙΊΚΛΜΝΞΟΌΠΘΡΣΤΥΎΦΧΨΩΏ’'", 5);
	private String language;
	private String letters;
	private int rank;
	
	/** 
	 * <h2> Method Description: </h2>
	 * <p1> The constructor for each alphabet</i></p1>
	 * @param lanuage The short hand text used to refer to the language
	 * @param letters The alphabet for the language
	 * @param rank The ranking for the language
	**/
	private Alphabet(String language, String letters, int rank) {
		this.language = language;
		this.letters = letters;
		this.rank = rank;
	}
	
	/** 
	 * <h2> Method Description: </h2>
	 * <p1> Verifies if a letter is part of the alphabet or not</i></p1>
	 * @param letter The letter to be checked
	 * @return True if the letter is part of the alphabet, or
	 * 		   False if the letter is not
	**/
	public boolean searchLetter(char letter) {
		String alphabet = this.getLetters();
		
		for(int i=0; i<alphabet.length(); i++) {
			if(alphabet.charAt(i) == letter) {
				return true;
			} 
		}
		return false;
	}

	public String getLanguage() {
		return language;
	}

	public String getLetters() {
		return letters;
	}

	public int getRank() {
		return rank;
	}
	
}
