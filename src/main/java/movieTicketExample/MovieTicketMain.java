package movieTicketExample;

import movieTicketExample.customer.Customer;
import movieTicketExample.movie.Movie;
import movieTicketExample.position.Position;
import movieTicketExample.reservation.ReservationService;
import movieTicketExample.reservation.ReservationServiceImpl;
import movieTicketExample.seat.Seat;
import movieTicketExample.theater.TheaterServiceImpl;
import movieTicketExample.theater.repository.TheaterRepositoryImpl;
import movieTicketExample.theater.repository.TheaterRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

public class MovieTicketMain {
    private final static Scanner scanner = new Scanner(System.in);
    private final static String CUSTOMER_MARK = "V";

    public static void main(String[] args) {
        System.out.println("영화 예매 프로그램");
        TheaterRepository theaterRepository = new TheaterRepositoryImpl(List.of(
                new TheaterServiceImpl(0L, new Movie(0L, "범죄도시1")),
                new TheaterServiceImpl(1L, new Movie(0L, "범죄도시2")),
                new TheaterServiceImpl(2L, new Movie(0L, "범죄도시3"))
        ));

        List<TheaterServiceImpl> theaterServiceImplList = theaterRepository.getAllTeaters();
        for (TheaterServiceImpl theaterServiceImpl : theaterServiceImplList) {
            System.out.println(theaterServiceImpl.id() + "번 상영관 -" + theaterServiceImpl.movie().title());
        }

        System.out.print("상영관을 선택하세요: ");
        int pick = scanner.nextInt();
        TheaterServiceImpl targetTheaterServiceImpl = theaterRepository.findById(pick);
        System.out.println(targetTheaterServiceImpl.id() + "번 상영관을 선택했습니다.");

        Seat[][] seatInfo = targetTheaterServiceImpl.getAllSeats();
        System.out.println("좌석정보: ");
        Arrays.stream(seatInfo)
                .map(row -> Arrays.stream(row)
                        .map(Seat::status)
                        .collect(joining("\t")))
                .forEach(System.out::println);

        ReservationService reservationService = new ReservationServiceImpl(targetTheaterServiceImpl);

        Customer customer = new Customer(0L, "customer", 10_000, reservationService);

        System.out.println("x값을 입력합니다.");
        int x = scanner.nextInt();

        System.out.println("y값을 입력합니다.");
        int y = scanner.nextInt();

        Position position = new Position(x, y);

        seatInfo = customer.makeReservation(position, CUSTOMER_MARK);

        System.out.println("좌석예약이 완료 되었습니다.");
        System.out.println("좌석정보: ");
        Arrays.stream(seatInfo)
                .map(row -> Arrays.stream(row)
                        .map(Seat::status)
                        .collect(joining("\t")))
                .forEach(System.out::println);
    }
}