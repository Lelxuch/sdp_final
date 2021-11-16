package FactoryPattern;

public abstract class Laptops {

    public abstract String getCPU();
    public abstract String getGPU();
    public abstract String getStorage();
    public abstract String getRAM();
    public abstract String getInch();

    public String toString(){
        return getCPU();
    }
}