package shoppingManagement.cart;

import shoppingManagement.product.Product;
import shoppingManagement.product.ProductQuantity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<ProductQuantity> productQuantities;

    public Cart(){
        this.productQuantities = new ArrayList<>();
    }

    public List<ProductQuantity> productQuantities() {
        return productQuantities;
    }

    public void addProduct(Product product, int quantity) {
        productQuantities.add(new ProductQuantity(product, quantity));
    }

    public int getTotalPrice(){
        return productQuantities.stream()
                .mapToInt(ProductQuantity::getTotalPrice)
                .sum();
    }
}
