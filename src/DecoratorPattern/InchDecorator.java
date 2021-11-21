package DecoratorPattern;

public class InchDecorator extends Decorator{
    String Inch;

    public InchDecorator(Message message, String Inch) {
        super(message);
        this.Inch = Inch;
    }

    public String decorate() {
        return decorateWithInch() + super.decorate();
    }

    private String decorateWithInch() {
        return "Inch: " + Inch + ", ";
    }
}
