package movieTicketExample.theater;

import movieTicketExample.movie.Movie;
import movieTicketExample.position.Position;
import movieTicketExample.seat.Seat;

public class Theater {
    private final Long number;
    private final Movie movie;
    private final Seat[][] seats;

    public Theater(Long number, Movie movie) {
        this.number = number;
        this.movie = movie;
        this.seats = createSeats();
    }

    public Seat[][] seats() {
        return this.seats;
    }

    public boolean hasSeat(Position position) {
        return this.seats[position.x()][position.y()].hasStatus("-");
    }

    public Seat[][] markSeat(Position position, String mark) {
        this.seats[position.x()][position.y()] = new Seat(position,mark);
        return this.seats;
    }

    private Seat[][] createSeats() {
        Seat[][] createSeats = new Seat[5][5];
        Position position = new Position(5,5);
        for (int x = 0; x < position.x(); x++) {
            for (int y = 0; y < position.y(); y++) {
                Seat seat = new Seat(position,"-");
                createSeats[x][y] = seat;
            }
        }
        return createSeats;
    }
}
