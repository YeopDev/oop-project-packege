package code1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BootCampTest {
    // -> 1. 생성 테스트
    // -> 2. 유효성 ㄱ머사
    // -> 3. method
    // -> e.g ) 행위만 있는 경우 인터페이스화
    // -> e.g ) 필드만 있는 경우 데이터 클래스화 ( record, final )

    @ParameterizedTest
    @CsvSource({"1,math", "2,english"})
    @DisplayName("부트캠프에 올바른 값이 들어오지 않았을 경우")
    void bootCampConstructorThrownBy(List<Lesson> lessons){
        Assertions.assertThatThrownBy(
                () -> new BootCamp(lessons)

        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1,math", "2,english"})
    @DisplayName("부트캠프에 올바른 값이 들어왔을 경우")
    void bootCampConstructorNoThrownBy(Long id , String lessonName) {
        Lesson lesson = new Lesson(id, lessonName, new ArrayList<>());
        List<Lesson> lessons = new ArrayList<>();
        lessons.add(lesson);
        BootCamp bootCamp = new BootCamp(lessons);

        assertThat(bootCamp.lessons().size()).isEqualTo(1);
    }
}