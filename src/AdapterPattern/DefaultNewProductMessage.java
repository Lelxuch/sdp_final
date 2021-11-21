package AdapterPattern;

import DecoratorPattern.Decorators.*;
import DecoratorPattern.Message;
import DecoratorPattern.NewProductMessage;

public class DefaultNewProductMessage implements IDefaultNewProductMessage{

    @Override
    public void CreateMonitorMessage(String name, String Inch, String Resolution, String Nits, String RefreshRate, int price) {
        Message message = new NameDecorator(new InchDecorator(new ResolutionDecorator(new NitsDecorator(new RefreshRateDecorator(new PriceDecorator(new NewProductMessage(), price), RefreshRate), Nits), Resolution), Inch), name);
    }

    @Override
    public void CreateSmartphoneMessage(String name, String CPU, String RAM, String Storage, String Inch, int price) {
        Message message = new NameDecorator(new CPUDecorator(new RAMDecorator(new StorageDecorator(new InchDecorator(new PriceDecorator(new NewProductMessage(), price), Inch), Storage), RAM), CPU), name);
    }

    @Override
    public void CreateLaptopMessage(String name, String CPU, String GPU, String RAM, String Storage, String Inch, int price) {
        Message message = new NameDecorator(new CPUDecorator(new GPUDecorator(new RAMDecorator(new StorageDecorator(new InchDecorator(new PriceDecorator(new NewProductMessage(), price), Inch), Storage), RAM), GPU), CPU), name);
    }
}
