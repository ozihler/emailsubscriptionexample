import newsletter.infrastructure.dataaccess.ListSubscriberRepository;
import newsletter.infrastructure.presentation.SubscriberOverviewTable;
import newsletter.infrastructure.presentation.SubscriberInputForm;
import newsletter.services.SubscriberOverview;
import newsletter.services.SubscriberRepository;
import newsletter.services.SubscriberService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws IOException {
        SubscriberOverview overview = new SubscriberOverviewTable(table());
        SubscriberRepository repository = new ListSubscriberRepository();

        SubscriberService service = new SubscriberService(overview, repository);

        SubscriberInputForm subscriberInputForm = new SubscriberInputForm(service, formInput(), formTitle());


        while (true) {
            try {
                subscriberInputForm.captureUserInput();
            } catch (Exception e) {
                endSession(e.getMessage());
            }
        }
    }

    private static void endSession(String message) {
        System.out.println(message);
        System.exit(-1);
    }

    private static BufferedReader formInput() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static PrintStream formTitle() {
        return System.out;
    }

    private static PrintStream table() {
        return System.out;
    }


}
