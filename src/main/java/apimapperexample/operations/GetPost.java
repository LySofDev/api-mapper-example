package apimapperexample.operations;

import apimapperexample.common.BasicOperation;
import apimapperexample.models.Post;
import apimapperexample.operations.impl.GetPostImpl;

public interface GetPost extends BasicOperation {
	
	public static GetPost withDefaultImplementation(final Integer id) {
		return new GetPostImpl(id);
	}

	Post getPost();
	
}
