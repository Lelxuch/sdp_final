package FactoryPattern;

public class Factory {

    public static Laptops getLaptop(String CPU, String GPU, String RAM, String Storage, String Inch){
        return new Laptop(CPU, GPU, RAM, Storage, Inch);
    }

    public static Smartphones getSmartphone(String CPU, String RAM, String Storage, String Inch) {
        return new Smartphone(CPU, RAM, Storage, Inch);
    }

    public static Monitors getMonitor(String Inch, String Resolution, String Nits, String RefreshRate) {
        return new Monitor(Inch, Resolution, Nits, RefreshRate);
    }
}