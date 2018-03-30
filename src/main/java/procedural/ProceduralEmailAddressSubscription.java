package procedural;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ProceduralEmailAddressSubscription {

    public static void main(String[] args) throws IOException {
        new ProceduralEmailAddressSubscription().addSubscribers(System.out, new BufferedReader(new InputStreamReader(System.in)));
    }

    public void addSubscribers(PrintStream out, BufferedReader bufferedReader) throws IOException {
        List<String> subscribers = new ArrayList<>();

        while (true) {
            //get an email address from the input field
            out.println("Enter email address for new subscriber: ");

            String inputEmailAddress = bufferedReader.readLine();
            EmailAddress emailAddress = EmailAddress.create(inputEmailAddress);

            //Store subscribers in database
            subscribers.add(emailAddress.getEmailAddress());

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


}
