package apimapperexample.common;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ErrorServiceImpl implements ErrorService {
	
	@Override
	public void consume(Exception exception) {
		System.err.println(exception);
	}

	@Override
	public void consume(List<Exception> exceptions) {
		exceptions.forEach(exception -> System.err.println(exception));
	}

	@Override
	public void log(BasicOperation operation) {
		operation.getErrors().forEach(exception -> System.err.println(exception));
	}

}
