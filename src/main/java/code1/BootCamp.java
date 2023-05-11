package code1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

record BootCamp(List<Lesson> lessons) {
    /**
     * 수업을 시작해.
     *
     * @param lesson
     */
    public void startLesson(Lesson lesson) {
        Lesson target = lessons.stream()
                .filter(item -> item == lesson)
                .findFirst().get();

        Student student = target.getStudents().stream().findAny().get();

        student.lessonListen(target);

        student.endLesson(target);

        endLesson(lesson);
    }

    public void endLesson(Lesson lesson) {
        lessons.remove(lesson);
    }


  /*  public void startLesson(Student student, Lesson lesson){
        System.out.printf("%s 수업을 시작합니다.",lesson.name());
        student.lessonListen(lesson);
        System.out.printf("현재 총 학생 %d명이 수업을 듣는 중입니다.",lesson.studentSize());
        System.out.println(" 수업중.. ");
    }

    public void endLesson(Student student, Lesson lesson){
        System.out.println("수업이 끝났습니다.");
        student.endLesson(lesson);
    }*/

    // 학원의 수업이 전부 끝났습니다. lesson 초기화
    //

}
