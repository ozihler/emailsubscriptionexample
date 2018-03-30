package procedural;

import java.util.ArrayList;

public interface Repository {
    void store(String inputEmailAddress);

    ArrayList<EmailAddress> getSubscribers();
}
