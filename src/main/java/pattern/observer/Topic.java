package pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Topic implements Subject {
    private List<Observer> observerList;
    private String message;

    public Topic() {
        this.observerList = new ArrayList<>();
        this.message = "";
    }

    @Override
    public void register(Observer obj) {
        if (!observerList.contains(obj)) { // 토픽이 같지 않은 것만 add
            observerList.add(obj);
        }
    }

    @Override
    public void unregister(Observer obj) {
        observerList.remove(obj);
    }

    @Override
    public void notifyObserverList() { // 2번 들어온 토픽값들을 뿌려줌
        this.observerList.forEach(Observer::update);
    }

    @Override
    public Object getUpdate(Observer obj) { //4번
        return this.message;
    }

    public void postMessage(String msg) { // 1번
        System.out.println("토픽 메시지 보내기: " + msg);
        this.message = msg;
        notifyObserverList();
    }
}