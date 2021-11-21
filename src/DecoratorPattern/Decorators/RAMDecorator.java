package DecoratorPattern.Decorators;

import DecoratorPattern.Decorator;
import DecoratorPattern.Message;

public class RAMDecorator extends Decorator {
    String RAM;

    public RAMDecorator(Message message, String RAM) {
        super(message);
        this.RAM = RAM;
    }

    public String decorate() {
        return decorateWithRAM() + super.decorate();
    }

    private String decorateWithRAM() {
        return "RAM: " + RAM + ", ";
    }
}
