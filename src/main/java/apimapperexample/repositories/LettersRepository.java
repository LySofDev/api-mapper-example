package apimapperexample.repositories;

import apimapperexample.models.LetterFrequencyReport;

public interface LettersRepository {
	
	LetterFrequencyReport getLetterFrequencyReport(final String letter);

}
