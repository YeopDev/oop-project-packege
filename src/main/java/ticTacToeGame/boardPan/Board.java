package ticTacToeGame.boardPan;

import ticTacToeGame.position.Position;

import java.util.stream.IntStream;

public class Board {
    private String[][] pan;

    public Board() {
        this.pan = initializeBoard();

    }

    public String[][] pan() {
        return pan;
    }

    private String[][] initializeBoard() {
        String[][] pan = new String[3][3];
        IntStream.range(0, 3).forEach(
                row -> IntStream.range(0, 3).forEach(col -> pan[row][col] = "-")
        );
        return pan;
    }

    public boolean isCellEmpty(Position position) {
        return pan[position.row()][position.col()] == "-";
    }

    public String[][] markCell(Position position, String mark) {
        pan[position.row()][position.col()] = mark;
        return pan;
    }
}
