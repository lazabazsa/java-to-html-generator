package com.balazstorok.container;

import com.balazstorok.component.Position;
import com.balazstorok.component.container.Container;
import com.balazstorok.component.container.ContainerImpl;
import com.balazstorok.component.element.InputImpl;
import com.balazstorok.ComponentFactory;
import com.balazstorok.util.CssUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for testing purposes of Container.
 * <p/>
 * Created by Balazs Torok on 12/02/17.
 */
public class TestContainers {

	public static final String TEXT_VALUE = "Text";
	public static final String TABLE_CLASS_STRING = "<table class=";
	public static final String CONTAINER_BORDER = "container-border";
	public static final String MARGIN_0_AUTO = "margin: 0 auto";
	public static final String TD_INPUT_TYPE = "<td><input type=";
	public static final String TR_CLOSING_TAG = "</tr>";
	public static final String TABLE_CLOSING_TAG = "</table>";
	public static final String TABLE_OPENING_TAG = "<table>";
	public static final String TR_OPENING_TAG = "<tr>";
	public static final String TD_OPENING_TAG = "<td>";
	public static final String BUTTON_VALUE = "Button";

	/**
	 * Test for a framed container with a style margin and one input field.
	 * <p/>
	 * Expected generated html code:
	 * <table class="container-border" style="margin: 0 auto">
	 * <tr>
	 * <td><input type="text" value="Text"></td>
	 * </tr>
	 * </table>
	 */
	@Test
	public void testContainerWithOneComponent() {
		Container<ContainerImpl> container = ComponentFactory.createContainer(true, new CssUtil.Margin());
		container.addComponent(ComponentFactory.createInput(InputImpl.InputType.TEXT, TEXT_VALUE));
		String containerHtmlCode = container.display();
		Assert.assertTrue(containerHtmlCode.length() == 121);
		Assert.assertTrue(containerHtmlCode.substring(0, 13).equals(TABLE_CLASS_STRING));
		Assert.assertTrue(containerHtmlCode.substring(14, 30).equals(CONTAINER_BORDER));
		Assert.assertTrue(containerHtmlCode.substring(39, 53).equals(MARGIN_0_AUTO));
		Assert.assertTrue(containerHtmlCode.substring(64, 80).equals(TD_INPUT_TYPE));
		Assert.assertTrue(containerHtmlCode.substring(107, 112).equals(TR_CLOSING_TAG));
		Assert.assertTrue(containerHtmlCode.substring(113, 121).equals(TABLE_CLOSING_TAG));
	}

	/**
	 * Test for a framed container with a style margin and two input fields next to each other.
	 * <p/>
	 * Expected generated html code:
	 * <table>
	 * <tr>
	 * <td><input type="text" value="Text"></td>
	 * <td><input type="button" value="Button"></td>
	 * </tr>
	 * </table>
	 */
	@Test
	public void testContainerWithOneComponentAndOneBeside() {
		Container<ContainerImpl> container = ComponentFactory.createContainer(false);
		container.addComponent(ComponentFactory.createInput(InputImpl.InputType.TEXT, "Text"))
				.addComponent(ComponentFactory.createInput(InputImpl.InputType.BUTTON, "Button"), Position.BESIDE);
		String containerHtmlCode = container.display();
		Assert.assertTrue(containerHtmlCode.length() == 121);
		Assert.assertTrue(containerHtmlCode.substring(0, 7).equals(TABLE_OPENING_TAG));
		Assert.assertTrue(containerHtmlCode.substring(9, 13).equals(TR_OPENING_TAG));
		Assert.assertTrue(containerHtmlCode.substring(16, 32).equals(TD_INPUT_TYPE));
		Assert.assertTrue(containerHtmlCode.substring(60, 76).equals(TD_INPUT_TYPE));
		Assert.assertTrue(containerHtmlCode.substring(107, 112).equals(TR_CLOSING_TAG));
		Assert.assertTrue(containerHtmlCode.substring(113, 121).equals(TABLE_CLOSING_TAG));
	}

	/**
	 * Test for a container with a style margin and one input field and a second below it.
	 * <p/>
	 * Expected generated html code:
	 * <table>
	 * <tr>
	 * <td><input type="text" value="Text"></td>
	 * </tr>
	 * <tr>
	 * <td><input type="button" value="Button"></td>
	 * </tr>
	 * </table>
	 */
	@Test
	public void testContainerWithOneComponentAndOneBelowThatComponent() {
		// Creating a container using the framework provided Factory utility
		Container<ContainerImpl> container = ComponentFactory.createContainer(false);
		container.addComponent(ComponentFactory.createInput(InputImpl.InputType.TEXT, TEXT_VALUE))
				.addComponent(ComponentFactory.createInput(InputImpl.InputType.BUTTON, BUTTON_VALUE), Position.NEXT_LINE);
		String containerHtmlCode = container.display();
		Assert.assertTrue(containerHtmlCode.length() == 134);
		Assert.assertTrue(containerHtmlCode.substring(0, 7).equals(TABLE_OPENING_TAG));
		Assert.assertTrue(containerHtmlCode.substring(9, 13).equals(TR_OPENING_TAG));
		Assert.assertTrue(containerHtmlCode.substring(16, 32).equals(TD_INPUT_TYPE));
		Assert.assertTrue(containerHtmlCode.substring(73, 89).equals(TD_INPUT_TYPE));
		Assert.assertTrue(containerHtmlCode.substring(120, 125).equals(TR_CLOSING_TAG));
		Assert.assertTrue(containerHtmlCode.substring(126, 134).equals(TABLE_CLOSING_TAG));
	}

	/**
	 * Test for a container with three container which are next to each other.
	 * <p/>
	 * Expected generated html code:
	 * <table class="container-border" style="margin: 0 auto">
	 * <tr>
	 * <td>
	 * <table class="container-border"></table></td>
	 * <td>
	 * <table class="container-border"></table></td>
	 * <td>
	 * <table class="container-border"></table></td>
	 * </tr>
	 * </table>
	 */
	@Test
	public void testContainerWithThreeContainersNextToEachOther() {
		// Creating a container using the framework provided Factory utility
		Container<ContainerImpl> container = ComponentFactory.createContainer(true, new CssUtil.Margin());
		container.addComponent(ComponentFactory.createContainer(true))
				.addComponent(ComponentFactory.createContainer(true), Position.BESIDE)
				.addComponent(ComponentFactory.createContainer(true), Position.BESIDE);

		String containerHtmlCode = container.display();

		Assert.assertTrue(containerHtmlCode.length() == 245);
		Assert.assertTrue(containerHtmlCode.substring(0, 13).equals(TABLE_CLASS_STRING));
		Assert.assertTrue(containerHtmlCode.substring(57, 61).equals(TR_OPENING_TAG));
		Assert.assertTrue(containerHtmlCode.substring(64, 68).equals(TD_OPENING_TAG));
		Assert.assertTrue(containerHtmlCode.substring(72, 85).equals(TABLE_CLASS_STRING));
		Assert.assertTrue(containerHtmlCode.substring(128, 141).equals(TABLE_CLASS_STRING));
		Assert.assertTrue(containerHtmlCode.substring(184, 197).equals(TABLE_CLASS_STRING));
	}

}
