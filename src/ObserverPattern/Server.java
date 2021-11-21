package ObserverPattern;

import FactoryPattern.ProductTypes.Monitors;

import java.util.ArrayList;

public class Server implements IObservable {

    private ArrayList<IObserver> clients = new ArrayList<IObserver>();
    private ArrayList<String> messages = new ArrayList<String>();

    @Override
    public void add(IObserver client) {
        this.clients.add(client);
    }

    @Override
    public void remove(IObserver client) {
        this.clients.remove(client);
    }

    @Override
    public void notifySubs() {
        clients.forEach(client -> {
            client.update();
        });
    }

    public void addMessage(String message) {

        this.messages.add(message);
        notifySubs();
    }

    public ArrayList<String> getMessages(String clientUsername) {
        ArrayList<String> messagesToSend = new ArrayList<String>();
        for (int i = 0; i < this.messages.size(); ++i) {
           messagesToSend.add("Dear, " + clientUsername + "\n" + this.messages.get(i));
        }
        return messagesToSend;
    }

    public IObserver findClient(String username) {

        for (int i = 0; i < this.clients.size(); ++i) {
            IObserver client = this.clients.get(i);
            if (client.getUsername().equals(username)) {
                return client;
            }
        }
        return null;
    }
    public ArrayList<String> getMessages(){
        return messages;
    }
}
