package com.balazstorok.component.element;

import java.util.List;

/**
 * Interface for a select component.
 *
 * Created by Balazs Torok on 13/02/17.
 */
public interface Select<T extends Select> extends Element<T> {

	/**
	 * Adds an option at the end of the options list.
	 */
	Select<T> addOption(SelectImpl.Option option);

	/**
	 * List of options for the select element.
	 * @return the list of options
	 */
	List<SelectImpl.Option> getOptions();

	/**
	 * Number of options which should be shown by the select element..
	 * @return the value of the size
	 */
	Integer getSize();
}