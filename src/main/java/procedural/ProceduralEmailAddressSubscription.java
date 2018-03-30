package procedural;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class ProceduralEmailAddressSubscription {

    private final PrintStream out;
    private final BufferedReader in;

    public ProceduralEmailAddressSubscription(PrintStream out, BufferedReader in) {
        this.out = out;
        this.in = in;
    }

    public static void main(String[] args) throws IOException {
        new ProceduralEmailAddressSubscription(System.out, new BufferedReader(new InputStreamReader(System.in))).addSubscribers();
    }

    public void addSubscribers() throws IOException {
        ArrayList<EmailAddress> subscribers = new ArrayList<>();

        while (true) {
            //get an email address from the input field
            out.println("Enter email address for new subscriber: ");

            String inputEmailAddress = in.readLine();

            //Store subscribers in database
            subscribers.add(EmailAddress.create(inputEmailAddress));

            //Show subscribers in overview
            String output = "All subscribers:" +
                    "\n================================\n";
            for (EmailAddress subscriber : subscribers) {
                output += subscriber.getEmailAddress() + "\n";
            }
            output += "================================";
            out.println(output);
        }
    }


}
