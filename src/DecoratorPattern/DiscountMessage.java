package DecoratorPattern;

public class DiscountMessage implements Message{
    private Message message;

    @Override
    public String decorate() {
        return "New discount on our product! \n";
    }
}
