package procedural;

import java.util.ArrayList;

public class SubscriberRepository {
    private ArrayList<EmailAddress> subscribers;

    public SubscriberRepository(ArrayList<EmailAddress> subscribers) {
        this.subscribers = subscribers;
    }

    public void store(String inputEmailAddress) {
        //Store subscribers in database
        subscribers.add(EmailAddress.create(inputEmailAddress));
    }

    public ArrayList<EmailAddress> getSubscribers() {
        return subscribers;
    }
}
