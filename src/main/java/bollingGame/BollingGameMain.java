package bollingGame;

public class BollingGameMain {
    public static void main(String[] args) {
        GameManagement gameManagement = new GameManagement(new CreateScore.DefaultCreateScore());

        for (int frame = 1; frame <= 10; frame++) {
            gameManagement.roll();
        }

        int totalScore = gameManagement.totalScore();
        System.out.println("Total Score: " + totalScore);
    }
}