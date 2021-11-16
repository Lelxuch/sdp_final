package FactoryPattern;

import java.sql.Ref;

public class Monitor extends Monitors {

    String Inch, Resolution, Nits, RefreshRate;

    Monitor(String Inch, String Resolution, String Nits, String RefreshRate){
        this.Inch = Inch;
        this.Resolution = Resolution;
        this.Nits = Nits;
        this.RefreshRate = RefreshRate;
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
