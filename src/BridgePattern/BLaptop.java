package BridgePattern;

import BridgePattern.Colors.Color;
import FactoryPattern.Laptop;
import FactoryPattern.ProductTypes.Laptops;

public class BLaptop extends Product {

    int price;
    String name, CPU, GPU, RAM, Storage, Inch;

    public BLaptop(Color color, Laptops laptop){
        super(color);
        this.price = laptop.getPrice();
        this.name = laptop.getName();
        this.CPU = laptop.getCPU();
        this.GPU = laptop.getGPU();
        this.RAM = laptop.getRAM();
        this.Storage = laptop.getStorage();
        this.Inch = laptop.getInch();
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
