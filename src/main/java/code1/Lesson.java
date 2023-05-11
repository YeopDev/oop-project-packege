package code1;

import java.util.ArrayList;
import java.util.List;

record Lesson(
        Long id,
        String name,
        StudentManager studentManager
) {
    private static final String REGEX = "[a-zA-Z가-힣]{1,10}";

    private Long id;
    private String name;
    private List<Student> students;

    public Lesson(Long id, String name, List<Student> students) {
        if (id == null) {
            throw new IllegalArgumentException("Not Null id");
        }
        if (name == null || !name.matches(REGEX)) {
            throw new IllegalArgumentException("Not Null Name or Not greater than 10");
        }
        if (students == null || students.isEmpty()) {
            throw new IllegalArgumentException("기본 학생은 0명부터 시작합니다");
        }
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public Long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }

    public List<Student> getStudents(){
        return this.students;
    }

    public void regist(Student student) {
        students.add(student);
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
}
