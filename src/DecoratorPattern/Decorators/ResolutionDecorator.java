package DecoratorPattern.Decorators;

import DecoratorPattern.Decorator;
import DecoratorPattern.Message;

public class ResolutionDecorator extends Decorator {
    String Resolution;

    public ResolutionDecorator(Message message, String Resolution) {
        super(message);
        this.Resolution = Resolution;
    }

    public String decorate() {
        return decorateWithResolution() + super.decorate();
    }

    private String decorateWithResolution() {
        return "Resolution: " + Resolution + ", ";
    }
}
