package DecoratorPattern;

public class Decorator implements Message{
    private Message message;

    public Decorator(Message message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return message.decorate();
    }
}
