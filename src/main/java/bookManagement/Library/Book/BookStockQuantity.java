package bookManagement.Library.Book;

import static java.util.Objects.isNull;

public record BookStockQuantity(Book book, int stockQuantity) {

    public BookStockQuantity {
        if (isNull(book)) {
            throw new IllegalArgumentException("도서정보가 없습니다.");
        }
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("재고수량에 올바르지 않은 값이 할당 되었습니다.");
        }
    }

    public Long returnBookId() {
        return book.responseId();
    }

    public BookStockQuantity decreaseStockQuantity() {
        return new BookStockQuantity(book, stockQuantity - 1);
    }

    public BookStockQuantity increaseStockQuantity() {
        return new BookStockQuantity(book, stockQuantity + 1);
    }
}
