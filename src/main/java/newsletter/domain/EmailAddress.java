package newsletter.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class EmailAddress {
    private static final Pattern EMAIL_ADDRESS_VALID_FORM = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    private final String emailAddress;

    private EmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String formatted() {
        return emailAddress;
    }

    public static EmailAddress create(String emailAddress) {
        if (!isValid(emailAddress)) {
            throw new RuntimeException("Invalid Emailaddress");
        }
        return new EmailAddress(emailAddress);
    }

    private static boolean isValid(String emailAddress) {
        return !isBlank(emailAddress) && correspondsToStandard(emailAddress);
    }

    private static boolean correspondsToStandard(String emailAddressData) {
        return EMAIL_ADDRESS_VALID_FORM.matcher(emailAddressData).matches();
    }

    private static boolean isBlank(String emailAddressData) {
        return StringUtils.isBlank(emailAddressData);
    }
}
