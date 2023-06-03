package movieTicketExample.customer;

import static java.util.Objects.isNull;

public record Customer(Long id, String name, int money) {
    public Customer {
        validate(id, name, money);
    }

    private void validate(Long id, String name, int money) {
        if (isNull(id) || id < 0) {
            throw new IllegalArgumentException("사용자id는 비어있을 수 없고, 0보다 작을 수 없습니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }
        if (money < 0) {
            throw new IllegalArgumentException("소지금은 0보다 작을 수 없습니다.");
        }
    }
}
