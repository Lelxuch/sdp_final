package BridgePattern;

import BridgePattern.Colors.Color;
import FactoryPattern.Monitor;
import FactoryPattern.ProductTypes.Monitors;

public class BMonitor extends Product {

    int price;
    String name, Inch, Resolution, Nits, RefreshRate;

    public BMonitor(Color color, Monitors monitor){
        super(color);
        this.price = monitor.getPrice();
        this.name = monitor.getName();
        this.Inch = monitor.getInch();
        this.Resolution = monitor.getResolution();
        this.Nits = monitor.getNits();
        this.RefreshRate = monitor.getRefreshRate();
    }

    @Override
    public void info() {
        System.out.println("You bought " + color.getName() + ". Total price is: " + (price + color.getPrice()));
    }

    @Override
    public int getPrice() {
        return price + color.getPrice();
    }
}
