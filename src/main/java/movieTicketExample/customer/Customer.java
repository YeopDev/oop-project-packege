package movieTicketExample.customer;

import movieTicketExample.position.Position;
import movieTicketExample.reservation.ReservationService;
import movieTicketExample.seat.Seat;

import static java.util.Objects.isNull;

public class Customer {
    private final Long id;
    private final String name;
    private final int money;
    private final ReservationService reservationService;

    public Customer(Long id, String name, int money, ReservationService reservationService) {
        validate(id, name, money);
        this.id = id;
        this.name = name;
        this.money = money;
        this.reservationService = reservationService;
    }

    public Seat[][] makeReservation(Position position, String mark) {
        return reservationService.place(position, mark);
    }

    private void validate(Long id, String name, int money) {
        if (isNull(id) || id < 0) {
            throw new IllegalArgumentException("id는 비어있을 수 없고, 0보다 작을 수 없습니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }
        if (money < 0) {
            throw new IllegalArgumentException("소지금은 0보다 작을 수 없습니다.");
        }
    }
}