package com.balazstorok.component.element;

/**
 * Input element interface.
 *
 * Created by Balazs Torok on 12/02/17.
 */
public interface Input<T extends Input> extends Element<T> {

	/**
	 * Returns the input html tag's type attribute.
	 *
	 * @return the input type as InputType enum
	 */
	InputImpl.InputType getInputType();

	/**
	 * Returns the input html tag's value attribute.
	 *
	 * @return the value as String
	 */
	String getValue();
}
