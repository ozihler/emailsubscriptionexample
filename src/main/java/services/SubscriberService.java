package services;

public class SubscriberService {

    private Repository subscriberRepository;
    private Overview overview;

    public SubscriberService(Repository subscriberRepository, Overview overview) {
        this.subscriberRepository = subscriberRepository;
        this.overview = overview;
    }

    public void store(String inputEmailAddress) {
        subscriberRepository.store(inputEmailAddress);
    }

    public void updateOverview() {
        overview.update(subscriberRepository.getSubscribers());
    }
}
