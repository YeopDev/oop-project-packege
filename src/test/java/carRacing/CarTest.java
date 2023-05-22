package carRacing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"람보르기니:0"}, delimiter = ':')
    @DisplayName("생성자에 올바른 값이 들어왔을 경우")
    void carConstructorNoThrownBy(String name, int distance) {
        Assertions.assertThatCode(
                () -> new Car(name, distance)
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource(value = {":0"}, delimiter = ':')
    @DisplayName("생성자에 올바르지 않은 값이 들어왔을 경우")
    void carConstructorThrownBy(String name, int distance) {
        Assertions.assertThatThrownBy(
                () -> new Car(name, distance)
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 이름값이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("자동차가 움직이는 메소드 검증(랜덤값 검증: 더블테스트어블)")
    void moveMethodNoThrownBy() {
        Car car = new Car("gunim", 0, () -> true);

        car.move();

        assertThat(car.distance()).isEqualTo(1);
    }

}