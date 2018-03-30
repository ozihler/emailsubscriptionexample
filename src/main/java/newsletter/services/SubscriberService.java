package newsletter.services;

import newsletter.domain.EmailAddress;

public class SubscriberService {
    private final SubscriberOverview overview; //Observer
    private final SubscriberRepository repository;//Observer

    public SubscriberService(SubscriberOverview overview, SubscriberRepository repository) {
        this.overview = overview;
        this.repository = repository;
    }

    public void store(EmailAddress emailAddress) {
        repository.store(emailAddress);
    }

    public void updateGui() {
        overview.update(repository.getAll());
    }
}
