package bookManagement.Library.Book;

import static java.util.Objects.isNull;

public record Book(Long id, String title, String author, String publisher, int price, int stockQuantity) {
    public Book {
        if (isNull(id) || id < 0) {
            throw new IllegalArgumentException("도서번호에 올바르지 않은 값이 할당 되었습니다.");
        }
        if (isNull(title) || title.isBlank()) {
            throw new IllegalArgumentException("도서이름에 올바르지 않은 값이 할당 되었습니다.");
        }
        if (isNull(author) || author.isBlank()) {
            throw new IllegalArgumentException("저자에 올바르지 않은 값이 할당 되었습니다.");
        }
        if (isNull(publisher) || publisher.isBlank()) {
            throw new IllegalArgumentException("출판사에 올바르지 않은 값이 할당 되었습니다.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("도서 가격에 올바르지 않은 값이 할당 되었습니다.");
        }
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("재고수량에 올바르지 않은 값이 할당 되었습니다.");
        }
    }

    public boolean checkId(Long id) {
        return this.id.equals(id);
    }

    public boolean checkTitle(String keyword) {
        return this.title.contains(keyword);
    }

    public Book checkOut() {
        if (!checkStockQuantity()) {
            throw new IllegalArgumentException("대출가능한 도서수량이 부족합니다.");
        }
        int result = stockQuantity - 1;
        return new Book(id, title, author, publisher, price, result);
    }

    public Book returnBook() {
        int result = stockQuantity + 1;
        return new Book(id, title, author, publisher, price, result);
    }

    private boolean checkStockQuantity() {
        return this.stockQuantity > 0;
    }
}
