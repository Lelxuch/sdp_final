package ObserverPattern;

import java.util.ArrayList;

public class Client implements IObserver {

    Server server;
    String username;
    ArrayList<String> messages = new ArrayList<String>();

    public Client(Server server, String username) {
        this.server = server;
        this.username = username;
    }

    @Override
    public void update() {

        this.messages = this.server.getMessages(username);
    }

    public String getUsername() {

        return username;
    }

    public void printMessages() {

        for (int i = 0; i < this.messages.size(); ++i) {
            System.out.println(this.messages.get(i));
        }
    }
}
