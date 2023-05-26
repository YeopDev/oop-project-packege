package ticTacToeGame.computer;

import ticTacToeGame.boardPan.Board;
import ticTacToeGame.position.Position;

public class Computer {
    private final RandomPosition randomPosition = new RandomPosition();
    private final String COMPUTER_MARK = "C";

    public String COMPUTER_MARK() {
        return COMPUTER_MARK;
    }

    public String[][] mark(Board board) {
        while (true) {
            Position position = randomPosition.create();
            if (board.isCellEmpty(position)) {
                return board.markCell(position, COMPUTER_MARK);
            }
        }
    }
}
