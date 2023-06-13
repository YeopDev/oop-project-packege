package numberBaseBallGame.model;

public enum Match {
    크다,
    같다,
    작다;

    public static Match compare(int target1, int target2) {
        if (target1 < target2) {
            return Match.크다;
        } else if (target1 == target2) {
            return Match.같다;
        } else {
            return Match.작다;
        }
    }
}
