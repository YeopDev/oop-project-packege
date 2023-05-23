package bookManagement.Library;

import bookManagement.Library.Book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public record Library(List<Book> books) {
    public Library {
        if (books.isEmpty()) {
            throw new IllegalArgumentException("리스트가 비어있습니다.");
        }
        books = new ArrayList<>(books);
    }

    public List<Book> search(String keyword) {
        if (keyword.isBlank()) {
            throw new IllegalArgumentException("정상적인 책 이름을 입력해주세요.");
        }
        return books.stream()
                .filter(book -> book.checkTitle(keyword))
                .toList();
    }

    public Optional<Book> findById(Long id) {
        return books.stream()
                .filter(book -> book.checkId(id))
                .findFirst();
    }

    public List<Book> checkOutBook(List<Book> checkOutList) {
        Set<Long> checkOutId = checkOutList.stream()
                .map(Book::id)
                .collect(Collectors.toSet());
        List<Book> changeBooks = books.stream()
                .filter(book -> checkOutId.contains(book.id()))
                .map(Book::checkOut)
                .toList();
        return changeBooks;
    }

    public List<Book> returnBook(List<Book> checkOutList) {
        Set<Long> checkOutId = checkOutList.stream()
                .map(Book::id)
                .collect(Collectors.toSet());
        List<Book> changeBooks = books.stream()
                .filter(book -> checkOutId.contains(book.id()))
                .map(Book::returnBook)
                .toList();
        return changeBooks;
    }
}
