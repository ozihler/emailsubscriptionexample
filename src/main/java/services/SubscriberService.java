package services;

import domain.EmailAddress;

public class SubscriberService {

    private Repository subscriberRepository;
    private Overview overview;

    public SubscriberService(Repository subscriberRepository, Overview overview) {
        this.subscriberRepository = subscriberRepository;
        this.overview = overview;
    }

    public void store(EmailAddress emailAddress) {
        subscriberRepository.store(emailAddress);
    }

    public void updateOverview() {
        overview.update(subscriberRepository.getSubscribers());
    }
}
