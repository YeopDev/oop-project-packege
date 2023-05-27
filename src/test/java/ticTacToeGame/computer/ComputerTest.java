package ticTacToeGame.computer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ticTacToeGame.boardPan.Board;
import ticTacToeGame.position.Position;

import static org.assertj.core.api.Assertions.*;

class ComputerTest {

    @ParameterizedTest
    @ValueSource(strings = {"C"})
    @DisplayName("생성자에 올바른 값이 들어왔을 경우")
    void constructorNoThrownBy(String name) {
        assertThatCode(
                () -> new Computer(name, new CreatePosition())
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {" "})
    @DisplayName("생성자에 올바르지 않은 값이 들어왔을 경우")
    void constructorThrownBy(String name) {
        assertThatThrownBy(
                () -> new Computer(name, new CreatePosition())
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("mark 할 값이 비어있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"C"})
    @DisplayName("mark 메서드가 정상적으로 실행 될 경우, 컴퓨터 더블링테스트")
    void markMethodNoThrownBy(String name) {
        assertThatCode(
                () -> {
                    Board board = new Board();
                    Computer computer = new Computer(name, () -> new Position(0, 0));
                    computer.mark(board);
                    String[][] test = board.content();
                    assertThat(test[0][0]).isEqualTo(name);

                }
        ).doesNotThrowAnyException();
    }
}