package movieTicketExample.theater;

import movieTicketExample.movie.Movie;
import movieTicketExample.position.Position;
import movieTicketExample.seat.Seat;
import movieTicketExample.seat.SeatFactory;

public class TheaterServiceImpl implements TheaterService{
    private final Long id;
    private final Movie movie;
    private final Seat[][] seats;

    public TheaterServiceImpl(Long id, Movie movie) {
        this.id = id;
        this.movie = movie;
        this.seats = new SeatFactory().createSeat(new Position(5,5),"-");
    }

    @Override
    public Seat[][] getAllSeats() {
        return this.seats;
    }

    public Long id() {
        return this.id;
    }

    public Movie movie() {
        return this.movie;
    }

    public boolean sameId(long id) {
        return this.id.equals(id);
    }

    @Override
    public boolean hasSeat(Position position) {
        return this.seats[position.x()][position.y()].hasStatus("-");
    }

    @Override
    public Seat[][] markSeat(Position position, String mark) {
        this.seats[position.x()][position.y()] = new Seat(position, mark);
        return this.seats;
    }
}