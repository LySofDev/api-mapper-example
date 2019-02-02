package apimapperexample.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import apimapperexample.common.ErrorService;
import apimapperexample.models.Post;
import apimapperexample.operations.GetAllPosts;
import apimapperexample.operations.GetPost;
import apimapperexample.operations.PaginatePosts;
import apimapperexample.repositories.PostsRepository;

@Component
public class PostsRepositoryImpl implements PostsRepository {
	
	@Autowired
	private ErrorService errors;

	@Override
	public List<Post> getAllPosts() {
		final GetAllPosts getAllPosts = GetAllPosts.withDefaultImplementation();
		getAllPosts.getErrors().forEach(exception -> System.err.println(exception));
		return getAllPosts.getPosts();
	}
	
	@Override
	public Post getPost(final Integer id) {
		final GetPost getPost = GetPost.withDefaultImplementation(id);
		this.errors.consume(getPost);
		return getPost.getPost();
	}

	@Override
	public List<Post> getPosts(final Integer page, final Integer size) {
		final GetAllPosts getAllPosts = GetAllPosts.withDefaultImplementation();
		this.errors.consume(getAllPosts);
		final PaginatePosts paginatePosts = PaginatePosts.withDefaultImplementation(getAllPosts.getPosts(), page, size);
		return paginatePosts.getPaginatedPosts();
	}
	
}
