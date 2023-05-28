package ticTacToeGame.computer;

import ticTacToeGame.boardPan.Board;
import ticTacToeGame.position.Position;

import static java.util.Objects.isNull;

public class Computer {
    private String name;
    private final CreatePositionPolicy createPositionPolicy;

    public Computer(String name, CreatePositionPolicy createPositionPolicy) {
        validate(name);
        this.name = name;
        this.createPositionPolicy = createPositionPolicy;
    }

    public String[][] mark(Board board) {
        while (true) {
            Position position = createPositionPolicy.create();
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
