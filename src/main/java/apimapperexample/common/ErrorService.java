package apimapperexample.common;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ErrorService {

	void consume(final Exception exception);
	
	void consume(final List<Exception> exceptions);
	
	void log(final BasicOperation operation);
	
}
