# Java to HTML Generator

## Description

This framework is capable of generating `Component` based 
html code. 

By the behaviour of the components the framework distinguish between `Container` and `Element` components.
  

### Containers
The containers are based on the `<table>` html element.
There are two different type of containers provided by the framework:

* **Container**: Can be framed and can contain 1 or more `Container`s and `Element`s.
* **TabbedContainer**: Can have tabs and each tab can contain 1 `Container` or 1 `Element`.

### Elements
The Elements are based on the any html element.
There are two different type of Elements provided by the framework:

* **Input**: Can be a `Text` or `Button` type input field.
* **Select**: It is a select html element, which can have multiple `Options`
and also its `size` can be defined.

# Usage
Using the framework's building blocks, the `ComponentFactory` shall be used.

After creating a Component its `display()` method returns its html code.

To add a Component (either Container or Element) to a Container, you can
define whether the Component should be added next to the previously added
Component (if there was any) or into a new line.

## Example

1. The following Java code creates a container with a frame and with the style `margin: 0 auto`. 
2. A Text `Input` element with the `value` *Hello World!* is added to the container.
3. The container prints its html code to the standard output.

`Container<ContainerImpl> container = ComponentFactory.createContainer(true, new CssUtil.Margin());`

`container.addComponent(ComponentFactory.createInput(InputImpl.InputType.TEXT, "Hello World!"));`

`AbstractComponent.display(container);`

The code above results the following html code:

`<table class="container-border" style="margin: 0 auto">`

`<tr>`

`<td><input type="text" value="Hello World!"></td>`

`</tr>`

`</table>`