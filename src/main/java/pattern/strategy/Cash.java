package pattern.strategy;

public class Cash implements PaymentStrategy {
    private int money;

    public Cash(int money) {
        this.money = money;
    }

    @Override
    public void pay(int amount) {
        this.money -= amount;
        System.out.println(amount + "원을 현금결제 했습니다. 남은 소지금은 : " + this.money + "원 입니다.");
    }
}