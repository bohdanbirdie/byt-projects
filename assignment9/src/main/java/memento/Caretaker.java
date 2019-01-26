package memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker<T> {
    private Originator<T> originator;
    private List<T> history = new ArrayList<>();

    public Caretaker(Originator<T> originator) {
        this.originator = originator;
    }

    public void undo() {
        if (history != null && history.size() > 1) {
            history.remove(history.size() - 1);
        }
        originator.restore(history.get(history.size() - 1));
    }

    public void makeBackup() {
        history.add(originator.makeSnapshot());
    }
}
