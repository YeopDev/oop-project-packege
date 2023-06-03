package movieTicketExample.theater;

import movieTicketExample.movie.Movie;
import movieTicketExample.seat.Seat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Theater {
    private List<Movie> movies;
    private Map<Movie, Seat[][]> seatingMap;

    public Theater() {
        this.movies = new ArrayList<>();
        this.seatingMap = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
        seatingMap.put(movie, new Seat[10][10]); // Assuming a theater has 10 rows and 10 columns of seats
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Seat[][] getSeatingMap(Movie movie) {
        return seatingMap.get(movie);
    }
}
