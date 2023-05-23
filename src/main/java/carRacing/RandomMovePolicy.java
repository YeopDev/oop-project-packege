package carRacing;

import java.util.Random;

public class RandomMovePolicy implements MovePolicy {
    private static final Random random = new Random();

    @Override
    public boolean isMove() {
        return random.nextInt(10) >= 4;
    }
}