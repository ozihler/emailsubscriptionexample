package newsletter.infrastructure.presentation;

import newsletter.domain.EmailAddress;
import newsletter.services.SubscriberService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class SubscriberInputForm {
    private final SubscriberService service;
    private final BufferedReader formInput;
    private final PrintStream formTitle;

    public SubscriberInputForm(SubscriberService service, BufferedReader formInput, PrintStream formTitle) {
        this.service = service;
        this.formInput = formInput;
        this.formTitle = formTitle;
    }

    public void captureUserInput() throws IOException {
        showTitle();
        EmailAddress emailAddress = captureInput();
        service.store(emailAddress);
        service.updateGui();
    }

    private void showTitle() {
        formTitle.println("Enter email address for new subscriber: ");
    }

    private EmailAddress captureInput() throws IOException {
        return EmailAddress.create(formInput.readLine());
    }

}
