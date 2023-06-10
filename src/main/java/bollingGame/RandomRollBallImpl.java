package bollingGame;

import java.util.Random;

public class RandomRollBallImpl implements RandomRollBall {
    private final Random random = new Random();

    @Override
    public int rollBall() {
        return random.nextInt(11);
    }
}