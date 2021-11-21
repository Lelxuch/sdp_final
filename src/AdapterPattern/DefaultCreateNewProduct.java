package AdapterPattern;

import FactoryPattern.Factory;
import FactoryPattern.ProductTypes.Laptops;
import FactoryPattern.ProductTypes.Monitors;
import FactoryPattern.ProductTypes.Smartphones;

public class DefaultCreateNewProduct implements IDefaultCreateNewProduct{
    @Override
    public void CreateMonitor(String name, String Inch, String Resolution, String Nits, String RefreshRate, int price) {
        Monitors monitor = Factory.getMonitor(name, Inch, Resolution, Nits, RefreshRate, price);
    }

    @Override
    public void CreateSmartphone(String name, String CPU, String RAM, String Storage, String Inch, int price) {
        Smartphones smartphone = Factory.getSmartphone(name, CPU, RAM, Storage, Inch, price);
    }

    @Override
    public void CreateLaptop(String name, String CPU, String GPU, String RAM, String Storage, String Inch, int price) {
        Laptops laptop = Factory.getLaptop(name,CPU, CPU, RAM, Storage, Inch, price);
    }
}
