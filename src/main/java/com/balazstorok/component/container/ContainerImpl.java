package com.balazstorok.component.container;

import com.balazstorok.component.Component;
import com.balazstorok.component.Position;
import com.balazstorok.exception.ContainerException;
import com.balazstorok.util.CssUtil;
import org.apache.commons.lang3.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Implementation of a container. A container component can contain 1 or more components, which can be element or
 * container type of components.
 * <p/>
 * A Container component can be framed. If it's so, the container's root table tag will get the .container-border.
 * <p/>
 * Created by Balazs Torok on 11/02/17.
 */
public class ContainerImpl extends AbstractContainer<ContainerImpl> {

	/**
	 * Tells whether the container should have a border around it or not.
	 */
	private final boolean isFramed;

	/**
	 * Margin of the container.
	 */
	private final CssUtil.Margin margin;

	/**
	 * Constructor for initializing the object with the default false isFramed and no margin values.
	 */
	public ContainerImpl() {
		this(false, null);
	}

	/**
	 * Constructor for initializing the object with the passed isFramed and no margin values.
	 */
	public ContainerImpl(boolean isFramed) {
		this(isFramed, null);
	}

	/**
	 * Constructor for initializing the object with the default false isFramed and the passed margin values.
	 */
	public ContainerImpl(CssUtil.Margin margin) {
		this(false, margin);
	}

	/**
	 * Constructor for initializing the object with the passed isFramed and the passed margin values.
	 */
	public ContainerImpl(boolean isFramed, CssUtil.Margin margin) {
		this.isFramed = isFramed;
		this.margin = margin;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	protected Element initializeJSoupElement() {
		// Generate the container's HTML code
		Element tableElement = new Element(Tag.valueOf(HTML.Tag.TABLE.toString()), "");

		// If the container has to be framed, we add the appropriate class to it.
		if (isFramed) {
			tableElement.addClass(CssUtil.Class.CONTAINER_BORDER);
		}

		// If the container has a Margin set it.
		if (margin != null) {
			tableElement.attr(HTML.Attribute.STYLE.toString(), CssUtil.Margin.getHtmlValue(margin));
		}
		/*
		 	While going through the keys of the map, we go row by row and ask the components to
		 	add their html code to the td tag.
		 */
		Set<Long> keySet = this.components.keySet();
		for (Long key : keySet) {
			List<Component<?>> nextLine = this.components.get(key);
			// Elements of the next line must not be empty
			Validate.notEmpty(nextLine);

			// Add a new row to the table element
			Element tableRowElement = tableElement.appendElement(HTML.Tag.TR.toString());
			for (Component<?> component : nextLine) {
				// per component add a new TD html tag with the html code of the component
				Element tableDataElement = tableRowElement.appendElement(HTML.Tag.TD.toString());
				tableDataElement.append(component.display());
			}
		}

		return tableElement;
	}

	/**
	 * @inheritDoc
	 */
	public Container<ContainerImpl> addComponent(Component<?> component) {
		return addComponent(component, Position.NEXT_LINE);
	}

	/**
	 * @inheritDoc
	 */
	public Container<ContainerImpl> addComponent(Component component, Position position) {

		// Both arguments must not be null.
		Validate.notNull(component);
		Validate.notNull(position);

		/*
			If the component has to be added next to the previous component, we add it to the list of the previous key.
			Else if it has to be in the next line, we add it as a new component with the next key.
		*/
		switch (position) {
			case BESIDE:

				// Current key (key of previous component) must not be null.
				Long currentKey = getKey();
				Validate.notNull(currentKey);

				// Get the components added to the map using the current key.
				List<Component<?>> components = super.components.get(currentKey);
				/*
					If there are no components added with the current key, it means the whole container is empty. In this
				 	case an exception is thrown.
				 */
				if (components == null) {
					throw new ContainerException("Container is empty. Please add the first component with the "
							+ Position.NEXT_LINE.name() + " argument!");
				} else {
					components.add(component);
				}
				break;

			case NEXT_LINE:

				// Create a new list for the components and add the currently added component to it with the next key.
				List<Component<?>> newComponents = new ArrayList<Component<?>>();
				newComponents.add(component);
				super.components.put(nextKey(), newComponents);
				break;
		}

		return this;
	}

	/**
	 * @inheritDoc
	 */
	public boolean isFramed() {
		return isFramed;
	}

	/**
	 * @inheritDoc
	 */
	public Class<ContainerImpl> getType() {
		return ContainerImpl.class;
	}
}
