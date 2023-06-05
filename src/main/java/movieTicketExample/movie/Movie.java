package movieTicketExample.movie;

import static java.util.Objects.isNull;

public record Movie(Long id, String title) {

    public Movie {
        validate(id, title);
    }

    private void validate(Long id, String title) {
        if (isNull(id) || id < 0) {
            throw new IllegalArgumentException("영화번호는 비어있을 수 없고, 0보다 작을 수 없습니다.");
        }
        if (title.isBlank()) {
            throw new IllegalArgumentException("영화이름은 비어있을 수 없습니다.");
        }
    }
}
