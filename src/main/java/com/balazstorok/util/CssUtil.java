package com.balazstorok.util;

import org.apache.commons.lang3.NotImplementedException;

/**
 * CssUtil helper class, which contains constants and already implemented style properties.
 * <p/>
 * Created by Balazs Torok on 12/02/17.
 */
public final class CssUtil {
	private static final CssUtil INSTANCE = new CssUtil();

	public static final class Class {
		public static final String CONTAINER_BORDER = "container-border";
		public static final String TAB = "tab";
		public static final String TAB_CONTENT = "tab-content";
		public static final String TAB_LINKS = "tab-links";
	}

	public static final class Id {

	}

	/**
	 * Margin class for representing margin css property
	 */
	public static final class Margin {

		public enum Orientation {
			AUTO("margin: 0 auto"),
			ALL("margin: %1$d"),
			TOP("margin-top: %1$d"),
			RIGHT("margin-right: %1$d"),
			BOTTOM("margin-bottom: %1$d"),
			LEFT("margin-left: %1$d");

			private String html;

			Orientation(String html) {
				this.html = html;
			}

			public String getHtml() {
				return html;
			}
		}

		private Integer all;
		private Integer top;
		private Integer right;
		private Integer bottom;
		private Integer left;
		private Orientation orientation;

		public Margin() {
			this.orientation = Orientation.AUTO;
		}

		public Margin(Integer all) {
			this.all = all;
			if (this.all == null) {
				throw new UnsupportedOperationException("At least one of the values must not be null.");
			}
			this.orientation = Orientation.ALL;
		}

		public Margin(Integer top, Integer right, Integer bottom, Integer left) {
			this.top = top;
			this.right = right;
			this.bottom = bottom;
			this.left = left;

			if (this.top != null) {
				this.orientation = Orientation.TOP;
			} else if (this.right != null) {
				this.orientation = Orientation.RIGHT;
			} else if (this.bottom != null) {
				this.orientation = Orientation.BOTTOM;
			} else if (this.left != null) {
				this.orientation = Orientation.LEFT;
			} else {
				throw new UnsupportedOperationException("At least one of the values must not be null.");
			}
		}

		public Integer getAll() {
			return all;
		}

		public Integer getTop() {
			return top;
		}

		public Integer getRight() {
			return right;
		}

		public Integer getBottom() {
			return bottom;
		}

		public Integer getLeft() {
			return left;
		}

		public Orientation getOrientation() {
			return orientation;
		}

		public static String getHtmlValue(Margin margin) {
			if (!Orientation.AUTO.equals(margin.getOrientation())) {
				throw new NotImplementedException("Support for adding margin-top, margin-right, margin-bottom, " +
						"margin-left to the container is not implemented yet.");
			}
			return Orientation.AUTO.getHtml();
		}
	}
}
