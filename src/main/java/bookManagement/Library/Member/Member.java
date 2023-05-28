package bookManagement.Library.Member;

import bookManagement.Library.Book.Book;
import bookManagement.Library.BorrowedBooks;
import bookManagement.Library.Library;
import bookManagement.Library.ReturnBooks;

import java.util.List;

import static java.util.Objects.isNull;

public record Member(Long id, String name) {

    public Member {
        if (isNull(id) || id < 0) {
            throw new IllegalArgumentException("id 값이 올바르지 않습니다.");
        }
        if (isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("회원이름이 올바르지 않습니다.");
        }
    }

    public List<Book> showBooks(Library library, List<Long> ids) {
        if (!library.isChecked(ids)) {
            throw new IllegalArgumentException("대출하려는 책이 없습니다.");
        }
        return library.displayBooks(ids);
    }

    public Library borrowBooks(Library library, List<Long> borrowedIds) {
        if (!library.isChecked(borrowedIds)) {
            throw new IllegalArgumentException("대출하려는 책이 없습니다.");
        }
        library.setLibraryBookManagementStrategy(new BorrowedBooks(library.bookStockQuantities(),borrowedIds));
        return library.bookStateChange();
    }

    public Library returnBook(Library library, List<Long> returnIds) {
        if (!library.isChecked(returnIds)) {
            throw new IllegalArgumentException("반납하려는 책이 없습니다.");
        }
        library.setLibraryBookManagementStrategy(new ReturnBooks(library.bookStockQuantities(),returnIds));
        return library.bookStateChange();
    }
}
