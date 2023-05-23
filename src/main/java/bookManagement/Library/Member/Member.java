package bookManagement.Library.Member;

import static java.util.Objects.isNull;

public record Member(Long id, String name) {

    public Member{
        if(isNull(id) || id < 0){
            throw new IllegalArgumentException("회원번호가 올바르지 않은 값이 할당 되었습니다.");
        }
        if(isNull(name) || name.isBlank()){
            throw new IllegalArgumentException("회원이름에 올바르지 않은 값이 할당 되었습니다.");
        }
    }
}
