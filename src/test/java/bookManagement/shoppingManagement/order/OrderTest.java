package bookManagement.shoppingManagement.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import shoppingManagement.cart.Cart;
import shoppingManagement.customer.Customer;
import shoppingManagement.customer.payment.CashPaymentStrategy;
import shoppingManagement.customer.payment.CreditCardPaymentStrategy;
import shoppingManagement.order.Order;
import shoppingManagement.product.Product;
import shoppingManagement.product.ProductQuantity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class OrderTest {

    static Stream<Arguments> generateDataNoThrownBy() {
        return Stream.of(
                Arguments.of(Arrays.asList(new ProductQuantity(new Product(0L, "상품1", 1000), 2),
                                new ProductQuantity(new Product(1L, "상품2", 2000), 2),
                                new ProductQuantity(new Product(2L, "상품3", 3000), 3),
                                new ProductQuantity(new Product(3L, "상품3", 3000), 3),
                                new ProductQuantity(new Product(4L, "상품3", 3000), 3)
                        )
                )
        );
    }

    static Stream<Arguments> generateDataThrownBy() {
        return Stream.of(
                Arguments.of(new ArrayList<>())
        );
    }

    @ParameterizedTest
    @MethodSource("generateDataNoThrownBy")
    @DisplayName("생성자에 정상적인 값이 들어왔을 경우")
    void constructorNoThrownBy(List<ProductQuantity> productQuantityList) {
        Assertions.assertThatCode(
                () -> new Order(productQuantityList)
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("generateDataThrownBy")
    @DisplayName("생성자에 정상적인 값이 들어오지 않았을 경우")
    void constructorThrownBy(List<ProductQuantity> productQuantities) {
        Assertions.assertThatThrownBy(
                () -> new Order(productQuantities)
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("리스트가 비어있습니다.");
    }

    @ParameterizedTest
    @MethodSource("generateDataNoThrownBy")
    @DisplayName("주문하기 메소드 정상동작")
    void placeOrderNoThrownBy(List<ProductQuantity> productQuantities) {
        Assertions.assertThatCode(
                () -> {
                    Order order = new Order(productQuantities);
                    Customer customer = new Customer("yeop", new CreditCardPaymentStrategy("1234567890", "12/25", "123"));
                    customer.addToCart(new Product(0L,"상품1", 1000), 1);
                    customer.addToCart(new Product(1L,"상품2", 2000), 1);
                    customer.setPaymentStrategy(new CashPaymentStrategy(10_000));
                    order.placeOrder(customer);
                    List<ProductQuantity> updateList = order.update(customer);
                    Assertions.assertThat(updateList.get(0).quantity()).isEqualTo(1);
                    Assertions.assertThat(updateList.get(1).quantity()).isEqualTo(1);
                }
        ).doesNotThrowAnyException();
    }
}