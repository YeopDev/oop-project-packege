package movieTicketExample.reservation;

import movieTicketExample.customer.Customer;
import movieTicketExample.position.Position;
import movieTicketExample.seat.Seat;
import movieTicketExample.theater.Theater;

public class Reservation {
    private int reservationNumber = 0;
    private Customer customer;
    private Theater theater;

    public Reservation(Customer customer, Theater theater) {
        reservationNumber++;//완성 객체
        this.customer = customer;
        this.theater = theater;

    }

    public Seat[][] reserved(Position position, String mark) {
        if (!theater.hasSeat(position)) {
            throw new IllegalArgumentException("이미 예약된 좌석입니다.");
        }
        return theater.markSeat(position, mark);
    }
}
