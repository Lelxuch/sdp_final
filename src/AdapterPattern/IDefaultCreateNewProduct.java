package AdapterPattern;

import FactoryPattern.ProductTypes.Laptops;
import FactoryPattern.ProductTypes.Monitors;
import FactoryPattern.ProductTypes.Smartphones;

import java.util.ArrayList;

public interface IDefaultCreateNewProduct {
    public ArrayList<Monitors> CreateMonitor(String name, String Inch, String Resolution, String Nits, String RefreshRate, int price,  ArrayList<Monitors> monitors);
    public ArrayList<Smartphones> CreateSmartphone(String name, String CPU, String RAM, String Storage, String Inch, int price, ArrayList<Smartphones> smartphones);
    public ArrayList<Laptops> CreateLaptop(String name, String CPU, String GPU, String RAM, String Storage, String Inch, int price, ArrayList<Laptops> laptops);
}
