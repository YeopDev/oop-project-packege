package movieTicketExample.movie;

import static java.util.Objects.isNull;

public record Movie(Long id, String name, int price) {

    public Movie {
        validate(id, name, price);
    }

    private void validate(Long id, String name, int price) {
        if (isNull(id) || id < 0) {
            throw new IllegalArgumentException("영화번호는 비어있을 수 없고, 0보다 작을 수 없습니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("영화이름은 비어있을 수 없습니다.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("영화가격은 0보다 작을 수 없습니다.");
        }
    }
}
