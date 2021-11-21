package AdapterPattern;

public interface IDefaultCreateNewProduct {
    public void CreateMonitor(String name, String Inch, String Resolution, String Nits, String RefreshRate, int price);
    public void CreateSmartphone(String name, String CPU, String RAM, String Storage, String Inch, int price);
    public void CreateLaptop(String name, String CPU, String GPU, String RAM, String Storage, String Inch, int price);
}
