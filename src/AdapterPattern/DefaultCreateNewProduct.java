package AdapterPattern;

import FactoryPattern.Factory;
import FactoryPattern.ProductTypes.Laptops;
import FactoryPattern.ProductTypes.Monitors;
import FactoryPattern.ProductTypes.Smartphones;

public class DefaultCreateNewProduct implements IDefaultCreateNewProduct{
    @Override
    public ArrayList<Monitors> CreateMonitor(String name, String Inch, String Resolution, String Nits, String RefreshRate, int price, ArrayList<Monitors> monitors) {
        Monitors monitor = Factory.getMonitor(name, Inch, Resolution, Nits, RefreshRate, price);
        monitors.add(monitor);
        return monitors;
    }

    @Override
    public ArrayList<Smartphones> CreateSmartphone(String name, String CPU, String RAM, String Storage, String Inch, int price, ArrayList<Smartphones> smartphones) {
        Smartphones smartphone = Factory.getSmartphone(name, CPU, RAM, Storage, Inch, price);
        smartphones.add(smartphone);
        return smartphones;
    }

    @Override
    public ArrayList<Laptops> CreateLaptop(String name, String CPU, String GPU, String RAM, String Storage, String Inch, int price, ArrayList<Laptops> laptops) {
        Laptops laptop = Factory.getLaptop(name,CPU, CPU, RAM, Storage, Inch, price);
        laptops.add(laptop);
        return laptops;
    }
}
