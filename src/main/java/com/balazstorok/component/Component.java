package com.balazstorok.component;

/**
 * Interface of all components within the framework.
 *
 * Created by Balazs Torok on 11/02/17.
 */
public interface Component<T extends Component> {

	/**
	 * Helper method to know what is the current type of the component.
	 *
	 * @return the type of the Component.
	 */
	Class<T> getType();

	/**
	 * Displays the content of the Component.
	 *
	 * @return the html code of the Component.
	 */
	String display();
}
