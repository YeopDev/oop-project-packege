package movieTicketExample.reservation;

import movieTicketExample.position.Position;
import movieTicketExample.seat.Seat;
import movieTicketExample.theater.TheaterService;

public class ReservationServiceImpl implements ReservationService {
    private TheaterService theaterService;

    public ReservationServiceImpl(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @Override
    public Seat[][] place(Position position, String mark) {
        if (!theaterService.hasSeat(position)) {
            throw new IllegalArgumentException("이미 예약된 좌석입니다.");
        }
        return theaterService.markSeat(position, mark);
    }
}