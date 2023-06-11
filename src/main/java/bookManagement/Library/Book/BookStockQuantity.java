package bookManagement.Library.Book;

import static java.util.Objects.isNull;

public record BookStockQuantity(Book book, int stockQuantity) {
    private static final int MINIMUM_QUANTITY = 0;

    public BookStockQuantity {
        if (isNull(book)) {
            throw new IllegalArgumentException("도서정보가 없습니다.");
        }
        if (stockQuantity < MINIMUM_QUANTITY) {
            throw new IllegalArgumentException("재고수량은 %d 보다 작을 수 없습니다.".formatted(MINIMUM_QUANTITY));
        }
    }

    public Long returnBookId() {
        return book.id();
    }

    public BookStockQuantity decreaseStockQuantity() {
        return new BookStockQuantity(book, stockQuantity - 1);
    }

    public BookStockQuantity increaseStockQuantity() {
        return new BookStockQuantity(book, stockQuantity + 1);
    }
}
