package bollingGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameManagementTest {
    @Test
    @DisplayName("랜덤으로 볼링공을 굴렸다 검증")
    void rollBallThrownBy() {
        Assertions.assertThatCode(
                () -> {
                    GameManagement gameManagement = new GameManagement(() -> 5);
                    gameManagement.roll();
                    gameManagement.roll();
                    Assertions.assertThat(gameManagement.getScore()).isEqualTo(10);
                }
        ).doesNotThrowAnyException();
    }
}