package procedural;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class AddSubscriberForm {
    private final BufferedReader in;
    private PrintStream out;
    private SubscriberService subscriberService;

    public AddSubscriberForm(BufferedReader in, PrintStream out, SubscriberService subscriberService) {
        this.in = in;
        this.out = out;
        this.subscriberService = subscriberService;
    }

    public void inputEmailAddress() throws IOException {
        //get an email address from the input field
        out.println("Enter email address for new subscriber: ");

        String inputEmailAddress = in.readLine();

        subscriberService.store(inputEmailAddress);

        subscriberService.updateOverview();
    }

}
