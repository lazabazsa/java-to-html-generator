package com.balazstorok.component.container;

import com.balazstorok.component.Component;

/**
 * Tabbed Container which capable of handling several tabs.
 *
 * The content of each tab can be any Component.
 *
 * Created by Balazs Torok on 11/02/17.
 */
public interface TabbedContainer<T extends TabbedContainer> extends Component<T> {

	/**
	 * Adds an component to the container's new tab with the passed title.
	 *
	 * @param title the title of the tab
	 * @param component the component to add
	 * @return the tabbed container itself
	 */
	TabbedContainer<T> addComponent(String title, Component<?> component);
}
