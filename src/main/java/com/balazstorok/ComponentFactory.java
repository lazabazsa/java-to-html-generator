package com.balazstorok;

import com.balazstorok.component.container.Container;
import com.balazstorok.component.container.ContainerImpl;
import com.balazstorok.component.container.TabbedContainer;
import com.balazstorok.component.container.TabbedContainerImpl;
import com.balazstorok.component.element.Input;
import com.balazstorok.component.element.InputImpl;
import com.balazstorok.component.element.Select;
import com.balazstorok.component.element.SelectImpl;
import com.balazstorok.util.CssUtil;

import java.util.List;

/**
 * Factory for creating components.
 *
 * This class can be used for building the components already provided by this framework.
 * <p/>
 * Created by Balazs Torok on 11/02/17.
 */
public final class ComponentFactory {

	/**
	 * Creates a container component.
	 * @return the created empty container component
	 */
	public static Container<ContainerImpl> createContainer() {
		return createContainer(false, null);
	}

	/**
	 * Creates a container component.
	 *
	 * @param isFramed true if the container should be bordered, otherwise false
	 * @return the created empty container component
	 */
	public static Container<ContainerImpl> createContainer(boolean isFramed) {
		return createContainer(isFramed, null);
	}

	/**
	 * Creates a container component.
	 *
	 * @param margin the margin object if the container should have any
	 * @return the created empty container component
	 */
	public static Container<ContainerImpl> createContainer(CssUtil.Margin margin) {
		return createContainer(false, margin);
	}

	/**
	 * Creates a container component.
	 *
	 * @param isFramed true if the container should be bordered, otherwise false
	 * @param margin the margin object if the container should have any
	 * @return the created empty container component
	 */
	public static Container<ContainerImpl> createContainer(boolean isFramed, CssUtil.Margin margin) {
		return new ContainerImpl(isFramed, margin);
	}

	/**
	 * Creates a tabbed container component.
	 * @return the created empty tabbed container component
	 */
	public static TabbedContainer<TabbedContainerImpl> createTabbedContainer() {
		return new TabbedContainerImpl();
	}

	/**
	 * Creates an Input component.
	 *
	 * @param inputType the type of the input
	 * @param value the value of the input
	 * @return the created input component
	 */
	public static Input<InputImpl> createInput(InputImpl.InputType inputType, String value) {
		return new InputImpl(inputType, value);
	}

	/**
	 * Creates a Select component.
	 *
	 * @return the created empty select component
	 */
	public static Select<SelectImpl> createSelect() {
		return createSelect(null, null);
	}

	/**
	 * Creates a Select component.
	 *
	 * @param options the list of the options what the select should have
	 * @return the created select component with the list of options
	 */
	public static Select<SelectImpl> createSelect(List<SelectImpl.Option> options) {
		return createSelect(options, null);
	}

	/**
	 * Creates a Select component.
	 *
	 * @param size the size of the visible options
	 * @return the created empty select component
	 */
	public static Select<SelectImpl> createSelect(Integer size) {
		return createSelect(null, size);
	}

	/**
	 * Creates a Select component.
	 *
	 * @param options the list of the options what the select should have
	 * @param size the size of the visible options
	 * @return the created select component with the list of options
	 */
	public static Select<SelectImpl> createSelect(List<SelectImpl.Option> options, Integer size) {
		return new SelectImpl(options, size);
	}
}
