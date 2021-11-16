package FactoryPattern;

public abstract class Smartphones {

    public abstract String getCPU();
    public abstract String getRAM();
    public abstract String getStorage();
    public abstract String getInch();

    public String toString(){
        return getCPU();
    }
}
