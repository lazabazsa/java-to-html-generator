package com.balazstorok.component.container;

import com.balazstorok.component.AbstractComponent;
import com.balazstorok.component.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Tabbed Container component of the framework, which can act as a Container with/without a frame and as a tabbed pane.
 * <p/>
 * Created by Balazs Torok on 11/02/17.
 */
abstract class AbstractTabbedContainer<T extends AbstractTabbedContainer> extends AbstractComponent<T> implements TabbedContainer<T> {
	/**
	 * Map of the elements where the key is the index of the tab, the value is any kind of Component.
	 */
	protected final List<Tab> tabs = new ArrayList<Tab>();

	/**
	 * Tab class for holding its title and component.
	 */
	protected final class Tab {
		private String title;
		private Component<?> component;

		public Tab(String title, Component<?> component) {
			this.title = title;
			this.component = component;
		}

		public String getTitle() {
			return title;
		}

		public Component<?> getComponent() {
			return component;
		}
	}
}
