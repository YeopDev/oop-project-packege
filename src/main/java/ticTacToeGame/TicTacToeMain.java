package ticTacToeGame;

import ticTacToeGame.boardPan.Board;
import ticTacToeGame.computer.Computer;
import ticTacToeGame.player.Player;
import ticTacToeGame.position.Position;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeMain {
    private final static Scanner sc = new Scanner(System.in);
    private static boolean gameOver = false;

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println("게임판을 생성하였습니다.");
        printBoard(board.pan());

        Computer computer = new Computer();
        Player player = new Player();

        while (!gameOver) {
            System.out.println("player가 x값을 입력합니다.");
            int x = sc.nextInt();
            System.out.println("player가 y값을 입력합니다.");
            int y = sc.nextInt();
            Position position = new Position(x, y);

            System.out.println("player가 mark 합니다.");
            printBoard(player.mark(board, position));
            if (hasWinner(board.pan(), player.PLAYER_MARK())) {
                System.out.println("player가 이겼습니다.");
                break;
            }

            System.out.println("computer가 mark 합니다.");
            printBoard(computer.mark(board));
            if (hasWinner(board.pan(), computer.COMPUTER_MARK())) {
                System.out.println("computer가 이겼습니다.");
                break;
            }
            if (gameOver) {
                break;
            }
        }
    }

    public static void printBoard(String[][] pan) {
        if (hasGameOver(pan)) {
            gameOver = true;
        }
        Arrays.stream(pan).forEach(row -> System.out.println(String.join("\t", row)));
    }

    public static boolean hasGameOver(String[][] pan) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (pan[row][col] == "-") {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean hasWinner(String[][] pan, String mark) {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (pan[row][0] == mark && pan[row][1] == mark && pan[row][2] == mark) {
                return true;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (pan[0][col] == mark && pan[1][col] == mark && pan[2][col] == mark) {
                return true;
            }
        }

        if (pan[0][0] == mark && pan[1][1] == mark && pan[2][2] == mark) {
            return true;
        }

        if (pan[0][2] == mark && pan[1][1] == mark && pan[2][0] == mark) {
            return true;
        }

        return false;
    }
}
