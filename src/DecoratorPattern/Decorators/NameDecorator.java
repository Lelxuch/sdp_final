package DecoratorPattern.Decorators;

import DecoratorPattern.Decorator;
import DecoratorPattern.Message;

public class NameDecorator extends Decorator {
    String name;

    public NameDecorator(Message message, String name) {
        super(message);
        this.name = name;
    }

    public String decorate() {
        return decorateWithName() + super.decorate();
    }

    private String decorateWithName() {
        return "Product name: " + name + ", ";
    }
}
