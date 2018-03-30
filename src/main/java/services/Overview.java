package services;

import domain.EmailAddress;

import java.util.ArrayList;

public interface Overview {
    void update(ArrayList<EmailAddress> subscribers);
}
