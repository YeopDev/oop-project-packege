package ticTacToeGame.computer;

import ticTacToeGame.position.Position;

@FunctionalInterface
public interface CreatePositionPolicy {
    Position create();
}
