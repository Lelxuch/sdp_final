package DecoratorPattern.Decorators;

import DecoratorPattern.Decorator;
import DecoratorPattern.Message;

public class CPUDecorator extends Decorator {
    String CPU;

    public CPUDecorator(Message message, String CPU) {
        super(message);
        this.CPU = CPU;
    }

    public String decorate() {
        return decorateWithCPU() + super.decorate();
    }

    private String decorateWithCPU() {
        return "CPU: " + CPU + ", ";
    }
}
