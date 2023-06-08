package bollingGame.bolling;

public interface GamePlayer {
    int score();

    boolean strike();

    boolean spare();

    int multiply();

    void calculateMultiply(int increase);

    void calculate(int increase);

    void changeStrike(boolean isStrike);

    void changeSpare(boolean isSpare);

    int rollBall();
}