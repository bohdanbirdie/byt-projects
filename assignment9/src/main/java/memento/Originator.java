package memento;

public interface Originator<T> {
    T makeSnapshot();
    void restore(T snapshot);
}
