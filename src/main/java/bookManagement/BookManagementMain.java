package bookManagement;

import bookManagement.Library.Book.Book;
import bookManagement.Library.Library;
import bookManagement.Library.LibraryBookManager;
import bookManagement.Library.Member.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManagementMain {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. 단일책임 원칙에 따라 작성 - SRP - 객체는 하나의 책임만 구현한다.
        // 2. 개방폐쇄 원칙에 따라 작성 - OCP - 확장성은 열어두고, 변경은 닫는다. - 추상화
        // 3. 리스코프 치환 원칙에 따라 작성 - LSP - 하위 클래스는 부모클래스로 교체될 수 있어야한다.
        // 4. 인터페이스 분리 원칙에 따라 작성 - ISP - SRP원칙처럼 인터페이스는 하나의 책임을 구현한다.
        // 5. 의존 역전 원칙에 따라 작성 - DIP - 객체를 참조할때 객체의 상위클래스를 참조한다.

//        규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
//        규칙 2: else 예약어를 쓰지 않는다.
//        규칙 3: 모든 원시값과 문자열을 포장한다.
//        규칙 4: 한 줄에 점을 하나만 찍는다.
//        규칙 5: 줄여쓰지 않는다(축약 금지).
//        규칙 6: 모든 엔티티를 작게 유지한다.
//        규칙 7: 2개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
//        규칙 8: 일급 콜렉션을 쓴다.
//        규칙 9: 게터/세터/프로퍼티를 쓰지 않는다.

        // *도서관리시스템*
        // 도서관은 회원을 가집니다.
        // 도서관은 도서목록을 가집니다.
        // 도서관은 도서 대출을 관리하고, 도서반납을 관리합니다.
        // 회원은 도서를 대출 할 수 있습니다.
        // 회원은 도서를 반납 할 수 있습니다.
        // 도서는 정보조회를 할 수 있습니다.
        // 도서는 재고확인을 할 수 있습니다.
        // 도서 대출은 책 객체당 1권만 가능 합니다.
        Library library = new Library(
                List.of(
                        new Book(0L, "객체지향의 사실과 오해", "human1", "위키북스", 25_000, 10),
                        new Book(1L, "객체지향", "human1", "위키북스", 30_000, 5),
                        new Book(2L, "혼자 공부하는 운영체제", "human1", "위키북스", 50_000, 3),
                        new Book(3L, "혼자 공부하는 네트워크", "human1", "위키북스", 50_000, 5),
                        new Book(4L, "엘레강트 오브젝트", "human1", "위키북스", 60_000, 5)
                )
        );
        Member member = new Member(0L, "yeop");
        System.out.println("찾으시는 도서이름을 입력해주세요.");
        String keyword = sc.nextLine();
        library.search(keyword);

        List<Book> checkOutBooks = new ArrayList<>();
        while (true) {
            System.out.println("대출 하시려는 도서번호를 입력하세요.");
            String id = sc.nextLine();
            if (id.isBlank()) {
                break;
            }
            Book book = library.findById(Long.parseLong(id))
                    .orElseThrow(() -> new IllegalArgumentException("도서번호가 잘못되었습니다."));
            checkOutBooks.add(book);
        }

        LibraryBookManager libraryBookManager = new LibraryBookManager(member, checkOutBooks);
        System.out.printf("%s이 도서를 대출 합니다.",member.name());
        checkOutBooks = library.checkOutBook(checkOutBooks);
        System.out.println(checkOutBooks);
        System.out.printf("%s이 도서를 반납합니다.",member.name());
        checkOutBooks = library.returnBook(checkOutBooks);
        System.out.println(checkOutBooks);
    }
}