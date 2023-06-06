package shoppingManagement.customer;

import shoppingManagement.cart.Cart;
import shoppingManagement.customer.payment.PaymentStrategy;
import shoppingManagement.product.Product;
import shoppingManagement.product.ProductQuantity;

import static java.util.Objects.isNull;

public class Customer {
    private final String name;
    private PaymentStrategy paymentStrategy;
    private final Cart cart;

    public Customer(String name, PaymentStrategy paymentStrategy) {
        validate(name);
        this.name = name;
        this.paymentStrategy = paymentStrategy;
        this.cart = new Cart();
    }

    public Cart cart() {
        return cart;
    }

    public void addToCart(Product product, int quantity) {
        cart.addProduct(new ProductQuantity(product, quantity));
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void purchaseProduct(int amount) {
        this.paymentStrategy.payments(amount);
    }

    private void validate(String name) {
        if (isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("이름이 비어있을 수 없습니다.");
        }
    }
}
