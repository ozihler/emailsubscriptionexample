package newsletter.services;

import newsletter.domain.EmailAddress;

import java.util.List;

public interface SubscriberOverview {
    void update(List<EmailAddress> subscribers);
}
