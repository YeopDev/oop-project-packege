package shoppingManagement.customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import shoppingManagement.customer.Customer;
import shoppingManagement.customer.payment.CashPaymentStrategy;

class CustomerTest {
    @ParameterizedTest
    @CsvSource(value = {"yeop"}, delimiter = ':')
    @DisplayName("생성자에 정상적인 값이 들어왔을 경우")
    void constructorNoThrownBy(String name) {
        Assertions.assertThatCode(
                () -> new Customer(name, new CashPaymentStrategy(10_000))
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings ={" "})
    @DisplayName("생성자에 정상적인 값이 들어오지 않았을 경우")
    void constructorThrownBy(String name) {
        Assertions.assertThatThrownBy(
                () -> new Customer(name, new CashPaymentStrategy(10_000))
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("이름이 비어있을 수 없습니다.");
    }
}