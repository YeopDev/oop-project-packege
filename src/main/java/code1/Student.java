package code1;

record Student(
        Long id,
        String name
) {
    private static final String REGEX = "[a-zA-Z가-힣]{1,10}";
    Student{
        if (id == null){
            throw new IllegalArgumentException("Not Null id");
        }
        if(name == null || !name.matches(REGEX)){
            throw new IllegalArgumentException("Not Null Name or Not greater than 10");
        }
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void lessonListen(Lesson lesson){
        System.out.printf("학생이 %s 수업을 시작 했습니다.",lesson.getName());
    }

    public void endLesson(Lesson lesson){
        System.out.println("학생이 수업을 다 들었습니다.");

        lesson.end(lesson.getStudents().stream()
                .filter(item -> item.id.equals(this.id))
                .findAny()
                .get());
    }

}
