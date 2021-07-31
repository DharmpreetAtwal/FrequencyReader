package pcakge;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.nio.charset.StandardCharsets;

/** 
 * <h2> Class Description: </h2>
 * <p1> Handles actions involving files</i></p1>
**/
public class FileHandler {

	/** 
	 * <h2> Method Description: </h2>
	 * <p1> Cleans the file according to the language. Files organized through the use of <i>fileNum</i></p1>
	 * @param trainingFile The URL of the path to the training file
	 * @param language The language to be cleaned in
	 * @param fileNum The number used to organize the training files
	 * @return The URL of the path to the cleaned file
	**/
	public static String cleanFile(String trainingFile, Alphabet language, int fileNum) throws IOException {
		Path cleanedFile = Paths.get("src/cleanedFiles/" + language.toString() + fileNum + "CLEANED");
		FileReader reader = new FileReader(trainingFile.toString());
		FileWriter writer = new FileWriter(cleanedFile.toString());
		
		System.out.println("Cleaning File: " + language.toString() + fileNum);
		
		char letter;
		do {
			letter = Character.toUpperCase((char)reader.read());
			// If letter is from desired language, write to the clean file
			if(language.searchLetter(letter)) {
				writer.write(letter);
			// Otherwise replace with a whitespace
			} else {
				writer.write(' ');
			}
		} while(letter != (char)-1);
		
		reader.close();
		writer.close();
		return cleanedFile.toString();
	}
	
	/** 
	 * <h2> Method Description: </h2>
	 * <p1> Reads through a cleaned file to record the frequencies of each word</i></p1>
	 * @param path The URL of the path to the file to be read
	 * @param hm The HashMap that will store the frequencies
	**/
	public static void readFileFrequency(String path, HashMap<String, Integer> hm) throws IOException {
		FileReader reader = new FileReader(path);
		char letter = 0;
		String word = "";

		while(letter != (char)-1) {
			// Having the file reader output the ASCII value and casting it to a char
			letter = Character.toUpperCase((char)reader.read());
			// If word is still being built
			if(!Character.isWhitespace(letter)) {
				word = word + letter;
			// If new word is starting, store built word as long as it's not empty
			} else if(Character.isWhitespace(letter) && word != "") {
				// If word has already been added, increment by 1
				if(hm.containsKey(word)) {
					int updatedCount = hm.get(word) + 1;
					hm.put(word, updatedCount);
					word = "";
				// If word is new, add it with a frequency of 1
				} else {
					hm.put(word, 1);
					word = "";
				}
			}
		}
		reader.close();
	}

}
