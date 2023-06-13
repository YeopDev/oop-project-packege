package bollingGame;

public class Score implements Comparable<Score> {
    private static final int MINIMUM_SCORE = 0;

    private final int value;

    public Score(int value) {
        if (value < MINIMUM_SCORE) {
            throw new IllegalArgumentException("점수는 %d보다 작을 수 없습니다. 현재 점수(%d)".formatted(MINIMUM_SCORE, value));
        }
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public int compareTo(Score score) {
        return value > score.value ? 1 : -1;
    }

    public boolean compare(Score score) {
        return value > score.value;
    }

    public static Score ZERO() {
        return new Score(0);
    }

    public Score plus(Score score) {
        if (score == null) {
            return this;
        }
        return new Score(this.value + score.value);
    }

    public boolean isStrike() {
        return value == 10;
    }
}
