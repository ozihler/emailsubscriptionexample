package newsletter.services;

import newsletter.domain.EmailAddress;

import java.util.List;

public interface SubscriberRepository {
    void store(EmailAddress emailAddress);

    List<EmailAddress> getAll();
}
