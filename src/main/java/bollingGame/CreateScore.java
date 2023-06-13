package bollingGame;

import java.util.random.RandomGenerator;

@FunctionalInterface
public interface CreateScore {
    Score rollBall();

    class DefaultCreateScore implements CreateScore {
        private final RandomGenerator random = RandomGenerator.getDefault();

        @Override
        public Score rollBall() {
            return new Score(random.nextInt(11));
        }
    }
}