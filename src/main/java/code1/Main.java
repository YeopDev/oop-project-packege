package code1;

import static code1.Lesson.deafultTable;

public class Main {
    // 객체지향 공부 7
    /**
     * - 학생이 학원이 개설한 여러개의 수업중에 하나를 등록한다.
     *    ㄴ 학생이 학원을 등록한다
     *
     * - 학원은 특정수업에 신청한 학생을 등록시키고 수업명단에 저장한다.
     *    ㄴ 학원은 등록받은 학생을 수업에 등록시키고 수업 명단에 저장한다.
     *
     * - 학생이 수업을 들으면 명단에서 빠진다.
     *
     * - new : 학생 전부가 수업을 들으면 명단을 초기화 한다.
     *
     * -
     */
    public static void main(String[] args) {
        Lesson lesson = new Lesson(0L,"TestLesson",deafultTable());

        Student s1 = new Student(0L,"junny");
        lesson.studentRegist(s1.id());

    }
}
