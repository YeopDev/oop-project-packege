package movieTicketExample.customer;

import static java.util.Objects.isNull;

public class Customer {
    private final Long id;
    private final String name;
    private final int money;

    public Customer(Long id, String name, int money) {
        validate(id, name, money);
        this.id = id;
        this.name = name;
        this.money = money;
    }

    private void validate(Long id, String name, int money) {
        if (isNull(id) || id < 0) {
            throw new IllegalArgumentException("id는 비어있을 수 없고, 0보다 작을 수 없습니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }
        if (money < 0) {
            throw new IllegalArgumentException("소지금은 0보다 작을 수 없습니다.");
        }
    }
}
