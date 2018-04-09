import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import procedural.EmailAddressSubscription;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class Tests {

    public static final String VALID_EMAIL_ADDRESS = "oliver.zihler@hotmail.com";
    public static final String VALID_EMAIL_ADDRESS_2 = "o.a@h.c";
    public static final String INVALID_EMAIL_ADDRESS = "o@z.d.";


    @Test
    public void testValidEmailAddresses() throws Exception {
        BufferedReader inputMock = mock(BufferedReader.class);
        when(inputMock.readLine())
                .thenReturn(VALID_EMAIL_ADDRESS)
                .thenReturn(VALID_EMAIL_ADDRESS_2)
                .thenReturn(INVALID_EMAIL_ADDRESS);

        PrintStream out = mock(PrintStream.class);
        try {
            new EmailAddressSubscription(out, inputMock, new ArrayList<String>()).addSubscribers();
        } catch (RuntimeException e) {

            verify(out, times(3)).println("Enter email address for new subscriber: ");
            verify(out, times(1)).println("All subscribers:\n" +
                    "================================\n" +
                    VALID_EMAIL_ADDRESS + "\n" +
                    "================================");
            verify(out, times(1)).println("All subscribers:\n" +
                    "================================\n" +
                    VALID_EMAIL_ADDRESS + "\n" +
                    VALID_EMAIL_ADDRESS_2 + "\n" +
                    "================================");
            assertEquals(e.getMessage(), "Not an email address: " + INVALID_EMAIL_ADDRESS + "\nProgram terminated");
        }
    }

    @Test(expected = RuntimeException.class)
    public void testEmptyEmailAddress() throws IOException {
        BufferedReader inputMock = mock(BufferedReader.class);
        when(inputMock.readLine())
                .thenReturn(StringUtils.EMPTY);

        PrintStream out = mock(PrintStream.class);

        new EmailAddressSubscription(out, inputMock, new ArrayList<String>()).addSubscribers();

        verify(out, times(1)).println("Enter email address for new subscriber: ");
        verify(out, times(1)).println("Not an email address: " + StringUtils.EMPTY);
        verify(out, times(1)).println("Program terminated");
    }

    @Test(expected = RuntimeException.class)
    public void testWhiteSpaceEmailAddress() throws IOException {
        BufferedReader inputMock = mock(BufferedReader.class);
        when(inputMock.readLine())
                .thenReturn(StringUtils.SPACE);

        PrintStream out = mock(PrintStream.class);

        new EmailAddressSubscription(out, inputMock, new ArrayList<String>()).addSubscribers();

        verify(out, times(1)).println("Enter email address for new subscriber: ");
        verify(out, times(1)).println("Not an email address: " + StringUtils.SPACE);
        verify(out, times(1)).println("Program terminated");
    }

    @Test(expected = RuntimeException.class)
    public void testNullEmailAddress() throws IOException {
        BufferedReader inputMock = mock(BufferedReader.class);
        when(inputMock.readLine())
                .thenReturn(null);

        PrintStream out = mock(PrintStream.class);

        new EmailAddressSubscription(out, inputMock, new ArrayList<String>()).addSubscribers();

        verify(out, times(1)).println("Enter email address for new subscriber: ");
        verify(out, times(1)).println("Not an email address: " + null);
        verify(out, times(1)).println("Program terminated");
    }

}