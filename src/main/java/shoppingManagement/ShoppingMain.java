package shoppingManagement;

import shoppingManagement.customer.Customer;
import shoppingManagement.customer.payment.CashPaymentStrategy;
import shoppingManagement.customer.payment.CreditCardPaymentStrategy;
import shoppingManagement.customer.payment.PaymentStrategy;
import shoppingManagement.order.Order;
import shoppingManagement.product.Product;
import shoppingManagement.product.ProductQuantity;

import java.util.List;
import java.util.Scanner;

public class ShoppingMain {
    private final static Scanner sc = new Scanner(System.in);
    private final static String REGEX = "(o|q|order|quit)";

    public static void main(String[] args) {
        List<ProductQuantity> productQuantities = List.of(
                new ProductQuantity(new Product(0L, "상품1", 1000), 2),
                new ProductQuantity(new Product(1L, "상품2", 2000), 2),
                new ProductQuantity(new Product(2L, "상품3", 3000), 3),
                new ProductQuantity(new Product(3L, "상품3", 3000), 3),
                new ProductQuantity(new Product(4L, "상품3", 3000), 3)
        );

        Order order = new Order(productQuantities);

        PaymentStrategy paymentStrategy = new CashPaymentStrategy(100_000);
        Customer customer = new Customer("yeop", paymentStrategy);

        while (true) {
            System.out.print("입력(o[order]: 주문, q[quit]: 종료) :");
            String target = sc.nextLine().toLowerCase();

            if (!target.matches(REGEX)) {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                continue;
            }

            if (List.of("q", "quit").contains(target)) {
                System.out.println("고객님의 주문 감사합니다.");
                break;
            }

            System.out.println("상품 목록:");
            for (ProductQuantity productQuantity : productQuantities) {
                System.out.println(productQuantity.product().id() + "-" + productQuantity.product().name() + " - " + productQuantity.product().price() + "원" + " - " + productQuantity.quantity() + "개");
            }


            while (true) {
                System.out.print("상품번호:");
                String id = sc.nextLine();
                System.out.print("상품수량:");
                String quantity = sc.nextLine();

                if (id.isBlank() && quantity.isBlank()) {
                    break;
                }

                Product product = productQuantities.stream()
                        .map(ProductQuantity::product)
                        .filter(item -> item.hasProduct(Long.parseLong(id)))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("상품 번호가 잘못되었습니다."));

                customer.addToCart(product, Integer.parseInt(quantity));
            }

            System.out.println("""
                    결제 방식을 선택하세요.
                    1. 현금 결제(default)
                    2. 신용카드 결제""");

            String fix = sc.nextLine();
            if (fix.equals("2")) {
                customer.setPaymentStrategy(new CreditCardPaymentStrategy("1234567890", "12/25", "123"));
            }

            order.placeOrder(customer);
            productQuantities = order.update(customer);
        }
    }
}
