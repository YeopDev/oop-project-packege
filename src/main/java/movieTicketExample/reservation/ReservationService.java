package movieTicketExample.reservation;

import movieTicketExample.position.Position;
import movieTicketExample.seat.Seat;

@FunctionalInterface
public interface ReservationService {
    Seat[][] place(Position position, String mark);
}