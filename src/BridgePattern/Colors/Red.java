package BridgePattern.Colors;

public class Red implements Color {

    public String name = "Red";

    @Override
    public int getPrice() {
        return 3000;
    }

    @Override
    public String getName() {
        return name;
    }
}