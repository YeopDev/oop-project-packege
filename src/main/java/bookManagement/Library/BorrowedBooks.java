package bookManagement.Library;

import bookManagement.Library.Book.BookStockQuantity;

import java.util.ArrayList;
import java.util.List;

public class BorrowedBooks implements LibraryBookManagementStrategy {

    private List<BookStockQuantity> bookStockQuantities;
    private List<Long> borrowedIds;

    public BorrowedBooks(List<BookStockQuantity> bookStockQuantities, List<Long> borrowedIds){
        if (bookStockQuantities.isEmpty()) {
            throw new IllegalArgumentException("리스트가 비어있습니다.");
        }
        if (borrowedIds.isEmpty()) {
            throw new IllegalArgumentException("리스트가 비어있습니다.");
        }
        this.bookStockQuantities = new ArrayList<>(bookStockQuantities);
        this.borrowedIds = new ArrayList<>(borrowedIds);
    }

    @Override
    public Library bookStateChange() {
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
}
