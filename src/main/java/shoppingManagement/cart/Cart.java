package shoppingManagement.cart;

import shoppingManagement.product.ProductQuantity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<ProductQuantity> productQuantities;

    public Cart() {
        this.productQuantities = new ArrayList<>();
    }

    public List<ProductQuantity> productQuantities() {
        return productQuantities;
    }

    public void addProduct(ProductQuantity productQuantity) {
        productQuantities.add(productQuantity);
    }

    public int getTotalPrice() {
        return productQuantities.stream()
                .mapToInt(ProductQuantity::getTotalPrice)
                .sum();
    }
}
