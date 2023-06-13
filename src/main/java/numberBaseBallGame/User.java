package numberBaseBallGame;

import numberBaseBallGame.model.Numbers;

public interface User {
    int value();

    record Computer(
            Numbers numbers
    ) implements User {
        @Override
        public int value() {
            return numbers.value();
        }
    }

    record Player(
            Numbers numbers
    ) implements User {
        @Override
        public int value() {
            return numbers.value();
        }
    }
}
