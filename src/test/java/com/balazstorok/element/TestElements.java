package com.balazstorok.element;

import com.balazstorok.ComponentFactory;
import com.balazstorok.component.element.Input;
import com.balazstorok.component.element.InputImpl;
import com.balazstorok.component.element.Select;
import com.balazstorok.component.element.SelectImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * * Test class for testing purposes of Containerl.
 * <p/>
 * Created by Balazs Torok on 13/02/17.
 */
public class TestElements {

	public static final String TEXT_VALUE = "Text Value";
	public static final String LOWERCASE_TEXT = "text";
	public static final String LOWERCASE_BUTTON = "button";
	public static final String INPUT_TYPE = "<input type=";
	public static final String OPENING_CLOSING_SELECT = "<select></select>";
	public static final String SELECT_OPTION_VALUE = "<select><option value=";
	public static final String TEXT_VALUE_OPTION_SELECT = ">Text Value</option></select>";

	/**
	 * Test for an input text field.
	 * <p/>
	 * Expected generated html code:
	 * <input type="text" value="Text Value">
	 */
	@Test
	public void testTextInput() {
		Input<InputImpl> inputText = ComponentFactory.createInput(InputImpl.InputType.TEXT, TEXT_VALUE);
		String containerHtmlCode = inputText.display();
		Assert.assertTrue(containerHtmlCode.length() == 38);
		Assert.assertTrue(containerHtmlCode.substring(0, 12).equals(INPUT_TYPE));
		Assert.assertTrue(containerHtmlCode.substring(13, 17).equals(LOWERCASE_TEXT));
		Assert.assertTrue(containerHtmlCode.substring(26, 36).equals(TEXT_VALUE));
	}

	/**
	 * Test for an input button.
	 * <p/>
	 * Expected generated html code:
	 * <input type="button" value="Text Value">
	 */
	@Test
	public void testButtonInput() {
		Input<InputImpl> inputText = ComponentFactory.createInput(InputImpl.InputType.BUTTON, TEXT_VALUE);
		String containerHtmlCode = inputText.display();
		Assert.assertTrue(containerHtmlCode.length() == 40);
		Assert.assertTrue(containerHtmlCode.substring(0, 12).equals(INPUT_TYPE));
		Assert.assertTrue(containerHtmlCode.substring(13, 19).equals(LOWERCASE_BUTTON));
		Assert.assertTrue(containerHtmlCode.substring(28, 38).equals(TEXT_VALUE));
	}

	/**
	 * Test for a select element with one option.
	 * <p/>
	 * Expected generated html code:
	 * <select></select>
	 */
	@Test
	public void testSelectWitNoOption() {
		Select<SelectImpl> select = ComponentFactory.createSelect();
		String containerHtmlCode = select.display();
		Assert.assertTrue(containerHtmlCode.length() == 17);
		Assert.assertTrue(containerHtmlCode.equals(OPENING_CLOSING_SELECT));
	}

	/**
	 * Test for a select element with one option.
	 * <p/>
	 * Expected generated html code:
	 * <select><option value="text">Text Value</option></select>
	 * */
	@Test
	public void testSelectWithOneOption() {
		Select<SelectImpl> select = ComponentFactory.createSelect().addOption(new SelectImpl.Option(LOWERCASE_TEXT, TEXT_VALUE));
		String containerHtmlCode = select.display();
		Assert.assertTrue(containerHtmlCode.length() == 57);
		Assert.assertTrue(containerHtmlCode.substring(0, 22).equals(SELECT_OPTION_VALUE));
		Assert.assertTrue(containerHtmlCode.substring(28, 57).equals(TEXT_VALUE_OPTION_SELECT));
	}

}
