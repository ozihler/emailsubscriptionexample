package procedural;

import java.io.PrintStream;
import java.util.ArrayList;

public class SubscriberOverview {
    private PrintStream out;

    public SubscriberOverview(PrintStream out) {
        this.out = out;
    }

    public void updateOverview(ArrayList<EmailAddress> subscribers) {
        //Show subscribers in overview
        String output = "All subscribers:" +
                "\n================================\n";
        for (EmailAddress subscriber : subscribers) {
            output += subscriber.getEmailAddress() + "\n";
        }
        output += "================================";
        this.out.println(output);
    }
}
