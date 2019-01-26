import checker.Checker;
import checker.SimpleSubscriber;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static com.sun.webkit.network.URLs.newURL;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;

public class CheckerTest {

    @Test
    public void connectionHandle() throws IOException {
        // On, cmon, it will take to much effort to the the URL and URLConnection
        // I'll just show that I know how to use mocks, spy's, fakes and etc. Simple example
        SimpleSubscriber simpleSubscriber = mock(SimpleSubscriber.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Checker checker = new Checker(newURL("http://www.pja.edu.pl/"));
        checker.subscribe(simpleSubscriber);

        long date = 1548463283;
        Date d = new Date(date);
        checker.handleNewDate(date);
        verify(simpleSubscriber, timeout(1)).update(argument.capture());

        assertEquals("http://www.pja.edu.pl/ was updated " + d.toString(), argument.getValue());
    }
}
