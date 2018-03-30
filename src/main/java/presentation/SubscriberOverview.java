package presentation;

import domain.EmailAddress;
import services.Overview;

import java.io.PrintStream;
import java.util.ArrayList;

public class SubscriberOverview implements Overview {
    private PrintStream out;

    public SubscriberOverview(PrintStream out) {
        this.out = out;
    }

    @Override
    public void update(ArrayList<EmailAddress> subscribers) {
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
