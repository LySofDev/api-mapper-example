package apimapperexample.operations;

import java.util.List;

import apimapperexample.common.BasicOperation;
import apimapperexample.models.Post;
import apimapperexample.operations.impl.GetAllPostsImpl;

public interface GetAllPosts extends BasicOperation {
	
	public static GetAllPosts withDefaultImplementation() {
		return new GetAllPostsImpl();
	}

	List<Post> getPosts();
		
}
