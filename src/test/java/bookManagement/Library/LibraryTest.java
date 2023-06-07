package bookManagement.Library;

import bookManagement.Library.Book.Book;
import bookManagement.Library.Book.BookStockQuantity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LibraryTest {
    @ParameterizedTest
    @MethodSource("generateDataNoThrownBy")
    @DisplayName("생성자에 올바른 값이 들어왔을 경우")
    void constructorNoThrownBy(List<BookStockQuantity> bookStockQuantities) {
        assertThatCode(
                () -> new Library(bookStockQuantities)
        ).doesNotThrowAnyException();
    }

    static Stream<Arguments> generateDataNoThrownBy() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(new BookStockQuantity(new Book(0L, "객체지향의 사실과 오해", "human1", "위키북스", 25_000), 1),
                                new BookStockQuantity(new Book(1L, "객체지향", "human1", "위키북스", 30_000), 1),
                                new BookStockQuantity(new Book(2L, "혼자 공부하는 운영체제", "human1", "위키북스", 50_000), 1),
                                new BookStockQuantity(new Book(3L, "혼자 공부하는 네트워크", "human1", "위키북스", 50_000), 1),
                                new BookStockQuantity(new Book(4L, "엘레강트 오브젝트", "human1", "위키북스", 60_000), 1)
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("generateDataThrownBy")
    @DisplayName("생성자에 올바르지 않은 값이 들어왔을 경우")
    void constructorThrownBy(List<BookStockQuantity> bookStockQuantities) {
        assertThatThrownBy(
                () -> new Library(bookStockQuantities)
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("리스트가 비어있습니다.");
    }

    static Stream<Arguments> generateDataThrownBy() {
        return Stream.of(
                Arguments.of(new ArrayList<>())
        );
    }

    @ParameterizedTest
    @MethodSource("generateDataNoThrownBy")
    @DisplayName("isChecked 메서드 테스트")
    void LibraryIsChecked(List<BookStockQuantity> bookStockQuantities) {
        assertThatCode(
                () -> {
                    List<Long> ids = List.of(0L, 1L, 2L);
                    Library library = new Library(bookStockQuantities);
                    assertThat(library.isChecked(ids)).isTrue();
                }
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("generateDataNoThrownBy")
    @DisplayName("borrowedBooks 메서드 테스트")
    void LibraryBorrowedBooks(List<BookStockQuantity> bookStockQuantities){
        assertThatCode(
                () -> {
                    List<Long> ids = List.of(0L, 1L, 2L);
                    Library library = new Library(bookStockQuantities);
                    library.setStrategy(new BorrowedBooks(library.bookStockQuantities(),ids));
                    library = library.bookStateChange();
                    assertThat(library.bookStockQuantities().get(0).stockQuantity()).isEqualTo(0);
                    assertThat(library.bookStockQuantities().get(1).stockQuantity()).isEqualTo(0);
                    assertThat(library.bookStockQuantities().get(2).stockQuantity()).isEqualTo(0);
                }
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("generateDataNoThrownBy")
    @DisplayName("returnBooks 메서드 테스트")
    void LibraryReturnBooks(List<BookStockQuantity> bookStockQuantities){
        assertThatCode(
                () -> {
                    List<Long> ids = List.of(0L, 1L, 2L);
                    Library library = new Library(bookStockQuantities);
                    library.setStrategy(new BorrowedBooks(library.bookStockQuantities(),ids));
                    library = library.bookStateChange();
                    library.setStrategy(new ReturnBooks(library.bookStockQuantities(),ids));
                    library = library.bookStateChange();
                    assertThat(library.bookStockQuantities().get(0).stockQuantity()).isEqualTo(1);
                    assertThat(library.bookStockQuantities().get(1).stockQuantity()).isEqualTo(1);
                    assertThat(library.bookStockQuantities().get(2).stockQuantity()).isEqualTo(1);
                }
        ).doesNotThrowAnyException();
    }
}