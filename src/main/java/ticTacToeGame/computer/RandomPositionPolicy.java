package ticTacToeGame.computer;

import ticTacToeGame.position.Position;

@FunctionalInterface
public interface RandomPositionPolicy {
    Position create();
}
