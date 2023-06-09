package bollingGame.bolling.player;

import bollingGame.bolling.GamePlayer;
import bollingGame.bolling.RandomRollBall;

public class Player implements GamePlayer {
    private final String name;
    private int score;
    private boolean isStrike;
    private boolean isSpare;
    private final RandomRollBall randomRollBall;

    public Player(String name, RandomRollBall randomRollBall) {
        this.name = name;
        this.score = 0;
        this.isStrike = false;
        this.isSpare = false;
        this.randomRollBall = randomRollBall;
    }

    @Override
    public int score() {
        return this.score;
    }

    @Override
    public boolean strike() {
        return this.isStrike;
    }

    @Override
    public boolean spare() {
        return this.isSpare;
    }

    @Override
    public void calculate(int increase) {
        this.score += increase;
    }

    @Override
    public void changeStrike(boolean isStrike) {
        this.isStrike = isStrike;
    }

    @Override
    public void changeSpare(boolean isSpare) {
        this.isSpare = isSpare;
    }

    @Override
    public int rollBall() {
        return randomRollBall.rollBall();
    }
}