package procedural;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.regex.Pattern;

public class EmailAddressSubscription {
    private static final Pattern EMAIL_ADDRESS_VALID_FORM = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");

    private final PrintStream out;
    private final BufferedReader in;
    private List<String> subscribers;

    public EmailAddressSubscription(PrintStream out, BufferedReader in, List<String> subscribers) {
        this.out = out;
        this.in = in;
        this.subscribers = subscribers;
    }

    public void addSubscribers() throws IOException {
        //get an email address from the input field
        out.println("Enter email address for new subscriber: ");
        String emailAddress = in.readLine();
        //validate the input
        if (!(!StringUtils.isBlank(emailAddress) && EMAIL_ADDRESS_VALID_FORM.matcher(emailAddress).matches())) {
            throw new RuntimeException("Not an email address: " + emailAddress + "\nProgram terminated");
        }

        //Store subscribers in database
        subscribers.add(emailAddress);

        //Show subscribers in overview
        String output = "All subscribers:" +
                "\n================================\n";
        for (String subscriber : subscribers) {
            output += subscriber + "\n";
        }
        output += "================================";
        out.println(output);
    }


}
