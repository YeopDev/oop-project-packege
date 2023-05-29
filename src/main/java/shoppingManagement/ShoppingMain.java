package shoppingManagement;

import shoppingManagement.cart.Cart;
import shoppingManagement.customer.Customer;
import shoppingManagement.customer.payment.CashPaymentStrategy;
import shoppingManagement.customer.payment.CreditCardPaymentStrategy;
import shoppingManagement.order.Order;
import shoppingManagement.product.Product;
import shoppingManagement.product.ProductQuantity;

import java.util.List;
import java.util.Scanner;

public class ShoppingMain {
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<ProductQuantity> productQuantities = List.of(
                new ProductQuantity(new Product(0L,"상품1",10000),2),
                new ProductQuantity(new Product(1L,"상품2",20000),1),
                new ProductQuantity(new Product(2L,"상품3",30000),3),
                new ProductQuantity(new Product(3L,"상품4",40000),1),
                new ProductQuantity(new Product(4L,"상품5",50000),1)
        );

        Order order = new Order(productQuantities);

        System.out.println("상품 목록:");
        productQuantities.forEach(item ->
                System.out.println(item.product().id() + "-" + item.product().name() + " - " + item.product().price() + "원" + " - " + item.quantity() + "개")
        );

        Cart cart = new Cart();
        while(true){
            System.out.println("상품번호를 선택해 주세요.");
            Long id = sc.nextLong();
            System.out.println("상품수량을 선택해 주세요.");
            int quantity = sc.nextInt();

            Product product = productQuantities.stream()
                    .map(ProductQuantity::product)
                    .filter(item -> item.hasProduct(id))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("상품 번호가 잘못되었습니다."));
            cart.addProduct(product,quantity);

            System.out.println("장바구니에 상품을 더 담으겠습니까?(Y/N)");
            sc.nextLine();
            if(sc.nextLine().equalsIgnoreCase("N")){
                break;
            }
        }

        Customer customer = new Customer("yeop",100_000);
        customer.setPaymentStrategy(new CashPaymentStrategy(100_000));

        System.out.println("""
        결제 방식을 선택하세요.
        1. 현금 결제(default)
        2. 신용카드 결제
        """);
        if(sc.nextInt() == 2) {
            customer.setPaymentStrategy(new CreditCardPaymentStrategy("1234567890", "12/25", "123"));
        }

        System.out.println("주문을 진행합니다.");
        order.placeOrder(customer,cart);
    }
}
