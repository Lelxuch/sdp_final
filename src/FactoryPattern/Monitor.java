package FactoryPattern;

import FactoryPattern.ProductTypes.Monitors;

public class Monitor extends Monitors {

    String name, Inch, Resolution, Nits, RefreshRate;

    Monitor(String name, String Inch, String Resolution, String Nits, String RefreshRate){
        this.name = name;
        this.Inch = Inch;
        this.Resolution = Resolution;
        this.Nits = Nits;
        this.RefreshRate = RefreshRate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getInch() {
        return this.Inch;
    }

    @Override
    public String getResolution() {
        return this.Resolution;
    }

    @Override
    public String getNits() {
        return this.Nits;
    }

    @Override
    public String getRefreshRate() {
        return this.RefreshRate;
    }
}
