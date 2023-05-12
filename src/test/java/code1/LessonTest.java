package code1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LessonTest {
    @ParameterizedTest
    @CsvSource({"1,math1", "2,english2"})
    @DisplayName("수업에 올바른 값이 들어오지 않았을 경우")
    void LessonConstructorThrownBy(Long id, String lessonName) {
        assertThatThrownBy(() -> new Lesson(id, lessonName, new ArrayList<>())
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1,math", "2,english"})
    @DisplayName("수업에 올바른 값이 들어왔을 경우")
    void LessonConstructorNoThrownBy(Long id, String lessonName) {
        Lesson lesson = new Lesson(id, lessonName, new ArrayList<>());
        assertThat(lesson.id()).isEqualTo(id);
        assertThat(lesson.name()).isEqualTo(lessonName);
    }

    @Test
    @DisplayName("수업에 수강신청한 학생들이 올바르게 반영 되었을 경우")
    void LessonRegist() {
        Lesson lesson = new Lesson(0L, "meth", new ArrayList<>());
        Student student1 = new Student(0L,"yeop");
        Student student2 = new Student(1L,"gun");

        lesson.regist(student1);
        lesson.regist(student2);

        assertThat(lesson.students().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("수업을 수강한 학생들을 명단에서 제거")
    void LessonReset() {
        Lesson lesson = new Lesson(0L, "lesson", new ArrayList<>());
        Student student = new Student(0L,"yeop");
        Student student2 = new Student(1L,"gun");

        lesson.regist(student);
        lesson.regist(student2);

        lesson.studentReset();

        assertThat(lesson.studentCount()).isEqualTo(0);
    }

}