package bookManagement.Library;

import bookManagement.Library.Book.BookStockQuantity;

import java.util.ArrayList;
import java.util.List;

public class ReturnBooks implements LibraryBookManagementStrategy {
    private List<BookStockQuantity> bookStockQuantities;
    private List<Long> returnIds;

    public ReturnBooks(List<BookStockQuantity> bookStockQuantities, List<Long> returnIds) {
        if (bookStockQuantities.isEmpty()) {
            throw new IllegalArgumentException("리스트가 비어있습니다.");
        }
        if (returnIds.isEmpty()) {
            throw new IllegalArgumentException("리스트가 비어있습니다.");
        }
        this.bookStockQuantities = new ArrayList<>(bookStockQuantities);
        this.returnIds = new ArrayList<>(returnIds);
    }

    @Override
    public Library bookStateChange() {
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
