package code1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
     * - 학생 전부가 수업을 들으면 명단을 초기화 한다.
     *
     * - new : 학원은 수업을 시작한다.
     *
     * - new : 학원은 수업을 끝낸다.
     *
     * - new : 학원은 수업이 다 끝난건지 확인한다.
     */
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Student student1 = new Student(0L,"yeop");
        Student student2 = new Student(1L,"gun");

        Lesson meth = new Lesson(0L,"meth", new ArrayList<>());
        Lesson english = new Lesson(1L,"english", new ArrayList<>());

        meth.regist(student1);
        english.regist(student2);

        BootCamp bootCamp = new BootCamp(
                List.of(meth,english)
        );

        System.out.println("시작 할 수업을 입력해주세요.");
        String lessonName = sc.next().toLowerCase();
        System.out.println("수업을 시작합니다.");
        Lesson target = bootCamp.startLesson(lessonName);
        bootCamp.endLesson(target);
    }
}
