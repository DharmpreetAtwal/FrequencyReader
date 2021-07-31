package pcakge;

public class Word {
	private String text;
	private Alphabet language;
	private int frequency;
	
	public Word(String text, Alphabet language) {
		this.text = text;
		this.language = language;
		this.frequency = 1;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Alphabet getLanguage() {
		return language;
	}

	public void setLanguage(Alphabet language) {
		this.language = language;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	
	
}
