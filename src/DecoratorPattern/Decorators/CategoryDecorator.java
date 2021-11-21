package DecoratorPattern.Decorators;

import DecoratorPattern.Decorator;
import DecoratorPattern.Message;

public class CategoryDecorator extends Decorator {
    String category;

    public CategoryDecorator(Message message, String category) {
        super(message);
        this.category = category;
    }

    public String decorate() {
        return decorateWithCategory() + super.decorate();
    }

    private String decorateWithCategory() {
        return "Category: " + category + ", ";
    }
}
