package movieTicketExample.seat;

import movieTicketExample.position.Position;

public class Seat {
    private final Position position;
    private final String status;

    public Seat(Position position, String status) {
        validate(status);
        this.position = position;
        this.status = status;
    }

    public String status() {
        return status;
    }

    public boolean hasStatus(String status) {
        return this.status.equals(status);
    }

    private void validate(String status) {
        if (status.isBlank()) {
            throw new IllegalArgumentException("상태값은 비어있을 수 없습니다.");
        }
    }
}
