package bollingGame;

import java.util.ArrayList;
import java.util.List;

public class GameManagement {
    private List<Frame> frames;
    private RandomRollBall randomRollBall;

    public GameManagement(RandomRollBall randomRollBall) {
        frames = new ArrayList<>();
        this.randomRollBall = randomRollBall;
    }

    public void roll() {
        int remainingPins = 10;

        if (!frames.isEmpty()) {
            Frame lastFrame = frames.get(frames.size() - 1);
            if (!lastFrame.isStrike() && lastFrame.getSecondRoll() != -1) {
                remainingPins = 10 - lastFrame.getSecondRoll();
            }
        }

        int pins = randomRollBall.rollBall();
        pins = Math.min(pins, remainingPins);

        Frame currentFrame = getCurrentFrame();

        if (currentFrame == null || currentFrame.getSecondRoll() == -1) {
            currentFrame = new Frame(pins, -1);
            frames.add(currentFrame);
            return;
        }

        currentFrame.changeSecondRoll(pins);
    }

    private Frame getCurrentFrame() {
        if (frames.isEmpty()) {
            return null;
        }
        Frame lastFrame = frames.get(frames.size() - 1);
        if (lastFrame.isStrike() || lastFrame.getSecondRoll() != -1) {
            return null;
        }
        return lastFrame;
    }

    public Frame getLastFrame() {
        if (frames.isEmpty()) {
            return null;
        }
        return frames.get(frames.size() - 1);
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            score += frame.getFrameScore();

            if (frame.isStrike()) {
                score += getStrikeBonus(i);
            }
            if (frame.isSpare()) {
                score += getSpareBonus(i);
            }
        }
        return score;
    }

    private int getStrikeBonus(int frameIndex) {
        int bonus = 0;
        int numBonuses = 0;

        for (int i = frameIndex + 1; i < frames.size(); i++) {
            Frame nextFrame = frames.get(i);
            bonus += nextFrame.getFrameScore();

            if (nextFrame.isStrike()) {
                numBonuses++;
                if (numBonuses < 2) {
                    Frame secondNextFrame = frames.get(i + 1);
                    bonus += secondNextFrame.getFirstRoll();
                }
            }

            if (numBonuses >= 2) {
                break;
            }
        }

        return bonus;
    }

    private int getSpareBonus(int frameIndex) {
        if (frameIndex == frames.size() - 1) {
            return 0; // 마지막 프레임인 경우 보너스 점수 없음
        }

        Frame nextFrame = frames.get(frameIndex + 1);
        return nextFrame.getFirstRoll();
    }
}