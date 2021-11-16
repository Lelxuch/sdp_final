import FactoryPattern.Factory;
import FactoryPattern.Laptops;
import FactoryPattern.Monitor;
import FactoryPattern.Monitors;

public class Main {

    public static void main(String[] args) {

        Laptops laptop = Factory.getLaptop("Intel", "Nvidia", "8gb", "1000gb", "16");
        System.out.println(laptop.toString());
        Monitors monitor = Factory.getMonitor("27 inch", "2k", "400", "144hz");
        System.out.println(monitor.toString());
    }
}
