package AdapterPattern;

import DecoratorPattern.Decorators.*;
import DecoratorPattern.Message;
import DecoratorPattern.NewProductMessage;

import java.util.ArrayList;

public class DefaultNewProductMessage implements IDefaultNewProductMessage{

    @Override
    public ArrayList<String> CreateMonitorMessage(String name, String Inch, String Resolution, String Nits, String RefreshRate, int price, ArrayList<String> messages) {
        Message message = new NameDecorator(new InchDecorator(new ResolutionDecorator(new NitsDecorator(new RefreshRateDecorator(new PriceDecorator(new NewProductMessage(), price), RefreshRate), Nits), Resolution), Inch), name);
        messages.add(message.decorate());
        return messages;
    }

    @Override
    public ArrayList<String> CreateSmartphoneMessage(String name, String CPU, String RAM, String Storage, String Inch, int price, ArrayList<String> messages) {
        Message message = new NameDecorator(new CPUDecorator(new RAMDecorator(new StorageDecorator(new InchDecorator(new PriceDecorator(new NewProductMessage(), price), Inch), Storage), RAM), CPU), name);
        messages.add(message.decorate());
        return messages;
    }

    @Override
    public ArrayList<String> CreateLaptopMessage(String name, String CPU, String GPU, String RAM, String Storage, String Inch, int price, ArrayList<String> messages) {
        Message message = new NameDecorator(new CPUDecorator(new GPUDecorator(new RAMDecorator(new StorageDecorator(new InchDecorator(new PriceDecorator(new NewProductMessage(), price), Inch), Storage), RAM), GPU), CPU), name);
        messages.add(message.decorate());
        return messages;
    }
}
