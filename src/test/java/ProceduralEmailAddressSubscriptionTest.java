import org.junit.Test;

import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ProceduralEmailAddressSubscriptionTest {
    @Test
    public void main() throws Exception {
        ProceduralEmailAddressSubscription.addSubscribers(mock(InputStream.class), mock(PrintStream.class));
    }

}