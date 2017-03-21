package com.balazstorok.component;

import org.apache.commons.lang3.Validate;
import org.jsoup.nodes.Element;

/**
 * The root component of the framework.
 * <p/>
 * Created by Balazs Torok on 11/02/17.
 */
public abstract class AbstractComponent<T extends Component> implements Component<T> {

	/**
	 * JSoup's Element to be able to build the html code of the Input component.
	 */
	private Element jSoupElement;

	/**
	 * Initializer method for the component that implements AbstractComponent.
	 * <p/>
	 * @return the jSoupElement which represents the component itself.
	 */
	protected Element initializeJSoupElement() {
		throw new UnsupportedOperationException("The method initializeJSoupElement() must be override by the " +
				"class which implements AbstractComponent class.");
	}

	public final String display() {
		if (jSoupElement == null) {
			Element element = initializeJSoupElement();

			// The initializing element must not me null.
			Validate.notNull(element, "JSoupElement must not be null.");

			jSoupElement = element;
		}
		return jSoupElement.toString();
	}

	/**
	 * Prints the component's html code on the standard output.
	 *
	 * @param component the component to be printed
	 */
	public static void display(Component<?> component) {
		System.out.print(component.display());
	}
}
