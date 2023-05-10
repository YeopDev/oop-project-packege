package code1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static code1.Lesson.deafultTable;

class LessonTest {
    @ParameterizedTest
    @CsvSource({"1,math1", "2,english2"})
    @DisplayName("수업에 올바른 값이 들어오지 않았을 경우")
    void LessonConstructorThrownBy(Long id, String lessonName) {
        assertThatThrownBy(() -> new Lesson(id, lessonName, deafultTable())
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1,math", "2,english"})
    @DisplayName("수업에 올바른 값이 들어왔을 경우")
    void LessonConstructorNoThrownBy(Long id, String lessonName) {
        Lesson lesson = new Lesson(id, lessonName, deafultTable());
        assertThat(lesson.id()).isEqualTo(id);
        assertThat(lesson.name()).isEqualTo(lessonName);
    }

    @ParameterizedTest
    @CsvSource({"1", "4", "5", "2", "3"})
    @DisplayName("수업에 수강신청한 학생들이 올바르게 반영 되었을 경우")
    void LessonRegist(Long count) {
        Lesson lesson = new Lesson(0L, "TestLesson", deafultTable());

        LongStream.rangeClosed(1, count)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll)
                .stream().map(e -> (long) e)
                .forEach(lesson::studentRegist);

        assertThat(lesson.studentSize()).isEqualTo(count);
    }

    @Test
    @DisplayName("수업을 수강한 학생들을 명단에서 제거")
    void LessonMinus() {
        Lesson lesson = new Lesson(0L, "lesson", deafultTable());

        List.of(1L, 2L, 3L, 4L, 5L, 6L)
                .forEach(lesson::studentRegist);

        Long count = lesson.lessonEnd(1L);

        assertThat(lesson.studentSize()).isEqualTo(5);
    }
    
    @Test
    @DisplayName("학생들이 수업을 전부 들었을 경우 초기화")
    void LessonReset(){
        Lesson lesson = new Lesson(0L, "lesson", deafultTable());
        List.of(1L, 2L, 3L, 4L, 5L, 6L)
                .forEach(lesson::studentRegist);
        Long count = lesson.lessonReset();

        assertThat(lesson.studentSize()).isEqualTo(0);
    }



}