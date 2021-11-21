package AdapterPattern;

public interface IDefaultNewProductMessage {
    public void CreateMonitorMessage(String name, String Inch, String Resolution, String Nits, String RefreshRate, int price);
    public void CreateSmartphoneMessage(String name, String CPU, String RAM, String Storage, String Inch, int price);
    public void CreateLaptopMessage(String name, String CPU, String GPU, String RAM, String Storage, String Inch, int price);
}
