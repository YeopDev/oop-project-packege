package pattern.observer;

public class TopicSubscriber implements Observer {
    private String name;
    private Subject topic;

    public TopicSubscriber(String name, Subject topic) {
        this.name = name;
        this.topic = topic;
    }

    @Override
    public void update() { // 3번
        String msg = (String) this.topic.getUpdate(this);
        System.out.println(this.name + ":: got message >> " + msg);
    }
}