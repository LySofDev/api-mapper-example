package apimapperexample.operations.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import apimapperexample.models.LetterFrequencyReport;
import apimapperexample.models.Post;
import apimapperexample.operations.GetLetterFrequencyReportOperation;

public class GetLetterFrequencyReportOperationImpl implements GetLetterFrequencyReportOperation {
	
	private static Map<String, Integer> letterFrequencies = new HashMap<String, Integer>();

	private List<Exception> errors = new LinkedList<Exception>();
	
	private LetterFrequencyReport letterFrequencyReport;
	
	public GetLetterFrequencyReportOperationImpl(final String letter, final List<Post> posts) {
		try {
			this.validateLetter(letter);
			if (!letterFrequencies.containsKey(letter)) {
				final List<String> texts = this.collectTitleAndBodyText(posts);
				final int frequency = this.getFrequencyOfCharacterInListOfText(letter, texts);
				letterFrequencies.put(letter, frequency);
			}
		} catch (Exception error) {
			this.errors.add(error);
		}
		this.letterFrequencyReport = new LetterFrequencyReport(letter, letterFrequencies.getOrDefault(letter, 0));
	}

	@Override
	public List<Exception> getErrors() {
		return this.errors;
	}

	@Override
	public LetterFrequencyReport getLetterFrequencyReport() {
		return this.letterFrequencyReport;
	}
	
	private List<String> collectTitleAndBodyText(final List<Post> posts) {
		final List<String> texts = new LinkedList<String>();
		for (int i = 0; i < posts.size(); i++) {
			texts.add(posts.get(i).getTitle());
			texts.add(posts.get(i).getBody());
		}
		return texts;
	}
	
	private int getFrequencyOfCharacterInText(final String character, final String text) {
		int frequency = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.substring(i, i + 1).equals(character)) {
				frequency++;
			}
		}
		return frequency;
	}
	
	private int getFrequencyOfCharacterInListOfText(final String character, final List<String> texts) {
		int frequency = 0;
		for (int i = 0; i < texts.size(); i++) {
			frequency += this.getFrequencyOfCharacterInText(character, texts.get(i));
		}
		return frequency;
	}
	
	private void validateLetter(final String letter) throws Exception {
		if (letter == null || letter.length() > 0) {
			throw new Exception("Invalid letter.");
		}
	}

}
