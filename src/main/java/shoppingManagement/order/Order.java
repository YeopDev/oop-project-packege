package shoppingManagement.order;

import shoppingManagement.cart.Cart;
import shoppingManagement.customer.Customer;
import shoppingManagement.product.Product;
import shoppingManagement.product.ProductQuantity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<ProductQuantity> productQuantityList;

    public Order(List<ProductQuantity> productQuantityList) {
        this.productQuantityList = new ArrayList<>(productQuantityList);
    }

    public void placeOrder(Customer customer) {
        Cart cart = customer.cart();
        int totalAmount = cart.getTotalPrice();

        for (ProductQuantity cartProductQuantity : cart.productQuantities()) {
            Product cartProduct = cartProductQuantity.product();
            Long id = cartProduct.id();
            int requestedQuantity = cartProductQuantity.quantity();

            ProductQuantity matchingProductQuantity = productQuantityList.stream()
                    .filter(pq -> pq.product().hasProduct(id))
                    .findFirst()
                    .orElse(null);

            if (!matchingProductQuantity.hasQuantity(requestedQuantity)) {
                throw new IllegalArgumentException("상품의 재고가 없거나 수량이 부족합니다. 주문을 처리할 수 없습니다.");
            }
        }

        customer.purchaseProduct(totalAmount);
    }

    public List<ProductQuantity> update(Customer customer) {
        Cart cart = customer.cart();

        List<ProductQuantity> updateList = productQuantityList.stream()
                .map(pq -> {
                    for (ProductQuantity productQuantity : cart.productQuantities()) {
                        if (pq.product().hasProduct(productQuantity.product().id())) {
                            int orderQuantity = productQuantity.quantity();
                            return pq.decreaseQuantity(orderQuantity);
                        }
                    }
                    return pq;
                })
                .toList();
        System.out.println("updateList = " + updateList);
        return updateList;
    }
}
