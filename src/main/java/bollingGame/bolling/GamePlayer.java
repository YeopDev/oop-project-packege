package bollingGame.bolling;

public interface GamePlayer {
    int score();

    boolean strike();

    boolean spare();

    void calculate(int increase);

    void changeStrike(boolean isStrike);

    void changeSpare(boolean isSpare);

    int rollBall();
}