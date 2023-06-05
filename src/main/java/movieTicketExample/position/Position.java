package movieTicketExample.position;

public record Position(int x, int y) {
    public Position {
        validate(x, y);
    }

    private void validate(int x, int y) {
        if (x < 0) {
            throw new IllegalArgumentException("x는 0보다 작을 수 없습니다.");
        }
        if (y < 0) {
            throw new IllegalArgumentException("y은 0보다 작을 수 없습니다.");
        }
    }
}
