package obeserver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Publisher {
    private List<Subscriber> subscribers = new ArrayList<Subscriber>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubsribe(final Subscriber subscriber) {
        subscribers = subscribers
                .stream()
                .filter(s -> !s.equals(subscriber))
                .collect(Collectors.toList());
    }

    protected void notifySubscribers(String message) {
        subscribers.forEach(s -> s.update(message));
    }

}
