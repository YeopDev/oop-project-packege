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
        return new Library(bookStockQuantities.stream()
                .map(bookStockQuantity -> {
                    if (borrowedIds.contains(bookStockQuantity.returnBookId())) {
                        return bookStockQuantity.decreaseStockQuantity();
                    }
                    return bookStockQuantity;
                })
                .toList()
        );
    }

    public Library returnBooks(List<Long> returnIds) {
        return new Library(bookStockQuantities.stream()
                .map(bookStockQuantity -> {
                    if (returnIds.contains(bookStockQuantity.returnBookId())) {
                        return bookStockQuantity.increaseStockQuantity();
                    }
                    return bookStockQuantity;
                })
                .toList()
        );
    }
}
