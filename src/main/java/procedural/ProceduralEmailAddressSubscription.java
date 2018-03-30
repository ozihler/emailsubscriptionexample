package procedural;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class ProceduralEmailAddressSubscription {

    private final PrintStream out;
    private final BufferedReader in;
    private SubscriberRepository subscriberRepository;

    public ProceduralEmailAddressSubscription(PrintStream out, BufferedReader in) {
        this.out = out;
        this.in = in;
        subscriberRepository = new SubscriberRepository(new ArrayList<>());
    }

    public static void main(String[] args) throws IOException {
        new ProceduralEmailAddressSubscription(System.out, new BufferedReader(new InputStreamReader(System.in))).addSubscribers();
    }

    public void addSubscribers() throws IOException {

        while (true) {
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


}
