import DecoratorPattern.DiscountMessage;
import DecoratorPattern.Message;
import DecoratorPattern.UserInfo;
import FactoryPattern.Factory;
import FactoryPattern.ProductTypes.Laptops;
import FactoryPattern.ProductTypes.Monitors;
import FactoryPattern.ProductTypes.Smartphones;
import ObserverPattern.Client;
import ObserverPattern.IObserver;
import ObserverPattern.Server;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Server server = new Server();
    private static ArrayList<User> users = new ArrayList<User>();
    private static ArrayList<Laptops> laptops = new ArrayList<Laptops>();
    private static ArrayList<Smartphones> smartphones = new ArrayList<Smartphones>();
    private static ArrayList<Monitors> monitors = new ArrayList<Monitors>();
    private static String signedInUser = "";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Laptops laptop1 = Factory.getLaptop("Asus ROG Strix G17","Ryzen 7 4800H", "RTX 3050", "16GB", "1000GB HDD", "17.3 inch");
        laptops.add(laptop1);
        Laptops laptop2 = Factory.getLaptop("Apple MacBook Air Retina M1","Apple M1", "Neural Engine", "16GB", "256GB SSD", "13 inch");
        laptops.add(laptop2);

        Monitors monitor1 = Factory.getMonitor("Acer Predator XB253", "24.5 inch", "FullHD", "400", "144hz");
        monitors.add(monitor1);
        Monitors monitor2 = Factory.getMonitor("GIGABYTE G27F", "27 inch", "FullHD", "300", "144hz");
        monitors.add(monitor2);

        Smartphones smartphone1 = Factory.getSmartphone("Samsung Galaxy A52", "Snapdragon 720G", "8GB", "256GB", "6.5");
        smartphones.add(smartphone1);
        Smartphones smartphone2 = Factory.getSmartphone("Apple iPhone 13", "A15 Bionic", "4GB", "128GB", "6.1");
        smartphones.add(smartphone2);

        users.add(new User("test", "test"));
        Client client = new Client(server, "test");
        server.add((client));
        Message message = new UserInfo(new DiscountMessage("Acer Predator XB253","130 000","Monitor"), "test");
        server.addMessage(message.decorate());
        server.notifySubs();

        String userChoice = "";

        while (true) {
            System.out.println(
                    "1. Sign in\n" +
                            "2. Sign up\n" +
                            "3. Exit"
            );
            userChoice = scanner.nextLine();
            switch(userChoice) {
                case "1":
                    if (authorization()) {
                        userMenu();
                    } else {
                        System.out.println("Wrong username or password");
                    }
                    break;
                case "2":
                    System.out.println(signUp());
                    break;
                case "3":
                    System.out.println("Thank you! Good bye!");
                    return;
                default:
                    System.out.println("no match");
            }
        }
    }

    public static void userMenu() {
        System.out.println("You signed in");
        while (true) {
            System.out.println("Menu\n" +
                    "1. View products\n" +
                    "2. Subscribe status\n" +
                    "3. Check mail\n" +
                    "4. Log out");
            String userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1":
                    viewProducts();
                    break;
                case "2":
                    subscribeSettings();
                    break;
                case "3":
                    checkMail();
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
            String userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":
                    return;
            }
        }
    }

    public static void viewProducts() {
        System.out.println("You signed in");
        while (true) {
            System.out.println("Menu\n" +
                    "1. Smartphones\n" +
                    "2. Laptops\n" +
                    "3. Monitors\n" +
                    "4. Back");
            String userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1":
                    showProducts(1);
                    break;
                case "2":
                    showProducts(2);
                    break;
                case "3":
                    showProducts(3);
                    break;
                case "4":
                    return;
            }
        }
    }

    public static void checkMail() {

        IObserver client = server.findClient(signedInUser);

        if (client == null) {
            System.out.println("No subscription");
        } else {
            client.printMessages();
        }
    }

    public static boolean showProducts(int type) {

        switch (type) {
            case 1:
                for (int i = 0; i < smartphones.size(); ++i) {
                    Smartphones smartphone = smartphones.get(i);
                    System.out.println((i + 1)+ ". " + smartphone.toString());
                }
                break;
            case 2:
                for (int i = 0; i < laptops.size(); ++i) {
                    Laptops laptop = laptops.get(i);
                    System.out.println((i + 1)+ ". " + laptop.toString());
                }
                break;
            case 3:
                for (int i = 0; i < monitors.size(); ++i) {
                    Monitors monitor = monitors.get(i);
                    System.out.println((i + 1)+ ". " + monitor.toString());
                }
                break;
        }


        return false;
    }

    public static boolean authorization() {

        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        for (int i = 0; i < users.size(); ++i) {
            User user = users.get(i);
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                signedInUser = user.getUsername();
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
        users.add(user);

        return "You signed up";
    }
}
