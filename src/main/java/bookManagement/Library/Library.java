package bookManagement.Library;

import bookManagement.Library.Book.Book;
import bookManagement.Library.Book.BookStockQuantity;

import java.util.ArrayList;
import java.util.List;

public class Library extends BookManagement{
    private List<BookStockQuantity> bookStockQuantities;

    public Library(List<BookStockQuantity> bookStockQuantities) {
        if (bookStockQuantities.isEmpty()) {
            throw new IllegalArgumentException("리스트가 비어있습니다.");
        }
        this.bookStockQuantities = new ArrayList<>(bookStockQuantities);
    }

    public List<BookStockQuantity> bookStockQuantities() {
        return bookStockQuantities;
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

    @Override
    public Library bookStateChange() {
        return super.bookStateChange();
    }

    @Override
    public void setLibraryBookManagementStrategy(LibraryBookManagementStrategy libraryBookManagementStrategy) {
        super.setLibraryBookManagementStrategy(libraryBookManagementStrategy);
    }

    @Override
    public String toString() {
        return "Library{" +
                "bookStockQuantities=" + bookStockQuantities +
                '}';
    }
}
