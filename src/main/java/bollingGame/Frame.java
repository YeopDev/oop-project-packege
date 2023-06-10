package bollingGame;

public class Frame {
    private int firstRoll;
    private int secondRoll;

    public Frame(int firstRoll, int secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public int getFrameScore() {
        return firstRoll + secondRoll;
    }

    public boolean isStrike() {
        return firstRoll == 10;
    }

    public boolean isSpare() {
        return !isStrike() && firstRoll + secondRoll == 10;
    }

    public void changeSecondRoll(int pins) {
        this.secondRoll = pins;
    }
}
