package pattern.factory;

public class CoffeeFactory {
    public Coffee getCoffee(String type, int price) {
        if ("Latte".equalsIgnoreCase(type)) {
            return new Latte(price);
        }
        return new Americano(price);
    }
}
