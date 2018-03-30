package newsletter.infrastructure.presentation;

import newsletter.domain.EmailAddress;
import newsletter.services.SubscriberOverview;

import java.io.PrintStream;
import java.util.List;

// "Speculative Generality Smell"
public class SubscriberOverviewTable implements SubscriberOverview {
    private final PrintStream table;

    public SubscriberOverviewTable(PrintStream table) {
        this.table = table;
    }

    @Override
    public void update(List<EmailAddress> subscribers) {
        table.println("All subscribers: ");
        table.println("================================");
        subscribers.stream()
                .map(EmailAddress::formatted)
                .forEach(table::println);
        table.println("================================");
    }


}
