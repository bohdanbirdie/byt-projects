package checker;

import obeserver.Subscriber;

public class SimpleSubscriber implements Subscriber {
    @Override
    public void update(String message) {
        System.out.println("I got the message: " + message);
    }
}
