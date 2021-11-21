package BridgePattern.Colors;

public class Black implements Color {

    public String name = "Black";

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }
}