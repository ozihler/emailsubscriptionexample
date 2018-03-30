package procedural;

import java.util.ArrayList;

public class SubscriberService {

    private SubscriberRepository subscriberRepository;
    private SubscriberOverview subscriberOverview;

    public SubscriberService(SubscriberRepository subscriberRepository, SubscriberOverview subscriberOverview) {
        this.subscriberRepository = subscriberRepository;
        this.subscriberOverview = subscriberOverview;
    }

    public void store(String inputEmailAddress) {
        subscriberRepository.store(inputEmailAddress);
    }

    public ArrayList<EmailAddress> getSubscribers() {
        return subscriberRepository.getSubscribers();
    }

    public void updateOverview() {
        subscriberOverview.updateOverview(getSubscribers());
    }
}
