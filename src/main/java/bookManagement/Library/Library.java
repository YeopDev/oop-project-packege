package bookManagement.Library;

import bookManagement.Library.Book.Book;
import bookManagement.Library.Book.BookStockQuantity;

import java.util.ArrayList;
import java.util.List;

public record Library(List<BookStockQuantity> bookStockQuantities) {

    public Library {
        if (bookStockQuantities.isEmpty()) {
            throw new IllegalArgumentException("리스트가 비어있습니다.");
        }
        bookStockQuantities = new ArrayList<>(bookStockQuantities);
    }

    public boolean isChecked(List<Long> ids) {
        return !ids.isEmpty();
    }

    public List<Book> displayBooks(List<Long> ids) {
        return bookStockQuantities.stream()
                .filter(bookStockQuantity -> ids.contains(bookStockQuantity.returnBookId()))
                .map(BookStockQuantity::book)
                .toList();
    }

    public Library borrowedBooks(List<Long> borrowedIds) {
        return new BorrowedBooks(bookStockQuantities, borrowedIds).bookStateChange();
    }

    public Library returnBooks(List<Long> returnIds) {
        return new ReturnBooks(bookStockQuantities, returnIds).bookStateChange();
    }
}
