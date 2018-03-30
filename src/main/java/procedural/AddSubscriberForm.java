package procedural;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class AddSubscriberForm {
    private final BufferedReader in;
    private final PrintStream out;
    private final SubscriberRepository subscriberRepository;
    private SubscriberOverview subscriberOverview;

    public AddSubscriberForm(BufferedReader in, PrintStream out, SubscriberRepository subscriberRepository, SubscriberOverview subscriberOverview) {
        this.in = in;
        this.out = out;
        this.subscriberRepository = subscriberRepository;
        this.subscriberOverview = subscriberOverview;
    }

    public void inputEmailAddress() throws IOException {
        //get an email address from the input field
        out.println("Enter email address for new subscriber: ");

        String inputEmailAddress = in.readLine();

        subscriberRepository.store(inputEmailAddress);

        //Show subscribers in overview
        subscriberOverview.updateOverview(subscriberRepository.getSubscribers());
    }
}
