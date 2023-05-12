package code1;

import java.util.List;

record Lesson(Long id, String name, List<Student> students) {
    private static final String REGEX = "[a-zA-Z가-힣]{1,10}";

    public Lesson{
        if (id == null) {
            throw new IllegalArgumentException("Not Null id");
        }
        if (name == null || !name.matches(REGEX)) {
            throw new IllegalArgumentException("Not Null Name or Not greater than 10");
        }
    }

    public void regist(Student student) {
        students.add(student);
    }

    public int studentCount() {
        return students.size();
    }

    public void studentReset() {
        students.clear();
    }
}
