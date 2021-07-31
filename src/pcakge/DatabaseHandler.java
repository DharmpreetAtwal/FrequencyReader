package pcakge;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.nio.charset.StandardCharsets;

/**
 * <h2> Class Description: </h2>
 * <p1> Handles actions related to the database</p1>
 * @author dharmpreetatwal
 */
public class DatabaseHandler {

	/** 
	 * <h2> Method Description: </h2>
	 * <p1> Creates the database for each individual language </p1>
	 * @param alphabets The VarArgs array of alphabets to create databases for
	**/
	public static void createDB(Alphabet alphabet) throws IOException {
			// Using the predictable naming convention for training files to create the Path for the database
		Path words = Paths.get("src/db/" + alphabet.toString() + "WORDS/");
		Path frequency = Paths.get("src/db/" + alphabet.toString() + "FREQUENCY/");
		
		if(Files.notExists(words)) { 
			Files.createFile(words);
		}  
		
		if(Files.notExists(frequency)) {
			Files.createFile(frequency);
		}
		
	}
	
	/** 
	 * <h2> Method Description: </h2>
	 * <p1> Searches for a specific entry by row number </p1>
	 * @param alphabet The language database to search through
	 * @param row The row number to search for
	 * @return The entry queried
	**/
	public static Map.Entry<String, Integer> searchEntry(Alphabet alphabet, Integer row) throws IOException {
		Path wordsPath = Paths.get("src/db/" + alphabet.toString() + "WORDS/");
		Path frequencyPath = Paths.get("src/db/" + alphabet.toString() + "FREQUENCY/");
	
		BufferedReader wordReader = Files.newBufferedReader(wordsPath);
		BufferedReader frequencyReader = Files.newBufferedReader(frequencyPath);

		Integer i = 1;
		while(i<row) {
			wordReader.readLine();
			frequencyReader.readLine();
			i++;
		}
		
		String word = wordReader.readLine();
		Integer frequency = Integer.valueOf(frequencyReader.readLine());
		Map.Entry<String, Integer> entry = Map.entry(word, frequency);
		
		return entry;
	}
	
	/** 
	 * <h2> Method Description: </h2>
	 * <p1> Searches for a specific entry by word </p1>
	 * @param alphabet The language database to search through
	 * @param word The word to search for
	 * @return The entry queried
	**/
	public static Map.Entry<String, Integer> searchEntry(Alphabet alphabet, String word) throws IOException {
		Path wordsPath = Paths.get("src/db/" + alphabet.toString() + "WORDS/");
		Path frequencyPath = Paths.get("src/db/" + alphabet.toString() + "FREQUENCY/");
		
		BufferedReader wordReader = Files.newBufferedReader(wordsPath);
		
		int i=1;
		while(i != -1) {
			String wordCheck = wordReader.readLine();
			if(wordCheck.equalsIgnoreCase(word)) {
				System.out.print("Row: " + i + "->");
				Map.Entry<String, Integer> entry = searchEntry(alphabet, i);
				return entry;
			} else {
				i++;
			}
		}
		return null;
	}

}
