package apimapperexample.operations.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import apimapperexample.models.Post;
import apimapperexample.operations.GetAllPosts;

public class GetAllPostsImpl implements GetAllPosts {
	
	private static String URL = "https://jsonplaceholder.typicode.com/posts";
	
	private static List<Post> posts = new LinkedList<Post>();
	
	private static List<Exception> errors = new LinkedList<Exception>();
	
	private final RestTemplate httpClient = new RestTemplate();
		
	public GetAllPostsImpl() {
		try {
			if (GetAllPostsImpl.posts.isEmpty()) {
				final List<Post> posts = this.httpClient.getForObject(URL, Post.Collection.class);
				GetAllPostsImpl.posts.addAll(posts);
			}
		} catch (Exception error) {
			GetAllPostsImpl.errors.add(error);
		}
	}

	@Override
	public List<Exception> getErrors() {
		return GetAllPostsImpl.errors;
	}
	
	@Override
	public List<Post> getPosts() {
		return GetAllPostsImpl.posts;
	}
	
}
