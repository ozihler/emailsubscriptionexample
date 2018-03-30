package procedural;

import java.util.ArrayList;

public class SubscriberService {

    private SubscriberRepository subscriberRepository;

    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    public void store(String inputEmailAddress) {
        subscriberRepository.store(inputEmailAddress);
    }

    public ArrayList<EmailAddress> getSubscribers() {
        return subscriberRepository.getSubscribers();
    }
}
