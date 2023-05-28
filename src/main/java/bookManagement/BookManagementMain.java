package bookManagement;

import bookManagement.Library.Book.Book;
import bookManagement.Library.Book.BookStockQuantity;
import bookManagement.Library.BookManagement;
import bookManagement.Library.Library;
import bookManagement.Library.Member.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManagementMain {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library(List.of(
                new BookStockQuantity(new Book(0L, "객체지향의 사실과 오해", "human1", "위키북스", 25_000), 1),
                new BookStockQuantity(new Book(1L, "객체지향", "human1", "위키북스", 30_000), 1),
                new BookStockQuantity(new Book(2L, "혼자 공부하는 운영체제", "human1", "위키북스", 50_000), 1),
                new BookStockQuantity(new Book(3L, "혼자 공부하는 네트워크", "human1", "위키북스", 50_000), 1),
                new BookStockQuantity(new Book(4L, "엘레강트 오브젝트", "human1", "위키북스", 60_000), 1)
        ));

        Member member = new Member(0L, "yeop");

        List<Long> ids = new ArrayList<>();
        while (true) {
            System.out.println("대출 하시려는 도서번호를 입력하세요.");
            ids.add(sc.nextLong());

            System.out.println("더 대출하시겠습니까? Y/N");
            String flag = sc.next().toUpperCase();
            if (!flag.equals("Y")) {
                break;
            }
        }

        System.out.println(member.name() + "님이 도서를 대출 합니다.");
        library = member.borrowBooks(library, ids);
        List<Book> borrowedBooks = member.showBooks(library, ids);
        System.out.println("대출 한 책 목록: " + borrowedBooks.stream().map(Book::title).toList());
        System.out.println("도서현황: " + library.bookStockQuantities().stream().filter(id -> id.stockQuantity() == 0).toList());

        System.out.println(member.name() + "님이 도서를 반납 합니다.");
        library = member.returnBook(library, borrowedBooks.stream().map(Book::id).toList());
        System.out.println("도서현황: " + library);
    }
}