package ticTacToeGame;

import ticTacToeGame.boardPan.Board;
import ticTacToeGame.computer.Computer;
import ticTacToeGame.computer.CreatePosition;
import ticTacToeGame.player.Player;
import ticTacToeGame.position.Position;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeMain {
    private final static Scanner sc = new Scanner(System.in);
    private final static String PLAYER_MARK = "P";
    private final static String COMPUTER_MARK = "C";
    private static boolean gameOver = false;

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println("게임판을 생성하였습니다.");
        printBoard(board.content());

        Computer computer = new Computer(COMPUTER_MARK, new CreatePosition());
        Player player = new Player(PLAYER_MARK);

        while (!gameOver) {
            System.out.println("player가 x값을 입력합니다.");
            int x = sc.nextInt();
            System.out.println("player가 y값을 입력합니다.");
            int y = sc.nextInt();
            Position position = new Position(x, y);

            System.out.println("player가 mark 합니다.");
            printBoard(player.mark(board, position));
            if (hasWinner(board.content(), PLAYER_MARK)) {
                System.out.println("player가 이겼습니다.");
                break;
            }

            System.out.println("computer가 mark 합니다.");
            printBoard(computer.mark(board));
            if (hasWinner(board.content(), COMPUTER_MARK)) {
                System.out.println("computer가 이겼습니다.");
                break;
            }

            if (gameOver) {
                break;
            }
        }
    }

    public static void printBoard(String[][] content) {
        if (hasGameOver(content)) {
            gameOver = true;
        }
        Arrays.stream(content).forEach(x -> System.out.println(String.join("\t", x)));
    }

    public static boolean hasGameOver(String[][] content) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (content[x][y] == "-") {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean hasWinner(String[][] content, String mark) {
        for (int x = 0; x < 3; x++) {
            if (content[x][0] == mark && content[x][1] == mark && content[x][2] == mark) {
                return true;
            }
        }

        for (int y = 0; y < 3; y++) {
            if (content[0][y] == mark && content[1][y] == mark && content[2][y] == mark) {
                return true;
            }
        }

        if (content[0][0] == mark && content[1][1] == mark && content[2][2] == mark) {
            return true;
        }

        if (content[0][2] == mark && content[1][1] == mark && content[2][0] == mark) {
            return true;
        }

        return false;
    }
}
