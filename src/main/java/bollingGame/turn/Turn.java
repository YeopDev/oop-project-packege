package bollingGame.turn;

import bollingGame.bolling.GamePlayer;

public class Turn {
    private GamePlayer player;
    private int score;
    private boolean first;

    public Turn(GamePlayer player) {
        this.player = player;
        this.score = 0;
        this.first = true;
    }

    public void play() { // 1 ~ 9 라운드까지는 play사용
        boolean isStrike = player.strike();// 이전에 스트라이크를 쳤는지
        boolean isSpare = player.spare();// 이전에 스페어를 처리했는지
        int pins = 10; //원래 핀 개수

        for (int i = 0; i < 2; i++) {
            if (first) {// 첫 번째 굴림
                int roll = player.rollBall();
                pins -= roll;
                if (isStrike) {
                    if (isZeroPin(pins)) {
                        player.changeStrike(true);
                        player.calculate(roll);
                        break;
                    } else {
                        player.changeStrike(false);
                        this.score += roll;
                    }

                } else if (isSpare) {
                    if (isZeroPin(pins)) {
                        player.changeStrike(true);
                        player.calculate(roll * 2);
                        break;
                    } else {
                        player.changeStrike(false);
                        player.calculate(roll * 2);
                    }

                } else {
                    if (isZeroPin(pins)) {
                        player.changeStrike(true);
                        player.calculate(roll);
                        break;
                    } else {
                        player.changeStrike(false);
                        player.calculate(roll);
                    }
                }

                first = false;
            } else {// 두번째 굴림
                int roll = 0;
                while (true) {
                    roll = player.rollBall();
                    if (pins >= roll) {
                        break;
                    }
                }
                pins -= roll;
                if (isStrike) {
                    if (isZeroPin(pins)) {
                        player.changeSpare(true);
                        player.calculate((roll + this.score) * 2);
                    } else {
                        player.changeSpare(false);
                        player.calculate((roll + this.score) * 2);
                    }

                } else if (isSpare) {
                    if (isZeroPin(pins)) {
                        player.changeSpare(true);
                        player.calculate(roll);
                    } else {
                        player.changeSpare(false);
                        player.calculate(roll);
                    }

                } else {
                    if (isZeroPin(pins)) {
                        player.changeSpare(true);
                        player.calculate(roll);
                    } else {
                        player.changeSpare(false);
                        player.calculate(roll);
                    }

                }
            }
        }
    }

    private boolean isZeroPin(int pins) {
        if (pins == 0) {
            return true;
        }
        return false;
    }
}