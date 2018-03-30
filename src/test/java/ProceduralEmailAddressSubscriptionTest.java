import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ProceduralEmailAddressSubscriptionTest {

    public static final String VALID_EMAIL_ADDRESS = "oliver.zihler@hotmail.com";
    public static final String STOP_COMMAND = "stop";
    public static final String VALID_EMAIL_ADDRESS_2 = "o.a@h.c";


    @Test
    public void main() throws Exception {


        BufferedReader inputMock = mock(BufferedReader.class);
        when(inputMock.readLine()).thenReturn(VALID_EMAIL_ADDRESS)
                .thenReturn(VALID_EMAIL_ADDRESS_2)
                .thenReturn(STOP_COMMAND);

        PrintStream out = mock(PrintStream.class);
        ProceduralEmailAddressSubscription.addSubscribers(out, inputMock);

        verify(out, times(3)).println("Enter email address for new subscriber: ");
        verify(out, times(1)).println("All subscribers:\n" +
                "================================\n" +
                VALID_EMAIL_ADDRESS+"\n" +
                "================================");
        verify(out, times(1)).println("All subscribers:\n" +
                "================================\n" +
                VALID_EMAIL_ADDRESS+"\n" +
                VALID_EMAIL_ADDRESS_2+"\n" +
                "================================");
        verify(out, times(1)).println("Not an email address: "+STOP_COMMAND);
        verify(out, times(1)).println("Program terminated");

    }

}