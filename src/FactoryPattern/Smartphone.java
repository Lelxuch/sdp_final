package FactoryPattern;

public class Smartphone extends Smartphones {

    String CPU, RAM, Storage, Inch;

    Smartphone(String CPU, String RAM, String Storage, String Inch){
        this.CPU = CPU;
        this.RAM = RAM;
        this.Storage = Storage;
        this.Inch = Inch;
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
}
