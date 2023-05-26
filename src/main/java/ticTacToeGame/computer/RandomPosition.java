package ticTacToeGame.computer;

import ticTacToeGame.position.Position;

import java.util.Random;

public class RandomPosition implements RandomPositionPolicy {
    private static final Random random = new Random();

    @Override
    public Position create() {
        int x = random.nextInt(3);
        int y = random.nextInt(3);
        return new Position(x, y);
    }
}
