package movieTicketExample.seat;

import movieTicketExample.position.Position;

public class SeatFactory {

    public Seat[][] createSeat(Position position,String mark){
        Seat[][] seatList = new Seat[position.x()][position.x()];
        for (int x = 0; x < position.x(); x++) {
            for (int y = 0; y < position.y(); y++) {
                Seat seat = new Seat(position, mark);
                seatList[x][y] = seat;
            }
        }
        return seatList;
    }
}
