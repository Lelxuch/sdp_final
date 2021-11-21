package DecoratorPattern;

public class NitsDecorator extends Decorator{
    String Nits;

    public NitsDecorator(Message message, String Nits) {
        super(message);
        this.Nits = Nits;
    }

    public String decorate() {
        return decorateWithNits() + super.decorate();
    }

    private String decorateWithNits() {
        return "Nits: " + Nits + ", ";
    }
}
