package bollingGame.bolling.computer;

import bollingGame.bolling.GamePlayer;
import bollingGame.bolling.RandomRollBall;

public class Computer implements GamePlayer {
    private final String name;
    private int score;
    private boolean isStrike;
    private boolean isSpare;

    private int multiply;
    private final RandomRollBall randomRollBall;

    public Computer(String name, RandomRollBall randomRollBall) {
        this.name = name;
        this.score = 0;
        this.isStrike = false;
        this.isSpare = false;
        this.multiply = 0;
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
    public int multiply() {
        return this.multiply;
    }

    @Override
    public void calculateMultiply(int increase) {
        multiply += increase;
        if(increase == 0){
            resetMultiply();
        }
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

    private void resetMultiply(){
        multiply = 0;
    }
}