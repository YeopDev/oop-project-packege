package shoppingManagement.customer.payment;

public class CashPaymentStrategy implements PaymentStrategy {
    private int money;

    public CashPaymentStrategy(int money) {
        this.money = money;
    }

    @Override
    public void payments(int amount) {
        if(money < amount){
            throw new IllegalArgumentException("소지금이 지불금액보다 부족합니다.");
        }
        money -= amount;
    }
}
