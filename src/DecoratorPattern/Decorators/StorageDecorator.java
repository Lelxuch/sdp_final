package DecoratorPattern.Decorators;

import DecoratorPattern.Decorator;
import DecoratorPattern.Message;

public class StorageDecorator extends Decorator {
    String Storage;

    public StorageDecorator(Message message, String Storage) {
        super(message);
        this.Storage = Storage;
    }

    public String decorate() {
        return decorateWithStorage() + super.decorate();
    }

    private String decorateWithStorage() {
        return "Storage: " + Storage + ", ";
    }
}
