package ticTacToeGame.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ticTacToeGame.boardPan.Board;
import ticTacToeGame.position.Position;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {
    @ParameterizedTest
    @ValueSource(strings = {"P"})
    @DisplayName("생성자에 올바른 값이 들어왔을 경우")
    void constructorNoThrownBy(String name) {
        assertThatCode(
                () -> new Player(name)
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {" "})
    @DisplayName("생성자에 올바르지 않은 값이 들어왔을 경우")
    void constructorThrownBy(String name) {
        assertThatThrownBy(
                () -> new Player(name)
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("mark 할 값이 비어있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"P"})
    @DisplayName("mark 메서드가 정상적으로 실행 될 경우")
    void markMethodNoThrownBy(String name) {
        assertThatCode(
                () -> {
                    Board board = new Board();
                    Position position = new Position(0, 0);
                    Player player = new Player(name);
                    player.mark(board, position);
                    String[][] test = board.content();
                    assertThat(test[0][0]).isEqualTo(name);
                }
        ).doesNotThrowAnyException();
    }
}