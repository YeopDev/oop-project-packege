package movieTicketExample.seat;

public record Seat(int x, int y, int price) {

    public Seat {
        validate(x, y, price);
    }

    private void validate(int x, int y, int price) {
        if (x < 0) {
            throw new IllegalArgumentException("좌석좌표 x는 0보다 작을 수 없습니다.");
        }
        if (y < 0) {
            throw new IllegalArgumentException("좌석좌표 y는 0보다 작을 수 없습니다.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("영화가격은 0보다 작을 수 없습니다.");
        }
    }
}
