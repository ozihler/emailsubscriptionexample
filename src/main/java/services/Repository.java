package services;

import domain.EmailAddress;

import java.util.ArrayList;

public interface Repository {
    void store(String inputEmailAddress);

    ArrayList<EmailAddress> getSubscribers();
}
