package pattern.strategy;

public class StrategyMain {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item A = new Item("kundolA",100);
        Item B = new Item("kundolB",300);

        cart.addItem(A);
        cart.addItem(B);

        cart.pay(new CreditCard("sang yeop","123456789", "123", "12/01"));

        cart.pay(new Cash(10_000));
    }
}
