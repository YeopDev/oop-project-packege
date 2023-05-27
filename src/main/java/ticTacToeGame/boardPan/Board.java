package ticTacToeGame.boardPan;

import ticTacToeGame.position.Position;

import java.util.stream.IntStream;

public class Board {
    private String[][] content;

    public Board() {
        this.content = initializeBoard();
    }

    public String[][] content() {
        return content;
    }

    public boolean isCellEmpty(Position position) {
        return content[position.x()][position.y()] == "-";
    }

    public String[][] markCell(Position position, String mark) {
        content[position.x()][position.y()] = mark;
        return content;
    }

    private String[][] initializeBoard() {
        String[][] pan = new String[3][3];
        IntStream.range(0, 3).forEach(
                row -> IntStream.range(0, 3).forEach(col -> pan[row][col] = "-")
        );
        return pan;
    }
}
