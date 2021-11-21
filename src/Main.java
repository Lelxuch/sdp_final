import AdapterPattern.DefaultNewProductMessage;
import AdapterPattern.NewProductAdapter;
import BridgePattern.BLaptop;
import BridgePattern.BMonitor;
import BridgePattern.BSmartphone;
import BridgePattern.Colors.Black;
import BridgePattern.Colors.Blue;
import BridgePattern.Colors.Red;
import BridgePattern.Product;
import Data.Data;
import DecoratorPattern.Decorators.CategoryDecorator;
import DecoratorPattern.Decorators.DiscountPriceDecorator;
import DecoratorPattern.Decorators.NameDecorator;
import DecoratorPattern.DiscountMessage;
import DecoratorPattern.Message;
import FactoryPattern.ProductTypes.Laptops;
import FactoryPattern.ProductTypes.Monitors;
import FactoryPattern.ProductTypes.Smartphones;
import ObserverPattern.Client;
import ObserverPattern.IObserver;
import ObserverPattern.Server;
import StrategyPattern.BuyProduct;
import StrategyPattern.PayPal;
import StrategyPattern.PaymentMethod;
import StrategyPattern.Shop;
import User.User;

import java.util.Scanner;

public class Main {

    private static Server server = new Server();
    private static Data data = new Data();
    private static User signedInUser;
    private static String userChoice = "";
    static Scanner scanner = new Scanner(System.in);
    private static final DefaultNewProductMessage defaultNewProductMessage = new DefaultNewProductMessage();
    private static NewProductAdapter newProductAdapter = new NewProductAdapter(defaultNewProductMessage);

    public static void main(String[] args) {
        newProductAdapter.getServer(server);

        data.UpdateLaptop(newProductAdapter.CreateLaptop("Asus ROG Strix G17","Ryzen 7 4800H", "RTX 3050", "16GB", "1000GB HDD", "17.3 inch", 500000, data.getLaptops()));
        data.UpdateLaptop(newProductAdapter.CreateLaptop("Apple MacBook Air Retina M1","Apple M1", "Neural Engine", "16GB", "256GB SSD", "13 inch", 550000, data.getLaptops()));

        data.UpdateMonitor(newProductAdapter.CreateMonitor("Acer Predator XB253", "24.5 inch", "FullHD", "400", "144hz", 150000, data.getMonitors()));
        data.UpdateMonitor(newProductAdapter.CreateMonitor("GIGABYTE G27F", "27 inch", "FullHD", "300", "144hz", 130000, data.getMonitors()));

        data.UpdateSmartphone(newProductAdapter.CreateSmartphone("Samsung Galaxy A52", "Snapdragon 720G", "8GB", "256GB", "6.5", 150000, data.getSmartphones()));
        data.UpdateSmartphone(newProductAdapter.CreateSmartphone("Apple iPhone 13", "A15 Bionic", "4GB", "128GB", "6.1", 510000, data.getSmartphones()));

        server = newProductAdapter.updateServer();

        data.users.add(new User("test", "test"));
        IObserver client = new Client(server, "test");
        server.add((client));
        Message message = new NameDecorator(new CategoryDecorator(new DiscountPriceDecorator(new DiscountMessage(), "130 000, Previous price: 150 000"), "Monitor"), "Acer Predator XB253");
        server.addMessage(message.decorate());
        Message message2 = new NameDecorator(new CategoryDecorator(new DiscountPriceDecorator(new DiscountMessage(), "110 000, Previous price: 130 000"), "Monitor"), "GIGABYTE G27F");
        server.addMessage(message2.decorate());
        server.notifySubs();

        while (true) {
            System.out.println(
                    "1. User\n" +
                            "2. Admin/Server\n" +
                            "3. Exit"
            );
            userChoice = scanner.nextLine();
            switch(userChoice) {
                case "1":
                    userMenu();
                    break;
                case "2":
                    adminMenu();
                    break;
                case "3":
                    return;

            }
        }
    }

    public static void userMenu() {

        while (true) {
            System.out.println(
                    "1. Sign in\n" +
                    "2. Sign up\n" +
                    "3. Back"
            );
            userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1":
                    if (authorization()) {
                        loggedInUserMenu();
                    } else {
                        System.out.println("Wrong username or password");
                    }
                    break;
                case "2":
                    System.out.println(signUp());
                    break;
                case "3":
                    return;

            }
        }
    }

    public static void loggedInUserMenu() {

        System.out.println("You signed in");

        while (true) {
            System.out.println("Menu\n" +
                    "1. Buy product\n" +
                    "2. Subscribe status\n" +
                    "3. Check mail\n" +
                    "4. Log out");
            userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1":
                    buyProducts();
                    break;
                case "2":
                    subscribeSettings();
                    break;
                case "3":
                    checkMail();
                    break;
                case "4":
                    return;

            }
        }
    }

    public static void subscribeSettings() {

        while (true) {
            System.out.println("Menu\n" +
                    "1. Subscribe\n" +
                    "2. Unsubscribe\n" +
                    "3. Back");
            userChoice = scanner.nextLine();
            IObserver client;
            switch (userChoice) {
                case "1":
                    client = new Client(server, signedInUser.getUsername());
                    server.add((client));
                    break;
                case "2":
                    client = server.findClient(signedInUser.getUsername());
                    client.clearMessages();
                    server.remove(client);
                    break;
                case "3":
                    return;

            }
        }
    }

    public static void buyProducts() {

        while (true) {
            System.out.println("Menu\n" +
                    "1. Smartphones\n" +
                    "2. Laptops\n" +
                    "3. Monitors\n" +
                    "4. Back");
            userChoice = scanner.nextLine();
            PaymentMethod paymentMethod;
            BuyProduct shop;
            int cashback = 0;
            int price = 0;
            Product bSmartphone;
            Product bLaptop;
            Product bMonitor;
            switch (userChoice) {
                case "1":
                    for (int i = 0; i < data.smartphones.size(); ++i) {
                        Smartphones smartphone = data.smartphones.get(i);
                        System.out.println((i + 1) + ". " + smartphone.toString());
                    }
                    System.out.println("Product number:");
                    userChoice = scanner.nextLine();
                    Smartphones smartphone = data.smartphones.get(Integer.parseInt(userChoice) - 1);
                    System.out.println("1. Black 0\n" +
                            "2. Red 3000\n" +
                            "3. Blue 5000");
                    userChoice = scanner.nextLine();
                    switch (userChoice) {
                        case "1":
                            bSmartphone = new BSmartphone(new Black(), smartphone);
                            bSmartphone.info();
                            price = bSmartphone.getPrice();
                            break;
                        case "2":
                            bSmartphone = new BSmartphone(new Red(), smartphone);
                            bSmartphone.info();
                            price = bSmartphone.getPrice();
                            break;
                        case "3":
                            bSmartphone = new BSmartphone(new Blue(), smartphone);
                            bSmartphone.info();
                            price = bSmartphone.getPrice();
                            break;
                    }
                    System.out.println("1. PayPal\n" +
                            "2. Kaspi gold");
                    userChoice = scanner.nextLine();
                    switch (userChoice) {
                        case "1":
                            paymentMethod = new PayPal();
                            shop = new Shop(paymentMethod);
                            cashback = shop.getCashBack(price);
                            System.out.println("Successful! Your cashback: " + cashback);
                            break;
                        case "2":
                            paymentMethod = new PayPal();
                            shop = new Shop(paymentMethod);
                            cashback = shop.getCashBack(price);
                            System.out.println("Successful! Your cashback: " + cashback);
                            break;
                    }
                    break;
                case "2":
                    for (int i = 0; i < data.laptops.size(); ++i) {
                        Laptops laptop = data.laptops.get(i);
                        System.out.println((i + 1) + ". " + laptop.toString());
                    }
                    System.out.println("Product number:");
                    userChoice = scanner.nextLine();
                    Laptops laptop = data.laptops.get(Integer.parseInt(userChoice) - 1);
                    System.out.println("1. Black 0\n" +
                            "2. Red 3000\n" +
                            "3. Blue 5000");
                    userChoice = scanner.nextLine();
                    switch (userChoice) {
                        case "1":
                            bLaptop = new BLaptop(new Black(), laptop);
                            bLaptop.info();
                            price = bLaptop.getPrice();
                            break;
                        case "2":
                            bLaptop = new BLaptop(new Red(), laptop);
                            bLaptop.info();
                            price = bLaptop.getPrice();
                            break;
                        case "3":
                            bLaptop = new BLaptop(new Blue(), laptop);
                            bLaptop.info();
                            price = bLaptop.getPrice();
                            break;
                    }
                    System.out.println("1. PayPal\n" +
                            "2. Kaspi gold");
                    userChoice = scanner.nextLine();
                    switch (userChoice) {
                        case "1":
                            paymentMethod = new PayPal();
                            shop = new Shop(paymentMethod);
                            cashback = shop.getCashBack(price);
                            System.out.println("Successful! Your cashback: " + cashback);
                            break;
                        case "2":
                            paymentMethod = new PayPal();
                            shop = new Shop(paymentMethod);
                            cashback = shop.getCashBack(price);
                            System.out.println("Successful! Your cashback: " + cashback);
                            break;
                    }
                    break;
                case "3":
                    for (int i = 0; i < data.monitors.size(); ++i) {
                        Monitors monitor = data.monitors.get(i);
                        System.out.println((i + 1) + ". " + monitor.toString());
                    }
                    System.out.println("Product number:");
                    userChoice = scanner.nextLine();
                    Monitors monitor = data.monitors.get(Integer.parseInt(userChoice) - 1);
                    System.out.println("1. Black 0\n" +
                            "2. Red 3000\n" +
                            "3. Blue 5000");
                    userChoice = scanner.nextLine();
                    switch (userChoice) {
                        case "1":
                            bMonitor = new BMonitor(new Black(), monitor);
                            bMonitor.info();
                            price = bMonitor.getPrice();
                            break;
                        case "2":
                            bMonitor = new BMonitor(new Red(), monitor);
                            bMonitor.info();
                            price = bMonitor.getPrice();
                            break;
                        case "3":
                            bMonitor = new BMonitor(new Blue(), monitor);
                            bMonitor.info();
                            price = bMonitor.getPrice();
                            break;
                    }
                    System.out.println("1. PayPal\n" +
                            "2. Kaspi gold");
                    userChoice = scanner.nextLine();
                    switch (userChoice) {
                        case "1":
                            paymentMethod = new PayPal();
                            shop = new Shop(paymentMethod);
                            cashback = shop.getCashBack(price);
                            System.out.println("Successful! Your cashback: " + cashback);
                            break;
                        case "2":
                            paymentMethod = new PayPal();
                            shop = new Shop(paymentMethod);
                            cashback = shop.getCashBack(price);
                            System.out.println("Successful! Your cashback: " + cashback);
                            break;
                    }
                    break;
                case "4":
                    return;

            }
        }
    }

    public static void checkMail() {

        IObserver client = server.findClient(signedInUser.getUsername());

        if (client == null) {
            System.out.println("No subscription");
        } else {
            client.printMessages();
        }
        return;
    }

    // Admin
    public static void adminMenu() {

        while (true) {
            System.out.println(
                    "1. Create product\n" +
                            "2. Create discount\n" +
                            "3. Back"
            );
            userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1":
                    createProductMenu();
                    break;
                case "2":
                    createDiscountMenu();
                    break;
                case "3":
                    return;

            }
        }
    }

    // Create
    public static void createProductMenu() {
        System.out.println("Menu\n" +
                "1. Smartphones\n" +
                "2. Laptops\n" +
                "3. Monitors\n" +
                "4. Back");
        userChoice = scanner.nextLine();
        if (userChoice.equals("4")) {
            return;
        }
        createProduct(userChoice);
    }

    public static void createProduct(String category) {
        int price;
        String name, CPU, RAM, Storage, Inch, GPU, Resolution, Nits, RefreshRate;

        switch (category) {
            case "1":
                System.out.println("Name:");
                name = scanner.nextLine();
                System.out.println("CPU:");
                CPU = scanner.nextLine();
                System.out.println("RAM:");
                RAM = scanner.nextLine();
                System.out.println("Storage:");
                Storage = scanner.nextLine();
                System.out.println("Size:");
                Inch = scanner.nextLine();
                System.out.println("Price:");
                price = scanner.nextInt();
                newProductAdapter.getServer(server);
                data.UpdateSmartphone(newProductAdapter.CreateSmartphone(name, CPU, RAM, Storage, Inch, price, data.getSmartphones()));
                server = newProductAdapter.updateServer();
                server.notifySubs();
                break;
            case "2":
                System.out.println("Name:");
                name = scanner.nextLine();
                System.out.println("CPU:");
                CPU = scanner.nextLine();
                System.out.println("GPU:");
                GPU = scanner.nextLine();
                System.out.println("RAM:");
                RAM = scanner.nextLine();
                System.out.println("Storage:");
                Storage = scanner.nextLine();
                System.out.println("Size:");
                Inch = scanner.nextLine();
                System.out.println("Price:");
                price = scanner.nextInt();
                newProductAdapter.getServer(server);
                data.UpdateLaptop(newProductAdapter.CreateLaptop(name, CPU, GPU, RAM, Storage, Inch, price, data.getLaptops()));
                server = newProductAdapter.updateServer();
                server.notifySubs();
                break;
            case "3":
                System.out.println("Name:");
                name = scanner.nextLine();
                System.out.println("Size:");
                Inch = scanner.nextLine();
                System.out.println("Resolution:");
                Resolution = scanner.nextLine();
                System.out.println("Nits:");
                Nits = scanner.nextLine();
                System.out.println("Refresh rate:");
                RefreshRate = scanner.nextLine();
                System.out.println("Price:");
                price = scanner.nextInt();
                newProductAdapter.getServer(server);
                data.UpdateMonitor(newProductAdapter.CreateMonitor(name, Inch, Resolution, Nits, RefreshRate, price, data.getMonitors()));
                server = newProductAdapter.updateServer();
                server.notifySubs();
                break;
        }
    }

    public static void createDiscountMenu() {

        Message message = new NameDecorator(new CategoryDecorator(new DiscountPriceDecorator(new DiscountMessage(), "110 000, Previous price: 130 000"), "Monitor"), "GIGABYTE G27F");
        server.addMessage(message.decorate());
        server.notifySubs();
    }

    // Authorization
    public static boolean authorization() {

        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        for (int i = 0; i < data.users.size(); ++i) {
            User user = data.users.get(i);
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                signedInUser = user;
                return true;
            }
        }
        return false;
    }

    public static String signUp() {

        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        User user = new User(username, password);
        data.users.add(user);

        return "You signed up";
    }
}
