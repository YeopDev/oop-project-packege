package bollingGame.bolling.computer;

import bollingGame.bolling.GamePlayer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ComputerTest {
    @ParameterizedTest
    @ValueSource(strings = {"computer"})
    @DisplayName("컴퓨터 플레이어가 랜덤으로 볼링핀을 쳤다를 검증")
    void rollBallThrownBy(String name) {
        Assertions.assertThatCode(
                () -> {
                    GamePlayer computer = new Computer(name, () -> 5);
                    computer.calculate(computer.rollBall());
                    Assertions.assertThat(computer.score()).isEqualTo(5);
                }
        ).doesNotThrowAnyException();
    }
}