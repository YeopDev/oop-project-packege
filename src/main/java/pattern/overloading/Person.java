package pattern.overloading;

public class Person {

    public void eat(String fruit){
        System.out.println("I eat "+ fruit);
    }

    public void eat(String fruit, String vegetable){
        System.out.println("I eat "+ fruit + " and " + vegetable);
    }
}
