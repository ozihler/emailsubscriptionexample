package procedural;

import org.apache.commons.lang3.StringUtils;

public class EmailAddress {
    private String emailAddress;

    public EmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public static EmailAddress create(String emailAddress) {
        if (!isValid(emailAddress)) {
            throw new RuntimeException("Not an email address: " + emailAddress + "\nProgram terminated");
        }
        return new EmailAddress(emailAddress);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public static boolean isValid(String emailAddress) {
        return !StringUtils.isBlank(emailAddress) && ProceduralEmailAddressSubscription.EMAIL_ADDRESS_VALID_FORM.matcher(emailAddress).matches();
    }
}
