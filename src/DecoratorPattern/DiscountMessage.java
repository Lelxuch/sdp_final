package DecoratorPattern;

public class DiscountMessage implements Message{
    private Message message;
    String productName;
    String priceWithDiscount;
    String category;

    public DiscountMessage(String productName, String priceWithDiscount, String category) {
        this.productName = productName;
        this.priceWithDiscount = priceWithDiscount;
        this.category = category;
    }

    @Override
    public String decorate() {
        return "New discount on our product! \n" + "Name: " + productName + "; Category: " + category + "; Price with discount: " + priceWithDiscount;
    }
}
