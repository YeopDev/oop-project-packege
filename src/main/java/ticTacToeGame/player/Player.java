package ticTacToeGame.player;

import ticTacToeGame.boardPan.Board;
import ticTacToeGame.position.Position;

public class Player {
    private String name;
    public Player(String name){
        this.name = name;
    }

    public String name() {
        return name;
    }

    public String[][] mark(Board board, Position position) {
        if (!board.isCellEmpty(position)) {
            throw new IllegalArgumentException("이미 들어있는 값을 할당 받았습니다.");
        }
        return board.markCell(position, name);
    }
}
