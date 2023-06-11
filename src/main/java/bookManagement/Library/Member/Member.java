package bookManagement.Library.Member;

import bookManagement.Library.BorrowedBooks;
import bookManagement.Library.Library;
import bookManagement.Library.ReturnBooks;

import java.util.List;

import static java.util.Objects.isNull;

public record Member(Long id, String name) {
    private static final int MINIMUM_ID = 0;

    public Member {
        if (isNull(id) || id < MINIMUM_ID) {
            throw new IllegalArgumentException("id는 %d 보다 작을 수 없습니다.".formatted(MINIMUM_ID));
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("회원이름은 비어있을 수 없습니다.");
        }
    }

    public Library borrowBooks(Library library, List<Long> borrowedIds) {
        if (!library.isChecked(borrowedIds)) {
            throw new IllegalArgumentException("대출하려는 책이 없습니다.");
        }
        library.setStrategy(new BorrowedBooks(library.bookStockQuantities(),borrowedIds));
        return library.bookStateChange();
    }

    public Library returnBook(Library library, List<Long> returnIds) {
        if (!library.isChecked(returnIds)) {
            throw new IllegalArgumentException("반납하려는 책이 없습니다.");
        }
        library.setStrategy(new ReturnBooks(library.bookStockQuantities(),returnIds));
        return library.bookStateChange();
    }
}
