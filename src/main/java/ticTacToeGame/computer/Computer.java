package ticTacToeGame.computer;

import ticTacToeGame.boardPan.Board;
import ticTacToeGame.position.Position;

import static java.util.Objects.isNull;

public class Computer {
    private final CreatePosition randomPosition = new CreatePosition();
    private String name;

    public Computer(String name) {
        validate(name);
        this.name = name;
    }

    public String name() {
        return name;
    }

    public String[][] mark(Board board) {
        while (true) {
            Position position = randomPosition.create();
            if (board.isCellEmpty(position)) {
                return board.markCell(position, name);
            }
        }
    }

    private void validate(String name) {
        if (isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("mark 할 값이 비어있습니다.");
        }
    }
}
