package services;

import domain.EmailAddress;

import java.util.ArrayList;

public interface Repository {
    void store(EmailAddress emailAddress);

    ArrayList<EmailAddress> getSubscribers();
}
