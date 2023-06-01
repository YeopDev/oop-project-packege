package shoppingManagement.customer;

import shoppingManagement.cart.Cart;
import shoppingManagement.customer.payment.PaymentStrategy;
import shoppingManagement.product.Product;
import shoppingManagement.product.ProductQuantity;

import static java.util.Objects.isNull;

public class Customer {
    private final String name;//이름
    private final int money;//소지금
    private PaymentStrategy paymentStrategy; // 결제방법 및 결제진행

    private final Cart cart;

    public Customer(String name, int money) {
        validate(name, money);
        this.name = name;
        this.money = money;
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

    private void validate(String name, int money) {
        if (isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("이름이 비어있거나 스페이스바가 포함되어있습니다.");
        }
        if (money < 0) {
            throw new IllegalArgumentException("소지금은 0보다 작을 수 없습니다.");
        }
    }
}
