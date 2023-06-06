package pattern.strategy;

public class CreditCard implements PaymentStrategy{
    private String name;
    private String number;
    private String cvv;
    private String dateOfExpiry;

    public CreditCard(String name, String number, String cvv, String dateOfExpiry){
        this.name = name;
        this.number = number;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "원을 신용카드 결제 했습니다.");
    }
}