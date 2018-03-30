package procedural;

import dataaccess.SubscriberRepository;
import presentation.SubscriberInputForm;
import presentation.SubscriberOverview;
import services.Overview;
import services.Repository;
import services.SubscriberService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EmailAddressSubscription {

     private SubscriberInputForm subscriberInputForm;

    public EmailAddressSubscription(SubscriberInputForm subscriberInputForm) {
        this.subscriberInputForm = subscriberInputForm;
    }

    public static void main(String[] args) throws IOException {
        Repository subscriberRepository = new SubscriberRepository(new ArrayList<>());
        Overview overview = new SubscriberOverview(System.out);

        SubscriberService subscriberService = new SubscriberService(subscriberRepository, overview);

        SubscriberInputForm subscriberInputForm = new SubscriberInputForm(new BufferedReader(new InputStreamReader(System.in)), System.out, subscriberService);

        new EmailAddressSubscription(subscriberInputForm).addSubscribers();
    }

    public void addSubscribers() throws IOException {

        while (true) {
            subscriberInputForm.inputEmailAddress();
        }
    }


}
