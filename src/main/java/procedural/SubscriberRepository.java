package procedural;

import java.util.ArrayList;

public class SubscriberRepository implements Repository {
    private ArrayList<EmailAddress> subscribers;

    public SubscriberRepository(ArrayList<EmailAddress> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public void store(String inputEmailAddress) {
        //Store subscribers in database
        subscribers.add(EmailAddress.create(inputEmailAddress));
    }

    @Override
    public ArrayList<EmailAddress> getSubscribers() {
        return subscribers;
    }
}
