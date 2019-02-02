package apimapperexample.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import apimapperexample.models.Post;

@Repository
public interface PostsRepository {

	List<Post> getAllPosts();
	
	List<Post> getPosts(final Integer page, final Integer size);
	
	Post getPost(final Integer id);
	
}
