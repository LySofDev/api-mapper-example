package apimapperexample.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import apimapperexample.common.ResourceList;

/**
 * Post POJO
 * @author esteban
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
	
	public static class Collection extends ResourceList<Post> {
		private static final long serialVersionUID = -2546853532113835891L; 
	}

	@JsonProperty
	private String body;
	
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String title;

	@JsonProperty
	private Long userId;

	/**
	 * @return the body
	 */
	public final String getBody() {
		return body;
	}

	/**
	 * @return the id
	 */
	public final Long getId() {
		return id;
	}

	/**
	 * @return the title
	 */
	public final String getTitle() {
		return title;
	}

	/**
	 * @return the userId
	 */
	public final Long getUserId() {
		return userId;
	}

	/**
	 * @param body the body to set
	 */
	public final void setBody(String body) {
		this.body = body;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param title the title to set
	 */
	public final void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param userId the userId to set
	 */
	public final void setUserId(Long userId) {
		this.userId = userId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean isEqual = this == obj;
		if (!isEqual && obj != null && obj.getClass().equals(this.getClass())) {
			final Post post = (Post) obj;
			isEqual = Objects.equals(this.body, post.body)
					&& Objects.equals(this.id, post.id)
					&& Objects.equals(this.title, post.title)
					&& Objects.equals(this.userId, post.userId);
		}
		return isEqual;
	}

}
