package apimapperexample.operations.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import apimapperexample.models.Post;
import apimapperexample.operations.GetPost;

public class GetPostImpl implements GetPost {
	
	private final static String URL = "https://jsonplaceholder.typicode.com/posts/1";

	private final List<Exception> errors = new LinkedList<Exception>();
	
	private final RestTemplate httpClient = new RestTemplate();
	
	private Post post;
	
	public GetPostImpl(final Integer id) {
		try {
			this.post = this.httpClient.getForObject(GetPostImpl.URL, Post.class);
		} catch (Exception error) {
			this.errors.add(error);
		}
	}
	
	@Override
	public List<Exception> getErrors() {
		return this.errors;
	}

	@Override
	public Post getPost() {
		return this.post;
	}

}
