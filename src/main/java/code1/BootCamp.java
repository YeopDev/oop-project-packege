package code1;

import java.util.List;

record BootCamp(List<Lesson> lessons) {
    public Lesson startLesson(String lessonName) {
        Lesson target = lessons.stream()
                .filter(l -> l.name().equals(lessonName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("등록된 수업 이름이 일치하지 않습니다."));
        System.out.printf("수업에 참여한 총 학생 수는 %d명 입니다. \n", target.studentCount());
        return target;
    }

    public void endLesson(Lesson target) {
        System.out.println("수업이 종료 되었습니다.");
        target.studentReset();
    }

}
