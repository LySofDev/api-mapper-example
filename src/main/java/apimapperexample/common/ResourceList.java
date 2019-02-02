package apimapperexample.common;

import java.util.LinkedList;
import java.util.List;

public abstract class ResourceList<T> extends LinkedList<T> implements List<T> {

	private static final long serialVersionUID = -975569800354070540L;

	public final List<T> asList() {
		return this;
	}

}
