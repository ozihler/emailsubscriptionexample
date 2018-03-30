import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ProceduralEmailAddressSubscription {
    private static final Pattern EMAIL_ADDRESS_VALID_FORM = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");

    public static void main(String[] args) throws IOException {
        addSubscribers(System.out, new BufferedReader(new InputStreamReader(System.in)));
    }

    static void addSubscribers(PrintStream out, BufferedReader bufferedReader) throws IOException {
        List<String> subscribers = new ArrayList<>();

        while (true) {
            //get an email address from the input field
            out.println("Enter email address for new subscriber: ");
            String emailAdress = bufferedReader.readLine();

            //validate the input
            if (!(!StringUtils.isBlank(emailAdress) && EMAIL_ADDRESS_VALID_FORM.matcher(emailAdress).matches())) {
                out.println("Not an email address: " + emailAdress);
                out.println("Program terminated");
                return;
            }

            //Store subscribers in database
            subscribers.add(emailAdress);

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
