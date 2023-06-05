package movieTicketExample.theater;

import movieTicketExample.position.Position;
import movieTicketExample.seat.Seat;

public interface TheaterService {
    Seat[][] getAllSeats();

    boolean hasSeat(Position position);

    Seat[][] markSeat(Position position, String mark);
}
