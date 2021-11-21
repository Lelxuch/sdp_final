package DecoratorPattern.Decorators;

import DecoratorPattern.Decorator;
import DecoratorPattern.Message;

public class GPUDecorator extends Decorator {
    String GPU;

    public GPUDecorator(Message message, String GPU) {
        super(message);
        this.GPU = GPU;
    }

    public String decorate() {
        return decorateWithGPU() + super.decorate();
    }

    private String decorateWithGPU() {
        return "GPU: " + GPU + ", ";
    }
}
