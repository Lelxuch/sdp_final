package FactoryPattern;

public class Laptop extends Laptops {

    String CPU, GPU, RAM, Storage, Inch;

    Laptop(String CPU, String GPU, String RAM, String Storage, String Inch){
        this.CPU = CPU;
        this.GPU = GPU;
        this.RAM = RAM;
        this.Storage = Storage;
        this.Inch = Inch;
    }

    @Override
    public String getCPU() {
        return this.CPU;
    }

    @Override
    public String getGPU() {
        return this.GPU;
    }

    @Override
    public String getStorage() {
        return this.Storage;
    }

    @Override
    public String getRAM() {
        return this.RAM;
    }

    @Override
    public String getInch() {
        return this.Inch;
    }
}