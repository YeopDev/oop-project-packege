package pattern.overloading;

public class OverloadingMain {
    public static void main(String[] args) {
        Person person = new Person();

        person.eat("사과");
        person.eat("사과","딸기");
    }
}
