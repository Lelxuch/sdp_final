package DecoratorPattern.Decorators;

import DecoratorPattern.Decorator;
import DecoratorPattern.Message;

public class DiscountPriceDecorator extends Decorator {
    String price;

    public DiscountPriceDecorator(Message message, String price) {
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
