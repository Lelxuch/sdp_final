package FactoryPattern;

public abstract class Monitors {

    public abstract String getInch();
    public abstract String getResolution();
    public abstract String getNits();
    public abstract String getRefreshRate();

    public String toString(){
        return "Screen size: " + getInch()
                + ", Resolution: " + getResolution()
                + ", Nits: " + getNits()
                + ", Refresh rate: " + getRefreshRate();
    }
}
