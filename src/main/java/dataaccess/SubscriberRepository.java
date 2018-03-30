package dataaccess;

import domain.EmailAddress;
import services.Repository;

import java.util.ArrayList;

public class SubscriberRepository implements Repository {
    private ArrayList<EmailAddress> subscribers;

    public SubscriberRepository(ArrayList<EmailAddress> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public void store(EmailAddress emailAddress) {
        //Store subscribers in database
        subscribers.add(emailAddress);
    }

    @Override
    public ArrayList<EmailAddress> getSubscribers() {
        return subscribers;
    }
}
