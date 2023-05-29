package shoppingManagement.product;

import static java.util.Objects.isNull;

public record Product(Long id, String name, int price) {
    public Product {
        validate(id, name, price);
    }

    public boolean hasProduct(Long id) {
        return this.id.equals(id);
    }

    private void validate(Long id, String name, int price) {
        if (isNull(id) || id < 0) {
            throw new IllegalArgumentException("상품번호는 비어있을 수 없으며, 0보다 작을 수 없습니다.");
        }
        if (isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("상품이름은 비어있을 수 없으며, 스페이스바를 이름으로 할 수 없습니다.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("상품가격은 0보다 작을 수 없습니다.");
        }
    }
}
