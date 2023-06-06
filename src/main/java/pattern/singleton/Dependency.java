package pattern.singleton;

public class Dependency {
    private static Dependency instance;

    private Dependency() {

    }

    public static Dependency getInstance() {
        if (instance == null) {
            instance = new Dependency();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Dependency is doing something.");
    }
}