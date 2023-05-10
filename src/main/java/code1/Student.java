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

    public void lessonListen(){

    }

}
