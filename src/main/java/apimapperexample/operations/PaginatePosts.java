package apimapperexample.operations;

import java.util.List;

import apimapperexample.common.BasicOperation;
import apimapperexample.models.Post;
import apimapperexample.operations.impl.PaginatePostsImpl;

public interface PaginatePosts extends BasicOperation {
	
	public static PaginatePosts withDefaultImplementation(final List<Post> posts, final Integer page, final Integer size) {
		return new PaginatePostsImpl(posts, page, size);
	}
	
	Integer getPage();

	List<Post> getPaginatedPosts();
	
	Integer getSize();
	
}
