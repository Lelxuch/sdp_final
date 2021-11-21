package AdapterPattern;

import java.util.ArrayList;

public interface IDefaultNewProductMessage {
    public ArrayList<String> CreateMonitorMessage(String name, String Inch, String Resolution, String Nits, String RefreshRate, int price, ArrayList<String> messages);
    public ArrayList<String> CreateSmartphoneMessage(String name, String CPU, String RAM, String Storage, String Inch, int price, ArrayList<String> messages);
    public ArrayList<String> CreateLaptopMessage(String name, String CPU, String GPU, String RAM, String Storage, String Inch, int price, ArrayList<String> messages);
}
