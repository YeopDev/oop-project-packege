package code1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StudentTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(
            strings = {"name1"}
    )
    @DisplayName("학생의 이름이 올바르지 않을 경우")
    void studentConstructorThrownBy(String name) {
        Assertions.assertThatThrownBy(() -> new Student(0L, name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1, names","2,이름"})
    @DisplayName("학생의 이름이 올바르게 입력받았을 경우")
    void studentConstructorNoThrownBy(Long id, String name){
        Student result = new Student(id,name);

        Assertions.assertThat(result.id()).isEqualTo(id);
        Assertions.assertThat(result.name()).isEqualTo(name);
    }

}