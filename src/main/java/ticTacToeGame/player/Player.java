package ticTacToeGame.player;

import ticTacToeGame.boardPan.Board;
import ticTacToeGame.position.Position;

import static java.util.Objects.isNull;

public class Player {
    private String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    public String[][] mark(Board board, Position position) {
        if (!board.isCellEmpty(position)) {
            throw new IllegalArgumentException("이미 mark 되어있는 값을 전달 받았습니다.");
        }
        return board.markCell(position, name);
    }

    private void validate(String name) {
        if (isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("mark 할 값이 비어있습니다.");
        }
    }
}
