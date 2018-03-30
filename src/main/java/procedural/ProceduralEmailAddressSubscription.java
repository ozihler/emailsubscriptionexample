package procedural;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ProceduralEmailAddressSubscription {

     private SubscriberInputForm subscriberInputForm;

    public ProceduralEmailAddressSubscription(SubscriberInputForm subscriberInputForm) {
        this.subscriberInputForm = subscriberInputForm;
    }

    public static void main(String[] args) throws IOException {
        Repository subscriberRepository = new SubscriberRepository(new ArrayList<>());
        Overview overview = new SubscriberOverview(System.out);

        SubscriberService subscriberService = new SubscriberService(subscriberRepository, overview);

        SubscriberInputForm subscriberInputForm = new SubscriberInputForm(new BufferedReader(new InputStreamReader(System.in)), System.out, subscriberService);

        new ProceduralEmailAddressSubscription(subscriberInputForm).addSubscribers();
    }

    public void addSubscribers() throws IOException {

        while (true) {
            subscriberInputForm.inputEmailAddress();
        }
    }


}
