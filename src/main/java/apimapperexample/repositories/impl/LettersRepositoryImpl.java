/**
 * 
 */
package apimapperexample.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;

import apimapperexample.common.ErrorService;
import apimapperexample.models.LetterFrequencyReport;
import apimapperexample.operations.GetLetterFrequencyReportOperation;
import apimapperexample.repositories.LettersRepository;
import apimapperexample.repositories.PostsRepository;

/**
 * @author esteban
 *
 */
public class LettersRepositoryImpl implements LettersRepository {
	
	@Autowired
	private ErrorService errors;
	
	@Autowired
	private PostsRepository posts;

	/* (non-Javadoc)
	 * @see apimapperexample.repositories.LettersRepository#getLetterFrequencyReport(java.lang.String)
	 */
	@Override
	public LetterFrequencyReport getLetterFrequencyReport(final String letter) {
		final GetLetterFrequencyReportOperation operation = GetLetterFrequencyReportOperation.withDefaultImplementation(letter, this.posts.getAllPosts());
		this.errors.log(operation);
		return operation.getLetterFrequencyReport();
	}

}
