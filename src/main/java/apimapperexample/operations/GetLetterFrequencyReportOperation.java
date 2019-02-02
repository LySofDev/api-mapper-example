package apimapperexample.operations;

import java.util.List;

import apimapperexample.common.BasicOperation;
import apimapperexample.models.LetterFrequencyReport;
import apimapperexample.models.Post;
import apimapperexample.operations.impl.GetLetterFrequencyReportOperationImpl;

public interface GetLetterFrequencyReportOperation extends BasicOperation {

	public static GetLetterFrequencyReportOperation withDefaultImplementation(final String letter, final List<Post> posts) {
		return new GetLetterFrequencyReportOperationImpl(letter, posts);
	}
	
	LetterFrequencyReport getLetterFrequencyReport();
	
}
