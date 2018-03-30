package procedural;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class ProceduralEmailAddressSubscription {

    public final PrintStream out;
    public final BufferedReader in;
    public SubscriberRepository subscriberRepository;
    private AddSubscriberForm addSubscriberForm;

    public ProceduralEmailAddressSubscription(PrintStream out, BufferedReader in) {
        this.out = out;
        this.in = in;
        subscriberRepository = new SubscriberRepository(new ArrayList<>());
        addSubscriberForm = new AddSubscriberForm(in, out, subscriberRepository);
    }

    public static void main(String[] args) throws IOException {
        new ProceduralEmailAddressSubscription(System.out, new BufferedReader(new InputStreamReader(System.in))).addSubscribers();
    }

    public void addSubscribers() throws IOException {

        while (true) {
            addSubscriberForm.inputEmailAddress();
        }
    }


}
