package procedural;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        EmailAddressSubscription emailAddressSubscription = new EmailAddressSubscription(System.out, new BufferedReader(new InputStreamReader(System.in)), new ArrayList<>());

        while (true) {
            try {
                emailAddressSubscription.addSubscribers();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }
}
