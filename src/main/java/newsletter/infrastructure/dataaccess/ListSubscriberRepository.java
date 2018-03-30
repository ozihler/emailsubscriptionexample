package newsletter.infrastructure.dataaccess;

import newsletter.domain.EmailAddress;
import newsletter.services.SubscriberRepository;

import java.util.ArrayList;
import java.util.List;

// "Speculative Generality Smell"
public class ListSubscriberRepository implements SubscriberRepository {
    private final List<EmailAddress> subscribers = new ArrayList<>();

    @Override
    public void store(EmailAddress emailAddress) {
        subscribers.add(emailAddress);
    }

    @Override
    public List<EmailAddress> getAll() {
        return subscribers;
    }
}
