package DecoratorPattern;

public class UserInfo extends Decorator{
    String username;

    public UserInfo(Message message, String username) {
        super(message);
        this.username = username;
    }

    public String decorate() {
        return decorateWithUser() + super.decorate();
    }

    private String decorateWithUser() {
        return "Dear, " + username + " \n";
    }
}
