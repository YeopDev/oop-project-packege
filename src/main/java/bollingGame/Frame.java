package bollingGame;

public class Frame {
    private static final int PIN_COUNT = 10;

    private Score first;
    private Score second;

    public Frame(Score first, Score second) {
        this.first = first;
        this.second = second;
    }

    public Frame(Score first) {
        this(first, Score.ZERO());
    }

    public Score first() {
        return first;
    }

    public Score second() {
        return second;
    }

    public int frameScore() {
        return first.plus(second).value();
    }

    public boolean isStrike() {
        return first.isStrike();
    }

    public boolean isSpare() {
        return !isStrike() && first.plus(second).isStrike();
    }

    public void addSecond(Score second) {
        if (this.second.compareTo(second.ZERO()) > 0) {
            throw new IllegalStateException("두번째시도의 값이 이미 있습니다.");
        }
        if (this.first.isStrike()) {
            throw new IllegalStateException("첫번째 시도가 이미 스트라이크 입니다.");
        }
        if (!remainingPinCount().compare(second)) {
            this.second = remainingPinCount();
        }
        this.second = second;
    }

    public Score remainingPinCount() {
        if (!isStrike()) {
            return new Score(PIN_COUNT - frameScore());
        }
        return new Score(PIN_COUNT);
    }
}
