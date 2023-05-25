package bookManagement.Library.Book;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BookStockQuantityTest {
    @ParameterizedTest
    @ValueSource(
            ints = {1,2}
    )
    @DisplayName("생성자가 올바른 값을 할당 받았을 경우")
    void constructorNoThrownBy(int stockQuantity) {
        Assertions.assertThatCode(
                () -> new BookStockQuantity(new Book(0L, "객체지향의 사실과 오해", "human1", "위키북스", 25_000), stockQuantity)
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(
            ints = {-1}
    )
    @DisplayName("생성자가 올바르지 않은 값을 할당 받았을 경우")
    void constructorThrownBy(int stockQuantity) {
        Assertions.assertThatThrownBy(
                () -> new BookStockQuantity(new Book(0L, "객체지향의 사실과 오해", "human1", "위키북스", 25_000), stockQuantity)
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("재고수량에 올바르지 않은 값이 할당 되었습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1})
    @DisplayName("decreaseStockQuantity 메서드 테스트")
    void decreaseStockQuantityNoThrownBy(int stockQuantity){
        Assertions.assertThatCode(
                () -> {
                    BookStockQuantity bookStockQuantity = new BookStockQuantity(new Book(0L, "객체지향의 사실과 오해", "human1", "위키북스", 25_000), stockQuantity);
                    BookStockQuantity decrease = bookStockQuantity.decreaseStockQuantity();
                    Assertions.assertThat(decrease.stockQuantity()).isEqualTo(0);
                }
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {1})
    @DisplayName("increaseStockQuantity 메서드 테스트")
    void increaseStockQuantityNoThrownBy(int stockQuantity){
        Assertions.assertThatCode(
                () -> {
                    BookStockQuantity bookStockQuantity = new BookStockQuantity(new Book(0L, "객체지향의 사실과 오해", "human1", "위키북스", 25_000), stockQuantity);
                    BookStockQuantity decrease = bookStockQuantity.increaseStockQuantity();
                    Assertions.assertThat(decrease.stockQuantity()).isEqualTo(2);
                }
        ).doesNotThrowAnyException();
    }
}