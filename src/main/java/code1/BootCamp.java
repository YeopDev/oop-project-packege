package code1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

record BootCamp(List<Lesson> lessons) {
    public void startLesson(String lessonName) {
        Lesson target = lessons.stream()
                .filter(l -> l.name().equals(lessonName))
                .findFirst()
                .orElseThrow(NullPointerException::new);
        System.out.println("학생전부가 수업을 들었습니다.");
        System.out.printf("수업에 참여한 총 학생 수는 %d명 입니다. \n", target.studentCount());
        target.studentReset();
    }

    public void end() {
        System.out.println("수업이 폐강 되었습니다.");
/*        lessons.stream()
                .filter(item -> item.id() == lesson.id())
                .collect(Collectors.toList())
                        .forEach(li -> {lessons.remove(li);});*/

/*        lessons = IntStream.range(0,lessons.size())
                .filter(idx -> idx == lesson.id())
                .mapToObj(idx -> lessons.get(idx))
                .collect(Collectors.toList());*/
        System.out.println("newLessons = " + lessons.toString());
    }

}
