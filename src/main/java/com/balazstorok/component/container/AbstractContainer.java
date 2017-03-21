package com.balazstorok.component.container;

import com.balazstorok.component.AbstractComponent;
import com.balazstorok.component.Component;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Container component of the framework, which can act as a Container with/without a frame.
 *
 * Created by Balazs Torok on 11/02/17.
 */
abstract class AbstractContainer<T extends AbstractContainer> extends AbstractComponent<T> implements Container<T> {

	private Long currentKey = null;
	private Long nextKey = 0L;

	/**
	 * Map of the elements where the key is the counter provided by this class, the values are the list
	 * of any kind of Components.
	 */
	protected final Map<Long, List<Component<?>>> components = new TreeMap<Long, List<Component<?>>>();

	/**
	 * Current key, which is the key of the previous component if there is any added to the components map.
	 * @return the value of the key counter
	 */
	protected Long getKey() {
		return currentKey;
	}

	/**
	 * Sets the currentKey equal to the value of the nextKey, returns it then increases it with 1.
	 * @return the value of nextKey
	 */
	protected Long nextKey() {
		currentKey = nextKey;
		return nextKey++;
	}
}
