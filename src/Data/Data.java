package Data;

import FactoryPattern.ProductTypes.Laptops;
import FactoryPattern.ProductTypes.Monitors;
import FactoryPattern.ProductTypes.Smartphones;
import User.User;

import java.util.ArrayList;

public class Data {

    public ArrayList<User> users = new ArrayList<User>();
    public ArrayList<Laptops> laptops = new ArrayList<Laptops>();
    public ArrayList<Smartphones> smartphones = new ArrayList<Smartphones>();
    public ArrayList<Monitors> monitors = new ArrayList<Monitors>();

    public void UpdateLaptop(ArrayList<Laptops> laptops){
        this.laptops = laptops;
    }
    public void UpdateSmartphone(ArrayList<Smartphones> smartphones){
        this.smartphones = smartphones;
    }
    public void UpdateMonitor(ArrayList<Monitors> monitors){
        this.monitors = monitors;
    }

    public ArrayList<Laptops> getLaptops() {
        return laptops;
    }

    public ArrayList<Smartphones> getSmartphones() {
        return smartphones;
    }

    public ArrayList<Monitors> getMonitors() {
        return monitors;
    }
}
