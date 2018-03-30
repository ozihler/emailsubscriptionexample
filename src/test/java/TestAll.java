import newsletter.domain.EmailAddress;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAll {
    @Test
    public void testAll() throws RuntimeException {
        String[] emailAddresses = {
                "oliver.zihler@hotmail.com",
                "hans@x.y"
        };

        for (String emailAddress : emailAddresses) {
            assertEquals(EmailAddress.create(emailAddress).formatted(), emailAddress);
        }
    }

    @Test(expected = RuntimeException.class)
    public void testFail() throws RuntimeException {
        String[] emailAddresses = {
                "oliver.@hotmail.com",
                "oliver.hotmail.co@m",
                "hans x.y"
        };

        for (String emailAddress : emailAddresses) {
            EmailAddress.create(emailAddress);
        }
    }
}
