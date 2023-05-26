package ticTacToeGame.player;

import ticTacToeGame.boardPan.Board;
import ticTacToeGame.position.Position;

public class Player {
    private final String PLAYER_MARK = "P";

    public String PLAYER_MARK() {
        return PLAYER_MARK;
    }

    public String[][] mark(Board board, Position position) {
        if (!board.isCellEmpty(position)) {
            throw new IllegalArgumentException("값을 잘못 입력하셨습니다.");
        }
        return board.markCell(position, PLAYER_MARK);
    }
}
