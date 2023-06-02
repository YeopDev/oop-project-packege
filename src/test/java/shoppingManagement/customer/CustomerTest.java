package shoppingManagement.customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CustomerTest {

    @ParameterizedTest
    @CsvSource(value = {"yeop:10_000"}, delimiter = ':')
    @DisplayName("생성자에 정상적인 값이 들어왔을 경우")
    void constructorNoThrownBy(String name, int money) {
        Assertions.assertThatCode(
                () -> new Customer(name, money)
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource(value = {"yeop:-1"}, delimiter = ':')
    @DisplayName("생성자에 정상적인 값이 들어오지 않았을 경우")
    void constructorThrownBy(String name, int money) {
        Assertions.assertThatThrownBy(
                () -> new Customer(name, money)
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("소지금은 0보다 작을 수 없습니다.");
    }
}