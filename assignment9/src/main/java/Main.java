import checker.Checker;
import checker.SimpleSubscriber;

import java.io.IOException;
import java.net.URL;

import static com.sun.webkit.network.URLs.newURL;

public class Main {
    public static void main(String[] args) throws IOException {
        URL address = newURL("http://www.pja.edu.pl/");
        Checker checker = new Checker(address);
        SimpleSubscriber simpleSubscriber = new SimpleSubscriber();
        checker.subscribe(simpleSubscriber);
        checker.run();
    }
}
