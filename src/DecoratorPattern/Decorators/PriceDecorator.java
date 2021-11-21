package DecoratorPattern.Decorators;

import DecoratorPattern.Decorator;
import DecoratorPattern.Message;

public class PriceDecorator extends Decorator {
    int price;

    public PriceDecorator(Message message, int price) {
        super(message);
        this.price = price;
    }

    public String decorate() {
        return decorateWithPrice() + super.decorate();
    }

    private String decorateWithPrice() {
        return "Price: " + price + ", ";
    }
}
