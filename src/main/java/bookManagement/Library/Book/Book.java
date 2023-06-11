package bookManagement.Library.Book;

import static java.util.Objects.isNull;

public record Book(Long id, String title, String author, String publisher, int price) {
    private static final int MINIMUM_VALUE = 0;

    public Book {
        if (isNull(id) || id < MINIMUM_VALUE) {
            throw new IllegalArgumentException("도서번호는 비어있을 수 없으며, %d 보다 작을 수 없습니다.".formatted(MINIMUM_VALUE));
        }
        if (title.isBlank()) {
            throw new IllegalArgumentException("도서이름에 올바르지 않은 값이 할당 되었습니다.");
        }
        if (author.isBlank()) {
            throw new IllegalArgumentException("저자에 올바르지 않은 값이 할당 되었습니다.");
        }
        if (publisher.isBlank()) {
            throw new IllegalArgumentException("출판사에 올바르지 않은 값이 할당 되었습니다.");
        }
        if (price < MINIMUM_VALUE) {
            throw new IllegalArgumentException("도서가격은 %d 보다 작을 수 없습니다.".formatted(MINIMUM_VALUE));
        }
    }
}
