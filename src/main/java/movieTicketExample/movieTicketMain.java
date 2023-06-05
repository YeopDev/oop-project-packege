package movieTicketExample;

import movieTicketExample.customer.Customer;
import movieTicketExample.movie.Movie;
import movieTicketExample.position.Position;
import movieTicketExample.reservation.Reservation;
import movieTicketExample.seat.Seat;
import movieTicketExample.theater.Theater;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

public class movieTicketMain {
    private final static Scanner scanner = new Scanner(System.in);
    private final static String CUSTOMER_MARK = "V";

    public static void main(String[] args) {
        System.out.println("영화관 예매 프로그램");
        Theater theater = new Theater(0L, new Movie(0L, "범죄도시1"));
        Seat[][] seatInfo = theater.seats();


        System.out.println("좌석정보: ");
        Arrays.stream(seatInfo)
                .map(row -> Arrays.stream(row)
                        .map(Seat::status)
                        .collect(joining("\t")))
                .forEach(System.out::println);

        Customer customer = new Customer(0L, "test", 10_000);

        Reservation reservation = new Reservation(customer, theater);

        System.out.println("x값을 입력합니다.");
        int x = scanner.nextInt();

        System.out.println("y값을 입력합니다.");
        int y = scanner.nextInt();

        Position position = new Position(x, y);

        seatInfo = reservation.reserved(position, CUSTOMER_MARK);


        System.out.println("좌석정보: ");
        Arrays.stream(seatInfo)
                .map(row -> Arrays.stream(row)
                        .map(Seat::status)
                        .collect(joining("\t")))
                .forEach(System.out::println);
    }
}
