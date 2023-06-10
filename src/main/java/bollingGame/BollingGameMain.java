package bollingGame;

public class BollingGameMain {
    public static void main(String[] args) {
        RandomRollBall randomRollBall = new RandomRollBallImpl();

        GameManagement gameManagement = new GameManagement(randomRollBall);
        boolean firstRoll = true;

        for (int frame = 1; frame <= 10; frame++) {
            for (int two = 0; two < 2; two++) {
                if (firstRoll) {
                    gameManagement.roll();
                    firstRoll = false;
                } else {
                    gameManagement.roll();
                    firstRoll = true;
                }
            }

            if (frame == 10 && (gameManagement.getLastFrame().isSpare() || gameManagement.getLastFrame().isStrike())) {
                gameManagement.roll();
            }
        }

        int score = gameManagement.getScore();
        System.out.println("최종 점수: " + score);
    }
}