package com.balazstorok.component.container;

import com.balazstorok.component.Component;
import com.balazstorok.component.Position;

/**
 * Container interface for holding all the container related methods.
 *
 * Created by Balazs Torok on 11/02/17.
 */
public interface Container<T extends Container> extends Component<T> {

	/**
	 * Adds an component to the container's next line.
	 * @param component the component to add
	 * @return the container itself
	 */
	Container<T> addComponent(Component<?> component);

	/**
	 * Adds an component to the container's next line or next to the previously added component.
	 * @param component the component to add
	 * @param position the position where to add
	 * @return the container itself
	 */
	Container<T> addComponent(Component<?> component, Position position);

	/**
	 * Tells whether the container is framed or not.
	 * @return true if the container is framed, otherwise false
	 */
	boolean isFramed();
}
