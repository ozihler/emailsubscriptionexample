package procedural;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class AddSubscriberForm {
    private final BufferedReader in;
    private PrintStream out;
    private SubscriberOverview subscriberOverview;
    private SubscriberService subscriberService;

    public AddSubscriberForm(BufferedReader in, PrintStream out, SubscriberOverview subscriberOverview, SubscriberService subscriberService) {
        this.in = in;
        this.out = out;
        this.subscriberOverview = subscriberOverview;
        this.subscriberService = subscriberService;
    }

    public void inputEmailAddress() throws IOException {
        //get an email address from the input field
        out.println("Enter email address for new subscriber: ");

        String inputEmailAddress = in.readLine();

        subscriberService.store(inputEmailAddress);

        subscriberOverview.updateOverview(subscriberService.getSubscribers());
    }

}
