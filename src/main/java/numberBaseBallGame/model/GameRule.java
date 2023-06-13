package numberBaseBallGame.model;

@FunctionalInterface
public interface GameRule {
    Match with(Numbers target, Numbers compare);

    GameRule BASIC = (COMPUTER, USER) -> Match.compare(COMPUTER.value(), USER.value());
}
