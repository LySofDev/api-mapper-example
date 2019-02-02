package apimapperexample.operations.impl;

import java.util.LinkedList;
import java.util.List;

import apimapperexample.models.Post;
import apimapperexample.operations.PaginatePosts;

public class PaginatePostsImpl implements PaginatePosts {
	
	private static int DEFAULT_PAGE = 1;
	
	private static int DEFAULT_SIZE = 5;

	private List<Exception> errors = new LinkedList<Exception>();
	
	private Integer page;
	
	private Integer size;
	
	private List<Post> paginatedPosts = new LinkedList<Post>();
	
	public PaginatePostsImpl(final List<Post> posts, final Integer page, final Integer size) {
		try {
			this.page = page != null ? page : DEFAULT_PAGE;
			this.size = size != null ? size : DEFAULT_SIZE;
			this.paginatedPosts = posts.subList((this.page - 1) * this.size, this.page * this.size);
		} catch (Exception exception) {
			this.errors.add(exception);
		}
	}
	
	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public List<Post> getPaginatedPosts() {
		return this.paginatedPosts;
	}

	@Override
	public List<Exception> getErrors() {
		return this.errors;
	}
	
	@Override
	public Integer getSize() {
		return this.size;
	}

}
