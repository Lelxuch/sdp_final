package FactoryPattern.ProductTypes;

public abstract class Monitors {

    public abstract String getName();
    public abstract String getInch();
    public abstract String getResolution();
    public abstract String getNits();
    public abstract String getRefreshRate();
    public abstract int getPrice();

    public String toString(){
        return "Name: " + getName()
                + ", Screen size: " + getInch()
                + ", Resolution: " + getResolution()
                + ", Nits: " + getNits()
                + ", Refresh rate: " + getRefreshRate()
                + ", Price: " + getPrice();
    }
}
