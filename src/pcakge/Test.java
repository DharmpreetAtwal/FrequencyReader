package pcakge;

import java.io.IOException;
import java.util.Map;

public class Test {

	public static void main(String[]args) {
//		System.out.println(Alphabet.ENGLISH.getLetters());
//		System.out.println(Alphabet.FRENCH.getLetters());
//		System.out.println(Alphabet.SPANISH.getLetters());
//		System.out.println(Alphabet.ITALIAN.getLetters());
	
		try {
			
			System.out.println("\n ---------------------- \n");

			LanguageTrainer english = new LanguageTrainer(Alphabet.ENGLISH);
			english.runTraining();
			english.printStoreMap();
			
			System.out.println("\n ---------------------- \n");
			
			LanguageTrainer french = new LanguageTrainer(Alphabet.FRENCH);
			french.runTraining();
			french.printStoreMap();
			
			System.out.println("\n ---------------------- \n");

			LanguageTrainer greek = new LanguageTrainer(Alphabet.GREEK);
			greek.runTraining();
			greek.printStoreMap();
			
			System.out.println("\n ---------------------- \n");

			LanguageTrainer italian = new LanguageTrainer(Alphabet.ITALIAN);
			italian.runTraining();
			italian.printStoreMap();
	
			System.out.println("\n ---------------------- \n");

			LanguageTrainer spanish = new LanguageTrainer(Alphabet.SPANISH);
			spanish.runTraining();
			spanish.printStoreMap();
		
			System.out.println("\n ---------------------- \n");

			System.out.println("Search Results:");
			Map.Entry<String, Integer> entry1 = DatabaseHandler.searchEntry(Alphabet.ENGLISH, 64);
			System.out.println(entry1.getKey() + ":" + entry1.getValue());
			
			Map.Entry<String, Integer> entry2 = DatabaseHandler.searchEntry(Alphabet.FRENCH, 64);
			System.out.println(entry2.getKey() + ":" + entry2.getValue());
			
			Map.Entry<String, Integer> entry3 = DatabaseHandler.searchEntry(Alphabet.SPANISH, 64);
			System.out.println(entry3.getKey() + ":" + entry3.getValue());
			
			Map.Entry<String, Integer> entry4 = DatabaseHandler.searchEntry(Alphabet.ITALIAN, 64);
			System.out.println(entry4.getKey() + ":" + entry4.getValue());
			
			Map.Entry<String, Integer> entry5 = DatabaseHandler.searchEntry(Alphabet.GREEK, 64);
			System.out.println(entry5.getKey() + ":" + entry5.getValue());
			
			Map.Entry<String, Integer> entry6 = DatabaseHandler.searchEntry(Alphabet.GREEK, "ΟΎΤΕ");
			System.out.println(entry6.getKey() + ":" + entry6.getValue());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
