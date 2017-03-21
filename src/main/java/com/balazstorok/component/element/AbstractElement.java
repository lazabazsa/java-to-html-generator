package com.balazstorok.component.element;

import com.balazstorok.component.AbstractComponent;

/**
 * The root of all Element type components.
 **
 * Created by Balazs Torok on 12/02/17.
 */
abstract class AbstractElement<T extends AbstractElement>  extends AbstractComponent<T> implements Element<T> {

}
