package shoppingManagement.product;

public record ProductQuantity(Product product, int quantity) {

    public ProductQuantity {
        validate(quantity);
    }

    public int getTotalPrice() {
        return product.price() * quantity;
    }

    public boolean hasQuantity(int quantity) {
        return this.quantity >= quantity;
    }

    public ProductQuantity decreaseQuantity(int quantity) {
        return new ProductQuantity(product,this.quantity-quantity);
    }

    private void validate(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("상품수량은 0보다 작을 수 없습니다.");
        }
    }
}
