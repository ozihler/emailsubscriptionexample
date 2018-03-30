package procedural;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class AddSubscriberForm {
    private final BufferedReader in;
    private final PrintStream out;
    private final SubscriberRepository subscriberRepository;

    public AddSubscriberForm(BufferedReader in, PrintStream out, SubscriberRepository subscriberRepository) {
        this.in = in;
        this.out = out;
        this.subscriberRepository = subscriberRepository;
    }

    public void inputEmailAddress() throws IOException {
        //get an email address from the input field
        out.println("Enter email address for new subscriber: ");

        String inputEmailAddress = in.readLine();

        subscriberRepository.store(inputEmailAddress);

        //Show subscribers in overview
        String output = "All subscribers:" +
                "\n================================\n";
        for (EmailAddress subscriber : subscriberRepository.getSubscribers()) {
            output += subscriber.getEmailAddress() + "\n";
        }
        output += "================================";
        out.println(output);
    }
}
