package bookManagement.Library;

import bookManagement.Library.Book.Book;
import bookManagement.Library.Book.BookStockQuantity;

import java.util.ArrayList;
import java.util.List;

public class Library{
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

    public List<Long> borrowedIds(List<Long> ids) {
        if (!isChecked(ids)) {
            throw new IllegalArgumentException("대출하려는 책이 없습니다.");
        }
        return bookStockQuantities.stream()
                .filter(bookStockQuantity -> ids.contains(bookStockQuantity.returnBookId()))
                .map(BookStockQuantity::book)
                .map(Book::id)
                .toList();
    }

    public Library bookStateChange(LibraryBookManagementStrategy libraryBookManagementStrategy){
        return libraryBookManagementStrategy.bookStateChange();
    }

    public List<BookStockQuantity> displayLoanStatus(){
        return bookStockQuantities().stream().filter(id -> id.stockQuantity() == 0).toList();
    }

    public boolean isChecked(List<Long> ids) {
        return !ids.isEmpty();
    }
}
