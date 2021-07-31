package pcakge;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.nio.charset.StandardCharsets;

/**
 * <h2> Class Description: </h2>
 * <p1> Handles the training for each language</p1>
 * @author dharmpreetatwal
 */
public class LanguageTrainer {
	private Alphabet language;
	private HashMap<String, Integer> languageTable = new HashMap<String, Integer>();
	
	/** 
	 * <h2> Method Description: </h2>
	 * <p1> Constructor for the trainer</p1>
	 * @param language The language the trainer will be recording
	 * @throws IOException 
	**/
	public LanguageTrainer(Alphabet language) throws IOException {
		this.language = language;
		DatabaseHandler.createDB(language);
	}
	
	/** 
	 * <h2> Method Description: </h2>
	 * <p1> Calls all the required methods to begin the training. Keeps track of which 
	 * file number is being used</p1>
	**/
	public void runTraining() throws IOException {
		String trainPath = "src/trainingfiles/";
		int fileNum = 1;

		while(Files.exists(Paths.get(trainPath + this.language.toString() + fileNum))) {
			String filePath = trainPath + this.language.toString() + fileNum;
			String cleanedFile = FileHandler.cleanFile(filePath, this.language, fileNum);
			FileHandler.readFileFrequency(cleanedFile, this.languageTable);
			fileNum++;
		} 
	}
	
	/** 
	 * <h2> Method Description: </h2>
	 * <p1> Prints and Stores all the entries within the HashMap. 
	 * Also stores the entries within the same loop</p1>
	**/
	public void printStoreMap() throws IOException {
		// Sorting the HashMap
		HashMap<String, Integer> sortedHashMap = sortByValue(this.languageTable);
		Iterator<Entry<String, Integer>> iterator = sortedHashMap.entrySet().iterator();

		// Variables needed for database Storage
        Path words = Paths.get("src/db/" + this.language.toString() + "WORDS");
		Path frequency = Paths.get("src/db/" + this.language.toString() + "FREQUENCY");
		FileWriter wordWriter = new FileWriter(words.toString());
		FileWriter frequencyWriter = new FileWriter(frequency.toString());
        
		
		while(iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			
			if(entry.getValue() <= 4) {
				// Removing entry < required
				sortedHashMap.remove(entry);
            } else {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                
                // Writing the word and it's frequency to the database
                wordWriter.write(entry.getKey() + "\n");
    			frequencyWriter.write(Integer.toString(entry.getValue()) + "\n");
            }   
		}

        wordWriter.close();
        frequencyWriter.close();
    }
	
	/** 
	 * <h2> Method Description: </h2>
	 * <p1> Sorts a HashMap's entries from their highest to lowest values</p1>
	 * @param hm The HashMap to be sorted:
	 * @return The sorted HashMap:
	**/
	private HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) { 
                return (o2.getValue()).compareTo(o1.getValue()); 
            } 
        }); 
		
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> entry : list) { 
            temp.put(entry.getKey(), entry.getValue()); 
        } 
		return temp;
	}

    
	public Alphabet getLanguage() {
		return language;
	}

	public void setLanguage(Alphabet language) {
		this.language = language;
	}

	public HashMap<String, Integer> getLanguageTable() {
		return languageTable;
	}

	public void setLanguageTable(HashMap<String, Integer> languageTable) {
		this.languageTable = languageTable;
	}
	
	
}
