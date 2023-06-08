package bollingGame.turn;

import bollingGame.bolling.GamePlayer;

public class Turn {
    private GamePlayer player;
    private boolean first;

    public Turn(GamePlayer player) {
        this.player = player;
        this.first = true;
    }

    public void play() {
        int roll = player.rollBall();
        boolean isStrike = player.strike();
        boolean isSpare = player.spare();
        for (int i = 0; i < 2; i++) {
            int pins = 10;
            if (first) {
                pins -= roll;
                // 첫 번째 굴림
                if (isStrike) {
                    if (isStrikePreviousRound(pins)) {
                        player.changeStrike(true);
                        break;
                    } else {
                        player.changeStrike(false);
                        player.calculateMultiply(2);
                        player.calculate(10 + player.score() * player.multiply());
                    }
                } else {
                    player.calculate(roll);
                    player.calculateMultiply(0);
                }

                first = false;
            } else {
                // 두번째 굴림
                pins -= roll;
                if (isSpare) {
                    if (isSparePreviousRound(pins)) {
                        player.changeSpare(true);
                    } else {
                        player.changeSpare(false);
                        player.calculateMultiply(2);
                        player.calculate(pins * player.multiply());
                    }
                } else {
                    player.calculate(roll);
                    player.calculateMultiply(0);
                }
            }
        }
    }

    private boolean isStrikePreviousRound(int pins) {
        if (pins == 0) {
            return true;
        }
        return false;
    }

    private boolean isSparePreviousRound(int pins) {
        if (pins == 0) {
            return true;
        }
        return false;
    }
}