package BridgePattern.Colors;

public class Blue implements Color {

    public String name = "Blue";

    @Override
    public int getPrice() {
        return 5000;
    }

    @Override
    public String getName() {
        return name;
    }
}