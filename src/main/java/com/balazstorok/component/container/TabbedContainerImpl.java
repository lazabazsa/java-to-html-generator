package com.balazstorok.component.container;

import com.balazstorok.component.Component;
import com.balazstorok.util.CssUtil;
import org.apache.commons.lang3.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import javax.swing.text.html.HTML;

/**
 * Implementation of a tabbed container which can contain a component in each of its tabs.
 * Each newly added component will be placed into a new tab.
 * <p/>
 * To see the tabbed containers, the final html code should include the content of:
 * /src/main/resources/css/container/TabbedContainerImpl.css
 * /src/main/resources/js/container/TabbedContainerImpl.jss.
 * <p/>
 * These files contain the default behaviour and the style of the container.
 * <p/>
 * Created by Balazs Torok on 11/02/17.
 */
public class TabbedContainerImpl extends AbstractTabbedContainer<TabbedContainerImpl> {

	public static final String JAVASCRIPT_VOID_0 = "javascript:void(0)";
	public static final String OPEN_TAB_EVENT_1$D = "openTab(event, '%1$d')";
	public static final String ONCLICK = "onclick";

	/**
	 * @inheritDoc
	 */
	@Override
	protected Element initializeJSoupElement() {
		// Generate the container's HTML code

		// Creating a div root element
		Element divRootElement = new Element(Tag.valueOf(HTML.Tag.DIV.toString()), "");

		// Creating a UL tag with class="tab"
		Element ulElement = divRootElement.appendElement(HTML.Tag.UL.toString());
		ulElement.addClass(CssUtil.Class.TAB);

		// While going through the Tabs, we call all their components display method.
		Integer tabIndex = 1;
		for (Tab tab : super.tabs) {
			// Create tab headers inside the ul element
			Element liElement = ulElement.appendElement(HTML.Tag.LI.toString());
			Element aElement = liElement.appendElement(HTML.Tag.A.toString());
			aElement.attr(HTML.Attribute.HREF.toString(), JAVASCRIPT_VOID_0);
			aElement.attr(ONCLICK, String.format(OPEN_TAB_EVENT_1$D, tabIndex));
			aElement.addClass(CssUtil.Class.TAB_LINKS);
			aElement.appendText(tab.getTitle());

			// creating the tab content elements
			Element divTabElement = divRootElement.appendElement(HTML.Tag.DIV.toString());
			divTabElement.attr(HTML.Attribute.ID.toString(), tabIndex.toString());
			divTabElement.addClass(CssUtil.Class.TAB_CONTENT);
			divTabElement.append(tab.getComponent().display());

			// increase the tab index
			tabIndex++;
		}

		return divRootElement;
	}

	/**
	 * @inheritDoc
	 */
	public TabbedContainerImpl addComponent(String title, Component<?> component) {
		// Component must not be null.
		Validate.notNull(component);
		// Add the component to the list (to the next tab).
		super.tabs.add(new Tab(title, component));
		return this;
	}

	/**
	 * @inheritDoc
	 */
	public Class<TabbedContainerImpl> getType() {
		return TabbedContainerImpl.class;
	}
}
