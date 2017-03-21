package com.balazstorok.samples;

import com.balazstorok.ComponentFactory;
import com.balazstorok.component.Position;
import com.balazstorok.component.container.Container;
import com.balazstorok.component.container.ContainerImpl;
import com.balazstorok.component.container.TabbedContainer;
import com.balazstorok.component.container.TabbedContainerImpl;
import com.balazstorok.component.element.InputImpl;
import com.balazstorok.component.element.SelectImpl;
import com.balazstorok.util.CssUtil;
import com.balazstorok.util.ResourceUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.swing.text.html.HTML;

/**
 * Example Application for demonstrating the library.
 *
 * To see the result, save the generated text as .html file, then open it in a browser.
 * <p/>
 * Created by Balazs Torok on 12/02/17.
 */
public final class ExampleApp {

	public static void main(String[] args) {

		// Creating a container using the framework provided Factory utility
		Container<ContainerImpl> container1 = ComponentFactory.createContainer(true, new CssUtil.Margin());
		container1.addComponent(ComponentFactory.createInput(InputImpl.InputType.TEXT, "Text"))
				.addComponent(ComponentFactory.createInput(InputImpl.InputType.BUTTON, "Button"))
				.addComponent(ComponentFactory.createInput(InputImpl.InputType.TEXT, "Text 2 beside Button"), Position.BESIDE)
				.addComponent(ComponentFactory.createInput(InputImpl.InputType.BUTTON, "Button 2 beside Text 2"), Position.BESIDE)
				.addComponent(ComponentFactory.createInput(InputImpl.InputType.TEXT, "Text 3 in new line"), Position.NEXT_LINE)
				.addComponent(ComponentFactory.createSelect(2)
						.addOption(new SelectImpl.Option("Option1", "Option 1 beside Text 3"))
						.addOption(new SelectImpl.Option("Option2", "Option 2 beside Text 3")), Position.BESIDE)
				.addComponent(ComponentFactory.createSelect().addOption(new SelectImpl.Option("Option3", "Option 3 in new line")), Position.NEXT_LINE);

		// Creating a second container
		Container<ContainerImpl> container2 = ComponentFactory.createContainer(true, new CssUtil.Margin());
		container2.addComponent(ComponentFactory.createInput(InputImpl.InputType.BUTTON, "Button 1"))
				.addComponent(ComponentFactory.createInput(InputImpl.InputType.BUTTON, "Button 2 beside Button 1"), Position.BESIDE)
				.addComponent(ComponentFactory.createInput(InputImpl.InputType.TEXT, "Text 1 beside Button 2"), Position.BESIDE)
				.addComponent(ComponentFactory.createInput(InputImpl.InputType.BUTTON, "Button 3 beside Text 1"), Position.BESIDE)
				.addComponent(ComponentFactory.createInput(InputImpl.InputType.BUTTON, "Button 4 beside Button 3"), Position.BESIDE)
				.addComponent(ComponentFactory.createSelect(2)
						.addOption(new SelectImpl.Option("Option1", "Option 1 in new line"))
						.addOption(new SelectImpl.Option("Option2", "Option 2 in new line")), Position.NEXT_LINE)
				.addComponent(ComponentFactory.createSelect(2)
						.addOption(new SelectImpl.Option("Option1", "Option 1 beside a select"))
						.addOption(new SelectImpl.Option("Option2", "Option 2 beside a select")), Position.BESIDE);


		// Creating a third container
		Container<ContainerImpl> container3 = ComponentFactory.createContainer(true, new CssUtil.Margin());
		container3.addComponent(container1).addComponent(container2, Position.BESIDE);


		// Creating a Tabbed container
		TabbedContainer<TabbedContainerImpl> tabbedContainer = ComponentFactory.createTabbedContainer()
				.addComponent("Simple container", container1)
				.addComponent("Multiple containers", container3)
				.addComponent("Simple element", ComponentFactory.createSelect().addOption(new SelectImpl.Option("Option4", "Option 4")));

		// Initialize a new HTML JSoup Document
		Document jSoupDocument = Jsoup.parse("");
		// Getting the body of it
		Element bodyElement = jSoupDocument.body();

		// Adding the content of the ContainerImpl.css file as inner style using the ResourceUtil utility
		Element styleElement = bodyElement.appendElement(HTML.Tag.STYLE.toString());
		styleElement.attr("type", "text/css");
		styleElement.appendChild(new DataNode(ResourceUtil.getFileContent("/css/container/ContainerImpl.css"), ""));
		// Adding the content of the TabbedContainerImpl.css file as inner style
		styleElement.appendChild(new DataNode(ResourceUtil.getFileContent("/css/container/TabbedContainerImpl.css"), ""));

		// Adding the content of the TabbedContainerImpl.jss file as embedded script
		Element scriptElement = bodyElement.appendElement(HTML.Tag.SCRIPT.toString());
		scriptElement.attr("type", "text/javascript");
		scriptElement.appendChild(new DataNode(ResourceUtil.getFileContent("/js/container/TabbedContainerImpl.jss"), ""));

		// Appending the html code of the container
		bodyElement.append(tabbedContainer.display());

		// Sending the generated text to the standard output
		System.out.println(jSoupDocument.html());
	}
}
