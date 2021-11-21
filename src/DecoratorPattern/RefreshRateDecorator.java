package DecoratorPattern;

public class RefreshRateDecorator extends Decorator{
    String RefreshRate;

    public RefreshRateDecorator(Message message, String RefreshRate) {
        super(message);
        this.RefreshRate = RefreshRate;
    }

    public String decorate() {
        return decorateWithRefreshRate() + super.decorate();
    }

    private String decorateWithRefreshRate() {
        return "RefreshRate: " + RefreshRate + ", ";
    }
}
