package FactoryPattern;

import FactoryPattern.ProductTypes.Smartphones;

public class Smartphone extends Smartphones {
    int price;
    String name, CPU, RAM, Storage, Inch;

    Smartphone(String name, String CPU, String RAM, String Storage, String Inch, int price){
        this.price = price;
        this.name = name;
        this.CPU = CPU;
        this.RAM = RAM;
        this.Storage = Storage;
        this.Inch = Inch;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getCPU() {
        return this.CPU;
    }

    @Override
    public String getRAM() {
        return this.RAM;
    }

    @Override
    public String getStorage() {
        return this.Storage;
    }

    @Override
    public String getInch() {
        return this.Inch;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
