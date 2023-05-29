package shoppingManagement.order;

import shoppingManagement.cart.Cart;
import shoppingManagement.customer.Customer;
import shoppingManagement.product.Product;
import shoppingManagement.product.ProductQuantity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<ProductQuantity> productQuantityList;

    public Order(List<ProductQuantity> productQuantityList){
        this.productQuantityList = new ArrayList<>(productQuantityList);
    }

    public void placeOrder(Customer customer, Cart cart) {
        int totalAmount = cart.getTotalPrice();
        cart.productQuantities().forEach(cartProductQuantity -> {
            Product product = cartProductQuantity.product();
            int quantityToPurchase = cartProductQuantity.quantity();
            productQuantityList.stream()
                    .filter(pq -> pq.product().hasProduct(product.id()))
                    .findFirst()
                    .ifPresent(matchingProductQuantity -> {
                        if (!matchingProductQuantity.hasQuantity(quantityToPurchase)) {
                            throw new IllegalArgumentException("상품의 재고가 없거나 수량이 부족합니다. 주문을 처리할 수 없습니다.");
                        }
                        matchingProductQuantity.decreaseQuantity(quantityToPurchase);
                    });
        });
        customer.purchaseProduct(totalAmount);
    }
}
