package bollingGame;

import java.util.List;
import java.util.Optional;

public class GameManagement {
    private final Frames frames;
    private final CreateScore createScore;

    private int totalScore;

    public GameManagement(CreateScore createScore) {
        frames = new Frames();
        this.createScore = createScore;
        this.totalScore = 0;
    }

    public int totalScore() {
        return this.totalScore;
    }

    public void roll() {
        Score firstScore = createScore.rollBall();
        Optional<Frame> currentFrame = frames.last();

        if (currentFrame.isEmpty()) {
            frames.add(new Frame(firstScore));
            roll();
        }

        boolean isStrike = currentFrame.map(Frame::isStrike).orElse(false);
        if (currentFrame.isPresent() && !isStrike) {
            Frame frame = currentFrame.get();
            frame.addSecond(firstScore);
            firstScore.plus(frame.second());
        }
        calculateTotalScore(frames);
        frames.reset();
    }

    private int calculateTotalScore(Frames frames) {
        List<Frame> frameList = frames.contents();

        for (int i = 0; i < frameList.size(); i++) {
            Frame frame = frameList.get(i);
            this.totalScore += frame.frameScore();

            if (frame.isStrike()) {
                strikeBonus(frameList, i);
            }

            if (frame.isSpare()) {
                spareBonus(frameList, i);
            }
        }

        return totalScore;
    }

    private void strikeBonus(List<Frame> frameList, int currentIndex) {
        if (currentIndex < frameList.size() - 1) {
            Frame nextFrame = frameList.get(currentIndex + 1);
            this.totalScore += nextFrame.frameScore();

            if (nextFrame.isStrike() && currentIndex < frameList.size() - 2) {
                Frame nextNextFrame = frameList.get(currentIndex + 2);
                this.totalScore += nextNextFrame.first().value();

                if (nextNextFrame.isStrike()) {
                    this.totalScore += nextNextFrame.second().value();
                }
            }
        }
    }

    private void spareBonus(List<Frame> frameList, int currentIndex) {
        if (currentIndex < frameList.size() - 1) {
            Frame nextFrame = frameList.get(currentIndex + 1);
            this.totalScore += nextFrame.first().value();
        }
    }
}