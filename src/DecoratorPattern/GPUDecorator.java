package DecoratorPattern;

public class GPUDecorator extends Decorator{
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
