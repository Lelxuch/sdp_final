package FactoryPattern.ProductTypes;

public abstract class Smartphones {

    public abstract String getName();
    public abstract String getCPU();
    public abstract String getRAM();
    public abstract String getStorage();
    public abstract String getInch();
    public abstract int getPrice();


    public String toString(){
        return "Name: " + getName()
                + ", CPU: " + getCPU()
                + ", Storage: " + getStorage()
                + ", RAM: " + getRAM()
                + ", Screen size: " + getInch()
                + ", Price: " + getPrice();
    }
}
