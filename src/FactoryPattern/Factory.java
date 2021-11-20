package FactoryPattern;

import FactoryPattern.ProductTypes.Laptops;
import FactoryPattern.ProductTypes.Monitors;
import FactoryPattern.ProductTypes.Smartphones;

public class Factory {

    public static Laptops getLaptop(String name, String CPU, String GPU, String RAM, String Storage, String Inch, int price){
        return new Laptop(name, CPU, GPU, RAM, Storage, Inch, price);
    }

    public static Smartphones getSmartphone(String name, String CPU, String RAM, String Storage, String Inch, int price) {
        return new Smartphone(name, CPU, RAM, Storage, Inch, price);
    }

    public static Monitors getMonitor(String name, String Inch, String Resolution, String Nits, String RefreshRate, int price) {
        return new Monitor(name, Inch, Resolution, Nits, RefreshRate, price);
    }

}