package apimapperexample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import apimapperexample.models.Post;
import apimapperexample.repositories.PostsRepository;

@RestController
@RequestMapping("/posts")
public class PostsController {

	@Autowired
	private PostsRepository posts;
	
	@GetMapping(produces = "application/json")
	public List<Post> getPosts(@RequestParam(required = false) final Integer page, @RequestParam(required = false) final Integer size) {
		return this.posts.getPosts(page, size);
	}
	
	@GetMapping(value = "/all", produces = "application/json")
	public List<Post> getAllPosts() {
		return this.posts.getAllPosts();
	}
	
	@GetMapping(value = "/posts/{id}", produces = "application/json")
	public Post getPost(@PathVariable final Integer id) {
		return this.posts.getPost(id);
	}
}
