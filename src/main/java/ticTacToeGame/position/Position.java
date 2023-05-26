package ticTacToeGame.position;

public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        validate(row, col);
        this.row = row;
        this.col = col;
    }

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }

    private void validate(int row, int col) {
        if (row < 0) {
            throw new IllegalArgumentException("row는 0보다 작을 수 없습니다.");
        }
        if (col < 0) {
            throw new IllegalArgumentException("col은 0보다 작을 수 없습니다.");
        }
    }
}
