package ticTacToeGame.computer;

import ticTacToeGame.boardPan.Board;
import ticTacToeGame.position.Position;

public class Computer {
    private final CreatePosition randomPosition = new CreatePosition();
    private String name;
    public Computer(String name){
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
}
