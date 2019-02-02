package apimapperexample.models;

public class LetterFrequencyReport {
	
	private String letter;
	
	private int frequency;

	public LetterFrequencyReport(final String letter, final int frequency) {
		this.letter = letter;
		this.frequency = frequency;
	}
	
	public final String getLetter() {
		return this.letter;
	}
	
	public final int getFrequency() {
		return this.frequency;
	}

}
