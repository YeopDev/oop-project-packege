package movieTicketExample.reservation;

import movieTicketExample.movie.Movie;
import movieTicketExample.position.Position;
import movieTicketExample.theater.TheaterService;
import movieTicketExample.theater.TheaterServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ReservationServiceImplTest {
    @Test
    @DisplayName("예약메소드 검증 - 정상")
    void placeNoThrownBy() {
        assertThatCode(
                () -> {
                    TheaterService theaterService = new TheaterServiceImpl(0L, new Movie(0L, "범죄도시1"));
                    ReservationService reservationService = new ReservationServiceImpl(theaterService);
                    Position position = new Position(0, 0);
                    reservationService.place(position, "V");
                    assertThat(theaterService.hasSeat(position)).isFalse();
                }
        ).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("예약메소드 검증 - 에러")
    void placeThrownBy() {
        assertThatThrownBy(
                () -> {
                    TheaterService theaterService = new TheaterServiceImpl(0L, new Movie(0L, "범죄도시1"));
                    ReservationService reservationService = new ReservationServiceImpl(theaterService);
                    Position position = new Position(0, 0);
                    reservationService.place(position, "V");
                    reservationService.place(position, "V");
                }
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("이미 예약된 좌석입니다.");
    }
}