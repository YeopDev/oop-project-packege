package movieTicketExample.theater.repository;

import movieTicketExample.theater.TheaterServiceImpl;

import java.util.List;

public interface TheaterRepository {
    List<TheaterServiceImpl> getAllTeaters();

    TheaterServiceImpl findById(long id);
}