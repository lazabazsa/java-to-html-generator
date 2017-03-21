package com.balazstorok.component.element;

import org.jsoup.parser.Tag;

import javax.swing.text.html.HTML;

/**
 * Input element as a Component.
 *
 * Created by Balazs Torok on 12/02/17.
 */
public class InputImpl extends AbstractElement<InputImpl> implements Input<InputImpl> {

	/**
	 * Type of the input element.
	 */
	private InputType inputType;

	/**
	 * Value of the input element.
	 */
	private String value;

	/**
	 * Constructor for initializing the object with the passed values of inputType and its value.
	 *
	 * @param inputType the inputType
	 * @param value the value attribute of the input
	 */
	public InputImpl(InputType inputType, String value) {
		this.inputType = inputType;
		this.value = value;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	protected org.jsoup.nodes.Element initializeJSoupElement() {
		// Generate the input's HTML code
		org.jsoup.nodes.Element inputElement = new org.jsoup.nodes.Element(Tag.valueOf(HTML.Tag.INPUT.toString()), "");
		// set the attributes of the component
		inputElement.attr(HTML.Attribute.TYPE.toString(), this.inputType.getHtmlValue());
		inputElement.attr(HTML.Attribute.VALUE.toString(), this.value);

		return inputElement;
	}

	/**
	 * @inheritDoc
	 */
	public InputType getInputType() {
		return inputType;
	}

	/**
	 * @inheritDoc
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @inheritDoc
	 */
	public Class<InputImpl> getType() {
		return InputImpl.class;
	}

	/**
	 * Type of an Input element. Currently the framework supports only these input types.
	 */
	public enum InputType {
		BUTTON("button"),
		CHECKBOX("checkbox"),
		EMAIL("email"),
		PASSWORD("password"),
		SEARCH("search"),
		SUBMIT("submit"),
		TEL("tel"),
		TEXT("text");

		private String htmlValue;

		InputType(String htmlValue) {
			this.htmlValue = htmlValue;
		}

		public String getHtmlValue() {
			return htmlValue;
		}
	}

}


