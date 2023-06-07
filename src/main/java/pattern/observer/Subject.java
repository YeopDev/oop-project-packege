package pattern.observer;

public interface Subject {
    void register(Observer obj);
    void unregister(Observer obj);
    void notifyObserverList();
    Object getUpdate(Observer obj);
}