package DecoratorPattern;

public class PriceDecorator extends Decorator{
    String price;

    public PriceDecorator(Message message, String price) {
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
