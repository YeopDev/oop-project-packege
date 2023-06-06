package pattern.singleton;

public class Singleton {
    private static Singleton instance;
    private Dependency dependency;

    private Singleton() {
        dependency = Dependency.getInstance();
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void doSomething() {
        dependency.doSomething();
    }
}