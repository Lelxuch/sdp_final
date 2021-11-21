package BridgePattern;

import BridgePattern.Colors.Color;
import FactoryPattern.ProductTypes.Smartphones;

public class BSmartphone extends Product {

    int price;
    String name, CPU, RAM, Storage, Inch;

    public BSmartphone(Color color, Smartphones smartphone){
        super(color);

        this.price = smartphone.getPrice();
        this.name = smartphone.getName();
        this.CPU = smartphone.getCPU();
        this.RAM = smartphone.getRAM();
        this.Storage = smartphone.getStorage();
        this.Inch = smartphone.getInch();
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