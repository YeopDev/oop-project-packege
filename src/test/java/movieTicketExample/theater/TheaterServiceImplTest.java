package movieTicketExample.theater;

import movieTicketExample.movie.Movie;
import movieTicketExample.position.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TheaterServiceImplTest {
    @ParameterizedTest
    @CsvSource(value = {"0"})
    @DisplayName("markSeat 메소드 검증")
    void markSeatNoThrownBy(Long id) {
        Assertions.assertThatCode(
                () -> {
                    Movie movie = new Movie(id, "범죄도시1");
                    TheaterService theaterService = new TheaterServiceImpl(id, movie);
                    Position position = new Position(0, 0);
                    theaterService.markSeat(position, "V");
                    Assertions.assertThat(theaterService.hasSeat(position)).isFalse();
                }
        ).doesNotThrowAnyException();
    }
}