package com.balazstorok.component.element;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.List;

/**
 * Input element as a Component.
 *
 * Created by Balazs Torok on 12/02/17.
 */
public class SelectImpl extends AbstractElement<SelectImpl> implements Select<SelectImpl> {

	/**
	 * List of options.
	 */
	private List<Option> options = new ArrayList<Option>();

	/**
	 * Shown number of options.
	 */
	private Integer size;

	/**
	 * Constructor for initializing the object with the default values.
	 */
	public SelectImpl() {
		this(null, null);
	}


	/**
	 * Constructor for initializing the object without options and with the passed size value.
	 */
	public SelectImpl(Integer size) {
		this(null, size);
	}

	/**
	 * Constructor for initializing the object with the passed options and with default size value.
	 */
	public SelectImpl(List<Option> options) {
		this(options, null);

	}

	/**
	 * Constructor for initializing the object with the passed options and size values.
	 */
	public SelectImpl(List<Option> options, Integer size) {
		if(options != null) {
			this.options = options;
		}
		this.size = size;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	protected Element initializeJSoupElement() {
		// Generate the select's HTML code
		Element selectElement = new Element(Tag.valueOf(HTML.Tag.SELECT.toString()), "");
		// set the size if it's defined
		if (size != null) {
			selectElement.attr(HTML.Attribute.SIZE.toString(), size.toString());

		}
		// Options list must not be null, can be empty
		Validate.notNull(options);
		for (Option option : options) {
			Element optionElement = selectElement.appendElement(HTML.Tag.OPTION.toString());
			optionElement.attr(HTML.Attribute.VALUE.toString(), option.getValue());
			optionElement.text(option.getText());
		}

		return selectElement;
	}

	/**
	 * @inheritDoc
	 */
	public Select<SelectImpl> addOption(Option option) {
		options.add(option);
		return this;
	}

	/**
	 * @inheritDoc
	 */
	public List<Option> getOptions() {
		return options;
	}

	/**
	 * @inheritDoc
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * @inheritDoc
	 */
	public Class<SelectImpl> getType() {
		return SelectImpl.class;
	}

	/**
	 * Option class for holding information about its value and text attributes.
	 */
	public static class Option {
		private String value;
		private String text;

		public Option(String value, String text) {
			this.value = value;
			this.text = text;
		}

		public String getValue() {
			return value;
		}

		public String getText() {
			return text;
		}
	}
}


