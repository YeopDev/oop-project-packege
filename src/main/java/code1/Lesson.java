package code1;

import java.util.ArrayList;
import java.util.List;

record Lesson(
        Long id,
        String name,
        StudentManager studentManager
) {
    private static final String REGEX = "[a-zA-Z가-힣]{1,10}";

    Lesson {
        if (id == null) {
            throw new IllegalArgumentException("Not Null id");
        }
        if (name == null || !name.matches(REGEX)) {
            throw new IllegalArgumentException("Not Null Name or Not greater than 10");
        }
        if (studentManager == null || studentManager.studentCount() > 0) {
            throw new IllegalArgumentException("기본 학생은 0명부터 시작합니다");
        }
    }
    public Long studentRegist(Long studentId){
        return studentManager.add(studentId);
    }
    public Long studentSize(){
        return studentManager.studentCount();
    }

    public Long lessonEnd(Long studentId){
        return studentManager.minus(studentId);
    }

    public Long lessonReset(){
        return studentManager.reset();
    }

    public static StudentManager deafultTable() {
        return new StudentManager(new ArrayList<>());
    }

    private record StudentManager(
            List<Long> students
    ) {
        private Long studentCount() {
            return (long) this.students.size();
        }
        private Long add(Long studentId) {
            this.students.add(studentId);
            return (long) this.students.size();
        }

        private Long minus(Long studentId){
            this.students.remove(studentId);
            return (long) this.students.size();
        }

        private Long reset(){
            this.students.removeAll(this.students);
            return (long) this.students.size();
        }
    }
}
