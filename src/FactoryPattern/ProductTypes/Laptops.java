package FactoryPattern.ProductTypes;

public abstract class Laptops {

    public abstract String getName();
    public abstract String getCPU();
    public abstract String getGPU();
    public abstract String getStorage();
    public abstract String getRAM();
    public abstract String getInch();
    public abstract int getPrice();

    public String toString(){
        return "Name: " + getName()
                + ", CPU: " + getCPU()
                + ", GPU: " + getGPU()
                + ", Storage: " + getStorage()
                + ", RAM: " + getRAM()
                + ", Screen size: " + getInch()
                + ", Price: " + getPrice();
    }
}