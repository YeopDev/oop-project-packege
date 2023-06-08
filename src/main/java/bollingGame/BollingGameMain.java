package bollingGame;

import bollingGame.bolling.GamePlayer;
import bollingGame.bolling.RandomRollBall;
import bollingGame.bolling.RandomRollBallImpl;
import bollingGame.bolling.computer.Computer;
import bollingGame.bolling.player.Player;
import bollingGame.turn.Turn;

public class BollingGameMain {
    public static void main(String[] args) {
        RandomRollBall randomRollBall = new RandomRollBallImpl();
        GamePlayer player = new Player("human1", randomRollBall);
        GamePlayer computer = new Computer("CP", randomRollBall);

        for (int i = 0; i < 10; i++) {
            Turn playerTurn = new Turn(player);
            Turn computerTurn = new Turn(computer);
            playerTurn.play();
            computerTurn.play();
        }

        System.out.println("Player's score: " + player.score());
        System.out.println("Computer's score: " + computer.score());

        if (player.score() < computer.score()) {
            System.out.println("컴퓨터의 승리 - 점수차: " + (computer.score() - player.score()));
        } else if (player.score() > computer.score()) {
            System.out.println("플레이어의 승리 - 점수차: " + (player.score() - computer.score()));
        } else {
            System.out.println("무승부");
        }
    }
}